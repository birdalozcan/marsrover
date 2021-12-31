package com.casestudy.marsrover.enums;

public enum ActionCommandType {

    LEFT("L"),
    RIGHT("R"),
    MOVE("M");

    private final String value;

    ActionCommandType(String value) {
        this.value = value;
    }

    public static ActionCommandType getEnumFromValue(String commandValue) {
        for (ActionCommandType actionCommandType : values()) {
            if (actionCommandType.getValue().equalsIgnoreCase(commandValue)) {
                return actionCommandType;
            }
        }
        throw new IllegalStateException("Unexpected enum constant : " + commandValue);
    }

    public String getValue() {
        return value;
    }
}
