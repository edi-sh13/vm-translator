package org.example.pseudocode;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.AssemblyInstructionSequence;

import java.util.ArrayList;
import java.util.List;

public class PseudoCode {
    private final List<AssemblyInstructionSequence> assemblyInstructionSequences = new ArrayList<>();

    public void addInstructionSequence(AssemblyInstructionSequence sequence) {
        assemblyInstructionSequences.add(sequence);
    }

    public String toAssembly() {
        StringBuilder sb = new StringBuilder();

        for (AssemblyInstructionSequence sequence : assemblyInstructionSequences) {
            for (AssemblyInstruction instruction : sequence.getInstructions()) {
                sb.append(instruction.toAssembly());
            }
        }

        return sb.toString();
    }

    public static PseudoCode withInstructionSequences(AssemblyInstructionSequence... sequences) {
        PseudoCode pseudoCode = new PseudoCode();

        for (AssemblyInstructionSequence sequence : sequences) {
            pseudoCode.addInstructionSequence(sequence);
        }

        return pseudoCode;
    }
}
