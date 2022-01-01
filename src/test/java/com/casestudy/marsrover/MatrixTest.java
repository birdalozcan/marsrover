package com.casestudy.marsrover;

import com.casestudy.marsrover.common.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest extends BaseUnitTest {

    @InjectMocks
    private Matrix matrix;

    @Test
    void parseMatrix_Success_WhenAllConditionsAreMet() {
        String matrixArea = "5 7";

        Matrix matrix = this.matrix.parseMatrix(matrixArea);

        assertEquals(5, matrix.getX());
        assertEquals(7, matrix.getY());
        assertEquals("x : 5, y : 7", matrix.toString());
    }

    @Test
    void parseMatrix_Fail_WhenWrongCharacterIsSent() {
        String matrixArea = "a 7";

        NumberFormatException exception = assertThrows(NumberFormatException.class,
                () -> matrix.parseMatrix(matrixArea));

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("For input string:"));
    }
}
