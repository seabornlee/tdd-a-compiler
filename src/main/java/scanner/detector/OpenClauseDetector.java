package scanner.detector;

import scanner.TokenDetector;
import scanner.token.OpenClause;
import scanner.Token;

import java.util.Arrays;

public class OpenClauseDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return Arrays.asList("(", "[", "{").contains(word);
    }

    @Override
    public Token create(String word) {
        return new OpenClause(word);
    }
}
