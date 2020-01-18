package scanner;

public class ReserveWordDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.endsWith("return");
    }

    @Override
    public Token create(String word) {
        return new ReverseWord(word);
    }
}
