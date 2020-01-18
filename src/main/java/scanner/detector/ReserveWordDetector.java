package scanner.detector;

import scanner.TokenDetector;
import scanner.token.ReverseWord;
import scanner.Token;

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
