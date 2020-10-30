package Project.Business.Business;

import Interfaces.hahalolo_business.Business.Business_InformationUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class BusinessInfoPagePO extends HeaderPagePO {
    WebDriver driver;
    public BusinessInfoPagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public String getOwnerNameIsDisplay() {
        waitElementToVisible(driver, Business_InformationUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_InformationUI.OWNER_NAME);
    }

    public String getOwnerEmailIsDisplay() {
        waitElementToVisible(driver, Business_InformationUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_InformationUI.OWNER_EMAIL);
    }

    public void openBackendLoginPage(WebDriver driver) {
    }

    public boolean checkBusinessInfoPageIsDisplay() {
        waitElementToVisible(driver, Business_InformationUI.BUSINESS_INFORMATION_PAGE);
        return getTextElement(driver, Business_InformationUI.BUSINESS_INFORMATION_TITLE_PAGE).equalsIgnoreCase("Quản lý thông tin kinh doanh");
    }
}
