package Interpreter.Parser;

import Interpreter.Lexer.Token.Token;
import Interpreter.Lexer.Token.TokenType;
import Interpreter.Parser.Nodes.*;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private LinkedList<Token> tokenList;
    private Token currToken;

    public Parser(List<Token> tokens) throws ParseException {
        currToken = null;
        if((tokenList = new LinkedList<>(tokens)).isEmpty()) //Stop the parse, there's nothing to do
            throw new ParseException("Empty token list.", 0);
    }

    public double parse(){
        return expression().value();
    }

    private Node expression(){
        return restExpression(term());
    }

    private Node restExpression(Node node){
        Token temp = getCurrToken(false); //don't pop it, we might not be looking for this token
        if(temp.getTokenType() == TokenType.T_MINUS){
            nextToken();
            return restExpression(new SubNode(node, term()));
        }else if(temp.getTokenType() == TokenType.T_PLUS){
            nextToken();
            return restExpression(new AddNode(node, term()));
        }else if(temp.getTokenType() == TokenType.T_MODULUS){
            nextToken(); //pop it, we found our term, search for the next one
            return restExpression(new ModNode(node, term()));
        }else if(temp.getTokenType() == TokenType.T_POWER){
            nextToken(); //pop it, we found our term, search for the next one
            return restExpression(new PowNode(node, term()));
        }
        return node;
    }

    private Node term(){
        return restTerm(factor());
    }

    private Node restTerm(Node node){
        Token temp = getCurrToken(false); //don't pop it, we might not be looking for this token
        if(temp.getTokenType() == TokenType.T_MUL){
            nextToken(); //pop it, we found our term, search for the next one
            return restExpression(new MulNode(node, factor()));
        }else if(temp.getTokenType() == TokenType.T_DIV){
            nextToken(); //pop it, we found our term, search for the next one
            return restTerm(new DivNode(node, factor()));
        }
        return node;
    }

    private Node factor(){
        return new DoubleNode(getCurrToken(true).getValue());
    }

    private Token peekToken(){
        return tokenList.peek(); //Look at the next token in the list
    }

    private Token getCurrToken(boolean pop){
        if(pop){
            Token temp = getCurrToken(false);
            if(peekToken() != null) //make sure we can actually advance
                nextToken(); //move the current token forward (for next call)
            return temp; //return the current token
        }else {
            return (currToken == null) ? nextToken() : currToken;
        }
    }

    private Token nextToken(){
        return (currToken = tokenList.pop());
    }
}