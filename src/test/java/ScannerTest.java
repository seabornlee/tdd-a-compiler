import org.junit.jupiter.api.Test;
import scanner.*;
import org.apache.commons.io.IOUtils;

import java.awt.*;
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
        assertThat(tokens.get(0).getName()).isEqualTo("id");
        assertThat(tokens.get(0).getValue()).isEqualTo("position");
        assertThat(tokens.get(1).getName()).isEqualTo("=");
        assertThat(tokens.get(1).getValue()).isNull();
        assertThat(tokens.get(2).getName()).isEqualTo("id");
        assertThat(tokens.get(2).getValue()).isEqualTo("initial");
        assertThat(tokens.get(3).getName()).isEqualTo("+");
        assertThat(tokens.get(3).getValue()).isNull();
        assertThat(tokens.get(4).getName()).isEqualTo("id");
        assertThat(tokens.get(4).getValue()).isEqualTo("rate");
        assertThat(tokens.get(5).getName()).isEqualTo("*");
        assertThat(tokens.get(5).getValue()).isNull();
        assertThat(tokens.get(6).getName()).isEqualTo("60");
        assertThat(tokens.get(6).getValue()).isNull();
    }

    @Test
    void should_generate_tokens() throws IOException {
        String code = IOUtils.toString(
                this.getClass().getResourceAsStream("sum.c"),
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
        assertThat(tokens.get(4)).isInstanceOf(Type.class);
        assertThat(tokens.get(4).getValue()).isEqualTo("int");
        assertThat(tokens.get(5)).isInstanceOf(Identifier.class);
        assertThat(tokens.get(5).getValue()).isEqualTo("argc");
        assertThat(tokens.get(6)).isInstanceOf(Symbol.class);
        assertThat(tokens.get(6).getValue()).isEqualTo(",");
        assertThat(tokens.get(7)).isInstanceOf(Pointer.class);
        assertThat(tokens.get(7).getValue()).isEqualTo("char");
    }
}
