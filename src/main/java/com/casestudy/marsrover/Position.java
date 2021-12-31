package com.casestudy.marsrover;

import com.casestudy.marsrover.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    private int x;
    private int y;
    private Direction direction;

    static Position parsePosition(String location) {
        location = location.replaceAll("\\s", "");
        char[] coordinates = location.toCharArray();
        int x = Integer.parseInt(String.valueOf(coordinates[0]));
        int y = Integer.parseInt(String.valueOf(coordinates[1]));
        Direction direction = Direction.getEnumFromValue(String.valueOf(coordinates[2]));
        return new Position(x, y, direction);
    }

    public Position turnLeft() {
        direction = Direction.left(direction.getValue());
        return this;
    }

    public Position turnRight() {
        direction = Direction.right(direction.getValue());
        return this;
    }

    public Position move() {
        if (this.direction == Direction.EAST) {
            x++;
        } else if (direction == Direction.WEST) {
            x--;
        } else if (direction == Direction.NORTH) {
            y++;
        } else if (direction == Direction.SOUTH) {
            y--;
        }
        return this;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction.getValue();
    }
}
