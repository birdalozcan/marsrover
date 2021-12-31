package com.casestudy.marsrover.enums;

public enum Direction {

    EAST("E"),
    WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction getEnumFromValue(String directionValue) {
        for (Direction direction : values()) {
            if (direction.getValue().equalsIgnoreCase(directionValue)) {
                return direction;
            }
        }
        throw new IllegalStateException("Unexpected enum constant : " + directionValue);
    }

    public String getValue() {
        return value;
    }

    public static Direction left(String directionValue) {
        Direction direction;
        switch (directionValue) {
            case "E":
                direction = NORTH;
                break;
            case "W":
                direction = SOUTH;
                break;
            case "N":
                direction = WEST;
                break;
            case "S":
                direction = EAST;
                break;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + directionValue);
        }
        return direction;
    }

    public static Direction right(String directionValue) {
        Direction direction;
        switch (directionValue) {
            case "E":
                direction = SOUTH;
                break;
            case "W":
                direction = NORTH;
                break;
            case "N":
                direction = EAST;
                break;
            case "S":
                direction = WEST;
                break;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + directionValue);
        }
        return direction;
    }
}
