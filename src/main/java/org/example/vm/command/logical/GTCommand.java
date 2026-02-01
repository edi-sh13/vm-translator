package org.example.vm.command.logical;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.PseudoCode;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.command.conditional.ComparisonOperator;
import org.example.pseudocode.command.conditional.ConditionalCommand;
import org.example.vm.command.VMCommand;

import java.util.List;

public class GTCommand implements VMCommand {
    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP")
                        .minusTheVariable("addr")
                        .intoTheVariable("diff"),
                ConditionalCommand
                        .when("diff", ComparisonOperator.GREATER_THAN_ZERO)
                        .then(
                                AssignmentCommand.loadTheConstant(-1).intoThePointer("SP")
                        ).elseDo(
                                AssignmentCommand.loadTheConstant(0).intoThePointer("SP")
                        ).end(),
                AssignmentCommand.increment("SP")
        ).getInstructions();
    }
}
