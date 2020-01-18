package parser;

import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.SyntaxTree;
import scanner.Token;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParserTest {
    @Test
    void should_build_syntax_tree_with_tokens_given_one_operator() {
        Token id = Token.of("count");
        Token equal = Token.of("=");
        Token value = Token.of("1");
        List<Token> tokens = Arrays.asList(id, equal, value);

        SyntaxTree syntaxTree = new Parser(tokens).parse();

        assertThat(syntaxTree).isNotNull();
        assertThat(syntaxTree.getRoot()).isEqualTo(equal);
        assertThat(syntaxTree.getLeftChild()).isEqualTo(id);
        assertThat(syntaxTree.getRightChild()).isEqualTo(value);
    }
    @Test
    void should_build_syntax_tree_with_tokens_given_multiple_operators() {
        List<Token> tokens = Arrays.asList(
                Token.of("position"),
                Token.of("="),
                Token.of("initial"),
                Token.of("+"),
                Token.of("rate"),
                Token.of("*"),
                Token.of("60")
        );

        SyntaxTree syntaxTree = new Parser(tokens).parse();

        assertThat(syntaxTree).isNotNull();
        assertThat(syntaxTree.getRoot()).isEqualTo(Token.of("="));
        assertThat(syntaxTree.getLeftChild()).isEqualTo(Token.of("position"));
        SyntaxTree right = syntaxTree.getRight();
        assertThat(right.getRoot()).isEqualTo(Token.of("+"));
        assertThat(right.getLeftChild()).isEqualTo(Token.of("initial"));
        SyntaxTree rightOfRight = right.getRight();
        assertThat(rightOfRight.getRoot()).isEqualTo(Token.of("*"));
        assertThat(rightOfRight.getLeftChild()).isEqualTo(Token.of("rate"));
        assertThat(rightOfRight.getRightChild()).isEqualTo(Token.of("60"));
    }
}
