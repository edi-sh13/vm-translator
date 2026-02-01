package org.example.pseudocode.command.assignment.source;

import org.example.pseudocode.InstructionSequence;
import org.example.pseudocode.command.assignment.destination.PointerDestination;
import org.example.pseudocode.command.assignment.destination.VariableDestination;
import org.example.pseudocode.command.assignment.source.operation.arithmetic.ArithmeticOperator;
import org.example.pseudocode.command.assignment.source.operation.arithmetic.ArithmeticConstantOperation;
import org.example.pseudocode.command.assignment.source.operation.arithmetic.ArithmeticPointerOperation;
import org.example.pseudocode.command.assignment.source.operation.arithmetic.ArithmeticVariableOperation;
import org.example.pseudocode.command.assignment.source.operation.logical.ANDVariableOperation;
import org.example.pseudocode.command.assignment.source.operation.logical.NOTVariableOperation;
import org.example.pseudocode.command.assignment.source.operation.logical.ORVariableOperation;

public class SourceCommand {
    private final InstructionSequence source;

    public SourceCommand(InstructionSequence source) {
        this.source = source;
    }

    public InstructionSequence intoTheVariable(String destinationVariableName) {
        return new VariableDestination(source, destinationVariableName);
    }

    public InstructionSequence intoThePointer(String destinationVariableName) {
        return new PointerDestination(source, destinationVariableName);
    }

    public SourceCommand plusTheConstant(int constant) {
        return new SourceCommand(new ArithmeticConstantOperation(source, constant, ArithmeticOperator.PLUS));
    }

    public SourceCommand minusTheConstant(int constant) {
        return new SourceCommand(new ArithmeticConstantOperation(source, constant, ArithmeticOperator.MINUS));
    }

    public SourceCommand plusTheVariable(String variableName) {
        return new SourceCommand(new ArithmeticVariableOperation(source, variableName, ArithmeticOperator.PLUS));
    }

    public SourceCommand minusTheVariable(String variableName) {
        return new SourceCommand(new ArithmeticVariableOperation(source, variableName, ArithmeticOperator.MINUS));
    }

    public SourceCommand plusThePointer(String variableName) {
        return new SourceCommand(new ArithmeticPointerOperation(source, variableName, ArithmeticOperator.PLUS));
    }

    public SourceCommand minusThePointer(String variableName) {
        return new SourceCommand(new ArithmeticPointerOperation(source, variableName, ArithmeticOperator.MINUS));
    }

    public SourceCommand AND(String variableName) {
        return new SourceCommand(new ANDVariableOperation(source, variableName));
    }

    public SourceCommand OR(String variableName) {
        return new SourceCommand(new ORVariableOperation(source, variableName));
    }

    public SourceCommand NOT() {
        return new SourceCommand(new NOTVariableOperation(source));
    }
}
