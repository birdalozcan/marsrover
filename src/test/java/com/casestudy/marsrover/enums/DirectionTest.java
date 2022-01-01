package com.casestudy.marsrover.enums;

import com.casestudy.marsrover.common.BaseUnitTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest extends BaseUnitTest {

    @Test
    void getEnumFromValue_Success_IfTheCorrectValue() {
        Direction direction = Direction.getEnumFromValue("E");

        assertNotNull(direction);
        assertEquals(Direction.EAST, direction);
    }

    @Test
    void getEnumFromValue_Fail_WhenWrongValue() {
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> Direction.getEnumFromValue("F"));

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Unexpected enum constant :"));
    }
}
