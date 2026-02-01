package org.example.pseudocode.command.conditional;

public class ConditionalCommand {
    public static WhenStatement when(String variableName, ComparisonOperator operator) {
        return new WhenStatement(variableName, operator);
    }
}
