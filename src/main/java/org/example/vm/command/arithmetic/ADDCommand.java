package org.example.vm.command.arithmetic;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class ADDCommand implements VMCommand {
    @Override
    public org.example.pseudocode.PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadTheVariable("addr").plusThePointerOf("SP").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        );
    }
}
