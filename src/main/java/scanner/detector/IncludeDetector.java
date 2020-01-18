package scanner.detector;

import scanner.TokenDetector;
import scanner.token.Include;
import scanner.Token;

public class IncludeDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.startsWith("#include");
    }

    @Override
    public Token create(String word) {
        return new Include(word);
    }
}
