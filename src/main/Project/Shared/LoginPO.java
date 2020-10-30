package Project.Shared;

import Interfaces.hahalolo_newsfeed.StartApp.LoginUI;
import Interfaces.hahalolo_newsfeed.StartApp.Signup_AccountUI;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;

public class LoginPO extends CommonStartAppPO {
    WebDriver driver;

    public LoginPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void clickToButtonLogin(){
        waitForElementClickable(driver, LoginUI.BUTTON_LOGIN);
        clickToElement(driver, LoginUI.BUTTON_LOGIN);
    }

    public void enterDataToFieldUserName(String userName){
        waitElementToVisible(driver, LoginUI.FIELD_USER_NAME);
        sendKeyToElement(driver, LoginUI.FIELD_USER_NAME, userName);
    }

    public void enterDataToFieldPassword(String password){
        waitElementToVisible(driver, LoginUI.FIELD_PASSWORD);
        sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, password);
    }

    public String getCaptchaCodeDisplayOnForm(){
        waitElementToVisible(driver, LoginUI.IMAGE_CAPTCHA_CODE);
        return getTextElement(driver, LoginUI.IMAGE_CAPTCHA_CODE);
    }

    public void clickToButtonResetCaptchaCode(){
        waitForElementClickable(driver, LoginUI.ICON_RESET_CAPTCHA_CODE);
        clickToElement(driver, LoginUI.ICON_RESET_CAPTCHA_CODE);
    }

    public void clickToLinkForgotPassword(){
        waitForElementClickable(driver, LoginUI.LINK_FORGOT_PASSWORD);
        clickToElement(driver, LoginUI.LINK_FORGOT_PASSWORD);
    }

    public void enterValueToFieldCaptchaCode(String captchaCode){
        waitElementToVisible(driver, LoginUI.FIELD_CAPTCHA_CODE);
        sendKeyToElement(driver, LoginUI.FIELD_CAPTCHA_CODE,captchaCode);
    }

    public String getMessageValidateFieldUsername(){
        waitElementToVisible(driver, LoginUI.MESSAGE_VALIDATE_FIELD_USERNAME);
        return getTextElement(driver, LoginUI.MESSAGE_VALIDATE_FIELD_USERNAME);
    }

    public String getMessageValidateFieldPassword(){
        waitElementToVisible(driver, LoginUI.MESSAGE_VALIDATE_FIELD_PASSWORD);
        return getTextElement(driver, LoginUI.MESSAGE_VALIDATE_FIELD_PASSWORD);
    }

    public String getMessageValidateFieldCaptchaCode(){
        waitElementToVisible(driver, LoginUI.MESSAGE_VALIDATE_FIELD_CAPTCHA_CODE);
        return getTextElement(driver, LoginUI.MESSAGE_VALIDATE_FIELD_CAPTCHA_CODE);
    }

    public void loginToNewsfeedHahalolo(String userName, String password){
       if(checkNewsfeedLoginPageIsDisplayed()){
           sendKeyToElement(driver, LoginUI.FIELD_USER_NAME, userName);
           sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, password);
           clickToElement(driver, LoginUI.BUTTON_LOGIN);
       }
    }

    public void loginToBackendHahalolo(String userName, String password, String captcha){
        if(checkBackendLoginPageIsDisplayed()){
            sendKeyToElement(driver, LoginUI.FIELD_USER_NAME, userName);
            sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, password);
            sendKeyToElement(driver, LoginUI.FIELD_CAPTCHA_CODE, captcha);
            clickToElement(driver, LoginUI.BUTTON_LOGIN);
        }
    }

    public void loginToCensorHahalolo(String userName, String password, String captcha){
        if(checkCensorLoginPageIsDisplayed()){
            sendKeyToElement(driver, LoginUI.FIELD_USER_NAME, userName);
            sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, password);
            sendKeyToElement(driver, LoginUI.FIELD_CAPTCHA_CODE, captcha);
            clickToElement(driver, LoginUI.BUTTON_LOGIN);
        }
    }

    public void loginToWalletHahalolo(String userName, String password, String captcha){
        if(checkWalletLoginPageIsDisplayed()){
            sendKeyToElement(driver, LoginUI.FIELD_USER_NAME, userName);
            sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, password);
            sendKeyToElement(driver, LoginUI.FIELD_CAPTCHA_CODE, captcha);
            clickToElement(driver, LoginUI.BUTTON_LOGIN);
        }
    }

    public void loginNewsfeedHahaloloByUsingExcelFile(XSSFRow row){
        if(checkNewsfeedLoginPageIsDisplayed()){
            sendKeyToElement(driver, LoginUI.FIELD_USER_NAME,row.getCell(2).toString());
            sendKeyToElement(driver, LoginUI.FIELD_PASSWORD, row.getCell(3).toString());
            clickToElement(driver, LoginUI.BUTTON_LOGIN);
        }
    }

    public boolean checkWalletLoginPageIsDisplayed() {
        String urlWallet = "https://test-wallet.hahalolo.com/auth/signin";
        String urlLink = getCurrentURL(driver);
        return checkElementIsDisplayed(driver, LoginUI.FORM_LOGIN_WALLET)
                && urlLink.equals(urlWallet);
    }

    public boolean checkBackendLoginPageIsDisplayed() {
        String urlBackend = "https://test-backend.hahalolo.com/auth/signin";
        String urlLink = getCurrentURL(driver);
        return checkElementIsDisplayed(driver, LoginUI.FORM_LOGIN_BACKEND_CENSOR)
                && urlLink.equals(urlBackend);
    }

    public boolean checkCensorLoginPageIsDisplayed() {
        String urlCensor = "https://test-censor.hahalolo.com/auth/signin";
        String urlLink = getCurrentURL(driver);
        return checkElementIsDisplayed(driver, LoginUI.FORM_LOGIN_BACKEND_CENSOR)
                && urlLink.equals(urlCensor);
    }

    public boolean checkNewsfeedLoginPageIsDisplayed() {
        setTimeDelay(1);
        String urlNewsfeed = "https://test-newsfeed.hahalolo.com/auth/signin";
        String urlLink = getCurrentURL(driver);
        return checkElementIsDisplayed(driver, Signup_AccountUI.FORM_REGISTER_ACCOUNT)
                && urlLink.equals(urlNewsfeed);
    }

}
