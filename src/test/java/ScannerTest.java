import org.junit.jupiter.api.Test;
import scanner.Scanner;
import scanner.Token;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTest {
    @Test
    public void should_generate_token() {
        String source = "count = 1";
        List<Token> tokens = new Scanner().scan(source);
        assertThat(tokens).hasSize(3);
        assertThat(tokens.get(0).getName()).isEqualTo("id");
        assertThat(tokens.get(0).getValue()).isEqualTo("count");
        assertThat(tokens.get(1).getName()).isEqualTo("=");
        assertThat(tokens.get(1).getValue()).isNull();
        assertThat(tokens.get(2).getName()).isEqualTo("1");
        assertThat(tokens.get(2).getValue()).isNull();
    }
}
