package scanner;

public class OpenClauseDetector implements TokenDetector {
    @Override
    public boolean match(String word) {
        return word.equals("(");
    }

    @Override
    public Token create(String word) {
        return new OpenClause(word);
    }
}
