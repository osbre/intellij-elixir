package org.elixir_lang;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.elixir_lang.psi.ElixirTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by luke.imhoff on 8/2/14.
 */
public class ElixirSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ALIAS = createTextAttributesKey(
            "ELIXIR_ALIAS",
            DefaultLanguageHighlighterColors.CLASS_NAME
    );

    public static final TextAttributesKey ATOM = createTextAttributesKey(
            "ELIXIR_ATOM",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
    );

    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey(
            "ELIXIR_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
    );

    static final TextAttributesKey BIT = createTextAttributesKey(
            "ELIXIR_BIT"
    );

    public static final TextAttributesKey BRACES = createTextAttributesKey(
            "ELIXIR_BRACES",
            DefaultLanguageHighlighterColors.BRACES
    );

    static final TextAttributesKey BRACKETS = createTextAttributesKey(
            "ELIXIR_BRACKET",
            DefaultLanguageHighlighterColors.BRACKETS
    );

    static final TextAttributesKey COMMA = createTextAttributesKey(
            "ELIXIR_COMMA",
            DefaultLanguageHighlighterColors.COMMA
    );

    static final TextAttributesKey DOT = createTextAttributesKey(
            "ELIXIR_DOT",
            DefaultLanguageHighlighterColors.DOT
    );

    public static final TextAttributesKey CHAR_LIST = createTextAttributesKey(
            "ELIXIR_CHAR_LIST",
            DefaultLanguageHighlighterColors.STRING
    );

    public static final TextAttributesKey CHAR_TOKEN_TOKEN = createTextAttributesKey(
            "ELIXIR_CHAR_TOKEN",
            DefaultLanguageHighlighterColors.MARKUP_ENTITY
    );

    public static final TextAttributesKey COMMENT = createTextAttributesKey(
            "ELIXIR_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
    );

    public static final TextAttributesKey DECIMAL = createTextAttributesKey(
            "ELIXIR_DECIMAL",
            DefaultLanguageHighlighterColors.NUMBER
    );

    public static final TextAttributesKey DOCUMENTATION_MODULE_ATTRIBUTE = createTextAttributesKey(
            "ELIXIR_DOCUMENTATION_MODULE_ATTRIBUTE",
            DefaultLanguageHighlighterColors.DOC_COMMENT_TAG
    );

    public static final TextAttributesKey DOCUMENTATION_TEXT = createTextAttributesKey(
            "ELIXIR_DOCUMENTATION_TEXT",
            DefaultLanguageHighlighterColors.DOC_COMMENT_TAG_VALUE
    );

    static final TextAttributesKey EXPRESSION_SUBSTITUTION_MARK = createTextAttributesKey(
            "ELIXIR_EXPRESSION_SUBSTITUTION_MARK",
            DefaultLanguageHighlighterColors.BRACES
    );

    public static final TextAttributesKey FUNCTION_CALL = createTextAttributesKey(
            "ELIXIR_FUNCTION_CALL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
    );

    public static final TextAttributesKey FUNCTION_DECLARATION = createTextAttributesKey(
            "ELIXIR_FUNCTION_DECLARATION",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
    );

    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey(
            "ELIXIR_IDENTIFIER",
            DefaultLanguageHighlighterColors.IDENTIFIER
    );

    public static final TextAttributesKey INVALID_DIGIT = createTextAttributesKey(
            "ELIXIR_INVALID_DIGIT",
            HighlighterColors.BAD_CHARACTER
    );

    public static final TextAttributesKey KEYWORD = createTextAttributesKey(
            "ELIXIR_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
    );

    public static final TextAttributesKey MACRO_CALL = createTextAttributesKey(
            "ELIXIR_MACRO_CALL",
            FUNCTION_CALL
    );

    public static final TextAttributesKey MACRO_DECLARATION = createTextAttributesKey(
            "ELIXIR_MACRO_DECLARATION",
            FUNCTION_DECLARATION
    );

    public static final TextAttributesKey MAP = createTextAttributesKey(
            "ELIXIR_MAP",
            // DO NOT link to {@link ElixirSyntaxHighlighter.BRACES} since that's for Tuples in standard Elixir
            DefaultLanguageHighlighterColors.BRACES
    );

    public static final TextAttributesKey MODULE_ATTRIBUTE = createTextAttributesKey(
            "ELIXIR_MODULE_ATTRIBUTE",
            DefaultLanguageHighlighterColors.CONSTANT
    );

    public static final TextAttributesKey OBSOLETE_WHOLE_NUMBER_BASE = createTextAttributesKey(
            "ELIXIR_OBSOLETE_WHOLE_NUMBER_BASE",
            HighlighterColors.BAD_CHARACTER
    );

    public static final TextAttributesKey OPERATION_SIGN = createTextAttributesKey(
            "ELIXIR_OPERATION_SIGN",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
    );

    static final TextAttributesKey PARENTHESES = createTextAttributesKey(
            "ELIXIR_PARENTHESES",
            DefaultLanguageHighlighterColors.PARENTHESES
    );

    public static final TextAttributesKey PARAMETER = createTextAttributesKey(
            "ELIXIR_PARAMETER",
            DefaultLanguageHighlighterColors.PARAMETER
    );

    public static final TextAttributesKey PREDEFINED_CALL = createTextAttributesKey(
            "ELIXIR_PREDEFINED",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
    );

    public static final TextAttributesKey SEMICOLON = createTextAttributesKey(
            "ELIXIR_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON
    );

    public static final TextAttributesKey SIGIL = createTextAttributesKey(
            "ELIXIR_SIGIL",
            // Based on color used for Regular expression's boundaries in Ruby
            DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR
    );

    public static final TextAttributesKey SPECIFICATION = createTextAttributesKey(
            "ELIXIR_SPECIFICATION",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
    );

    public static final TextAttributesKey STRUCT = createTextAttributesKey(
            "ELIXIR_STRUCT",
            MAP
    );

    public static final TextAttributesKey CALLBACK = createTextAttributesKey(
            "ELIXIR_CALLBACK",
            SPECIFICATION
    );

    public static final TextAttributesKey STRING = createTextAttributesKey(
            "ELIXIR_STRING",
            DefaultLanguageHighlighterColors.STRING
    );

    public static final TextAttributesKey TYPE = createTextAttributesKey(
            "ELIXIR_TYPE",
            DefaultLanguageHighlighterColors.METADATA
    );

    public static final TextAttributesKey TYPE_PARAMETER = createTextAttributesKey(
            "ELIXIR_TYPE_PARAMETER",
            DefaultLanguageHighlighterColors.PARAMETER
    );

    public static final TextAttributesKey VALID_DIGIT = createTextAttributesKey(
            "ELIXIR_VALID_DIGIT",
            DefaultLanguageHighlighterColors.NUMBER
    );

    public static final TextAttributesKey VALID_ESCAPE_SEQUENCE = createTextAttributesKey(
            "ELIXIR_VALID_ESCAPE_SEQUENCE",
            DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE
    );

    public static final TextAttributesKey VARIABLE = createTextAttributesKey(
            "ELIXIR_VARIABLE",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE
    );

    public static final TextAttributesKey IGNORED_VARIABLE = createTextAttributesKey(
            "ELIXIR_IGNORED_VARIABLE",
            VARIABLE
    );

    public static final TextAttributesKey WHOLE_NUMBER_BASE = createTextAttributesKey(
            "ELIXIR_WHOLE_NUMBER_BASE",
            DefaultLanguageHighlighterColors.NUMBER
    );

    public static final TextAttributesKey[] ALIAS_KEYS = new TextAttributesKey[]{ALIAS};
    public static final TextAttributesKey[] ATOM_KEYS = new TextAttributesKey[]{ATOM};
    public static final TextAttributesKey[] ATOM_KEYWORD_KEYS = new TextAttributesKey[]{ATOM, KEYWORD};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    public static final TextAttributesKey[] BIT_KEYS = new TextAttributesKey[]{BIT};
    public static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};
    public static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{BRACKETS};
    public static final TextAttributesKey[] CHAR_LIST_KEYS = new TextAttributesKey[]{CHAR_LIST};
    private static final TextAttributesKey[] CHAR_TOKEN_KEYS = new TextAttributesKey[]{CHAR_TOKEN_TOKEN};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    public static final TextAttributesKey[] DECIMAL_KEYS = new TextAttributesKey[]{DECIMAL};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] EXPRESSION_SUBSTITUTION_MARK_KEYS = new TextAttributesKey[]{EXPRESSION_SUBSTITUTION_MARK};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] INVALID_DIGITS_KEYS = new TextAttributesKey[]{INVALID_DIGIT};
    public static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] OBSOLETE_WHOLE_NUMBER_BASE_KEYS = new TextAttributesKey[]{OBSOLETE_WHOLE_NUMBER_BASE};
    public static final TextAttributesKey[] OPERATION_SIGN_KEYS = new TextAttributesKey[]{OPERATION_SIGN};
    public static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[]{PARENTHESES};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] SIGIL_KEYS = new TextAttributesKey[]{SIGIL};
    public static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] VALID_DIGITS_KEYS = new TextAttributesKey[]{VALID_DIGIT};
    private static final TextAttributesKey[] WHOLE_NUMBER_BASE_KEYS = new TextAttributesKey[]{WHOLE_NUMBER_BASE};

    private static final TokenSet ATOMS = TokenSet.create(
            ElixirTypes.COLON,
            ElixirTypes.ATOM_FRAGMENT
    );
    private static final TokenSet ATOM_KEYWORDS = TokenSet.create(
            ElixirTypes.FALSE,
            ElixirTypes.NIL,
            ElixirTypes.TRUE
    );
    private static final TokenSet BIT_TOKEN_SET = TokenSet.create(
            ElixirTypes.CLOSING_BIT,
            ElixirTypes.OPENING_BIT
    );
    public static final TokenSet BRACES_TOKEN_SET = TokenSet.create(
            ElixirTypes.OPENING_CURLY,
            ElixirTypes.CLOSING_CURLY
    );
    private static final TokenSet BRACKETS_TOKEN_SET = TokenSet.create(
            ElixirTypes.OPENING_BRACKET,
            ElixirTypes.CLOSING_BRACKET
    );
    private static final TokenSet CHAR_LISTS = TokenSet.create(
            ElixirTypes.CHAR_LIST_FRAGMENT,
            ElixirTypes.CHAR_LIST_HEREDOC_PROMOTER,
            ElixirTypes.CHAR_LIST_HEREDOC_TERMINATOR,
            ElixirTypes.CHAR_LIST_PROMOTER,
            ElixirTypes.CHAR_LIST_SIGIL_HEREDOC_PROMOTER,
            ElixirTypes.CHAR_LIST_SIGIL_HEREDOC_TERMINATOR,
            ElixirTypes.CHAR_LIST_SIGIL_PROMOTER,
            ElixirTypes.CHAR_LIST_SIGIL_TERMINATOR,
            ElixirTypes.CHAR_LIST_TERMINATOR,
            ElixirTypes.INTERPOLATING_CHAR_LIST_SIGIL_NAME,
            ElixirTypes.LITERAL_CHAR_LIST_SIGIL_NAME
    );
    private static final TokenSet DECIMAL_TOKEN_SET = TokenSet.create(
            ElixirTypes.DECIMAL_MARK,
            ElixirTypes.NUMBER_SEPARATOR,
            ElixirTypes.EXPONENT_MARK
    );
    private static final TokenSet EXPRESSION_SUBSTITUTION_MARKS =  TokenSet.create(
            ElixirTypes.INTERPOLATION_START,
            ElixirTypes.INTERPOLATION_END
    );
    private static final TokenSet INVALID_DIGITS_TOKEN_SET = TokenSet.create(
            ElixirTypes.INVALID_BINARY_DIGITS,
            ElixirTypes.INVALID_DECIMAL_DIGITS,
            ElixirTypes.INVALID_HEXADECIMAL_DIGITS,
            ElixirTypes.INVALID_OCTAL_DIGITS,
            ElixirTypes.INVALID_UNKNOWN_BASE_DIGITS
    );
    private static final TokenSet KEYWORD_TOKEN_SET = TokenSet.create(
            ElixirTypes.AFTER,
            ElixirTypes.CATCH,
            ElixirTypes.DO,
            ElixirTypes.ELSE,
            ElixirTypes.END,
            ElixirTypes.FN,
            ElixirTypes.RESCUE
    );
    private static final TokenSet OBSOLETE_WHOLE_NUMBER_BASE_TOKEN_SET = TokenSet.create(
            ElixirTypes.OBSOLETE_BINARY_WHOLE_NUMBER_BASE,
            ElixirTypes.OBSOLETE_HEXADECIMAL_WHOLE_NUMBER_BASE
    );
    private static final TokenSet OPERATION_SIGNS = TokenSet.create(
            ElixirTypes.AND_SYMBOL_OPERATOR,
            ElixirTypes.AND_WORD_OPERATOR,
            ElixirTypes.ARROW_OPERATOR,
            ElixirTypes.ASSOCIATION_OPERATOR,
            ElixirTypes.AT_OPERATOR,
            ElixirTypes.CAPTURE_OPERATOR,
            ElixirTypes.COMPARISON_OPERATOR,
            ElixirTypes.DIVISION_OPERATOR,
            ElixirTypes.IN_OPERATOR,
            ElixirTypes.IN_MATCH_OPERATOR,
            ElixirTypes.MATCH_OPERATOR,
            ElixirTypes.MINUS_OPERATOR,
            ElixirTypes.MULTIPLICATION_OPERATOR,
            ElixirTypes.NEGATE_OPERATOR,
            ElixirTypes.NUMBER_OR_BADARITH_OPERATOR,
            ElixirTypes.OR_SYMBOL_OPERATOR,
            ElixirTypes.OR_WORD_OPERATOR,
            ElixirTypes.PIPE_OPERATOR,
            ElixirTypes.PLUS_OPERATOR,
            ElixirTypes.POWER_OPERATOR,
            ElixirTypes.RANGE_OPERATOR,
            ElixirTypes.RELATIONAL_OPERATOR,
            ElixirTypes.STAB_OPERATOR,
            ElixirTypes.TWO_OPERATOR,
            ElixirTypes.TYPE_OPERATOR,
            ElixirTypes.UNARY_OPERATOR,
            ElixirTypes.WHEN_OPERATOR
    );
    private static final TokenSet PARENTHESES_TOKEN_SET = TokenSet.create(
            ElixirTypes.CLOSING_PARENTHESIS,
            ElixirTypes.OPENING_PARENTHESIS
    );
    // @todo Highlight each type of sigil separately and group char list and string with non-sigil versions
    private static final TokenSet SIGILS = TokenSet.create(
            ElixirTypes.INTERPOLATING_REGEX_SIGIL_NAME,
            ElixirTypes.INTERPOLATING_SIGIL_NAME,
            ElixirTypes.INTERPOLATING_WORDS_SIGIL_NAME,
            ElixirTypes.LITERAL_REGEX_SIGIL_NAME,
            ElixirTypes.LITERAL_SIGIL_NAME,
            ElixirTypes.LITERAL_WORDS_SIGIL_NAME,
            ElixirTypes.REGEX_FRAGMENT,
            ElixirTypes.REGEX_HEREDOC_PROMOTER,
            ElixirTypes.REGEX_HEREDOC_TERMINATOR,
            ElixirTypes.REGEX_PROMOTER,
            ElixirTypes.REGEX_TERMINATOR,
            ElixirTypes.SIGIL_FRAGMENT,
            ElixirTypes.SIGIL_HEREDOC_PROMOTER,
            ElixirTypes.SIGIL_HEREDOC_TERMINATOR,
            ElixirTypes.SIGIL_MODIFIER,
            ElixirTypes.SIGIL_PROMOTER,
            ElixirTypes.SIGIL_TERMINATOR,
            ElixirTypes.TILDE,
            ElixirTypes.WORDS_FRAGMENT,
            ElixirTypes.WORDS_HEREDOC_PROMOTER,
            ElixirTypes.WORDS_HEREDOC_TERMINATOR,
            ElixirTypes.WORDS_PROMOTER,
            ElixirTypes.WORDS_TERMINATOR
    );
    private static final TokenSet STRINGS = TokenSet.create(
            ElixirTypes.INTERPOLATING_STRING_SIGIL_NAME,
            ElixirTypes.LITERAL_STRING_SIGIL_NAME,
            ElixirTypes.STRING_FRAGMENT,
            ElixirTypes.STRING_HEREDOC_PROMOTER,
            ElixirTypes.STRING_HEREDOC_TERMINATOR,
            ElixirTypes.STRING_PROMOTER,
            ElixirTypes.STRING_SIGIL_HEREDOC_PROMOTER,
            ElixirTypes.STRING_SIGIL_HEREDOC_TERMINATOR,
            ElixirTypes.STRING_SIGIL_PROMOTER,
            ElixirTypes.STRING_SIGIL_TERMINATOR,
            ElixirTypes.STRING_TERMINATOR
    );
    private static final TokenSet VALID_DIGITS_TOKEN_SET = TokenSet.create(
            ElixirTypes.VALID_BINARY_DIGITS,
            ElixirTypes.VALID_DECIMAL_DIGITS,
            ElixirTypes.VALID_HEXADECIMAL_DIGITS,
            ElixirTypes.VALID_OCTAL_DIGITS
    );
    private static final TokenSet WHOLE_NUMBER_BASE_TOKEN_SET = TokenSet.create(
            ElixirTypes.BASE_WHOLE_NUMBER_PREFIX,
            ElixirTypes.BINARY_WHOLE_NUMBER_BASE,
            ElixirTypes.HEXADECIMAL_WHOLE_NUMBER_BASE,
            ElixirTypes.OCTAL_WHOLE_NUMBER_BASE
    );

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ElixirLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ElixirTypes.ALIAS)) {
            return ALIAS_KEYS;
        } else if (ATOM_KEYWORDS.contains(tokenType)) {
            return ATOM_KEYWORD_KEYS;
        } else if (ATOMS.contains(tokenType)) {
            return ATOM_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (BIT_TOKEN_SET.contains(tokenType)) {
            return BIT_KEYS;
        } else if (BRACES_TOKEN_SET.contains(tokenType)) {
            return BRACES_KEYS;
        } else if (BRACKETS_TOKEN_SET.contains(tokenType)) {
            return BRACKETS_KEYS;
        } else if (CHAR_LISTS.contains(tokenType)) {
            return CHAR_LIST_KEYS;
        } else if (tokenType == ElixirTypes.CHAR_TOKENIZER) {
            return CHAR_TOKEN_KEYS;
        } else if (tokenType.equals(ElixirTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(ElixirTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (DECIMAL_TOKEN_SET.contains(tokenType)) {
            return DECIMAL_KEYS;
        } else if (tokenType.equals(ElixirTypes.DOT_OPERATOR)) {
            return DOT_KEYS;
        } else if (EXPRESSION_SUBSTITUTION_MARKS.contains(tokenType)) {
            return EXPRESSION_SUBSTITUTION_MARK_KEYS;
        } else if (tokenType.equals(ElixirTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (INVALID_DIGITS_TOKEN_SET.contains(tokenType)) {
            return INVALID_DIGITS_KEYS;
        } else if (KEYWORD_TOKEN_SET.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (OBSOLETE_WHOLE_NUMBER_BASE_TOKEN_SET.contains(tokenType)) {
            return OBSOLETE_WHOLE_NUMBER_BASE_KEYS;
        } else if (OPERATION_SIGNS.contains(tokenType)) {
            return OPERATION_SIGN_KEYS;
        } else if (PARENTHESES_TOKEN_SET.contains(tokenType)) {
            return PARENTHESES_KEYS;
        } else if (tokenType.equals(ElixirTypes.SEMICOLON)) {
            return SEMICOLON_KEYS;
        } else if (SIGILS.contains(tokenType)) {
            return SIGIL_KEYS;
        } else if (STRINGS.contains(tokenType)) {
            return STRING_KEYS;
        } else if (VALID_DIGITS_TOKEN_SET.contains(tokenType)) {
            return VALID_DIGITS_KEYS;
        } else if (WHOLE_NUMBER_BASE_TOKEN_SET.contains(tokenType)) {
            return WHOLE_NUMBER_BASE_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
