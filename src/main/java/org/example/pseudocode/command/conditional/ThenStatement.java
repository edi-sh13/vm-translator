package org.example.pseudocode.command.conditional;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.assembly.instruction.LabelInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ThenStatement implements InstructionSequence {
    private final WhenStatement whenStatement;
    private final InstructionSequence body;
    private final ConditionLabel conditionLabel;

    public ThenStatement(WhenStatement whenStatement, InstructionSequence body, ConditionLabel conditionLabel) {
        this.whenStatement = whenStatement;
        this.body = body;
        this.conditionLabel = conditionLabel;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        whenStatement.emitTo(instructions);

        instructions.add(LabelInstruction.from(conditionLabel.getLabel()));
        body.emitTo(instructions);

        instructions.add(AInstruction.from(conditionLabel.getEndLabel()));
        instructions.add(
                CInstruction.withComp(CInstruction.REGISTER_D)
                        .withJump(ComparisonOperator.UNCONDITIONAL.getOperator())
                        .build()
        );

        instructions.add(LabelInstruction.from(conditionLabel.getNegatedLabel()));
    }

    public ElseStatement elseDo(InstructionSequence elseBody) {
        return new ElseStatement(this, elseBody, conditionLabel);
    }

    public InstructionSequence end() {
        return new EndStatement(this, conditionLabel);
    }
}
