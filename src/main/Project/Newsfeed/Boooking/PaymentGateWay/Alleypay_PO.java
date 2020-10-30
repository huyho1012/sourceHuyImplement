package Project.Newsfeed.Boooking.PaymentGateWay;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_AlepayUI;
import org.openqa.selenium.WebDriver;

public class Alleypay_PO extends AbstractPage
{
    WebDriver driver;
    public Alleypay_PO(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAlleypayGateWayIsDisplay(){
        return true;
    }

    public void choosePaymentMethod(String paymentMethod){
        waitForElementClickable(driver, Newsfeed_Payment_AlepayUI.PAYMENT_METHOD_DROPDOWN);
        selectItemInDropdownByText(driver, Newsfeed_Payment_AlepayUI.PAYMENT_METHOD_DROPDOWN,paymentMethod);
    }

    public void enterDataToCardHolderNameField(String cardHoldername){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.CARDHOLDER_NAME_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.CARDHOLDER_NAME_FIELD,cardHoldername);
    }

    public void enterDataToCardNumberField(String cardHoldername){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.CARD_NUMBER_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.CARD_NUMBER_FIELD,cardHoldername);
    }

    public void enterDataToExpiredDateField(String expireDate){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.EXPIRED_DATE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.EXPIRED_DATE_FIELD,expireDate);
    }

    public void enterDataToCVVField(String ccvCode){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.CCV_CODE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.CCV_CODE_FIELD,ccvCode);
    }

    public void enterDataToEmailField(String email){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.EMAIL_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.EMAIL_FIELD,email);
    }
    public void enterDataToPhoneField(String phone){
        waitElementToVisible(driver, Newsfeed_Payment_AlepayUI.PHONE_FIELD);
        sendKeyToElement(driver, Newsfeed_Payment_AlepayUI.PHONE_FIELD,phone);
    }

    public void clickToConfirmPayment(){
        waitForElementClickable(driver, Newsfeed_Payment_AlepayUI.PAYMENT_BUTTON);
        clickToElement(driver, Newsfeed_Payment_AlepayUI.PAYMENT_BUTTON);
    }

}
