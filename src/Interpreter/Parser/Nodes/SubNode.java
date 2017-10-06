package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class SubNode extends Node {
    public SubNode(Node leftNode, Node rightNode){
        super(leftNode, rightNode);
    }

    @Override
    public double value() {
        return leftNode.value() - rightNode.value();
    }
}
