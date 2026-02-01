package org.example.assembly.instruction;

public class AInstruction implements AssemblyInstruction {
    private final String value;

    public AInstruction(String value) {
        this.value = value;
    }

    @Override
    public String toAssembly() {
        return "@%s\n".formatted(value);
    }

    public static AInstruction from(String value) {
        return new AInstruction(value);
    }

    public static AInstruction from(int value) {
        return AInstruction.from(Integer.toString(value));
    }
}
