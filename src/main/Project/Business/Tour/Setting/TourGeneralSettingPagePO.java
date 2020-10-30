package Project.Business.Tour.Setting;

import Interfaces.hahalolo_business.Tour.GeneralSetting.Tour_General_SettingUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class TourGeneralSettingPagePO extends HeaderPagePO {
    WebDriver driver;
    public TourGeneralSettingPagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }
    public void clickToItemOnTourInformationNav(String itemMenu){
        waitForElementClickable(driver, Tour_General_SettingUI.NAVBAR_MENU, itemMenu);
        clickToElement(driver, Tour_General_SettingUI.NAVBAR_MENU, itemMenu);
    }

    public void enterPrepaymentAmount(String s) {
    }

    public void enterCancellationAmount( String s) {
    }

    public void enterDayAllowToCancel( String s) {
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver, Tour_General_SettingUI.BUTTON_SAVE_ON_BODY);
        clickToElement(driver, Tour_General_SettingUI.BUTTON_SAVE_ON_BODY);
    }

    public void clickToSettingVAT(WebDriver driver) {
    }

    public void chooseOptionVATInclude() {
        waitForElementClickable(driver, Tour_General_SettingUI.VAT_OPTION_1);
        clickToElement(driver, Tour_General_SettingUI.VAT_OPTION_1);
    }
    public void chooseOptionAddVAT(String valueVAT) {
        waitForElementClickable(driver, Tour_General_SettingUI.VAT_OPTION_2);
        clickToElement(driver, Tour_General_SettingUI.VAT_OPTION_2);
        waitElementToVisible(driver, Tour_General_SettingUI.VAT_VALUE_FIELD);
        sendKeyToElement(driver, Tour_General_SettingUI.VAT_VALUE_FIELD,valueVAT);
    }

    public void enterDataValueToTextFieldOnAgeSettingTab(String nameField, String valueData){
        waitElementToVisible(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }

    public void enterDataValueToTextFieldOnNotiOrder(String nameField, String valueData){
        waitElementToVisible(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }

    public void clickToEnableMode() {
        waitElementToVisible(driver, Tour_General_SettingUI.TITLE_OF_GENERAL_INFO);
        waitForElementClickable(driver, Tour_General_SettingUI.ENABLE_MODE);
        clickToElement(driver, Tour_General_SettingUI.ENABLE_MODE);
        setTimeDelay(1);
    }

    public void enterValueOnEmailAddress(String s) {
    }

    public void enterValueOnPhone(String s) {
    }

    public void clickToTopicTourOnMenu() {
    }

    public boolean checkTabPrepaymentAmountDisplay() {
        return true;
    }

    public boolean checkVATSettingPageDisplay() {
        waitElementToVisible(driver, Tour_General_SettingUI.TITLE_OF_GENERAL_INFO);
        return getAttributeValue(driver, Tour_General_SettingUI.NAVBAR_MENU, "class", "vat").contains("active");
    }

    public boolean checkAgeSettingPageDisplay(){
        waitElementToVisible(driver, Tour_General_SettingUI.TITLE_OF_GENERAL_INFO);
        return getAttributeValue(driver, Tour_General_SettingUI.NAVBAR_MENU, "class", "age").contains("active");

    }

    public boolean checkNotiForOrderSettingPageDisplay() {
        waitElementToVisible(driver, Tour_General_SettingUI.TITLE_OF_GENERAL_INFO);
        return getAttributeValue(driver, Tour_General_SettingUI.NAVBAR_MENU, "class", "mail").contains("active");
    }

    public void enterDataValueToTextFieldOnPrepaymentTab(String nameField, String valueData) {
        waitElementToVisible(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,nameField);
        sendKeyToElement(driver, Tour_General_SettingUI.DYNAMIC_TEXT_FIELD,valueData,nameField);
    }
}
