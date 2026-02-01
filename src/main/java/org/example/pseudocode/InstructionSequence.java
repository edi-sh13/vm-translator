package org.example.pseudocode;

import org.example.assembly.instruction.AssemblyInstruction;

import java.util.List;

public interface InstructionSequence {
    void emitTo(List<AssemblyInstruction> instructions);
}
