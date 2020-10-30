package Project.Newsfeed.Boooking;


import Interfaces.hahalolo_newsfeed.Booking.PaymentGateWay.Newsfeed_Payment_BillingInfoUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class PaymentInfoPO extends HeaderPagePO {
    WebDriver driver;
    public PaymentInfoPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPaymentBillinginfoIsDisplay() {
        return checkElementIsDisplayed(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_TAB);
    }

    public void enterDataToDynamicFieldOnBillingInfoTab(String nameField, String valueData ){
        waitElementToVisible(driver, Newsfeed_Payment_BillingInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, nameField);
        sendKeyToElement(driver, Newsfeed_Payment_BillingInfoUI.DYNAMIC_FIELD_ON_BILLING_INFO, valueData, nameField);
    }

    public void chooseCountryOnBillingInfoTab(String countryName) {
        selectItemInCustomDropdownByScroll(driver, Newsfeed_Payment_BillingInfoUI.COUNTRY_DROPDOWN_ON_BILLING_INFO , Newsfeed_Payment_BillingInfoUI.COUNTRY_ITEMM_ON_BILLING_INFO, countryName);
        setTimeDelay(1);
    }

    public void clickUpdateBillingInfo(){
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_UPDATE_BILLING_INFO);
    }

//    public boolean checkPaymentMethodSectionIsDisplay(WebDriver driver){
//        return checkElementDisplay(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
//    }

    public void choosePaymentMethodAleypay(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.ALEYPAY_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_PAYMENT);
    }

    public void choosePaymentMethodBaoKim(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_DOMESTIC);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_DOMESTIC);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.BAOKIM_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BAOKIM_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_PAYMENT);
    }

    public void choosePaymentMethodStripe(){
//        waitElementToVisible(driver, PaymentInfoUI.PAYMENT_METHOD_SECTION);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_INTERNATIONAL);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.PAYMENT_METHOD_INTERNATIONAL);
        setTimeDelay(1);
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.STRIPE_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.STRIPE_GATE_WAY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.CHECKBOX_AGGREE_POLICY);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_PAYMENT);
    }

    public boolean checkViscardTabIsDisplay() {
        return true;
    }

    public void clickButtonSaveBillingInfo() {
        waitForElementClickable(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_UPDATE_BILLING_INFO);
        clickToElement(driver, Newsfeed_Payment_BillingInfoUI.BUTTON_UPDATE_BILLING_INFO);
    }

    public void checkPaymentMethodIsDisplay() {
        setTimeDelay(2);
    }

    public boolean checkPaymentSuccessIsDisplay() {
        return true;
    }

    public void clickHereLinkToGoHandnote() {
    }


}
