package org.example.vm.command.memory;

import org.example.pseudocode.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

public class PUSHCommand implements VMCommand {
    private final String segment;
    private final String index;

    public PUSHCommand(String segment, String index) {
        this.segment = segment;
        this.index = index;
    }

    @Override
    public PseudoCode getPseudoCode() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.loadTheVariable(segment).plusTheConstant(index).intoTheVariable("addr"),
                AssignmentCommand.loadThePointer("addr").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        );
    }
}
