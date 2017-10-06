package Interpreter.Parser;

public abstract class Node {
    protected Node rightNode, leftNode;
    protected double value;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node(double val) {
        value = val;
    }

    public abstract double value();
}