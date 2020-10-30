package Project.Business.Tour;

import Interfaces.hahalolo_business.Tour.Tour_DashboardUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class TourDashboardPagePO extends HeaderPagePO {
    WebDriver driver;

    public TourDashboardPagePO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public String getPageNameOnTourDashboard()
    {
        waitElementToVisible(driver, Tour_DashboardUI.TOUR_DASHBOARD_PAGE);
        return getTextElement(driver, Tour_DashboardUI.TEXT_PAGE_NAME_ON_DASHBOARD);
    }

    public void createNewTourOnDashboard(String tourName, String topicName)
    {
        enterDataToTourName(tourName);
        selectTopicOnPopupCreateTour(topicName);
        clickToButtonSaveOnPopupCreateTour();
    }

    public boolean checkPageIsDisplay(String tourPageName)
    {
//        switchWindowByID(driver, driver.getWindowHandle());
        switchWindowByTitle(driver,"Hahalolo - Tour Dashboard");
        return getPageNameOnTourDashboard().contains(tourPageName);
    }

    public void clickToButtonCreateTour()
    {
        waitElementToVisible(driver, Tour_DashboardUI.BUTTON_CREATE_TOUR);
        waitForElementClickable(driver, Tour_DashboardUI.BUTTON_CREATE_TOUR);
        scrollIntoElementByJS(driver, Tour_DashboardUI.BUTTON_CREATE_TOUR);
        clickToElementByJS(driver, Tour_DashboardUI.BUTTON_CREATE_TOUR);
    }

    public void clickToButtonSaveOnPopupCreateTour()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_BUTTON_SAVE);
        clickToElement(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_BUTTON_SAVE);
    }

    public void clickToButtonCancel()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_BUTTON_CANCEL);
        clickToElement(driver, Tour_DashboardUI.POPUP_BUTTON_CANCEL);
        waitForElementInvisible(driver, Tour_DashboardUI.POPUP_BUTTON_CANCEL);
    }

    public void enterDataToTourName(String tourName)
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_TEXTBOX_NAME);
        sendKeyToElement(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_TEXTBOX_NAME, tourName);
    }

    public void selectTopicOnPopupCreateTour(String topicName)
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_TOPIC);
        selectItemInDropdownByText(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_TOPIC, topicName);
    }

    public String getAlertOnTourName()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_NAME);
        return getTextElement(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_NAME);
    }

    public String getAlertOnTourTopic()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR);
        return getTextElement(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR);
    }

    public boolean checkAlertOnTourName()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_NAME);
        return checkElementIsDisplayed(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_NAME);
    }

    public boolean checkAlertOnTourNameUndisplay()
    {
        return checkElementUndisplayed(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_NAME);
    }

    public boolean checkAlertOnTourTopic()
    {
        waitElementToVisible(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR);
        return checkElementIsDisplayed(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR);
    }

    public boolean checkAlertOnTourTopicUndisplay()
    {
        return checkElementUndisplayed(driver, Tour_DashboardUI.POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR);
    }

}
