package org.domain.utils;

import org.domain.models.RentalAgreement;
import org.domain.models.Tool;
import org.domain.models.ToolType;

import java.util.List;

public class DisplayUtils {
    /**
     * This method displays a table containing the available tools for rent.
     * @param tools list that will be used to populate the table.
     */
    public static void displayToolsAvailableToRent(List<Tool> tools) {
        System.out.printf("%5s | %11s | %5s\n","Tool Code","Tool Type","Brand");
        tools.forEach(tool -> {
            System.out.printf("%9s | %11s | %5s\n",
                    tool.getToolCode(),
                    tool.getToolType().getType(),
                    tool.getBrand());
        });
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * This method displays a table containing the tool types and their rent charges.
     * @param toolTypes list that will be used to populate the table.
     */
    public static void displayChargesForToolTypes(List<ToolType> toolTypes) {
        System.out.printf("%10s | %5s | %5s | %5s | %5s\n","Tool Type","Daily charge","Weekday charge", "Weekend charge", "Holiday charge");
        toolTypes.forEach(toolType -> {
            System.out.printf("%10s | %12s | %14s | %14s | %14s\n", toolType.getType(),
                    FormatUtils.formatCurrencyValue(toolType.getDailyRentalCharge()),
                    FormatUtils.formatChargeValue(toolType.getWeekdayCharge()),
                    FormatUtils.formatChargeValue(toolType.getWeekendCharge()),
                    FormatUtils.formatChargeValue(toolType.getHolidayCharge()));
        });
        System.out.println("-----------------------------------------------------------------");
    }

    /**
     * This method displays the rental agreement once checkout have been processed.
     * @param rentalAgreement object will contain values to populate the display.
     */
    public static void displayRentalAgreement(RentalAgreement rentalAgreement){
        System.out.println("--------Rental Agreement--------");
        System.out.printf("Tool code: %s\nTool type: %s\nCheckout date: %s\nDiscount: %s\nDue date: %s\nCharge days: %s\nPre-discount charge: %s\nDiscount amount: %s\nFinal charge: %s\n",
                rentalAgreement.getToolCode(),
                rentalAgreement.getToolType().getType(),
                FormatUtils.formatDateValue(rentalAgreement.getCheckoutDate()),
                FormatUtils.formatPercentageValue(rentalAgreement.getDiscount()),
                FormatUtils.formatDateValue(rentalAgreement.getDueDate()),
                rentalAgreement.getChargeDays(),
                FormatUtils.formatCurrencyValue(rentalAgreement.getPreDiscountCharge()),
                FormatUtils.formatCurrencyValue(rentalAgreement.getDiscountAmount()),
                FormatUtils.formatCurrencyValue(rentalAgreement.getFinalCharge()));
        System.out.println("--------------------------------");
    }
}
