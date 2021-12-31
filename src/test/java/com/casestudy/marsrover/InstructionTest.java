package com.casestudy.marsrover;

import com.casestudy.marsrover.common.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionTest extends BaseUnitTest {

    @InjectMocks
    private Instruction instruction;

    @Test
    void parseCommands() {
        String commands = "MMRMMRMRRM";

        Instruction actualInstruction = instruction.parseCommands(commands);

        assertEquals(commands.length(), actualInstruction.getCommands().size());
        assertEquals("M, M, R, M, M, R, M, R, R, M", actualInstruction.toString());
    }
}
