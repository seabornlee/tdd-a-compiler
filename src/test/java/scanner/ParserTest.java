package scanner;

import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.SyntaxTree;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ParserTest {
    @Test
    void should_build_syntax_tree_with_tokens() {
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
}
