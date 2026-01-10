package org.example;

import org.example.pseudocode.PseudoCode;
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
        PseudoCode commandPseudoCode = command.getPseudoCode();
        this.writer.write(commandPseudoCode.toAssembly());
    }

    public void close() throws IOException {
        this.writer.close();
    }
}
