package scanner;

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
