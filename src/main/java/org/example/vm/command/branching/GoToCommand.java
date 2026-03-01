package org.example.vm.command.branching;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;
import org.example.pseudocode.command.conditional.ComparisonOperator;
import org.example.vm.command.VMCommand;

import java.util.List;

public class GoToCommand implements VMCommand, InstructionSequence {
    private final String label;

    public GoToCommand(String label) {
        this.label = label;
    }

    @Override
    public List<AssemblyInstruction> getInstructions() {
        return List.of(
                AInstruction.from(label),
                CInstruction.withComp(CInstruction.REGISTER_D)
                        .withJump(ComparisonOperator.UNCONDITIONAL.getOperator())
                        .build()
        );
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        instructions.addAll(getInstructions());
    }
}
