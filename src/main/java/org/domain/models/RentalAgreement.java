package org.domain.models;

import org.domain.utils.FormatUtils;
import org.domain.utils.HolidayUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class RentalAgreement {
    /**
     * The tool code value that represents what tool what chosen to rent.
     */
    private String toolCode;

    /**
     * The tool type value that contains charge values for the respective type of tool.
     */
    private ToolType toolType;

    /**
     * The tool brand value that represents the brand that the tool is from.
     */
    private String toolBrand;

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
     * The due date value that represents when the tool will be due based off of the amount of days the tool is being rented.
     */
    private LocalDate dueDate;

    /**
     * The charge days value that represents the amount of days that will be charged for use of the tool.
     */
    private int chargeDays;

    /**
     * The charge amount value that represents the charge before any discount is applied.
     */
    private Double preDiscountCharge;

    /**
     * The discount amount value that represents the discounted amount that will be subtracted from the pre-discounted charge.
     */
    private Double discountAmount;

    /**
     * The final charge value that represents the total amount due with the discount applied.
     */
    private Double finalCharge;

    /**
     * The constructor that takes in the tool, checkout date, rental days, and discount values to build out a rental agreement object.
     * @param tool the tool value that indicates the representative tool that will be rented out.
     * @param checkoutDate the checkout date value that represents when the tool will be checked out.
     * @param rentalDays the rental date value indicating the amount of time the tool will be rented out.
     * @param discount the discount value that indicates the percentage of discount applied to the charge.
     */
    public RentalAgreement(Tool tool, LocalDate checkoutDate, int rentalDays, int discount){
        this.toolCode = tool.getToolCode();
        this.toolType = tool.getToolType();
        this.toolBrand = tool.getBrand();
        this.checkoutDate = checkoutDate;
        this.rentalDays = rentalDays;
        this.discount = discount;
    }

    /**
     * The method that generates the values for the due date, charge days, pre-discount charge, discount amount, and final charge for display.
     */
    public void generate(){
        this.dueDate = calculateDueDate(this.checkoutDate, this.rentalDays);
        this.chargeDays = calculateChargeDays(this.toolType, this.checkoutDate, this.rentalDays);
        this.preDiscountCharge = calculatePreDiscountCharge(this.chargeDays, this.toolType.getDailyRentalCharge());
        this.discountAmount = calculateDiscountAmount(this.discount, this.preDiscountCharge);
        this.finalCharge = calculateFinalCharge(this.preDiscountCharge, discountAmount);
    }

    /**
     * The method calculates the due date based off of the checkout date and the number of rental days.
     * @param checkoutDate the checkout date value that represents when the tool will be checked out.
     * @param rentalDays the rental date value indicating the amount of time the tool will be rented out.
     * @return Date value that represents the due date.
     */
    private LocalDate calculateDueDate(LocalDate checkoutDate, int rentalDays){
        return checkoutDate.plusDays(rentalDays);
    }

    /**
     * The method calculates the charge days based off of the tool type, checkout date, and the number of rental days.
     * @param toolType the tool type value that contains charge values for the respective type of tool.
     * @param checkoutDate the checkout date value that represents when the tool will be checked out.
     * @param rentalDays the rental date value indicating the amount of time the tool will be rented out.
     * @return int value that represents the charge days.
     */
    private int calculateChargeDays(ToolType toolType, LocalDate checkoutDate, int rentalDays){
        int chargeDays = 0;
        LocalDate iteratorDate = checkoutDate;

        for(int iterator = 0; iterator < rentalDays; iterator++){
            if(FormatUtils.formatDateValue(HolidayUtils.getLaborDayDate(iteratorDate)).equals(FormatUtils.formatDateValue(iteratorDate)) || FormatUtils.formatDateValue(HolidayUtils.getObservedIndependenceDay(iteratorDate)).equals(FormatUtils.formatDateValue(iteratorDate))){
                if (toolType.getHolidayCharge()){
                    chargeDays++;
                }
            }
            else if ((iteratorDate.getDayOfWeek() == DayOfWeek.SATURDAY || iteratorDate.getDayOfWeek() == DayOfWeek.SUNDAY) && toolType.getWeekendCharge()){
                chargeDays++;
            }
            else if(!(iteratorDate.getDayOfWeek() == DayOfWeek.SATURDAY || iteratorDate.getDayOfWeek() == DayOfWeek.SUNDAY) && toolType.getWeekdayCharge()){
                chargeDays++;
            }
            iteratorDate = iteratorDate.plusDays(1);
        }
        return chargeDays;
    }

    /**
     * The method calculates the pre-discount charge based off of the charge days and the daily charge amount for the tool type.
     * @param chargeDays the charge days value that represents the amount of days that will be charged for use of the tool.
     * @param dailyCharge the daily charge value that represents the amount charged for each charge rental day for the respective tool type.
     * @return Double value that represents the pre-discount charge.
     */
    private Double calculatePreDiscountCharge(int chargeDays, Double dailyCharge){
        BigDecimal preDiscountCharge = new BigDecimal(chargeDays * dailyCharge).setScale(2, RoundingMode.HALF_UP);
        return preDiscountCharge.doubleValue();
    }

    /**
     * The method calculates the discount amount based off of the discount percent and the pre-discount charge amount.
     * @param discount the discount value that represents the percentage of discount applied to the charge.
     * @param preDiscountCharge the charge amount value that represents the charge before any discount is applied.
     * @return Double value that represents the discount amount.
     */
    private Double calculateDiscountAmount(int discount, Double preDiscountCharge){
        Double discountPercent = (double)discount / 100;
        BigDecimal discountAmount = new BigDecimal(preDiscountCharge * discountPercent).setScale(2, RoundingMode.HALF_UP);
        return discountAmount.doubleValue();
    }

    /**
     * The method calculates the final charge amount based off of the pre-discount charge amount and the discount amount.
     * @return Double value that represents the  final charge amount.
     */
    private Double calculateFinalCharge(Double preDiscountCharge, Double discountAmount){
        return preDiscountCharge - discountAmount;
    }

    /**
     * A getter that retrieves the value for the tool code
     * @return String value that contains the respective tool code.
     */
    public String getToolCode() {
        return toolCode;
    }

    /**
     * A getter that retrieves the value for the tool type.
     * @return String value that contains the respective tool type.
     */
    public ToolType getToolType() {
        return toolType;
    }

    /**
     * A getter that retrieves the value for the checkout date.
     * @return String value that contains the respective checkout date.
     */
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * A getter that retrieves the value for the discount.
     * @return String value that contains the respective discount.
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * A getter that retrieves the value for the due date
     * @return String value that contains the respective due date.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * A getter that retrieves the value for the charge days.
     * @return String value that contains the respective charge days.
     */
    public int getChargeDays() {
        return chargeDays;
    }

    /**
     * A getter that retrieves the value for the pre-discount charge.
     * @return String value that contains the respective pre-discount charge.
     */
    public Double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    /**
     * A getter that retrieves the value for the discount amount.
     * @return String value that contains the respective discount amount.
     */
    public Double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * A getter that retrieves the value for the final charge.
     * @return String value that contains the respective final charge.
     */
    public Double getFinalCharge() {
        return finalCharge;
    }
}
