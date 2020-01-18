package scanner;

import org.junit.jupiter.api.Test;
import org.apache.commons.io.IOUtils;
import scanner.Token;
import scanner.Scanner;
import scanner.token.*;

import java.io.IOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTest {
    @Test
    public void should_generate_tokens_from_source_code() {
        String source = "position = initial + rate * 60";
        List<Token> tokens = new Scanner().scan(source);
        assertThat(tokens).hasSize(7);
        assertThat(tokens.get(0)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(0).getValue()).isEqualTo("position");
        assertThat(tokens.get(1)).isInstanceOf(Operator.class);
        assertThat(tokens.get(1).getValue()).isEqualTo("=");
        assertThat(tokens.get(2)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(2).getValue()).isEqualTo("initial");
        assertThat(tokens.get(3)).isInstanceOf(Operator.class);
        assertThat(tokens.get(3).getValue()).isEqualTo("+");
        assertThat(tokens.get(4)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(4).getValue()).isEqualTo("rate");
        assertThat(tokens.get(5)).isInstanceOf(Operator.class);
        assertThat(tokens.get(5).getValue()).isEqualTo("*");
        assertThat(tokens.get(6)).isInstanceOf(Value.class);
        assertThat(tokens.get(6).getValue()).isEqualTo("60");
    }

    @Test
    void should_generate_tokens() throws IOException {
        String code = IOUtils.toString(
                this.getClass().getResourceAsStream("/sum.c"),
                UTF_8
        );

        List<Token> tokens = new Scanner().scan(code);
        assertThat(tokens.get(0)).isInstanceOf(Include.class);
        assertThat(tokens.get(0).getValue()).isEqualTo("stdio.h");
        assertThat(tokens.get(1)).isInstanceOf(Type.class);
        assertThat(tokens.get(1).getValue()).isEqualTo("int");
        assertThat(tokens.get(2)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(2).getValue()).isEqualTo("main");
        assertThat(tokens.get(3)).isInstanceOf(OpenClause.class);
        assertThat(tokens.get(3).getValue()).isEqualTo("(");
        assertThat(tokens.get(4)).isInstanceOf(Type.class);
        assertThat(tokens.get(4).getValue()).isEqualTo("int");
        assertThat(tokens.get(5)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(5).getValue()).isEqualTo("argc");
        assertThat(tokens.get(6)).isInstanceOf(Symbol.class);
        assertThat(tokens.get(6).getValue()).isEqualTo(",");
        assertThat(tokens.get(7)).isInstanceOf(Pointer.class);
        assertThat(tokens.get(7).getValue()).isEqualTo("char");
        assertThat(tokens.get(8)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(8).getValue()).isEqualTo("argv");
        assertThat(tokens.get(9)).isInstanceOf(OpenClause.class);
        assertThat(tokens.get(9).getValue()).isEqualTo("[");
        assertThat(tokens.get(10)).isInstanceOf(CloseClause.class);
        assertThat(tokens.get(10).getValue()).isEqualTo("]");
        assertThat(tokens.get(11)).isInstanceOf(CloseClause.class);
        assertThat(tokens.get(11).getValue()).isEqualTo(")");
        assertThat(tokens.get(12)).isInstanceOf(OpenClause.class);
        assertThat(tokens.get(12).getValue()).isEqualTo("{");
        assertThat(tokens.get(13)).isInstanceOf(Type.class);
        assertThat(tokens.get(13).getValue()).isEqualTo("int");
        assertThat(tokens.get(14)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(14).getValue()).isEqualTo("sum");
        assertThat(tokens.get(15)).isInstanceOf(Operator.class);
        assertThat(tokens.get(15).getValue()).isEqualTo("=");
        assertThat(tokens.get(16)).isInstanceOf(Value.class);
        assertThat(tokens.get(16).getValue()).isEqualTo("1");
        assertThat(tokens.get(17)).isInstanceOf(Operator.class);
        assertThat(tokens.get(17).getValue()).isEqualTo("+");
        assertThat(tokens.get(18)).isInstanceOf(Value.class);
        assertThat(tokens.get(18).getValue()).isEqualTo("2");
        assertThat(tokens.get(19)).isInstanceOf(Symbol.class);
        assertThat(tokens.get(19).getValue()).isEqualTo(";");
        assertThat(tokens.get(20)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(20).getValue()).isEqualTo("printf");
        assertThat(tokens.get(21)).isInstanceOf(OpenClause.class);
        assertThat(tokens.get(21).getValue()).isEqualTo("(");
        assertThat(tokens.get(22)).isInstanceOf(Value.class);
        assertThat(tokens.get(22).getValue()).isEqualTo("sum=%d\\n");
        assertThat(tokens.get(23)).isInstanceOf(Symbol.class);
        assertThat(tokens.get(23).getValue()).isEqualTo(",");
        assertThat(tokens.get(24)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(24).getValue()).isEqualTo("sum");
        assertThat(tokens.get(25)).isInstanceOf(CloseClause.class);
        assertThat(tokens.get(25).getValue()).isEqualTo(")");
        assertThat(tokens.get(26)).isInstanceOf(ReverseWord.class);
        assertThat(tokens.get(26).getValue()).isEqualTo("return");
        assertThat(tokens.get(27)).isInstanceOf(Value.class);
        assertThat(tokens.get(27).getValue()).isEqualTo("0");
        assertThat(tokens.get(28)).isInstanceOf(Symbol.class);
        assertThat(tokens.get(28).getValue()).isEqualTo(";");
        assertThat(tokens.get(29)).isInstanceOf(CloseClause.class);
        assertThat(tokens.get(29).getValue()).isEqualTo("}");
    }
}
