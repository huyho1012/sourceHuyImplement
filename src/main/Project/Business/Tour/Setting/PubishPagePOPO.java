package Project.Business.Tour.Setting;

import Interfaces.hahalolo_business.Tour.GeneralSetting.PublishUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class PubishPagePOPO extends HeaderPagePO {
    WebDriver driver;
    public PubishPagePOPO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPublishPageIsDisplay(){
        return checkElementIsDisplayed(driver, PublishUI.TITLE_PAGE) && checkElementIsDisplayed(driver, PublishUI.BUTTON_PUBLISH_PAGE);
    }

    public void publishPage(){
        waitForElementClickable(driver, PublishUI.BUTTON_PUBLISH_PAGE);
        clickToElement(driver, PublishUI.BUTTON_PUBLISH_PAGE);
        setTimeDelay(1);
    }

    public void unPublishPage(){
        waitForElementClickable(driver, PublishUI.BUTTON_PUBLISH_PAGE);
        clickToElement(driver, PublishUI.BUTTON_PUBLISH_PAGE);
        setTimeDelay(1);
    }


    public Boolean checkStatusOfPage () {
        String rgb = Color.fromString(getAttributeClassWithAfter(driver, ".custom-control-label","background-color")).asHex();
        if(rgb.equals("#166986")){
            System.out.println("Page publish");
            return true;
        }
        else {
            System.out.println("Page unpublish");
            return false;
        }
    }

    public String getTextOFToastMessage(){
        waitForElementInvisible(driver, PublishUI.TOAST_MESSAGE);
        return getTextElement(driver, PublishUI.TOAST_MESSAGE);
    }
}

