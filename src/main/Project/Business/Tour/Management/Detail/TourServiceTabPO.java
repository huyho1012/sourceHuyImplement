package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_ServiceUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourServiceTabPO extends TourCommonPO {
    WebDriver driver;
    public TourServiceTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkTourServiceTabDisplaySuccess() {
        return checkElementIsDisplayed(driver, Tour_ServiceUI.SERVICE_TAB);
    }

    public void addServicesApply(int numberService) {
        waitElementToVisible(driver, Tour_ServiceUI.SERVICE_TAB);
        int n = findElements(driver, Tour_ServiceUI.HALO_SERVICE_LIST).size();
        for(int i =1 ; i<=n ; i++){
            waitForElementClickable(driver, Tour_ServiceUI.HALO_SERVICE_ITEM, String.valueOf(i));
            clickToElement(driver, Tour_ServiceUI.HALO_SERVICE_ITEM, String.valueOf(i));
            setTimeDelay(1);
            if(i > numberService){
                break;
            }
        }
    }
    public void removeServiceApply() {
        waitElementToVisible(driver, Tour_ServiceUI.SERVICE_TAB);
        int n = findElements(driver, Tour_ServiceUI.HALO_SERVICE_LIST).size();
        for(int i =0 ; i<n ; i++){
            waitForElementClickable(driver, Tour_ServiceUI.HALO_SERVICE_ITEM, String.valueOf(i));
            clickToElement(driver, Tour_ServiceUI.HALO_SERVICE_ITEM, String.valueOf(i));
            setTimeDelay(1);
        }
    }

    public void clickUpdateButton() {
        waitForElementClickable(driver, Tour_ServiceUI.BUTTON_UPDATE_SERVICE);
        clickToElement(driver, Tour_ServiceUI.BUTTON_UPDATE_SERVICE);
        setTimeDelay(1);
    }

    public void checkHaloTourIsAdded() {
        waitElementToVisible(driver, Tour_ServiceUI.SERVICE_TAB);
        int n = findElements(driver, Tour_ServiceUI.TOUR_SERVICE_LIST).size();
        for(int i = 0; i<n ; i++){
            waitForElementClickable(driver, Tour_ServiceUI.TOUR_SERVICE_ITEM, String.valueOf(i));
            clickToElement(driver, Tour_ServiceUI.TOUR_SERVICE_ITEM, String.valueOf(i));
            setTimeDelay(1);
        }

    }
}
