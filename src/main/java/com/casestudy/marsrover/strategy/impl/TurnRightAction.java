package com.casestudy.marsrover.strategy.impl;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.strategy.ActionStrategy;

public class TurnRightAction implements ActionStrategy {

    private static TurnRightAction instance;

    private TurnRightAction() {
    }

    public static TurnRightAction getInstance() {
        if(instance == null) {
            instance = new TurnRightAction();
        }
        return instance;
    }

    @Override
    public void action(Position position) {
        position.turnRight();
    }

    @Override
    public ActionCommandType command() {
        return ActionCommandType.RIGHT;
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
