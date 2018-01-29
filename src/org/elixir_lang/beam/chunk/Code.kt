package org.elixir_lang.beam.chunk

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.component1
import com.intellij.openapi.util.component2
import org.elixir_lang.beam.Cache
import org.elixir_lang.beam.chunk.Chunk.unsignedInt
import org.elixir_lang.beam.chunk.code.Operation

class Code(private val operationList: List<Operation>) {
    data class Options(val inline: Inline = Inline(), val showArgumentNames: Boolean = true) {
        data class Inline(
                val atoms: Boolean = true,
                val functions: Boolean = false,
                val imports: Boolean = false,
                val integers: Boolean = true,
                val labels: Boolean = true,
                val literals: Boolean = false
        ) {
            companion object {
                val UNAMBIGUOUS = Inline(
                        atoms = true,
                        functions = false,
                        imports = false,
                        integers = true,
                        literals = false
                )
            }
        }

        companion object {
            val UNAMBIGUOUS = Options(Inline.Companion.UNAMBIGUOUS)
        }
    }

    fun assembly(cache: Cache, options: Options): String =
        indentOperationList().joinToString("\n") { (indent, operation) ->
            val operationAssembly = operation.assembly(cache, options)

            val suffix = when (operation.code) {
                org.elixir_lang.beam.chunk.code.operation.Code.BADMATCH,
                org.elixir_lang.beam.chunk.code.operation.Code.CALL_EXT_LAST,
                org.elixir_lang.beam.chunk.code.operation.Code.CALL_EXT_ONLY,
                org.elixir_lang.beam.chunk.code.operation.Code.CALL_ONLY,
                org.elixir_lang.beam.chunk.code.operation.Code.CALL_LAST,
                org.elixir_lang.beam.chunk.code.operation.Code.RETURN ->
                    "\n"
                else ->
                    ""
            }

            "${" ".repeat(indent)}$operationAssembly$suffix"
        }

    operator fun get(index: Int): Operation = operationList[index]
    fun size(): Int = operationList.size

    private fun functionHeadBodyPairList(): List<Pair<List<Operation>, List<Operation>>> {
        val headerIndexLengthPairs = headerIndexLengthPairs()

        return headerIndexLengthPairs.mapIndexed { index, (headerIndex, headerLength) ->
            val bodyIndex = headerIndex + headerLength
            val nextHeaderIndex = headerIndexLengthPairs.getOrNull(index + 1)?.first ?: operationList.size

            val functionHead = operationList.subList(headerIndex, bodyIndex)
            val functionBody = operationList.subList(bodyIndex, nextHeaderIndex)

            Pair(functionHead, functionBody)
        }
    }

    private fun headerIndexLengthPairs(): List<Pair<Int, Int>> {
        val headerIndexLengthPairs = operationList
                .mapIndexedNotNull { index, operation ->
                    if (operation.code == org.elixir_lang.beam.chunk.code.operation.Code.FUNC_INFO) {
                        index
                    } else {
                        null
                    }
                }.map { funcInfoIndex ->
                    val lineIndex = funcInfoIndex - 1
                    val hasLine = operationList.getOrNull(lineIndex)?.code == org.elixir_lang.beam.chunk.code.operation.Code.LINE

                    if (hasLine) {
                        val labelIndex = lineIndex - 1
                        val hasLabel = operationList.getOrNull(labelIndex)?.code == org.elixir_lang.beam.chunk.code.operation.Code.LABEL

                        if (hasLabel) {
                            Pair(labelIndex, 3)
                        } else {
                            Pair(lineIndex, 2)
                        }
                    } else {
                        Pair(funcInfoIndex, 1)
                    }
                }

        val firstHeaderIndex = headerIndexLengthPairs.firstOrNull()?.first ?: 0

        return if (firstHeaderIndex > 0) {
            headerIndexLengthPairs.toMutableList().apply {
                add(0, Pair(0, 0))
            }
        } else {
            headerIndexLengthPairs
        }
    }

    private fun indentOperationList() =
            functionHeadBodyPairList().flatMap { (functionHead, functionBody) ->
                val indentOperationList = mutableListOf<Pair<Int, Operation>>()

                functionHead.forEach {
                    indentOperationList.add(Pair(0, it))
                }

                functionBody.forEach {
                    val indent = when (it.code) {
                        org.elixir_lang.beam.chunk.code.operation.Code.LABEL -> 2
                        org.elixir_lang.beam.chunk.code.operation.Code.LINE -> 4
                        else -> 6
                    }

                    indentOperationList.add(Pair(indent, it))
                }

                indentOperationList
            }

    companion object {
        private val LOGGER = Logger.getInstance(Code::class.java)

        fun from(chunk: Chunk, literalFloat: Boolean = true): Code {
            val data = chunk.data
            var offset = 0

            val (_unknown, unknownByteCount) = unsignedInt(data, offset)
            offset += unknownByteCount

            val (version, versionByteCount) = unsignedInt(data, offset)
            offset += versionByteCount

            if (version != 0L) {
                LOGGER.error(
                        "Code version ($version) differs from expect 0.  There was an incompatible change in " +
                                "https://github.com/erlang/otp/blob/master/lib/compiler/src/genop.tab."
                )
            }

            val (maxOpcode, maxOpcodeByteCount) = unsignedInt(data, offset)
            offset += maxOpcodeByteCount

            val expectedMaxOpcode = org.elixir_lang.beam.chunk.code.operation.Code.values().max()?.ordinal ?: 0
            if (maxOpcode > expectedMaxOpcode) {
                LOGGER.error(
                        "Max opcode ($maxOpcode) exceeds expected max opcode ($expectedMaxOpcode).  Additional " +
                                "opcodes have been added to the end of " +
                                "https://github.com/erlang/otp/blob/master/lib/compiler/src/genop.tab."
                )
            }

            val (labelCount, labelCountByteCount) = unsignedInt(data, offset)
            offset += labelCountByteCount

            val (functionCount, functionCountByteCount) = unsignedInt(data, offset)
            offset += functionCountByteCount

            val operationList = mutableListOf<Operation>()

            while (offset < data.lastIndex) {
                val (operation, operationByteCount) = Operation.from(data, offset, literalFloat)

                operationList.add(operation)
                offset += operationByteCount
            }

            return Code(operationList)
        }
    }
}
