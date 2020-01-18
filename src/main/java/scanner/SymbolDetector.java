package scanner;

public class SymbolDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.equals(",");
    }

    @Override
    public Token create(String word) {
        return new Symbol(word);
    }
}
