package org.example.vm.command.arithmetic;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class NEGCommand implements VMCommand {
    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadTheConstant("0").minusThePointerOf("SP").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        );
    }
}
