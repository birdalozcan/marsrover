package com.casestudy.marsrover.strategy.impl;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.common.BaseUnitTest;
import com.casestudy.marsrover.enums.Direction;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TurnRightActionTest extends BaseUnitTest {

    @InjectMocks
    private TurnRightAction turnRightAction;

    @Test
    void getInstance() {
        TurnRightAction instance1 = turnRightAction.getInstance();
        TurnRightAction instance2 = turnRightAction.getInstance();

        assertTrue(instance1.equals(instance2));
        assertTrue(instance1.hashCode() == instance2.hashCode());
    }

    @Test
    void action() {
        Position position = new Position(1, 2, Direction.NORTH);

        turnRightAction.action(position);

        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Direction.EAST, position.getDirection());
    }
}
