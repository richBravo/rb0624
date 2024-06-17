package modules;

import org.domain.exceptions.DiscountValidationException;
import org.domain.models.Checkout;
import org.domain.utils.FormatUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutTest {
    /**
     * The checkout object used to process inputs and generate rental agreement
     */
    private static Checkout checkout;

    /**
     * The date format to display local date values.
     */
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy");

    @Test()
    @DisplayName("A unit test verifying that upon giving a discount value out of range a DiscountValidationException will be thrown.")
    public void testGenerateRentalAgreement_WhenDiscountIsOutsideOfValueRange_ThrowDiscountValidationException() {
        //Build test data
        checkout = new Checkout("JAKR", LocalDate.parse("09/03/15", dateFormat), 5, 101);

        //Assert
        assertThrows(DiscountValidationException.class, () -> checkout.generateRentalAgreement());
    }

    @Test
    @DisplayName("A unit test verifying that upon Independence day falling on a Saturday that the observed date will be on a Friday and will not be charged if it is a ladder.")
    public void testGenerateRentalAgreement_WhenIndependenceDateFallsOnASaturdayAndRentedToolIsALadder_ApplyNoHolidayChargeOnFriday() throws Exception {
        //Build test data
        checkout = new Checkout("LADW", LocalDate.parse("07/02/20", dateFormat), 3, 10);

        //Mock
        checkout.generateRentalAgreement();

        //Assert
        assertEquals("07/05/20", FormatUtils.formatDateValue(checkout.getRentalAgreement().getDueDate()));
        assertEquals(2, checkout.getRentalAgreement().getChargeDays());
        assertEquals("$3.98", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getPreDiscountCharge()));
        assertEquals("$0.40", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getDiscountAmount()));
        assertEquals("$3.58", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getFinalCharge()));
    }

    @Test
    @DisplayName("A unit test verifying that upon Independence day falling on a Sunday that the observed date will be on a Monday.")
    public void testGenerateRentalAgreement_WhenIndependenceDateFallsOnASunday_ApplyHolidayChargeOnMonday() throws Exception{
        //Build test data
        checkout = new Checkout("CHNS", LocalDate.parse("07/02/15", dateFormat), 6, 25);

        //Mock
        checkout.generateRentalAgreement();

        //Assert
        assertEquals("07/08/15", FormatUtils.formatDateValue(checkout.getRentalAgreement().getDueDate()));
        assertEquals(4, checkout.getRentalAgreement().getChargeDays());
        assertEquals("$5.96", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getPreDiscountCharge()));
        assertEquals("$1.49", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getDiscountAmount()));
        assertEquals("$4.47", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getFinalCharge()));
    }

    @Test
    @DisplayName("A unit test verifying that Labor day will fall on the first Monday being the 7th and apply the holiday charge.")
    public void testGenerateRentalAgreement_WhenLaborDayFallsOnThe7thAndWithZeroDiscount_ApplyHolidayCharge() throws Exception{
        //Build test data
        checkout = new Checkout("JAKD", LocalDate.parse("09/03/15", dateFormat), 6, 0);

        //Mock
        checkout.generateRentalAgreement();

        //Assert
        assertEquals("09/09/15", FormatUtils.formatDateValue(checkout.getRentalAgreement().getDueDate()));
        assertEquals(3, checkout.getRentalAgreement().getChargeDays());
        assertEquals("$8.97", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getPreDiscountCharge()));
        assertEquals("$0.00", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getDiscountAmount()));
        assertEquals("$8.97", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getFinalCharge()));
    }

    @Test
    @DisplayName("A unit test verifying that upon Independence day falling on a Saturday and with zero discount that the the holiday charge will be applied.")
    public void testGenerateRentalAgreement_WhenIndependenceDateFallsOnASaturdayAndWithZeroDiscount_ApplyHolidayChargeOnFriday() throws Exception{
        //Build test data
        checkout = new Checkout("JAKR", LocalDate.parse("07/02/15", dateFormat), 9, 0);

        //Mock
        checkout.generateRentalAgreement();

        //Assert
        assertEquals("07/11/15", FormatUtils.formatDateValue(checkout.getRentalAgreement().getDueDate()));
        assertEquals(6, checkout.getRentalAgreement().getChargeDays());
        assertEquals("$17.94", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getPreDiscountCharge()));
        assertEquals("$0.00", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getDiscountAmount()));
        assertEquals("$17.94", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getFinalCharge()));
    }

    @Test
    @DisplayName("A unit test verifying that upon Independence day falling on a Saturday that the observed date will be on a Friday and will not be charged if it is a Jackhammer.")
    public void testGenerateRentalAgreement_WhenIndependenceDateFallsOnASaturdayAndRentedToolIsAJackHammer_ApplyNoHolidayChargeOnFriday() throws Exception{
        //Build test data
        checkout = new Checkout("JAKR", LocalDate.parse("07/02/20", dateFormat), 4, 50);

        //Mock
        checkout.generateRentalAgreement();

        //Assert
        assertEquals("07/06/20", FormatUtils.formatDateValue(checkout.getRentalAgreement().getDueDate()));
        assertEquals(1, checkout.getRentalAgreement().getChargeDays());
        assertEquals("$2.99", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getPreDiscountCharge()));
        assertEquals("$1.50", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getDiscountAmount()));
        assertEquals("$1.49", FormatUtils.formatCurrencyValue(checkout.getRentalAgreement().getFinalCharge()));
    }
}
