package com.casestudy.marsrover.strategy;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.enums.ActionCommandType;

public interface ActionStrategy {

    void action(Position position);
    ActionCommandType command();
}
