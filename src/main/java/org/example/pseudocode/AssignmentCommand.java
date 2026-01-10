package org.example.pseudocode;

import org.example.pseudocode.source.ConstantSource;
import org.example.pseudocode.source.PointerSource;
import org.example.pseudocode.source.Source;
import org.example.pseudocode.source.VariableSource;

import java.util.ArrayList;

public class AssignmentCommand {
    public static Source loadTheConstant(String constant) {
        return new ConstantSource(new ArrayList<>(), constant);
    }

    public static Source loadTheVariable(String variable) {
        return new VariableSource(new ArrayList<>(), variable);
    }

    public static Source loadThePointer(String variable) {
        return new PointerSource(new ArrayList<>(), variable);
    }

    public static AssignmentInstructionSequence increment(String variable) {
        return AssignmentCommand.loadTheVariable(variable).plusTheConstant("1").intoTheVariable(variable);
    }

    public static AssignmentInstructionSequence incrementThePointerOf(String variable) {
        return AssignmentCommand.loadThePointer(variable).plusTheConstant("1").intoThePointer(variable);
    }

    public static AssignmentInstructionSequence decrement(String variable) {
        return AssignmentCommand.loadTheVariable(variable).minusTheConstant("1").intoTheVariable(variable);
    }

    public static AssignmentInstructionSequence decrementThePointerOf(String variable) {
        return AssignmentCommand.loadThePointer(variable).minusTheConstant("1").intoThePointer(variable);
    }
}
