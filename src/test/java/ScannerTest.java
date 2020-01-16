import org.junit.jupiter.api.Test;
import scanner.Scanner;
import scanner.Token;

import java.util.List;

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
}
