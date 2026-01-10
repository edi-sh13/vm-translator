package org.example.pseudocode.source;

import org.example.pseudocode.destination.PointerDestination;
import org.example.pseudocode.destination.VariableDestination;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.AssignmentInstructionSequence;
import org.example.pseudocode.operation.arithmetic.MinusConstantOperation;
import org.example.pseudocode.operation.arithmetic.MinusPointerOperation;
import org.example.pseudocode.operation.arithmetic.MinusVariableOperation;
import org.example.pseudocode.operation.arithmetic.PlusConstantOperation;
import org.example.pseudocode.operation.arithmetic.PlusPointerOperation;
import org.example.pseudocode.operation.arithmetic.PlusVariableOperation;
import org.example.pseudocode.operation.logical.ANDVariableOperation;
import org.example.pseudocode.operation.logical.NOTVariableOperation;
import org.example.pseudocode.operation.logical.ORVariableOperation;

import java.util.List;

public abstract class Source extends AssignmentInstructionSequence {
    protected Source(List<AssemblyInstruction> instructions) {
        super(instructions);
    }

    public AssignmentInstructionSequence intoTheVariable(String destination) {
        return new VariableDestination(getInstructions(), destination);
    }

    public AssignmentInstructionSequence intoThePointer(String destination) {
        return new PointerDestination(getInstructions(), destination);
    }

    public Source plusTheConstant(String value) {
        return new PlusConstantOperation(getInstructions(), value);
    }

    public Source plusTheVariable(String value) {
        return new PlusVariableOperation(getInstructions(), value);
    }

    public Source plusThePointerOf(String value) {
        return new PlusPointerOperation(getInstructions(), value);
    }

    public Source minusTheConstant(String value) {
        return new MinusConstantOperation(getInstructions(), value);
    }

    public Source minusTheVariable(String value) {
        return new MinusVariableOperation(getInstructions(), value);
    }

    public Source minusThePointerOf(String value) {
        return new MinusPointerOperation(getInstructions(), value);
    }

    public Source AND(String value) {
        return new ANDVariableOperation(getInstructions(), value);
    }

    public Source OR(String value) {
        return new ORVariableOperation(getInstructions(), value);
    }

    public Source NOT() {
        return new NOTVariableOperation(getInstructions());
    }
}
