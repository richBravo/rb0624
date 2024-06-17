package org.domain;

import org.domain.builders.ToolBuilder;
import org.domain.builders.ToolTypeBuilder;
import org.domain.models.Checkout;
import org.domain.utils.DisplayUtils;
import org.domain.validators.InputValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    /**
     * The checkout object used to process inputs and generate rental agreement
     */
    private static Checkout checkout;

    /**
     * The main method for application execution.
     * @param args
     */
    public static void main(String[] args) {
        initiateDisplayOfToolRentals();
        initiateCheckout();
    }

    /**
     * This method displays the tables for available tools for purchase and the cost for each tool type.
     */
    private static void initiateDisplayOfToolRentals(){
        DisplayUtils.displayToolsAvailableToRent(ToolBuilder.initiateToolListCreation());
        DisplayUtils.displayChargesForToolTypes(ToolTypeBuilder.initiateToolListCreation());
    }

    /**
     * This method initiates the checkout process, will generate the rental agreement afterwards
     * @throws Exception
     */
    public static void initiateCheckout() {
        Scanner input = new Scanner(System.in);
        try{
            //Receives the tool code input value and then validates
            System.out.print("Enter Tool code: ");
            String toolCode = input.nextLine();
            InputValidator.validateToolCodeExists(ToolBuilder.initiateToolListCreation(), toolCode);

            //Receives the checkout date input value and then validates
            System.out.print("Enter Checkout date (Ex: MM/dd/yy): ");
            LocalDate checkoutDate = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("MM/dd/yy"));

            //Receives the rental day input value and then validates
            System.out.print("Enter Rental days: ");
            int rentalDays = Integer.parseInt(input.nextLine());
            InputValidator.validateRentalDayInput(rentalDays);

            //Receives the discount input value and then validates
            System.out.print("Enter Discount: ");
            int discount = Integer.parseInt(input.nextLine());
            InputValidator.validateDiscountPercent(discount);

            //Creates a checkout instance to generate the rental agreement
            checkout = new Checkout(toolCode, checkoutDate, rentalDays, discount);
            checkout.generateRentalAgreement();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}