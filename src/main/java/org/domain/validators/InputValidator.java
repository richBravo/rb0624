package org.domain.validators;

import org.domain.exceptions.DiscountValidationException;
import org.domain.exceptions.RentalDayValidationException;
import org.domain.models.Tool;

import java.util.List;
import java.util.NoSuchElementException;

public class InputValidator {
    /**
     * This method validates whether the rental day inputted is within value range (1 or more days), if not the RentalDayValidationException is thrown.
     * @param rentalDay The rental date value that represents the amount of time the tool will be rented out.
     * @throws RentalDayValidationException when a given value is not within the rental day range.
     */
    public static void validateRentalDayInput(int rentalDay) throws RentalDayValidationException {
        if(rentalDay < 1){
            throw new RentalDayValidationException("Rental day count is not 1 or greater");
        }
    }

    /**
     * This method validates whether the discount inputted is within value range, if not the DiscountValidationException is thrown.
     * @param discount the discount value that represents the percentage of discount applied to the charge.
     * @throws DiscountValidationException when a given value is not within the percentage range.
     */
    public static void validateDiscountPercent(int discount) throws DiscountValidationException {
        if(discount < 0 || discount > 100){
            throw new DiscountValidationException("Discount percent is not in the range 0-100");
        }
    }

    /**
     * This method validates whether the tool code inputted is present within the tool list, if not the NoSuchElementException is thrown.
     * @param tools the list of tools values.
     * @param toolCode the tool code value that represents what tool what chosen to rent.
     * @throws NoSuchElementException when a given value is not present within the list.
     */
    public static void validateToolCodeExists(List<Tool> tools, String toolCode) throws NoSuchElementException {
        if(tools.stream().noneMatch(test -> test.getToolCode().equals(toolCode))){
            throw new NoSuchElementException("Tool code does not exist");
        }
    }
}
