package com.casestudy.marsrover;

import com.casestudy.marsrover.common.BaseUnitTest;
import com.casestudy.marsrover.enums.ActionCommandType;
import com.casestudy.marsrover.enums.Direction;
import com.casestudy.marsrover.strategy.ActionStrategy;
import com.casestudy.marsrover.strategy.impl.MoveForwardAction;
import com.casestudy.marsrover.strategy.impl.TurnLeftAction;
import com.casestudy.marsrover.strategy.impl.TurnRightAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest extends BaseUnitTest {

    @Spy
    private Map<ActionCommandType, ActionStrategy> commandActionMap = new HashMap<>();

    @InjectMocks
    private Rover rover;

    @BeforeEach
    void setUp() {
        commandActionMap.put(ActionCommandType.LEFT, TurnLeftAction.getInstance());
        commandActionMap.put(ActionCommandType.RIGHT, TurnRightAction.getInstance());
        commandActionMap.put(ActionCommandType.MOVE, MoveForwardAction.getInstance());

        Matrix matrix = new Matrix(5, 5);
        Position position = new Position(1, 2, Direction.NORTH);
        Instruction instruction = getInstruction();
        rover.setMatrix(matrix);
        rover.setPosition(position);
        rover.setInstruction(instruction);
    }

    @Test
    void action_Success_WhenAllConditionsAreMet() {
        rover.action();
        Position actualPosition = rover.getPosition();

        assertEquals(1, actualPosition.getX());
        assertEquals(3, actualPosition.getY());
        assertEquals(Direction.NORTH, actualPosition.getDirection());
    }

    @Test
    void action_Fail_WhenWrongCommandIsSent() {
        rover.getInstruction().getCommands().add("T");

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> rover.action());

        assertNotNull(exception);
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("Unexpected enum constant :"));
    }

    private Instruction getInstruction() {
        Instruction instruction = new Instruction();
        instruction.getCommands().add("L");
        instruction.getCommands().add("M");
        instruction.getCommands().add("L");
        instruction.getCommands().add("M");
        instruction.getCommands().add("L");
        instruction.getCommands().add("M");
        instruction.getCommands().add("L");
        instruction.getCommands().add("M");
        instruction.getCommands().add("M");
        return instruction;
    }
}
