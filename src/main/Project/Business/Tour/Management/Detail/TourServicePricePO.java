package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_ServicePriceUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourServicePricePO extends TourCommonPO {
    WebDriver driver;
    public TourServicePricePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkTourServicePriceTab() {
         waitElementToVisible(driver, Tour_ServicePriceUI.TAB_PRICE_SERVICE);
         return true;
    }

    public void clickButtonCreateNewPrice() {
        waitForElementClickable(driver, Tour_ServicePriceUI.BUTTON_CREATE_PRICE);
        clickToElement(driver, Tour_ServicePriceUI.BUTTON_CREATE_PRICE);
    }

    public void enterPriceOfService(String price) {
        int positionField = 0;
        if(!checkPageHaveServicePrice()){
            waitElementToVisible(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, String.valueOf(1));
            sendKeyToElement(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, price, String.valueOf(1));
        }
        else {
            int n = findElements(driver, Tour_ServicePriceUI.SERVICE_PRICE_LIST).size();
            waitElementToVisible(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, String.valueOf(n+1));
            sendKeyToElement(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, price, String.valueOf(n+1));
        }

    }

    private boolean checkPageHaveServicePrice() {
        waitElementToVisible(driver, Tour_ServicePriceUI.TAB_PRICE_SERVICE);
        return checkElementIsDisplayed(driver, Tour_ServicePriceUI.SELECTED_SERIVCE);
    }

    public void choooseServiceOnDropdown() {
        int positionField = 0;
        if(!checkPageHaveServicePrice()){
            waitElementToVisible(driver, Tour_ServicePriceUI.SERVICE_DROP_LiST, String.valueOf(1));
            selectItemInCustomDropdownByScroll(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, Tour_ServicePriceUI.SERVICE_DROP_ITEM,"Phòng view công viên", String.valueOf(1));
        }
        else {
            int n = findElements(driver, Tour_ServicePriceUI.SERVICE_PRICE_LIST).size();
            waitElementToVisible(driver, Tour_ServicePriceUI.SERVICE_DROP_LiST, String.valueOf(n+1));
            selectItemInCustomDropdownByScroll(driver, Tour_ServicePriceUI.SERVICE_PRICE_FIELD, Tour_ServicePriceUI.SERVICE_DROP_ITEM,"Phòng view công viên", String.valueOf(n+1));
        }
    }


}
