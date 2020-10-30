package Project.Newsfeed.Boooking.PaymentGateWay;

import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_StripeUI;
import Project.Newsfeed.Boooking.BookingCommonPO;
import org.openqa.selenium.WebDriver;

public class Stripe_PO extends BookingCommonPO {
    WebDriver driver;

    public Stripe_PO(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkStripeSectionIsDisplay(){
        return checkElementIsDisplayed(driver, Newsfeed_Payment_StripeUI.STRIPE_PAGE);
    }

    public void enterCardnumber(String cardNum){
        waitElementToVisible(driver, Newsfeed_Payment_StripeUI.CARD_NUMBER);
        sendKeyToElement(driver, Newsfeed_Payment_StripeUI.CARD_NUMBER, cardNum);

    }

    public void enterValueToCcvCodeField(String ccvCode){
        waitElementToVisible(driver, Newsfeed_Payment_StripeUI.CVV_CODE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_StripeUI.CVV_CODE_FIELD, ccvCode);
    }

    public void enterValueToCardholderName(String cardHolderName){
        waitElementToVisible(driver, Newsfeed_Payment_StripeUI.CARD_HOLDERNAME);
        sendKeyToElement(driver, Newsfeed_Payment_StripeUI.CARD_HOLDERNAME, cardHolderName);
    }

    public void chooseExpirteDate(String valueMonth, String valueYear){
        selectItemInDropdownByValue(driver, Newsfeed_Payment_StripeUI.monthExpDropdown,valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Newsfeed_Payment_StripeUI.yearExpDropdown,valueYear);
    }
}
