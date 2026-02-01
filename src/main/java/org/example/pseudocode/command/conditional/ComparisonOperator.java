package org.example.pseudocode.command.conditional;

public enum ComparisonOperator {
    UNCONDITIONAL("JMP"),
    EQUALS_ZERO("JEQ");

    private final String operator;

    ComparisonOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
