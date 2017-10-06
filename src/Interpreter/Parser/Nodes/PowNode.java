package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class PowNode extends Node {
    public PowNode(Node leftNode, Node rightNode){
        super(leftNode, rightNode);
    }

    @Override
    public double value() {
        return Math.pow(leftNode.value(), rightNode.value());
    }
}
