package com.casestudy.marsrover.strategy.impl;

import com.casestudy.marsrover.Position;
import com.casestudy.marsrover.common.BaseUnitTest;
import com.casestudy.marsrover.enums.Direction;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveForwardActionTest extends BaseUnitTest {

    @InjectMocks
    private MoveForwardAction moveForwardAction;

    @Test
    void getInstance() {
        MoveForwardAction instance1 = moveForwardAction.getInstance();
        MoveForwardAction instance2 = moveForwardAction.getInstance();

        assertTrue(instance1.equals(instance2));
        assertTrue(instance1.hashCode() == instance2.hashCode());
    }

    @Test
    void action() {
        Position position = new Position(1, 2, Direction.NORTH);

        moveForwardAction.action(position);

        assertEquals(1, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Direction.NORTH, position.getDirection());
    }
}
