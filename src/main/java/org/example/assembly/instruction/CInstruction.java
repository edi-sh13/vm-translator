package org.example.assembly.instruction;

public class CInstruction implements AssemblyInstruction {
    public static final String REGISTER_A = "A";
    public static final String REGISTER_D = "D";
    public static final String REGISTER_M = "M";

    private final String dest;
    private final String comp;
    private final String jump;

    private CInstruction(String dest, String comp, String jump) {
        this.dest = dest;
        this.comp = comp;
        this.jump = jump;
    }

    @Override
    public String toAssembly() {
        StringBuilder assembly = new StringBuilder();

        if (dest != null) {
            assembly.append(dest).append("=");
        }

        assembly.append(comp);

        if (jump != null) {
            assembly.append(";").append(jump);
        }

        return assembly.append("\n").toString();
    }

    public static CInstructionBuilder withDest(String dest) {
        return new CInstructionBuilder().withDest(dest);
    }

    public static class CInstructionBuilder {
        private String dest;
        private String comp;
        private String jump;

        public CInstructionBuilder withDest(String dest) {
            this.dest = dest;
            return this;
        }

        public CInstructionBuilder withComp(String comp) {
            this.comp = comp;
            return this;
        }

        public CInstructionBuilder withJump(String jump) {
            this.jump = jump;
            return this;
        }

        public CInstruction build() {
            if (comp == null) {
                throw new IllegalStateException("Invalid C-instruction. Comp field is required!");
            }

            return new CInstruction(dest, comp, jump);
        }
    }
}
