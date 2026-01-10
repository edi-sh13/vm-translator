package org.example.vm.command.memory;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class POPCommand implements VMCommand {
    private final String segment;
    private final String index;

    public POPCommand(String segment, String index) {
        this.segment = segment;
        this.index = index;
    }

    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.loadTheVariable(segment).plusTheConstant(index).intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoThePointer("addr")
        );
    }
}
