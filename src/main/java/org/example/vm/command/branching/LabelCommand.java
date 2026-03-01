package org.example.vm.command.branching;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.assembly.instruction.LabelInstruction;
import org.example.vm.command.VMCommand;

import java.util.List;

public class LabelCommand implements VMCommand {
    private final String label;

    public LabelCommand(String label) {
        this.label = label;
    }

    @Override
    public List<AssemblyInstruction> getInstructions() {
        return List.of(
                LabelInstruction.from(label)
        );
    }
}
