package scanner;

public class Include extends Token {
    public Include(String header) {
        super(header.substring("#include<".length(), header.length() - 1));
    }
}
