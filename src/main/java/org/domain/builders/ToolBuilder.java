package org.domain.builders;

import org.domain.enums.Brand;
import org.domain.enums.ToolCode;
import org.domain.models.Tool;

import java.util.ArrayList;
import java.util.List;

public class ToolBuilder {
    /**
     * This method builds a tool object containing values for a Stihl chainsaw.
     *
     * @return Tool value that contains values for a Stihl chainsaw.
     */
    public static Tool buildStihlChainsaw(){
        return new Tool(ToolCode.CHNS.toString(),  ToolTypeBuilder.buildChainsaw(), Brand.STIHL.getValue());
    }

    /**
     * This method builds a tool object containing values for a Werner ladder.
     * @return Tool value that contains values for a Werner ladder.
     */
    public static Tool buildWernerLadder(){
        return new Tool(ToolCode.LADW.toString(),ToolTypeBuilder.buildLadder(), Brand.WERNER.getValue());
    }

    /**
     * This method builds a tool object containing values for a DeWalt jackhammer.
     * @return Tool value that contains values for a DeWalt jackhammer.
     */
    public static Tool buildDeWaltJackhammer(){
        return new Tool(ToolCode.JAKD.toString(),ToolTypeBuilder.buildJackhammer(), Brand.DEWALT.getValue());
    }

    /**
     * This method builds a tool object containing values for a Ridgid jackhammer.
     * @return Tool value that contains values for a Ridgid jackhammer.
     */
    public static Tool buildRidgidJackhammer(){
        return new Tool(ToolCode.JAKR.toString(),ToolTypeBuilder.buildJackhammer(), Brand.RIDGID.getValue());
    }

    /**
     * This method initiates the list creation for both tools and tool types
     */
    public static List<Tool> initiateToolListCreation(){
        List<Tool> tools = new ArrayList<>();

        //Build all the tools for list
        Tool tool1 = ToolBuilder.buildStihlChainsaw();
        Tool tool2 = ToolBuilder.buildRidgidJackhammer();
        Tool tool3 = ToolBuilder.buildDeWaltJackhammer();
        Tool tool4 = ToolBuilder.buildWernerLadder();

        //Populates the lists with their respective tools and tool types
        tools.add(tool1);
        tools.add(tool2);
        tools.add(tool3);
        tools.add(tool4);

        return tools;
    }

}
