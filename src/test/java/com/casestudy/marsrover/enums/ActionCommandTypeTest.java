package com.casestudy.marsrover.enums;

import com.casestudy.marsrover.common.BaseUnitTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionCommandTypeTest extends BaseUnitTest {

    @Test
    void getEnumFromValue_Success_IfTheCorrectValue() {
        ActionCommandType actionCommandType = ActionCommandType.getEnumFromValue("L");

        assertNotNull(actionCommandType);
        assertEquals(ActionCommandType.LEFT, actionCommandType);
    }

    @Test
    void getEnumFromValue_Fail_WhenWrongValue() {
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> ActionCommandType.getEnumFromValue("G"));

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Unexpected enum constant :"));
    }
}
