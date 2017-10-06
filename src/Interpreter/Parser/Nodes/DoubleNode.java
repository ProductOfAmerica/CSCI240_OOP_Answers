package Interpreter.Parser.Nodes;

import Interpreter.Parser.Node;

public class DoubleNode extends Node {
    public DoubleNode(double dub) {
        super(dub);
    }

    @Override
    public double value() {
        return value;
    }
}