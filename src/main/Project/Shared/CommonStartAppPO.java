package Project.Shared;

import Common.HelperFunction.AbstractTest;
import Interfaces.hahalolo_newsfeed.StartApp.LoginUI;
import Interfaces.hahalolo_newsfeed.StartApp.Starting_CommonUI;
import org.openqa.selenium.WebDriver;

public class CommonStartAppPO extends AbstractTest {
    WebDriver driver;
    public CommonStartAppPO(WebDriver webDriver){
        driver = webDriver;
    }
    String content1= "Bạn thích";
    String content2= "đi du lịch?";
    String content3= "Bạn muốn tìm hiểu";
    String content4= "thông tin về những điểm đến?";
    String content5= "Hãy đăng nhập nhanh chóng chỉ với";
    String content6= "thao tác nhỏ để trải nghiệm và cảm nhận";
    String content7= "các tiện ích tuyệt vời của chúng tôi.";

    public boolean checkContentOfHaLoStartApp() {
        waitElementToVisible(driver, LoginUI.BUTTON_LOGIN);
        return getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_1).equalsIgnoreCase(content1)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_2).equalsIgnoreCase(content2)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_3).equalsIgnoreCase(content3)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_4).equalsIgnoreCase(content4)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_5).equalsIgnoreCase(content5)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_6).equalsIgnoreCase(content6)
                && getTextElement(driver, Starting_CommonUI.NEWSFEED_HALO_CONTENT_7).equalsIgnoreCase(content7);
    }
    public boolean checkGooglePlayIconIsDisplay(){
        waitElementToVisible(driver, LoginUI.BUTTON_LOGIN);
        return checkElementIsDisplayed(driver, Starting_CommonUI.ICON_GOOGLE_PLAY);
    }
    public boolean checkAppStoreIconIsDisplay(){
        waitElementToVisible(driver, LoginUI.BUTTON_LOGIN);
        return checkElementIsDisplayed(driver, Starting_CommonUI.ICON_APP_STORE);
    }
    public void clickToAppStoreLink(){
        waitForElementClickable(driver, Starting_CommonUI.ICON_APP_STORE);
        clickToElement(driver, Starting_CommonUI.ICON_APP_STORE);
    }
    public void clickToCHPlayLink(){
        waitForElementClickable(driver, Starting_CommonUI.ICON_GOOGLE_PLAY);
        clickToElement(driver, Starting_CommonUI.ICON_GOOGLE_PLAY);
    }

    public void clickToChangeLanguageToVI(){
        if(getAttributeValue(driver, Starting_CommonUI.ICON_VI,"class").contains("active")){
            clickToElement(driver, Starting_CommonUI.ICON_VI);
        }
    }

    public void clickToChangeToEng(){
        if(getAttributeValue(driver, Starting_CommonUI.ICON_ENG,"class").contains("active")){
            clickToElement(driver, Starting_CommonUI.ICON_ENG);
        }
    }

    public String getLanguageOfSystemHahalolo() {
        waitElementToVisible(driver, Starting_CommonUI.ICON_VI);
        if(getAttributeValue(driver, Starting_CommonUI.ICON_VI,"class").endsWith("active")){
            return "vi";
        }else if(getAttributeValue(driver, Starting_CommonUI.ICON_ENG,"class").endsWith("active")){
            return "eng";
        }
        return null;
    }
}
