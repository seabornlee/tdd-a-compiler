package scanner.detector;

import scanner.TokenDetector;
import scanner.token.CloseClause;
import scanner.Token;

import java.util.Arrays;

public class CloseClauseDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return Arrays.asList(")", "]", "}").contains(word);
    }

    @Override
    public Token create(String word) {
        return new CloseClause(word);
    }
}
