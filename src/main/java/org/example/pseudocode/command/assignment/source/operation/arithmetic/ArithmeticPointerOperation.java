package org.example.pseudocode.command.assignment.source.operation.arithmetic;

import org.example.assembly.instruction.AInstruction;
import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.CInstruction;
import org.example.pseudocode.InstructionSequence;

import java.util.List;

public class ArithmeticPointerOperation implements InstructionSequence {
    private final InstructionSequence source;
    private final String variableName;
    private final ArithmeticOperator operator;

    public ArithmeticPointerOperation(InstructionSequence source, String variableName, ArithmeticOperator operator) {
        this.source = source;
        this.variableName = variableName;
        this.operator = operator;
    }

    @Override
    public void emitTo(List<AssemblyInstruction> instructions) {
        source.emitTo(instructions);

        instructions.add(AInstruction.from(variableName));
        instructions.add(
                CInstruction.withDest(CInstruction.REGISTER_A)
                .withComp(CInstruction.REGISTER_M)
                .build()
        );
        instructions.add(
                CInstruction.withDest(CInstruction.REGISTER_D)
                        .withComp(CInstruction.REGISTER_D + operator.getSymbol() + CInstruction.REGISTER_M)
                        .build()
        );
    }
}
