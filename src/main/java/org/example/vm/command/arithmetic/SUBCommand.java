package org.example.vm.command.arithmetic;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.PseudoCode;
import org.example.vm.command.VMCommand;

import java.util.List;

public class SUBCommand implements VMCommand {
    @Override
    public List<AssemblyInstruction> getInstructions() {
        return PseudoCode.withInstructionSequences(
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadThePointer("SP").intoTheVariable("addr"),
                AssignmentCommand.decrement("SP"),
                AssignmentCommand.loadTheVariable("addr").minusThePointer("SP").intoThePointer("SP"),
                AssignmentCommand.increment("SP")
        ).getInstructions();
    }
}
