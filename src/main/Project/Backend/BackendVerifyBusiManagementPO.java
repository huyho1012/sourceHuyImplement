package Project.Backend;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_backend.Backend_VerifyBusiManagementeUI;
import org.openqa.selenium.WebDriver;

public class BackendVerifyBusiManagementPO extends AbstractPage {
    WebDriver driver;
    public BackendVerifyBusiManagementPO(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterEmailBusinessForSearch(WebDriver driver, String ownerBusinessEmail) {
        waitElementToVisible(driver, Backend_VerifyBusiManagementeUI.FIELD_SEARCH_BUSINESS_VERIFICATION);
        sendKeyToElement(driver, Backend_VerifyBusiManagementeUI.FIELD_SEARCH_BUSINESS_VERIFICATION,ownerBusinessEmail);
        setTimeDelay(1);
    }

    public void chooseStartDateForFilter(WebDriver driver, String startDate){
        waitElementToVisible(driver, Backend_VerifyBusiManagementeUI.START_DATE_FIELD);
        sendKeyToElement(driver, Backend_VerifyBusiManagementeUI.START_DATE_FIELD, startDate);
        setTimeDelay(1);
    }
    public void chooseEndDateForFilter(WebDriver driver, String endDate){
        waitElementToVisible(driver, Backend_VerifyBusiManagementeUI.END_DATE_FIELD);
        sendKeyToElement(driver, Backend_VerifyBusiManagementeUI.END_DATE_FIELD, endDate);
        setTimeDelay(1);
    }
    public void chooseTypeBusiness(WebDriver driver, String typeBusiness){
        selectItemInCustomDropdown(driver, Backend_VerifyBusiManagementeUI.BUSI_TYPE_DROPDOWN, Backend_VerifyBusiManagementeUI.BUSI_TYPE_ITEM, typeBusiness);
        setTimeDelay(2);
    }
    public void chooseStatusVerification(WebDriver driver, String statusVerification){
        selectItemInCustomDropdown(driver, Backend_VerifyBusiManagementeUI.STATUS_VERIFY_DROPDOWN, Backend_VerifyBusiManagementeUI.STATUS_VERIFY_ITEM, statusVerification);
        setTimeDelay(2);
    }
    public void clickToFilterButton(WebDriver driver) {
        clickToElementByJS(driver, Backend_VerifyBusiManagementeUI.BUTTON_FILTER);
        setTimeDelay(2);
    }

    public void clickVerifyButton(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        waitForElementClickable(driver, Backend_VerifyBusiManagementeUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        clickToElement(driver, Backend_VerifyBusiManagementeUI.BUTTON_VERIFY,businessName,ownerName, ownerEmail);
        setTimeDelay(1);
    }

    public void clickConfirmButtonOnPopup(WebDriver driver) {
        waitElementToVisible(driver, Backend_VerifyBusiManagementeUI.POPUP_CONFIRM_VERIFICATION);
        waitForElementClickable(driver, Backend_VerifyBusiManagementeUI.BUTTON_CONFIRM);
        clickToElement(driver, Backend_VerifyBusiManagementeUI.BUTTON_CONFIRM);
        setTimeDelay(1);
    }

    public void goToWalletLoginPage(WebDriver driver) {
    }

    public boolean checkPageIsDisplaySuccess() {
        return true;
    }

    public String getStatusOfBusinessVerification(WebDriver driver, String businessName, String ownerName, String ownerEmail) {
        return getTextElement(driver, Backend_VerifyBusiManagementeUI.STATUS_VERIFY_OF_BUSINESS_ITEM,businessName,ownerName,ownerEmail);
    }

    public boolean checkConfirmPopupDisplay(WebDriver driver) {
        return checkElementIsDisplayed(driver, Backend_VerifyBusiManagementeUI.POPUP_CONFIRM_VERIFICATION);
    }
}
