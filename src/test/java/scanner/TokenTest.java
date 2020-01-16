package scanner;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TokenTest {

    @Test
    public void should_generate_identifier_token() {
        Token count = new Token("name");
        assertThat(count.getName()).isEqualTo("id");
        assertThat(count.getValue()).isEqualTo("name");
    }

    @Test
    public void should_generate_operator_token() {
        Token count = new Token("=");
        assertThat(count.getName()).isEqualTo("=");
    }
}