package org.example.pseudocode;

import org.example.assembly.instruction.AssemblyInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PseudoCode implements InstructionSequence {
    private final List<AssemblyInstruction> instructions;

    public PseudoCode() {
        this.instructions = new ArrayList<>();
    }

    public PseudoCode(List<AssemblyInstruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        instructions.addAll(this.instructions);
    }

    public List<AssemblyInstruction> getInstructions() {
        return instructions;
    }

    public static InstructionSequence withAssemblyInstructions(AssemblyInstruction... instructions) {
        return new PseudoCode(Arrays.stream(instructions).toList());
    }

    public static PseudoCode withInstructionSequences(InstructionSequence... sequences) {
        PseudoCode pseudoCode = new PseudoCode();

        for (InstructionSequence sequence : sequences) {
            sequence.emitTo(pseudoCode.instructions);
        }

        return pseudoCode;
    }
}
