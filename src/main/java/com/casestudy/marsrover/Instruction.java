package com.casestudy.marsrover;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Instruction {

    @Setter(AccessLevel.NONE)
    private List<String> commands = new ArrayList<>();

    static Instruction parseCommands(String commands) {
        Instruction instruction = new Instruction();
        commands = commands.replaceAll("\\s", "");
        char[] commandArray = commands.toCharArray();
        for (char commandChar : commandArray) {
            String command = String.valueOf(commandChar);
            instruction.getCommands().add(command);
        }
        return instruction;
    }

    public List<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return commands.stream().collect(Collectors.joining(", "));
    }
}
