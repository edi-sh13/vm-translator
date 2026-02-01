package org.example.pseudocode.command.assignment.source.operation.logical;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class NOTVariableOperation implements InstructionSequence {
    private final InstructionSequence source;

    public NOTVariableOperation(InstructionSequence source) {
        this.source = source;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        source.emitTo(instructions);

        instructions.add(
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp("!" + CInstruction.REGISTER_M)
                        .build()
        );
    }
}
