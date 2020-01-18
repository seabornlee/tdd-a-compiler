package scanner;

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
