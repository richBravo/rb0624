package org.domain.exceptions;

public class DiscountValidationException extends Exception{
    /**
     * The DiscountValidationException that is thrown upon the discount value being out of range.
     * @param message The message that will be printed of the exception occurring
     */
    public DiscountValidationException(String message) {
        super(message);
    }
}
