package org.example.vm.command.logical;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class EQCommand implements VMCommand {
    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").minusTheVariable("diff")
        );
    }
}


// todo: define a LabelInstruction which just writes the (JUMP) instruction
// use it here to branch out depending on diff being zero or not
// then set D to 0 or -1 accordingly