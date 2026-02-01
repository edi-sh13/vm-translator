package org.example.pseudocode.command.assignment.source.operation.arithmetic;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ArithmeticConstantOperation implements InstructionSequence {
    private final InstructionSequence source;
    private final int constant;
    private final ArithmeticOperator operator;

    public ArithmeticConstantOperation(InstructionSequence source, int constant, ArithmeticOperator operator) {
        this.source = source;
        this.constant = constant;
        this.operator = operator;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        source.emitTo(instructions);

        instructions.add(AInstruction.from(constant));
        instructions.add(
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp(CInstruction.REGISTER_D + operator.getSymbol() + CInstruction.REGISTER_A)
                        .build()
        );
    }
}
