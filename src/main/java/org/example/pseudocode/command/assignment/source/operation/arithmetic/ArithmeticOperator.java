package org.example.pseudocode.command.assignment.source.operation.arithmetic;

public enum ArithmeticOperator {
    PLUS("+"),
    MINUS("-");

    private final String symbol;

    ArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
