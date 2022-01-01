package com.casestudy.marsrover.strategy.impl;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.strategy.ActionStrategy;

public class MoveForwardAction implements ActionStrategy {

    private static MoveForwardAction instance;

    private MoveForwardAction() {
    }

    public static MoveForwardAction getInstance() {
        if(instance == null) {
            instance = new MoveForwardAction();
        }
        return instance;
    }

    @Override
    public void action(Position position) {
        position.move();
    }

    @Override
    public ActionCommandType getCommand() {
        return ActionCommandType.MOVE;
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
