package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class AddNode extends Node {
    public AddNode(Node leftNode, Node rightNode){
        super(leftNode, rightNode);
    }

    @Override
    public double value() {
        return leftNode.value() + rightNode.value();
    }
}
