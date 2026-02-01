package org.example.vm.command.logical;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

import java.util.List;

public class NOTCommand implements VMCommand {
    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").NOT().intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        ).getInstructions();
    }
}
