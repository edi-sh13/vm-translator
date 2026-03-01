package org.example.pseudocode.command.conditional;

public enum ComparisonOperator {
    UNCONDITIONAL("JMP"),
    EQUALS_ZERO("JEQ"),
    LESS_THAN_ZERO("JLT"),
    GREATER_THAN_ZERO("JGT"),
    NOT_EQUAL_TO_ZERO("JNE");

    private final String operator;

    ComparisonOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
