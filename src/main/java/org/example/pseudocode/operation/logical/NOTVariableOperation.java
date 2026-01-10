package org.example.pseudocode.operation.logical;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.source.Source;

import java.util.List;

public class NOTVariableOperation extends Source {
    public NOTVariableOperation(List<AssemblyInstruction> instructions) {
        super(instructions);
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                CInstruction.withDest(CInstruction.REGISTER_D).withComp("!" + CInstruction.REGISTER_D).build()
        );
    }
}
