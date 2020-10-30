package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.Newsfeed_Account_SecurityAndLoginUI;
import Interfaces.hahalolo_newsfeed.Header.HeaderUI;
import org.openqa.selenium.WebDriver;

public class SecurityAndLoginPO extends AccountCommonPO {
    WebDriver driver;
    public SecurityAndLoginPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void clickButtonLogOutAllSession(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_LOGOUT_ALL);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_LOGOUT_ALL);
    }

    public boolean checkConfirmLogOutAllSessionIsDisplay(){
        return checkElementIsDisplayed(driver, Newsfeed_Account_SecurityAndLoginUI.POPUP_CONFIRM_LOGOUT_ALL_SESSION);
    }

    public void clickToConfirmActionLogoutAll(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CONFIRM_LOGOUT_ALL);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CONFIRM_LOGOUT_ALL);
    }

    public boolean checkLogoutAllSessionSuccesfully(){
        return getTextElement(driver, HeaderUI.TOAST_MESSAGE).equalsIgnoreCase("Đăng xuất thành công");
    }

    public void clickToIconChangePassword(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.ICON_CHANGE_PASSWORD);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.ICON_CHANGE_PASSWORD);
    }

    public void clickToConfirmChangePass(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CONFIRM_CHANGE_PASS);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CONFIRM_CHANGE_PASS);
    }

    public void clickToCancelChangePass(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CANCEL_CHANGE_PASS);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.BUTTON_CANCEL_CHANGE_PASS);
    }

    public void clickToLinkForgotPass(){
        waitForElementClickable(driver, Newsfeed_Account_SecurityAndLoginUI.LINK_FORGOT);
        clickToElement(driver, Newsfeed_Account_SecurityAndLoginUI.LINK_FORGOT);
    }

    public void enterDataToCurrentPassword(String currentPass){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.CURRENT_PASS);
        sendKeyToElement(driver, Newsfeed_Account_SecurityAndLoginUI.CURRENT_PASS, currentPass);
    }

    public void enterDataToNewPassword(String newPass){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.NEW_PASS);
        sendKeyToElement(driver, Newsfeed_Account_SecurityAndLoginUI.NEW_PASS, newPass);
    }

    public void enterDataToConfirmNewPass(String confirmNewPass){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.CONFIRM_NEW_PASS);
        sendKeyToElement(driver, Newsfeed_Account_SecurityAndLoginUI.CONFIRM_NEW_PASS, confirmNewPass);
    }

    public String getErrorMessageOfCurrentPass(){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_CURRENT_PASS);
        return getTextElement(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_CURRENT_PASS);
    }

    public String getErrorMessageOfNewPass(){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_NEW_PASS);
        return getTextElement(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_NEW_PASS);
    }

    public String getErrorMessageOfConfirmNewPass(){
        waitElementToVisible(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_CONFIRM_NEW_PASS);
        return getTextElement(driver, Newsfeed_Account_SecurityAndLoginUI.MESSAGE_OF_CONFIRM_NEW_PASS);
    }
}
