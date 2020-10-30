package Project.Business.Business;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_business.Business.Business_VerificationRequestUI;
import Interfaces.Shared.Choose_Place_ModelUI;
import org.openqa.selenium.WebDriver;

public class BusinessVerificationRequestPO extends AbstractPage {
    WebDriver driver;

    public BusinessVerificationRequestPO(WebDriver webDriver) {
        driver = webDriver;
    }

    public void enterValueToDynamicFieldOfVerifyForm(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, Business_VerificationRequestUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION, nameField);
        sendKeyToElement(driver, Business_VerificationRequestUI.DYNAMIC_FIELD_ON_ENTERPRISE_VERIFICATION,valueData,nameField);
    }

    public void chooseRegistrationDate(WebDriver driver, String valueDay, String valueMonth, String valueYear) {
        selectItemInDropdownByValue(driver, Business_VerificationRequestUI.SELECT_DAY_DROPDOWN, valueDay);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Business_VerificationRequestUI.SELECT_MONTH_DROPDOWN, valueMonth);
        setTimeDelay(1);
        selectItemInDropdownByValue(driver, Business_VerificationRequestUI.SELECT_YEAR_DROPDOWN, valueYear);
    }

    public void clickEnterToSearchAddress(WebDriver driver) {
        waitForElementClickable(driver, Business_VerificationRequestUI.SEARCH_ADDRESS_ICON);
        clickToElement(driver, Business_VerificationRequestUI.SEARCH_ADDRESS_ICON);
        setTimeDelay(1);
    }

    public void clickToUploadDocumentVerify(WebDriver driver, String fileName) {
        waitForElementClickable(driver, Business_VerificationRequestUI.UPLOAD_FILE_BUTTON);
        clickToElement(driver, Business_VerificationRequestUI.UPLOAD_FILE_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
        setTimeDelay(5);
        waitElementToVisible(driver, Business_VerificationRequestUI.UPLOADED_FIELD);
    }

    public void clickToSendRequestVerify(WebDriver driver) {
        waitForElementClickable(driver, Business_VerificationRequestUI.BUTTON_VERIFY_BUSINESS);
        clickToElement(driver, Business_VerificationRequestUI.BUTTON_VERIFY_BUSINESS);
    }

    public void clickToBackBusinessManagementPage(WebDriver driver) {
        waitElementToVisible(driver, Business_VerificationRequestUI.FORM_NOTIFICATION_SENT_REQUEST);
        waitElementToVisible(driver, Business_VerificationRequestUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        clickToElement(driver, Business_VerificationRequestUI.BACK_TO_BUSINESS_DASHBOARD_BUTTON);
        setTimeDelay(1);
    }

    public void enterValueToZipCodeField(WebDriver driver, String zipCode) {
        waitElementToVisible(driver, Business_VerificationRequestUI.ZIPCODE_FIELD);
        sendKeyToElement(driver, Business_VerificationRequestUI.ZIPCODE_FIELD,zipCode);
    }

    public void enterValueToBusinessScopeTextarea(WebDriver driver, String businessScope) {
        waitElementToVisible(driver, Business_VerificationRequestUI.BUSINESS_SCOPE_TEXT_AREA);
        sendKeyToElement(driver, Business_VerificationRequestUI.BUSINESS_SCOPE_TEXT_AREA, businessScope);
    }

    public boolean checkFormChooseLocationIsDisplay() {
        waitElementToVisible(driver, Choose_Place_ModelUI.TITLE_FORM);
        return checkElementIsDisplayed(driver, Choose_Place_ModelUI.ADD_LOCATION_BUTTON) &&
                checkElementIsDisplayed(driver, Choose_Place_ModelUI.MAP_CONTENT) &&
                checkElementIsDisplayed(driver, Choose_Place_ModelUI.TITLE_FORM);
    }

    public void chooseLocation(WebDriver driver, String expectedAddress) {
        waitForElementToPresence(driver, Choose_Place_ModelUI.LIST_LOCATION);
        waitForElementClickable(driver, Choose_Place_ModelUI.ITEM_LOCATION);
        clickToElement(driver, Choose_Place_ModelUI.ITEM_LOCATION);
        setTimeDelay(5);
    }

    public String getTitleOfFormSendRequestSuccess(WebDriver driver) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Business_VerificationRequestUI.FORM_NOTIFICATION_SENT_REQUEST);
        return getTextElement(driver, Business_VerificationRequestUI.TITLE_FORM_NOTIFICATION_SENT_REQUEST);
    }

    public String getTitleOfFormVerificationRequest() {
        waitElementToVisible(driver, Business_VerificationRequestUI.FORM_ENTERPRISE_VERIFICATION);
        return getTextElement(driver, Business_VerificationRequestUI.TITLE_FORM_ENTERPRISE_VERIFICATION);
    }
}