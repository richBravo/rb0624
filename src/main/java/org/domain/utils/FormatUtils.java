package org.domain.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatUtils {
    /**
     * The date format to display local date values.
     */
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy");

    /**
     * The currency format to display value amounts.
     */
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    /**
     * the percentage format to display discount values.
     */
    private static final DecimalFormat percentageFormat = new DecimalFormat("###%");

    /**
     * This method formats date values to MM/dd/yy.
     * @param date object that will be formatted to MM/dd/yy date.
     * @return A string representation of MM/dd/yy.
     */
    public static String formatDateValue(LocalDate date){
        return dateFormat.format(date);
    }

    /**
     * This method formats double values to currency format.
     * @param currency object that will be formatted to a standard currency value.
     * @return A string representation of a standard currency value.
     */
    public static String formatCurrencyValue(Double currency){
        return currencyFormat.format(currency);
    }

    /**
     * This method formats int values to percentage format.
     * @param discount object that will be formatted to percentage format.
     * @return A string representation containing a numerical value with a percentage character.
     */
    public static String formatPercentageValue(int discount){
        Double percentDiscount = (double)discount / 100;
        return percentageFormat.format(percentDiscount);
    }

    /**
     * This method formats true or false values to respective yes or no.
     * @param isCharge object that will be formatted to yes or no values.
     * @return A string representation containing a value of either yes or no.
     */
    public static String formatChargeValue(Boolean isCharge){
        return isCharge ? "Yes" : "No";
    }

}
