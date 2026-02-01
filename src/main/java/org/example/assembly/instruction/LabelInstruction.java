package org.example.assembly.instruction;

public class LabelInstruction implements AssemblyInstruction {
    private final String label;

    public LabelInstruction(String label) {
        this.label = label;
    }

    @Override
    public String toAssembly() {
        return "(%s)\n".formatted(label);
    }

    public static LabelInstruction from(String label) {
        return new LabelInstruction(label);
    }
}
