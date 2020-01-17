package parser;

import scanner.Token;

import java.util.List;

public class Parser {
    private List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public SyntaxTree parse() {
        SyntaxTree syntaxTree = new SyntaxTree();
        parse(syntaxTree, this.tokens);
        return syntaxTree;
    }

    private void parse(SyntaxTree syntaxTree, List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token.isValue()) {
                syntaxTree.setRoot(token);
                continue;
            }

            if (token.isIdentifier()) {
                syntaxTree.setLeftChild(token);
                continue;
            }

            if (token.isOperator()) {
                syntaxTree.setRoot(token);
                SyntaxTree right = new SyntaxTree();
                parse(right, tokens.subList(i + 1, tokens.size()));
                syntaxTree.setRight(right);
                return;
            }
        }
    }

}
