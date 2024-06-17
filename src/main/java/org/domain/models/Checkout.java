package org.domain.models;

import org.domain.builders.ToolBuilder;
import org.domain.utils.DisplayUtils;
import org.domain.validators.InputValidator;

import java.time.LocalDate;
import java.util.List;

public class Checkout {
    /**
     * The list of tools that are available to rent.
     */
    private static final List<Tool> tools = ToolBuilder.initiateToolListCreation();

    /**
     * The tool code value that represents what tool what chosen to rent.
     */
    private String toolCode;

    /**
     * The rental agreement that is generated from the checkout process.
     */
    private RentalAgreement rentalAgreement;

    /**
     * The rental date value that represents the amount of time the tool will be rented out.
     */
    private int rentalDays;

    /**
     * The checkout date value that represents when the tool will be checked out.
     */
    private LocalDate checkoutDate;

    /**
     * The discount value that represents the percentage of discount applied to the charge.
     */
    private int discount;

    /**
     * The constructor that takes in the tool list to build out a checkout object.
     * @param toolCode the tool code value that indicates the representative tool that will be rented out.
     * @param checkoutDate the checkout date value that indicates when the tool will be checked out.
     * @param rentalDays the rental date value indicating the amount of time the tool will be rented out.
     * @param discount the discount value that indicates the percentage of discount applied to the charge.
     */
    public Checkout(String toolCode, LocalDate checkoutDate, int rentalDays, int discount){
        this.toolCode = toolCode;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.discount = discount;
    }

    /**
     * The method generates the rental agreement given by the values needed for calculating rental agreement values.
     */
    public void generateRentalAgreement() throws Exception{
        InputValidator.validateToolCodeExists(ToolBuilder.initiateToolListCreation(), toolCode);
        InputValidator.validateRentalDayInput(rentalDays);
        InputValidator.validateDiscountPercent(discount);
        Tool tool = tools.stream().filter(test -> test.getToolCode().equals(toolCode)).findFirst().orElse(null);
        this.rentalAgreement = new RentalAgreement(tool, checkoutDate, rentalDays, discount);
        this.rentalAgreement.generate();
        DisplayUtils.displayRentalAgreement(this.rentalAgreement);
    }

    /**
     * A getter that retrieves the value for the rental agreement.
     * @return RentalAgreement value that contains the values for the rental agreement upon previous checkout.
     */
    public RentalAgreement getRentalAgreement(){
        return this.rentalAgreement;
    }
}
