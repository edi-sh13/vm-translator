package org.example;

import org.example.assembly.instruction.AssemblyInstruction;
import org.example.pseudocode.PseudoCode;
import org.example.pseudocode.command.assignment.AssignmentCommand;
import org.example.pseudocode.command.conditional.ComparisonOperator;
import org.example.pseudocode.command.conditional.ConditionalCommand;

public class Main {
    public static void main(String[] args) {
//        PseudoCode.withInstructionSequences(
//                AssignmentCommand.loadTheConstant(0).intoTheVariable("var1"),
//                ConditionalCommand.when("var1", ComparisonOperator.EQUALS_ZERO)
//                        .then(AssignmentCommand.loadTheConstant(53).intoTheVariable("var1"))
//                        .elseDo(AssignmentCommand.loadTheConstant(11).intoTheVariable("var1")).end()
//        ).getInstructions().stream().map(AssemblyInstruction::toAssembly).forEach(System.out::print);
        try {
            VMTranslator translator = new VMTranslator(args[0]);
            translator.run();
            System.out.println("Translation completed successfully.");
        } catch (Exception e) {
            System.out.println("Translation failed: " + e.getMessage());
        }
    }
}
