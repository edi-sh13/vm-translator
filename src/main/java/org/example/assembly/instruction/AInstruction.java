package org.example.assembly.instruction;

public class AInstruction implements AssemblyInstruction {
    private final String value;

    public AInstruction(String value) {
        this.value = value;
    }

    @Override
    public String toAssembly() {
        return "@" + value + "\n";
    }

    public static AInstruction of(String value) {
        return new AInstruction(value);
    }
}
