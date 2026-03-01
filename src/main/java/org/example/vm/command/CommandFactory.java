package org.example.vm.command;

import org.example.vm.command.arithmetic.ADDCommand;
import org.example.vm.command.arithmetic.NEGCommand;
import org.example.vm.command.arithmetic.SUBCommand;
import org.example.vm.command.branching.GoToCommand;
import org.example.vm.command.branching.IfGoToCommand;
import org.example.vm.command.branching.LabelCommand;
import org.example.vm.command.logical.ANDCommand;
import org.example.vm.command.logical.EQCommand;
import org.example.vm.command.logical.GTCommand;
import org.example.vm.command.logical.LTCommand;
import org.example.vm.command.logical.NOTCommand;
import org.example.vm.command.logical.ORCommand;
import org.example.vm.command.memory.POPCommand;
import org.example.vm.command.memory.PUSHCommand;

public class CommandFactory {
    public static VMCommand createCommand(String command) {
        String[] args = command.split("\\s+");
        String type = args[0];

        return switch (type) {
            case "push" -> new PUSHCommand(args[1], Integer.parseInt(args[2]));
            case "pop" -> new POPCommand(args[1], Integer.parseInt(args[2]));
            case "add" -> new ADDCommand();
            case "sub" -> new SUBCommand();
            case "neg" -> new NEGCommand();
            case "and" -> new ANDCommand();
            case "or" -> new ORCommand();
            case "not" -> new NOTCommand();
            case "eq" -> new EQCommand();
            case "lt" -> new LTCommand();
            case "gt" -> new GTCommand();
            case "label" -> new LabelCommand(args[1]);
            case "goto" -> new GoToCommand(args[1]);
            case "if-goto" -> new IfGoToCommand(args[1]);
            default -> throw new IllegalArgumentException("Unknown command type: " + type);
        };
    }
}
