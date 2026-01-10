package org.example.pseudocode.source;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;

import java.util.List;

public class VariableSource extends Source {
    private final String source;

    public VariableSource(List<AssemblyInstruction> instructions, String source) {
        super(instructions);
        this.source = source;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                AInstruction.of(source),
                CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_M).build()
        );
    }
}
