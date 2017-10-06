package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class DivNode extends Node {
    public DivNode(Node leftNode, Node rightNode){
        super(leftNode, rightNode);
    }

    @Override
    public double value() {
        return leftNode.value() / rightNode.value();
    }
}
