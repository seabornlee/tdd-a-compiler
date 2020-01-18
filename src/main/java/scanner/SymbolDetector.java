package scanner;

import java.util.Arrays;

public class SymbolDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return Arrays.asList(",", ";").contains(word);
    }

    @Override
    public Token create(String word) {
        return new Symbol(word);
    }
}
