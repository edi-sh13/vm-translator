package org.example.pseudocode.operation.arithmetic;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.source.Source;

import java.util.List;

public class PlusConstantOperation extends Source {
    private final String value;

    public PlusConstantOperation(List<AssemblyInstruction> instructions, String value) {
        super(instructions);
        this.value = value;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        if (value.equals("1")) {
            return List.of(
                    CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_D + "+1").build()
            );
        }

        return List.of(
                AInstruction.of(value),
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp(CInstruction.REGISTER_D + "+" + CInstruction.REGISTER_A)
                        .build()
        );
    }
}
