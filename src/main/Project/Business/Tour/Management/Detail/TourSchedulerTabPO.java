package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_SchedulerUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourSchedulerTabPO extends TourCommonPO {
    WebDriver driver;
    public TourSchedulerTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkSchedulerTabDisplaySuccess() {
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver, Tour_SchedulerUI.SCHEDULER_TAB);
    }

    public void chooseStartDate(String startDate) {
        waitElementToVisible(driver, Tour_SchedulerUI.START_DATE_FIELD);
        sendKeyToElement(driver, Tour_SchedulerUI.START_DATE_FIELD,startDate);
    }

    public void chooseEndDate(String endDate) {
        waitElementToVisible(driver, Tour_SchedulerUI.END_DATE_FIELD);
        sendKeyToElement(driver, Tour_SchedulerUI.END_DATE_FIELD,endDate);
        setTimeDelay(3);
    }

    public void clickButtonSetting() {
        clickToElement(driver, Tour_SchedulerUI.SCHEDULER_TAB);
        waitForElementClickable(driver, Tour_SchedulerUI.BUTTON_SETTING);
        clickToElementByJS(driver, Tour_SchedulerUI.BUTTON_SETTING);
    }
}
