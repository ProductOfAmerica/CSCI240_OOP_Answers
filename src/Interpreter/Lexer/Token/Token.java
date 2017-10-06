package Interpreter.Lexer.Token;

public class Token {
    private TokenType tokenType;
    private String name;
    private double value;

    public Token(TokenType tokenType, String name, double value) {
        this.tokenType = tokenType;
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return String.format("%-14s%14s%16.3f", tokenType, name, value);
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}