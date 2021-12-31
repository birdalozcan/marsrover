package com.casestudy.marsrover.strategy.impl;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.strategy.ActionStrategy;

public class TurnLeftAction implements ActionStrategy {

    private static TurnLeftAction instance;

    private TurnLeftAction() {
    }

    public static TurnLeftAction getInstance() {
        if(instance == null) {
            instance = new TurnLeftAction();
        }
        return instance;
    }

    @Override
    public void action(Position position) {
        position.turnLeft();
    }

    @Override
    public ActionCommandType command() {
        return ActionCommandType.LEFT;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
