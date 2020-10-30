package Project.Business.Tour.Management;

import Interfaces.hahalolo_business.Tour.Management.Tour_CommonUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class TourCommonPO extends HeaderPagePO {
    WebDriver driver;

    public TourCommonPO(WebDriver webDriver) {
        super(webDriver);
        driver= webDriver;
    }

    public void clickToItemOfNavigationMenu(String nameItem) {
        waitElementToVisible(driver, Tour_CommonUI.MENU_ON_TOUR_DETAIL);
        waitElementToVisible(driver, Tour_CommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
        clickToElementByJS(driver, Tour_CommonUI.ITEM_MENU_ON_TOUR_DETAIL, nameItem);
    }


    public void clickToBackTourManagement() {
        waitElementToVisible(driver, Tour_CommonUI.BUTTON_BACK_TO_MANAGEMENT_LIST);
        clickToElement(driver, Tour_CommonUI.BUTTON_BACK_TO_MANAGEMENT_LIST);
    }
}
