package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class MulNode extends Node {
    public MulNode(Node leftNode, Node rightNode){
        super(leftNode, rightNode);
    }

    @Override
    public double value() {
        return leftNode.value() * rightNode.value();
    }
}
