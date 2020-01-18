package scanner;

public class ValueDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.matches("\\d+");
    }

    @Override
    public Token create(String word) {
        return new Value(word);
    }
}
