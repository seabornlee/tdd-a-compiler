package ir;

import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.SyntaxTree;
import scanner.Scanner;
import scanner.Token;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class IRGeneratorTest {
    @Test
    void should_generate_ir_code() {
        Scanner scanner = new Scanner();
        List<Token> tokens = scanner.scan("position = initial + rate * 60");
        Parser parser = new Parser(tokens);
        SyntaxTree syntaxTree = parser.parse();

        IRGenerator irGenerator = new IRGenerator(syntaxTree);
        String ir = irGenerator.generate();

        assertThat(ir).isEqualTo(
                        "t1 = id3 * 60\r\n" +
                        "t2 = id2 + t1\r\n" +
                        "id1 = t2");
    }
}
