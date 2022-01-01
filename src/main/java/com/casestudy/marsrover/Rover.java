package com.casestudy.marsrover;

import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.strategy.ActionStrategy;
import com.casestudy.marsrover.strategy.impl.MoveForwardAction;
import com.casestudy.marsrover.strategy.impl.TurnLeftAction;
import com.casestudy.marsrover.strategy.impl.TurnRightAction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Rover {

    private Matrix matrix;
    private Position position;
    private Instruction instruction;
    private Map<ActionCommandType, ActionStrategy> commandActionMap;

    {
        List<ActionStrategy> actionStrategies = new ArrayList<>();
        actionStrategies.add(TurnLeftAction.getInstance());
        actionStrategies.add(TurnRightAction.getInstance());
        actionStrategies.add(MoveForwardAction.getInstance());

        commandActionMap = actionStrategies.stream()
                .collect(Collectors.toMap(ActionStrategy::getCommand, actionStrategy -> actionStrategy, (x, y) -> x));
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
