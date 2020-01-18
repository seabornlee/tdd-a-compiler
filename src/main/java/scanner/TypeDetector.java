package scanner;

import java.util.Arrays;

public class TypeDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return Arrays.asList("int", "char").contains(word);
    }

    @Override
    public Token create(String word) {
        return new Type(word);
    }

}
