package org.example.pseudocode;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.AssemblyInstructionSequence;

import java.util.ArrayList;
import java.util.List;

public abstract class AssignmentInstructionSequence implements AssemblyInstructionSequence {
    private final List<AssemblyInstruction> instructions;

    public AssignmentInstructionSequence(List<AssemblyInstruction> instructions) {
        this.instructions = new ArrayList<>(instructions);
    }

    protected abstract List<AssemblyInstruction> getInstructionsToAppend();

    @Override
    public final List<AssemblyInstruction> getInstructions() {
        List<AssemblyInstruction> allInstruction = new ArrayList<>(instructions);
        allInstruction.addAll(getInstructionsToAppend());
        return allInstruction;
    }
}
