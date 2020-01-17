package scanner;


import java.util.Objects;

import static java.util.Arrays.asList;

public class Token {
    private String name;
    private String value;

    public Token(String name) {
        this.name = name;
    }

    public Token(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static Token of(String word) {
        if (isOperator(word)) {
            return new Operator(word);
        }

        if (isValue(word)) {
            return new Value(word);
        }

        if (isIdentifier(word)) {
            return new Identifier(word);
        }

        return null;
    }

    private static boolean isValue(String word) {
        return word.matches("\\d+");
    }

    private static boolean isOperator(String word) {
        return asList("=", "+", "-", "*", "/", "%").contains(word);
    }

    private static boolean isIdentifier(String word) {
        return word.matches("\\w+");
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "<" + name + ", " + value + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(name, token.name) &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    public boolean isIdentifier() {
        return this instanceof Identifier;
    }

    public boolean isOperator() {
        return this instanceof Operator;
    }

    public boolean isValue() {
        return this instanceof Value;
    }
}
