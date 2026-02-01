package org.example.pseudocode.command.assignment.source;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ConstantSource implements InstructionSequence {
    private final int value;

    public ConstantSource(int value) {
        this.value = value;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        if (value >= 0) {
            instructions.add(AInstruction.from(value));
            instructions.add(CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_A).build());
            return;
        }

        instructions.add(AInstruction.from(-value));
        instructions.add(CInstruction.withDest(CInstruction.REGISTER_D).withComp("-" + CInstruction.REGISTER_A).build());
    }
}
