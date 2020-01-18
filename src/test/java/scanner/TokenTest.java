package scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.fest.assertions.api.Assertions.assertThat;

public class TokenTest {

    @Test
    public void should_generate_identifier_token() {
        assertThat(Token.of("name")).isInstanceOf(Identifier.class);
        assertThat(Token.of("name").getValue()).isEqualTo("name");

        assertThat(Token.of("argc")).isInstanceOf(Identifier.class);
        assertThat(Token.of("argc").getValue()).isEqualTo("argc");
    }

    @ParameterizedTest
    @CsvSource({
            "=", "+", "-", "*", "/", "%"
    })
    public void should_generate_operator_token(String word) {
        Token token = Token.of(word);
        assertThat(token).isInstanceOf(Operator.class);
        assertThat(token.getValue()).isEqualTo(word);
    }

    @Test
    void should_generate_include_token() {
        Token token = Token.of("#include<stdio.h>");
        assertThat(token).isInstanceOf(Include.class);
        assertThat(token.getValue()).isEqualTo("stdio.h");
    }
}