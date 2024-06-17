package org.domain.models;

public class ToolType {
    /**
     * The type that represents the type that the tool is.
     */
    private String type;

    /**
     * The daily rental charge that represents the value amount charged for each rentable day for the tool.
     */
    private Double dailyRentalCharge;

    /**
     * The weekday charge that represents whether there are rent charges during the weekdays for the respective tool.
     */
    private Boolean weekdayCharge;

    /**
     * The weekend charge that represents whether there are rent charges during the weekends for the respective tool.
     */
    private Boolean weekendCharge;

    /**
     * The holiday charge that represents whether there are rent charges during the holidays for the respective tool.
     */
    private Boolean holidayCharge;

    /**
     * The constructor that takes in the type, dailyRentalCharge, weekdayCharge, weekendCharge, and holidayCharge to build a tool type object
     * @param type value that represents the type that the tool is.
     * @param dailyRentalCharge value that represents the value amount charged for each rentable day for the tool.
     * @param weekdayCharge value that represents whether there are rent charges during the weekdays for the respective tool.
     * @param weekendCharge value that represents whether there are rent charges during the weekends for the respective tool.
     * @param holidayCharge value that represents whether there are rent charges during the holidays for the respective tool.
     */
    public ToolType(String type, double dailyRentalCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.type = type;
        this.dailyRentalCharge = dailyRentalCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;

    }

    /**
     * A getter that retrieves the value for the tool type.
     * @return String value that contains the respective tool type.
     */
    public String getType() {
        return type;
    }

    /**
     * A getter that retrieves the value of the rent charge fee.
     * @return Double value that contains the rent charge fee of the respective tool type.
     */
    public Double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    /**
     * A getter that retrieves the value for if there is a weekday rent charge.
     * @return Boolean value that represents if there is a charge for rent on the weekdays.
     */
    public Boolean getWeekdayCharge() {
        return weekdayCharge;
    }

    /**
     * A getter that retrieves the value for if there is a weekend rent charge.
     * @return Boolean value that represents if there is a charge for rent on the weekends.
     */
    public Boolean getWeekendCharge() {
        return weekendCharge;
    }

    /**
     * A getter that retrieves the value for if there is a holiday rent charge.
     * @return Boolean value that represents if there is a charge for rent on the holidays.
     */
    public Boolean getHolidayCharge() {
        return holidayCharge;
    }

}
