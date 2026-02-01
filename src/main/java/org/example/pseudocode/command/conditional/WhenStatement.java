package org.example.pseudocode.command.conditional;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class WhenStatement implements InstructionSequence {
    private final String variableName;
    private final ComparisonOperator operator;
    private final ConditionLabel conditionLabel;

    public WhenStatement(String variableName, ComparisonOperator operator) {
        this.variableName = variableName;
        this.operator = operator;
        this.conditionLabel = new ConditionLabel(variableName, operator);
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        // Load the variable's value into register D
        instructions.add(AInstruction.from(variableName));
        instructions.add(CInstruction.withDest(CInstruction.REGISTER_D).withComp(CInstruction.REGISTER_M).build());

        // Jump based on the operator and the value of register D
        instructions.add(AInstruction.from(conditionLabel.getLabel()));
        instructions.add(CInstruction.withComp(CInstruction.REGISTER_D).withJump(operator.getOperator()).build());

        // Build the opposite jump to continue execution if the condition is not met
        instructions.add(AInstruction.from(conditionLabel.getNegatedLabel()));
        instructions.add(
                CInstruction.withComp(CInstruction.REGISTER_D)
                        .withJump(ComparisonOperator.UNCONDITIONAL.getOperator())
                        .build()
        );
    }

    public ThenStatement then(InstructionSequence instructionSequence) {
        return new ThenStatement(this, instructionSequence, conditionLabel);
    }
}
