package org.example.pseudocode.operation.arithmetic;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.source.Source;

import java.util.List;

public class PlusPointerOperation extends Source {
    private final String value;

    public PlusPointerOperation(List<AssemblyInstruction> instructions, String value) {
        super(instructions);
        this.value = value;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                AInstruction.of(value),
                CInstruction.withDest(CInstruction.REGISTER_A).withComp(CInstruction.REGISTER_M).build(),
                CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_D + "+" + CInstruction.REGISTER_M).build()
        );
    }
}
