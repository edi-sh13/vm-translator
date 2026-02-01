package org.example.vm.command;

import org.example.assembly.instruction.AssemblyInstruction;

import java.util.List;

public interface VMCommand {
    List<AssemblyInstruction> getInstructions();
}
