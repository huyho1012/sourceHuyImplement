package Project.Business.Tour.Management.List;

import Interfaces.hahalolo_business.Tour.Management.List.Tour_ManagementUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourManagementPagePO extends TourCommonPO {
    WebDriver driver;
    public TourManagementPagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void enterValueOfTourName(String tourName) {
        waitElementToVisible(driver, Tour_ManagementUI.TOUR_NAME_FIELD);
        sendKeyToElement(driver, Tour_ManagementUI.TOUR_NAME_FIELD,tourName);
    }

    public void chooseTourType(String tourType) {
        waitElementToVisible(driver, Tour_ManagementUI.POPUP_CREATE_TOUR);
        selectItemInDropdownByText(driver, Tour_ManagementUI.TOUR_TYPE_DROP_DOWN,tourType);
    }

    public void chooseTourTopic(String tourTopic) {
        waitElementToVisible(driver, Tour_ManagementUI.POPUP_CREATE_TOUR);
        selectItemInDropdownByText(driver, Tour_ManagementUI.TOUR_TOPIC_DROP_DOWN,tourTopic);
    }

    public void clickSaveButtonToCreateTour() {
        waitElementToVisible(driver, Tour_ManagementUI.BUTTON_START_CREATE_TOUR);
        clickToElement(driver, Tour_ManagementUI.BUTTON_START_CREATE_TOUR);
    }

    public boolean checkPageWithCaseNoTourDisplay() {
        return checkElementIsDisplayed(driver, Tour_ManagementUI.BUTTON_START_CREATE_TOUR);
    }

    public void clickStartCreateTourButtonOnCenterListPage() {
        waitElementToVisible(driver, Tour_ManagementUI.BUTTON_START_CREATE_TOUR);
        clickToElement(driver, Tour_ManagementUI.BUTTON_START_CREATE_TOUR);
        setTimeDelay(1);
    }
    public void clickToButtonSaveOnPopup(){
        waitForElementClickable(driver, Tour_ManagementUI.BUTTON_SAVE);
        clickToElement(driver, Tour_ManagementUI.BUTTON_SAVE);
        setTimeDelay(1);
    }

    public boolean checkPopupCreateTourDisplay() {
        waitElementToVisible(driver, Tour_ManagementUI.POPUP_CREATE_TOUR);
        return getTextElement(driver, Tour_ManagementUI.POPUP_CREATE_TOUR_TITLE).contentEquals("Tạo Tour mới");
    }

    public boolean checkPageWithCaseHaveTourDisplay() {
        waitElementToVisible(driver, Tour_ManagementUI.TOUR_TOPIC_DROP_DOWN);
        return checkElementIsDisplayed(driver, Tour_ManagementUI.TOUR_LIST);
    }

    public void clickEditButtonOfDirectTour() {
        waitElementToVisible(driver, Tour_ManagementUI.TOUR_TOPIC_DROP_DOWN);
        waitForElementClickable(driver, Tour_ManagementUI.BUTTON_EDIT_DIRECT_TOUR);
        clickToElement(driver, Tour_ManagementUI.BUTTON_EDIT_DIRECT_TOUR);
    }

    public String getLanguageDefaultDsiplayOnFilterLang() {
        return getTextElement(driver, Tour_ManagementUI.DEFAULT_LANGUAGE);
    }

    public void clickTOViewDetailOfDirectTour(String tourName) {
        waitForElementClickable(driver, Tour_ManagementUI.BUTTON_VIEW_DETAIL_DIRECT_TOUR,tourName);
        clickToElement(driver, Tour_ManagementUI.BUTTON_VIEW_DETAIL_DIRECT_TOUR,tourName);
    }
}
