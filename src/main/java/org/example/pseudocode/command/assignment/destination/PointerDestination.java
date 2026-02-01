package org.example.pseudocode.command.assignment.destination;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class PointerDestination implements InstructionSequence {
    private final InstructionSequence source;
    private final String variableName;

    public PointerDestination(InstructionSequence source, String variableName) {
        this.source = source;
        this.variableName = variableName;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        source.emitTo(instructions);
        instructions.addAll(List.of(
                AInstruction.from(variableName),
                CInstruction.withDest(CInstruction.REGISTER_A).withComp(CInstruction.REGISTER_M).build(),
                CInstruction.withDest(CInstruction.REGISTER_M).withComp(CInstruction.REGISTER_D).build()
        ));
    }
}
