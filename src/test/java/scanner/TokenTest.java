package scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.fest.assertions.api.Assertions.assertThat;

public class TokenTest {

    @Test
    public void should_generate_identifier_token() {
        Token count = new Token("name");
        assertThat(count.getName()).isEqualTo("id");
        assertThat(count.getValue()).isEqualTo("name");
    }

    @ParameterizedTest
    @CsvSource({
            "=", "+", "-", "*", "/", "%"
    })
    public void should_generate_operator_token(String word) {
        Token count = new Token(word);
        assertThat(count.getName()).isEqualTo(word);
        assertThat(count.getValue()).isNull();
    }
}