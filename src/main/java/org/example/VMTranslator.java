package org.example;

import org.example.vm.command.VMCommand;

import java.io.IOException;

public class VMTranslator {
    private final Parser parser;
    private final CodeWriter codeWriter;

    public VMTranslator(String filePath) throws IOException {
        this.parser = new Parser(filePath);

        String pathToWrite = filePath.replace(".vm", ".asm");
        this.codeWriter = new CodeWriter(pathToWrite);
    }

    public void run() throws Exception {
        while (parser.hasMoreCommands()) {
            parser.advance();

            VMCommand command = parser.getCurrentCommand();

            codeWriter.write(command);
        }

        this.close();
    }

    private void close() throws Exception {
        this.parser.close();
        this.codeWriter.close();
    }
}
