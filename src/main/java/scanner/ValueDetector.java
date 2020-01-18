package scanner;

public class ValueDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return isIntValue(word) || isStringValue(word);
    }

    private boolean isIntValue(String word) {
        return word.matches("\\d+");
    }

    private boolean isStringValue(String word) {
        return word.startsWith("\"") && word.endsWith("\"");
    }

    @Override
    public Token create(String word) {
        if (isStringValue(word)) {
            return new Value(word.substring(1, word.length() - 1));
        }
        return new Value(word);
    }
}
