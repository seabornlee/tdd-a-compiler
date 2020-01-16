package scanner;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Scanner {
    public List<Token> scan(String source) {
        String[] words = source.split("\\s");
        return Arrays.stream(words)
                .map(Token::new)
                .collect(toList());
    }
}
