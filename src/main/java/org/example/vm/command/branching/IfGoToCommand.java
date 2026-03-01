package org.example.vm.command.branching;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.PseudoCode;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.command.conditional.ComparisonOperator;
import org.example.pseudocode.command.conditional.ConditionalCommand;
import org.example.vm.command.VMCommand;

import java.util.List;

public class IfGoToCommand implements VMCommand {
    private final String label;

    public IfGoToCommand(String label) {
        this.label = label;
    }

    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("value"),
                AssignmentCommand.increment("SP"),
                ConditionalCommand
                        .when("value", ComparisonOperator.NOT_EQUAL_TO_ZERO)
                        .then(new GoToCommand(label))
                        .end()
        ).getInstructions();
    }
}
