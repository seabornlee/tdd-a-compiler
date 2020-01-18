package scanner;

public interface TokenDetector {
    boolean match(String word);
    Token create(String word);
}
