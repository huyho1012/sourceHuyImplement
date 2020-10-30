package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_SettingUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class TourSettingTabPO extends TourCommonPO {
    WebDriver driver;

    public TourSettingTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkSettingTourPageDisplay(WebDriver driver) {
        return checkElementIsDisplayed(driver, Tour_SettingUI.TOUR_SETTING_TAB);
    }

    public void clickToPublishTour() {
        if(!checkStatusPublishTour()){
            waitForElementClickable(driver, Tour_SettingUI.PUBLISH_TOUR);
            clickToElement(driver, Tour_SettingUI.PUBLISH_TOUR);
        }
    }

    public void clickToUnPublishTour() {
        if(checkStatusPublishTour()){
            waitForElementClickable(driver, Tour_SettingUI.PUBLISH_TOUR);
            clickToElement(driver, Tour_SettingUI.PUBLISH_TOUR);
        }
    }

    public boolean checkStatusPublishTour() {
        String colorBackground =  getAttributeClassWithAfter(driver,".custom-control-label","background-color");
        String hexaColorButtonPublish = Color.fromString(colorBackground).asHex();
        return hexaColorButtonPublish == "#166986";
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, Tour_SettingUI.BUTTON_SAVE_SETTING);
        clickToElement(driver, Tour_SettingUI.BUTTON_SAVE_SETTING);
    }
}
