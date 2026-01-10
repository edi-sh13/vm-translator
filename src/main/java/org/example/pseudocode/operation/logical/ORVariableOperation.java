package org.example.pseudocode.operation.logical;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.source.Source;

import java.util.List;

public class ORVariableOperation extends Source {
    private final String value;

    public ORVariableOperation(List<AssemblyInstruction> instructions, String value) {
        super(instructions);
        this.value = value;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                AInstruction.of(value),
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp(CInstruction.REGISTER_D + "|" + CInstruction.REGISTER_M)
                        .build()
        );
    }
}
