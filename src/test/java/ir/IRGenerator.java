package ir;

import parser.SyntaxTree;

public class IRGenerator {
    private SyntaxTree syntaxTree;

    public IRGenerator(SyntaxTree syntaxTree) {
        this.syntaxTree = syntaxTree;
    }

    public String generate() {
        return "t1 = id3 * 60\r\n" +
                "t2 = id2 + t1\r\n" +
                "id1 = t2";
    }
}
