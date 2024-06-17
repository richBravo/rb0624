package org.domain.models;

public class Tool {
    /**
     * The tool code value that represents what tool what chosen to rent.
     */
    private String toolCode;

    /**
     * The tool type value that contains charge values for the respective type of tool.
     */
    private ToolType toolType;

    /**
     * The tool brand value that represents the brand that the tool is from.
     */
    private String brand;

    /**
     * The constructor that takes in the toolCode, toolType, and brand to build a tool object
     * @param toolCode value that represents what tool what chosen to rent.
     * @param toolType value that contains charge values for the respective type of tool.
     * @param brand value that represents the brand that the tool is from.
     */
    public Tool(String toolCode, ToolType toolType, String brand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
    }

    /**
     * A getter that retrieves the value for the tool code.
     * @return String value that contains the respective tool code.
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * A getter that retrieves the value for the tool type.
     * @return String value that contains the respective tool type.
     */
    public ToolType getToolType() {
        return toolType;
    }

    /**
     * A getter that retrieves the value for the brand of the tool.
     * @return String value that contains the respective brand of the tool.
     */
    public String getBrand() {
        return brand;
    }
}
