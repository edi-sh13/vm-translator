package org.example;

import org.example.vm.command.CommandFactory;
import org.example.vm.command.VMCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private final BufferedReader reader;
    private VMCommand currentCommand;

    public Parser(String filePath) throws FileNotFoundException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        if (!filePath.endsWith(".vm")) {
            throw new IllegalArgumentException("File must have a .vm extension: " + filePath);
        }

        File file = new File(filePath);

        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist: " + filePath);
        }

        if (!file.isFile()) {
            throw new IllegalArgumentException("Path is not a file: " + filePath);
        }

        if (!file.canRead()) {
            throw new IllegalArgumentException("File is not readable: " + filePath);
        }

        this.reader = new BufferedReader(new FileReader(file));
    }

    public boolean hasMoreCommands() throws IOException {
        this.reader.mark(1);
        int nextChar = this.reader.read();

        if (nextChar == -1) {
            return false;
        }

        this.reader.reset();

        return true;
    }

    public void advance() throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.isEmpty() || line.startsWith("//")) {
                continue;
            }

            int commentIndex = line.indexOf("//");
            if (commentIndex != -1) {
                line = line.substring(0, commentIndex).trim();
            }

            currentCommand = CommandFactory.createCommand(line);
            return;
        }
    }

    public VMCommand getCurrentCommand() {
        return this.currentCommand;
    }

    public void close() throws Exception {
        reader.close();
    }
}
