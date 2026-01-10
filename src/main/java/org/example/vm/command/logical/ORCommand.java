package org.example.vm.command.logical;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class ORCommand implements VMCommand {
    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").OR("addr").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        );
    }
}
