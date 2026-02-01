package org.example.vm.command.memory;


import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

import java.util.List;

public class POPCommand implements VMCommand {
    private final String segment;
    private final int index;

    public POPCommand(String segment, int index) {
        this.segment = segment;
        this.index = index;
    }

    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.loadTheVariable(segment).plusTheConstant(index).intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoThePointer("addr")
        ).getInstructions();
    }
}
