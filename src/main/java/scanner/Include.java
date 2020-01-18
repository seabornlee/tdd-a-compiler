package scanner;

public class Include extends Token {
    public Include(String header) {
        super("include", header.substring("#include<".length(), header.length() - 1));
    }
}
