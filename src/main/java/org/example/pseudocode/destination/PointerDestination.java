package org.example.pseudocode.destination;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.AssignmentInstructionSequence;

import java.util.List;

public class PointerDestination extends AssignmentInstructionSequence {
    private final String destination;

    public PointerDestination(List<AssemblyInstruction> instructions, String destination) {
        super(instructions);
        this.destination = destination;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                AInstruction.of(destination),
                CInstruction.withDest(CInstruction.REGISTER_A).withComp(CInstruction.REGISTER_M).build(),
                CInstruction.withDest(CInstruction.REGISTER_M).withComp(CInstruction.REGISTER_D).build()
        );
    }
}
