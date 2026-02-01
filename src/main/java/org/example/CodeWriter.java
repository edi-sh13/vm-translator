package org.example;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.vm.command.VMCommand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {
    private final BufferedWriter writer;

    public CodeWriter(String filePath) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(filePath));
    }

    public void write(VMCommand command) throws IOException {
        for (AssemblyInstruction instruction : command.getInstructions()) {
            this.writer.write(instruction.toAssembly());
        }
    }

    public void close() throws IOException {
        this.writer.close();
    }
}
