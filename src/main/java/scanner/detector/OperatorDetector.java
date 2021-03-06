package scanner.detector;

import scanner.TokenDetector;
import scanner.token.Operator;
import scanner.Token;

import static java.util.Arrays.asList;

public class OperatorDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return asList("=", "+", "-", "*", "/", "%").contains(word);
    }

    @Override
    public Token create(String word) {
        return new Operator(word);
    }
}
