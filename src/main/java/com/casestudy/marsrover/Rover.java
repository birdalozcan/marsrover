package com.casestudy.marsrover;

import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.strategy.ActionStrategy;
import com.casestudy.marsrover.strategy.impl.MoveForwardAction;
import com.casestudy.marsrover.strategy.impl.TurnLeftAction;
import com.casestudy.marsrover.strategy.impl.TurnRightAction;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Rover {

    private Map<ActionCommandType, ActionStrategy> commandActionMap = new HashMap<>();

    private Matrix matrix;
    private Position position;
    private Instruction instruction;

    {
        commandActionMap.put(ActionCommandType.LEFT, TurnLeftAction.getInstance());
        commandActionMap.put(ActionCommandType.RIGHT, TurnRightAction.getInstance());
        commandActionMap.put(ActionCommandType.MOVE, MoveForwardAction.getInstance());
    }

    public Rover(Matrix matrix, Position position, Instruction instruction) {
        this.matrix = matrix;
        this.position = position;
        this.instruction = instruction;
    }

    public void action() {
        instruction.getCommands().stream().forEach(command -> {
            ActionCommandType actionCommandType = ActionCommandType.getEnumFromValue(command);
            ActionStrategy actionStrategy = commandActionMap.get(actionCommandType);
            actionStrategy.action(position);
        });
    }
}
