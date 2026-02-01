package org.example.pseudocode.command.assignment.source;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class VariableSource implements InstructionSequence {
    private final String variableName;

    public VariableSource(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        instructions.add(AInstruction.from(variableName));
        instructions.add(CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_M).build());
    }
}
