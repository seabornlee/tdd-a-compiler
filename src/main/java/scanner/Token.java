package scanner;

import static java.util.Arrays.asList;

public class Token {
    private String name;
    private String value;

    public Token(String word) {
        if (isSymbol(word) || isValue(word)) {
            this.name = word;
            return;
        }

        if (isIdentifier(word)) {
            this.name = "id";
            this.value = word;
        }
    }

    private boolean isValue(String word) {
        return word.matches("\\d+");
    }

    private boolean isSymbol(String word) {
        return asList("=", "+", "-", "*", "/", "%").contains(word);
    }

    private boolean isIdentifier(String word) {
        return word.matches("\\w+");
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
