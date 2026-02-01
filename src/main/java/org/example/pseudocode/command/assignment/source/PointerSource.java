package org.example.pseudocode.command.assignment.source;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class PointerSource implements InstructionSequence {
    private final String variableName;

    public PointerSource(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        instructions.add(AInstruction.from(variableName));
        instructions.add(CInstruction.withDest(CInstruction.REGISTER_A).withComp(CInstruction.REGISTER_M).build());
        instructions.add(CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_M).build());
    }
}
