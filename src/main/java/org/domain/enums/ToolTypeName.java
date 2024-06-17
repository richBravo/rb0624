package org.domain.enums;

public enum ToolTypeName {
    CHAINSAW("Chainsaw"),
    LADDER("Ladder"),
    JACKHAMMER("Jackhammer");

    /**
     * The string value for the associate enum
     */
    private final String value;

    /**
     * The constructor that takes in the value that will be mapped to the enum.
     * @param value of the enum that will be mapped to the appropriate enum
     */
    ToolTypeName(String value) {
        this.value = value;
    }

    /**
     * A getter that retrieves the value of the specified enum.
     * @return String value that contains the value for the specified enum.
     */
    public String getValue(){
        return this.value;
    }
}
