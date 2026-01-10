package org.example.vm.command.arithmetic;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class SUBCommand implements VMCommand {
    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadTheVariable("addr").minusThePointerOf("SP").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        );
    }
}
