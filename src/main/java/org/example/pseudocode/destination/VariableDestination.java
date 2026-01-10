package org.example.pseudocode.destination;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.AssignmentInstructionSequence;

import java.util.List;

public class VariableDestination extends AssignmentInstructionSequence {
    private final String destination;

    public VariableDestination(List<AssemblyInstruction> instructions, String destination) {
        super(instructions);
        this.destination = destination;
    }

    @Override
    protected List<AssemblyInstruction> getInstructionsToAppend() {
        return List.of(
                AInstruction.of(destination),
                CInstruction.withDest(CInstruction.REGISTER_M).withComp(CInstruction.REGISTER_D).build()
        );
    }
}


// update the api so that the client calls it like:
// PseudoCommand.loadTheValueOf("varName").plusConstant(1).into("destinationVarName");
// both source loaders and operation builders should implement some common interface that returns source builders
// and then you can call into(destination) at the end