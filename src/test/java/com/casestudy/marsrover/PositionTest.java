package com.casestudy.marsrover;

import com.casestudy.marsrover.common.BaseUnitTest;
import com.casestudy.marsrover.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest extends BaseUnitTest {

    @InjectMocks
    private Position position;

    private Position beforePosition;
    private Position expectedAfterPosition;

    @BeforeEach
    void setUp() {
        beforePosition = new Position(1, 2, Direction.NORTH);
    }

    @Test
    void parsePosition_Success_WhenAllConditionsAreMet() {
        String locationAsString = "1 2 N";

        Position parsePosition = position.parsePosition(locationAsString);

        assertEquals(1, parsePosition.getX());
        assertEquals(2, parsePosition.getY());
        assertEquals("1 2 N", parsePosition.toString());
    }

    @Test
    void parsePosition_Success_WhenWrongCoordinateCharacterIsSent() {
        String locationAsString = "a 7 N";

        NumberFormatException exception = assertThrows(NumberFormatException.class,
                () -> position.parsePosition(locationAsString));

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("For input string:"));
    }

    @Test
    void parsePosition_Success_WhenWrongDirectionIsSent() {
        String locationAsString = "4 7 t";

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> position.parsePosition(locationAsString));

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Unexpected enum constant :"));
    }

    @Test
    void turnLeft() {
        expectedAfterPosition = new Position(1, 2, Direction.WEST);

        Position actualAfterPosition = beforePosition.turnLeft();

        assertEquals(expectedAfterPosition, actualAfterPosition);
        assertTrue(expectedAfterPosition.getX() == actualAfterPosition.getX());
        assertTrue(expectedAfterPosition.getY() == actualAfterPosition.getY());
        assertTrue(expectedAfterPosition.getDirection() == actualAfterPosition.getDirection());
    }

    @Test
    void turnRight() {
        expectedAfterPosition = new Position(1, 2, Direction.EAST);

        Position actualAfterPosition = beforePosition.turnRight();

        assertEquals(expectedAfterPosition, actualAfterPosition);
        assertTrue(expectedAfterPosition.getX() == actualAfterPosition.getX());
        assertTrue(expectedAfterPosition.getY() == actualAfterPosition.getY());
        assertTrue(expectedAfterPosition.getDirection() == actualAfterPosition.getDirection());
    }

    @Test
    void move() {
        expectedAfterPosition = new Position(1, 3, Direction.NORTH);

        Position actualAfterPosition = beforePosition.move();

        assertEquals(expectedAfterPosition, actualAfterPosition);
        assertTrue(expectedAfterPosition.getX() == actualAfterPosition.getX());
        assertTrue(expectedAfterPosition.getY() == actualAfterPosition.getY());
        assertTrue(expectedAfterPosition.getDirection() == actualAfterPosition.getDirection());
    }
}
