package org.elixir_lang.elixir_flex_lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.elixir_lang.ElixirFlexLexer;
import org.elixir_lang.psi.ElixirTypes;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.elixir_lang.ElixirFlexLexer.MULTILINE_WHITE_SPACE_MAYBE;

/**
 * Created by luke.imhoff on 9/1/14.
 */
@RunWith(Parameterized.class)
public class YYInitialTest extends TokenTest {
    /*
     * Constants
     */

    private static final int INITIAL_STATE = ElixirFlexLexer.YYINITIAL;

    /*
     * Constructors
     */

    public YYInitialTest(CharSequence charSequence, IElementType tokenType, int lexicalState, boolean consumeAll) {
        super(charSequence, tokenType, lexicalState, consumeAll);
    }

    /*
     * Methods
     */

    @Parameterized.Parameters(
            name = "\"{0}\" parses as {1} token and advances to state {2}"
    )
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                        {" ", TokenType.WHITE_SPACE, ElixirFlexLexer.YYINITIAL, true},
                        {"!", ElixirTypes.UNARY_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, true},
                        {"!=", ElixirTypes.COMPARISON_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"!==", ElixirTypes.COMPARISON_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"", null, INITIAL_STATE, true},
                        {"#", ElixirTypes.COMMENT, ElixirFlexLexer.YYINITIAL, true},
                        {"%", ElixirTypes.STRUCT_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, true},
                        {"%{}", ElixirTypes.STRUCT_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, false},
                        {"&", ElixirTypes.CAPTURE_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"&&", ElixirTypes.AND_SYMBOL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"&&&", ElixirTypes.AND_SYMBOL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"'", ElixirTypes.CHAR_LIST_PROMOTER, ElixirFlexLexer.GROUP, true},
                        {"'''", ElixirTypes.CHAR_LIST_HEREDOC_PROMOTER, ElixirFlexLexer.GROUP_HEREDOC_START, true},
                        {"(", ElixirTypes.OPENING_PARENTHESIS, MULTILINE_WHITE_SPACE_MAYBE, true},
                        {")", ElixirTypes.CLOSING_PARENTHESIS, ElixirFlexLexer.ADDITION_OR_SUBTRACTION_MAYBE, true},
                        {"+", ElixirTypes.NUMBER_OR_BADARITH_OPERATOR, INITIAL_STATE, true},
                        {"++", ElixirTypes.TWO_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {",", ElixirTypes.COMMA, ElixirFlexLexer.YYINITIAL, true},
                        {"-", ElixirTypes.NEGATE_OPERATOR, INITIAL_STATE, true},
                        {"--", ElixirTypes.TWO_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"*", ElixirTypes.MULTIPLICATION_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"**", ElixirTypes.POWER_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"->", ElixirTypes.STAB_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {".", ElixirTypes.DOT_OPERATOR, ElixirFlexLexer.DOT_OPERATION, true},
                        {"..", ElixirTypes.RANGE_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"...", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"001234567", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, true},
                        {"0B10", ElixirTypes.BASE_WHOLE_NUMBER_PREFIX, ElixirFlexLexer.BASE_WHOLE_NUMBER_BASE, false},
                        {"0X0123456789abcdefABCDEF", ElixirTypes.BASE_WHOLE_NUMBER_PREFIX, ElixirFlexLexer.BASE_WHOLE_NUMBER_BASE, false},
                        {"0b10", ElixirTypes.BASE_WHOLE_NUMBER_PREFIX, ElixirFlexLexer.BASE_WHOLE_NUMBER_BASE, false},
                        {"0o01234567", ElixirTypes.BASE_WHOLE_NUMBER_PREFIX, ElixirFlexLexer.BASE_WHOLE_NUMBER_BASE, false},
                        {"0x0123456789abcdefABCDEF", ElixirTypes.BASE_WHOLE_NUMBER_PREFIX, ElixirFlexLexer.BASE_WHOLE_NUMBER_BASE, false},
                        {"1.", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1.0", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1.0e+1", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1.0e-1", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1.0e1", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1234567890", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, true},
                        {"1_", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {"1_2_3_4_5_6_7_8_9_0", ElixirTypes.VALID_DECIMAL_DIGITS, ElixirFlexLexer.DECIMAL_WHOLE_NUMBER, false},
                        {": ", ElixirTypes.COLON, INITIAL_STATE, false},
                        {":", ElixirTypes.COLON, ElixirFlexLexer.ATOM_START, true},
                        {"::", ElixirTypes.TYPE_OPERATOR, MULTILINE_WHITE_SPACE_MAYBE, true},
                        {":\n", ElixirTypes.COLON, INITIAL_STATE, false},
                        {":\r\n", ElixirTypes.COLON, INITIAL_STATE, false},
                        {":\t", ElixirTypes.COLON, INITIAL_STATE, false},
                        {";", ElixirTypes.SEMICOLON, ElixirFlexLexer.MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<", ElixirTypes.RELATIONAL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<-", ElixirTypes.IN_MATCH_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<<", ElixirTypes.OPENING_BIT, MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<<<", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<<>>", ElixirTypes.OPENING_BIT, MULTILINE_WHITE_SPACE_MAYBE, false},
                        {"<<~", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<=", ElixirTypes.RELATIONAL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<>", ElixirTypes.TWO_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<|>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<~", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"<~>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"=", ElixirTypes.MATCH_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"==", ElixirTypes.COMPARISON_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"===", ElixirTypes.COMPARISON_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"=>", ElixirTypes.ASSOCIATION_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"=~", ElixirTypes.COMPARISON_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {">", ElixirTypes.RELATIONAL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {">=", ElixirTypes.RELATIONAL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {">>", ElixirTypes.CLOSING_BIT, ElixirFlexLexer.ADDITION_OR_SUBTRACTION_MAYBE, true},
                        {">>>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"@", ElixirTypes.AT_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"Enum", ElixirTypes.ALIAS_TOKEN, ElixirFlexLexer.ADDITION_OR_SUBTRACTION_OR_WHITE_SPACE_MAYBE, true},
                        {"[", ElixirTypes.OPENING_BRACKET, MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"\"", ElixirTypes.STRING_PROMOTER, ElixirFlexLexer.GROUP, true},
                        {"\"\"\"", ElixirTypes.STRING_HEREDOC_PROMOTER, ElixirFlexLexer.GROUP_HEREDOC_START, true},
                        {"\\;", TokenType.BAD_CHARACTER, INITIAL_STATE, false},
                        {"\\\\", ElixirTypes.IN_MATCH_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"\\\n", TokenType.WHITE_SPACE, INITIAL_STATE, true},
                        {"\\\r\n", TokenType.WHITE_SPACE, INITIAL_STATE, true},
                        {"\f", TokenType.WHITE_SPACE, ElixirFlexLexer.YYINITIAL, true},
                        {"\n", ElixirTypes.EOL, ElixirFlexLexer.YYINITIAL, true},
                        {"\r\n", ElixirTypes.EOL, ElixirFlexLexer.YYINITIAL, true},
                        {"\t", TokenType.WHITE_SPACE, ElixirFlexLexer.YYINITIAL, true},
                        {"]", ElixirTypes.CLOSING_BRACKET, ElixirFlexLexer.ADDITION_OR_SUBTRACTION_MAYBE, true},
                        {"^", ElixirTypes.UNARY_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, true},
                        {"_identifier", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"after", ElixirTypes.AFTER, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"afterwards", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"and", ElixirTypes.AND_WORD_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"androids", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"catch", ElixirTypes.CATCH, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"catchall", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"defmodule", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"do", ElixirTypes.DO, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"done", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"else", ElixirTypes.ELSE, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"elsewhere", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"end", ElixirTypes.END, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, true},
                        {"ending", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"false", ElixirTypes.FALSE, ElixirFlexLexer.ADDITION_OR_KEYWORD_PAIR_OR_SUBTRACTION_OR_WHITE_SPACE_MAYBE, true},
                        {"falsehood", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"fn", ElixirTypes.FN, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"fnctn", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"identifier!", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"identifier", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"identifier9", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"identifier?", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"in", ElixirTypes.IN_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"inner", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        // https://github.com/KronicDeth/intellij-elixir/issues/1211 regression test
                        {"name@lang: ", ElixirTypes.ATOM_FRAGMENT, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, false},
                        {"nil", ElixirTypes.NIL, ElixirFlexLexer.ADDITION_OR_KEYWORD_PAIR_OR_SUBTRACTION_OR_WHITE_SPACE_MAYBE, true},
                        {"nils", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"not", ElixirTypes.NOT_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"notifiers", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"or", ElixirTypes.OR_WORD_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"order", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"rescue", ElixirTypes.RESCUE, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"rescuer", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"true", ElixirTypes.TRUE, ElixirFlexLexer.ADDITION_OR_KEYWORD_PAIR_OR_SUBTRACTION_OR_WHITE_SPACE_MAYBE, true},
                        {"truest", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"when", ElixirTypes.WHEN_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"whenever", ElixirTypes.IDENTIFIER_TOKEN, ElixirFlexLexer.AFTER_UNQUALIFIED_IDENTIFIER, true},
                        {"{}", ElixirTypes.OPENING_CURLY, MULTILINE_WHITE_SPACE_MAYBE, false},
                        {"|", ElixirTypes.PIPE_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"|>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"||", ElixirTypes.OR_SYMBOL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"|||", ElixirTypes.OR_SYMBOL_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"~", ElixirTypes.TILDE, ElixirFlexLexer.SIGIL, true},
                        {"~>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"~>>", ElixirTypes.ARROW_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_OR_MULTILINE_WHITE_SPACE_MAYBE, true},
                        {"~~~", ElixirTypes.UNARY_OPERATOR, ElixirFlexLexer.KEYWORD_PAIR_MAYBE, true},
                }
        );
    }

    protected int initialState() {
        return INITIAL_STATE;
    }
}
