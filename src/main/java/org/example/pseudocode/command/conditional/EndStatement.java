package org.example.pseudocode.command.conditional;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.LabelInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class EndStatement implements InstructionSequence {
    private final InstructionSequence currentCondition;
    private final ConditionLabel conditionLabel;

    public EndStatement(InstructionSequence currentCondition, ConditionLabel conditionLabel) {
        this.currentCondition = currentCondition;
        this.conditionLabel = conditionLabel;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        currentCondition.emitTo(instructions);
        instructions.add(LabelInstruction.from(conditionLabel.getEndLabel()));
    }
}
