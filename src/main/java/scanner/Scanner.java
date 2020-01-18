package scanner;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Scanner {
    public List<Token> scan(String source) {
        String[] words = source.split("\\s");
        List<String> elements = process(words);
        return elements.stream()
                .map(Token::of)
                .collect(toList());
    }

    private List<String> process(String[] words) {
        List<String> elements = new ArrayList<>();
        for (String word : words) {
            if (word.contains("(")) {
                elements.add(word.substring(0, word.indexOf("(")));
                elements.add("(");
                elements.add(word.substring(word.indexOf("(") + 1));
            } else if (word.contains(",")) {
                elements.add(word.substring(0, word.indexOf(",")));
                elements.add(",");
            } else {
                elements.add(word);
            }
        }
        return elements;
    }
}
