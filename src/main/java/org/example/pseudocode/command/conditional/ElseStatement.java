package org.example.pseudocode.command.conditional;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.assembly.instruction.LabelInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ElseStatement implements InstructionSequence {
    private final ThenStatement thenStatement;
    private final InstructionSequence elseBody;
    private final ConditionLabel conditionLabel;

    public ElseStatement(
            ThenStatement thenStatement,
            InstructionSequence elseBody,
            ConditionLabel conditionLabel
    ) {
        this.thenStatement = thenStatement;
        this.elseBody = elseBody;
        this.conditionLabel = conditionLabel;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        thenStatement.emitTo(instructions);
        elseBody.emitTo(instructions);
    }

    public InstructionSequence end() {
        return new EndStatement(this, conditionLabel);
    }
}
