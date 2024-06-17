package org.domain.exceptions;

public class RentalDayValidationException extends Exception {
    /**
     * The RentalDayValidationException that is thrown upon the rental day value is less than 1.
     * @param message The message that will be printed out when the exception occurs
     */
    public RentalDayValidationException(String message) {
        super(message);
    }
}
