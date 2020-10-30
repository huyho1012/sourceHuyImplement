package Project.Shared;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_newsfeed.StartApp.Forgot_PasswordUI;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPO extends AbstractPage {
    WebDriver driver;
    public ForgotPasswordPO(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsernameToSearch(WebDriver driver, String userName){
        waitElementToVisible(driver, Forgot_PasswordUI.SEARCH_USERNAME_FIELD);
        sendKeyToElement(driver, Forgot_PasswordUI.SEARCH_USERNAME_FIELD, userName);
    }

    public void clickToSearchUsername(WebDriver driver){
        waitForElementClickable(driver, Forgot_PasswordUI.SEARCH_USER_BUTTON);
        clickToElement(driver, Forgot_PasswordUI.SEARCH_USER_BUTTON);
    }

    public void clickToCancelChangePassOnStep1(WebDriver driver){
        waitForElementClickable(driver, Forgot_PasswordUI.CANCEL_FORGOT_BUTTON);
        clickToElement(driver, Forgot_PasswordUI.CANCEL_FORGOT_BUTTON);
    }

    public String getErrMessageOfUsername(WebDriver driver){
        waitElementToVisible(driver, Forgot_PasswordUI.ERR_VALIDATE_USERNAME_FIELD);
        return getTextElement(driver, Forgot_PasswordUI.ERR_VALIDATE_USERNAME_FIELD);
    }

    public boolean checkMessageNoResultAccount(WebDriver driver){
        return checkElementIsDisplayed(driver, Forgot_PasswordUI.NO_RESULT);
    }

    public String getHeaderNoResultAccount(WebDriver driver){
        return getTextElement(driver, Forgot_PasswordUI.NO_RESULT_HEADER);
    }
    public String getContentNoResultAccount(WebDriver driver){
        return getTextElement(driver, Forgot_PasswordUI.NO_RESULT_CONTENT);
    }

    public String getDataOfUsernameDisplayOnStep2(WebDriver driver){
        return  getTextElement(driver, Forgot_PasswordUI.USERNAME_FIELD_DATA);
    }
    public void clickContinueButtonOnStep2(WebDriver driver){
        waitForElementClickable(driver, Forgot_PasswordUI.CONTINUE_STEP2);
        clickToElement(driver, Forgot_PasswordUI.CONTINUE_STEP2);
    }
    public void clickCancelFindAccountOnStep2(WebDriver driver){
        waitForElementClickable(driver, Forgot_PasswordUI.BACK_FIND_ACCOUNT_BUTTON);
        clickToElement(driver, Forgot_PasswordUI.BACK_FIND_ACCOUNT_BUTTON);
    }
    public void enterDataOnDynamicFieldOnChangePass(WebDriver driver, String nameField, String data){
        waitElementToVisible(driver, Forgot_PasswordUI.DYNAMIC_FIELD_ON_FORGOT_FORM, nameField);
        sendKeyToElement(driver, Forgot_PasswordUI.DYNAMIC_FIELD_ON_FORGOT_FORM,nameField, data);
    }
}
