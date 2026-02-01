package org.example.vm.command.arithmetic;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

import java.util.List;

public class NEGCommand implements VMCommand {
    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadTheConstant(0).minusThePointer("SP").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        ).getInstructions();
    }
}
