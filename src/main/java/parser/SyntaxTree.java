package parser;

import scanner.Token;

public class SyntaxTree {
    private Token root;
    private SyntaxTree left;
    private SyntaxTree right;

    public SyntaxTree(Token root) {
        this.root = root;
    }

    public SyntaxTree() {}

    public Token getRoot() {
        return root;
    }

    public Token getLeftChild() {
        return left.getRoot();
    }

    public Token getRightChild() {
        return right.getRoot();
    }

    public void setLeftChild(Token token) {
        this.left = new SyntaxTree(token);
    }

    public SyntaxTree getRight() {
        return right;
    }

    public void setRight(SyntaxTree right) {
        this.right = right;
    }

    public void setRoot(Token token) {
        this.root = token;
    }
}
