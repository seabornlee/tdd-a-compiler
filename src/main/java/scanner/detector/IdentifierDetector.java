package scanner.detector;

import scanner.TokenDetector;
import scanner.token.Identifier;
import scanner.Token;

public class IdentifierDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.matches("\\w+");
    }

    @Override
    public Token create(String word) {
        return new Identifier(word);
    }
}
