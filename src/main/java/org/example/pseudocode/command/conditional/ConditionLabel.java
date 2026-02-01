package org.example.pseudocode.command.conditional;

public class ConditionLabel {
    private final String conditionLabel;
    private final String negatedConditionLabel;
    private final String endLabel;

    public ConditionLabel(String variableName, ComparisonOperator operator) {
        this.conditionLabel = generateConditionLabel(variableName, operator);
        this.negatedConditionLabel = generateNegatedConditionLabel(this.conditionLabel);
        this.endLabel = generateEndLabel(this.conditionLabel);
    }

    public String getLabel() {
        return this.conditionLabel;
    }

    public String getNegatedLabel() {
        return this.negatedConditionLabel;
    }

    public String getEndLabel() {
        return this.endLabel;
    }

    private String generateConditionLabel(String variableName, ComparisonOperator operator) {
        return "WHEN_" + variableName + "_" + operator.name();
    }

    private String generateNegatedConditionLabel(String conditionLabel) {
        return "NOT_" + conditionLabel;
    }

    private String generateEndLabel(String conditionLabel) {
        return "END_OF_" + conditionLabel;
    }
}
