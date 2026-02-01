package org.example.pseudocode.command.assignment.source.operation.logical;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ANDVariableOperation implements InstructionSequence {
    private final InstructionSequence source;
    private final String variableName;

    public ANDVariableOperation(InstructionSequence source, String variableName) {
        this.source = source;
        this.variableName = variableName;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        source.emitTo(instructions);

        instructions.add(AInstruction.from(variableName));
        instructions.add(
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp(CInstruction.REGISTER_D + "&" + CInstruction.REGISTER_M)
                        .build()
        );
    }
}
