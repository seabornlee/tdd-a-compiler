package scanner;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Token {
    private String value;

    public Token(String value) {
        this.value = value;
    }

    public static Token of(String word) {
        List<TokenDetector> detectors = new ArrayList<>();
        detectors.add(new OperatorDetector());
        detectors.add(new TypeDetector());
        detectors.add(new OpenClauseDetector());
        detectors.add(new SymbolDetector());
        detectors.add(new PointerDetector());
        detectors.add(new ValueDetector());
        detectors.add(new IdentifierDetector());
        detectors.add(new IncludeDetector());

        return detectors.stream().filter(detector -> detector.match(word))
                .findFirst()
                .map(detector -> detector.create(word))
                .orElse(null);

    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "<" + value + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value.equals(token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
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
