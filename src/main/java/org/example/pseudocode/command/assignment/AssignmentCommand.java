package org.example.pseudocode.command.assignment;

import org.example.pseudocode.InstructionSequence;
import org.example.pseudocode.command.assignment.source.ConstantSource;
import org.example.pseudocode.command.assignment.source.PointerSource;
import org.example.pseudocode.command.assignment.source.SourceCommand;
import org.example.pseudocode.command.assignment.source.VariableSource;

public class AssignmentCommand {
    public static SourceCommand loadTheConstant(int constant) {
        return new SourceCommand(new ConstantSource(constant));
    }

    public static SourceCommand loadTheVariable(String variableName) {
        return new SourceCommand(new VariableSource(variableName));
    }

    public static SourceCommand loadThePointer(String variableName) {
        return new SourceCommand(new PointerSource(variableName));
    }

    public static InstructionSequence increment(String variableName) {
        return loadTheVariable(variableName).plusTheConstant(1).intoTheVariable(variableName);
    }

    public static InstructionSequence decrement(String variableName) {
        return loadTheVariable(variableName).minusTheConstant(1).intoTheVariable(variableName);
    }
}
