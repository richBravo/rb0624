package org.domain.builders;

import org.domain.enums.ToolTypeName;
import org.domain.models.ToolType;

import java.util.ArrayList;
import java.util.List;

public class ToolTypeBuilder {
    /**
     * This method builds a tool type object containing values for a ladder.
     * @return ToolType value that contains values for a ladder's charge values.
     */
    public static ToolType buildLadder(){
        return new ToolType(ToolTypeName.LADDER.getValue(), 1.99, true, true, false);
    }

    /**
     * This method builds a tool type object containing values for a chainsaw.
     * @return ToolType value that contains values for a chainsaw's charge values.
     */
    public static ToolType buildChainsaw(){
        return new ToolType(ToolTypeName.CHAINSAW.getValue(), 1.49, true, false, true);
    }

    /**
     * This method builds a tool type object containing values for a jackhammer.
     * @return ToolType value that contains values for a jackhammer's charge values.
     */
    public static ToolType buildJackhammer(){
        return new ToolType(ToolTypeName.JACKHAMMER.getValue(), 2.99, true, false, false);
    }

    /**
     * This method initiates the list creation for tool types.
     * @return List containing the different tool type and their charge values.
     */
    public static List<ToolType> initiateToolListCreation(){
        List<ToolType> toolTypes = new ArrayList<>();

        //Build all the tools and tool types for lists
        ToolType toolType1 = ToolTypeBuilder.buildLadder();
        ToolType toolType2 = ToolTypeBuilder.buildChainsaw();
        ToolType toolType3 = ToolTypeBuilder.buildJackhammer();

        //Populates the lists with their respective tools and tool types
        toolTypes.add(toolType1);
        toolTypes.add(toolType2);
        toolTypes.add(toolType3);

        return toolTypes;
    }
}
