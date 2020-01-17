package parser;

import scanner.Token;

import java.util.List;

public class Parser {
    private List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public SyntaxTree parse() {
        SyntaxTree syntaxTree = new SyntaxTree(tokens.get(1));
        syntaxTree.setLeftChild(tokens.get(0));
        syntaxTree.setRightChild(tokens.get(2));
        return syntaxTree;
    }
}
