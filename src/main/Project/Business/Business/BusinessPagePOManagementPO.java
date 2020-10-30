package Project.Business.Business;

import Interfaces.hahalolo_business.Business.Business_PageManagementUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class BusinessPagePOManagementPO extends HeaderPagePO {
    WebDriver driver;
    public BusinessPagePOManagementPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void choosePageType(String pageType) {
        clickToElementByJS(driver, Business_PageManagementUI.PAGE_CATEGORY_ITEM,pageType);
        setTimeDelay(1);
    }

    public void enterPageNameToCreate(String pageName) {
        waitElementToVisible(driver, Business_PageManagementUI.PAGE_NAME_FIELD);
        sendKeyToElement(driver, Business_PageManagementUI.PAGE_NAME_FIELD, pageName);
        setTimeDelay(1);
    }

    public void clickToCreatePage() {
        waitElementToVisible(driver, Business_PageManagementUI.POPUP_CREATE_NEW_PAGE);
        waitForElementClickable(driver, Business_PageManagementUI.BUTTON_CREATE_PAGE);
        clickToElement(driver, Business_PageManagementUI.BUTTON_CREATE_PAGE);
        setTimeDelay(1);
    }

    public void clickPageManagementLinkToGoDetail(WebDriver driver, String pageName) {
        waitForElementClickable(driver, Business_PageManagementUI.PAGE_MANAGEMENT_LINK,pageName);
        clickToElement(driver, Business_PageManagementUI.PAGE_MANAGEMENT_LINK,pageName);
        setTimeDelay(1);
    }

    public boolean checkPageDisplaySuccess(WebDriver driver) {
        waitElementToVisible(driver, Business_PageManagementUI.HEADER_TITLE_PAGE);
        return checkElementIsDisplayed(driver, Business_PageManagementUI.BUTTON_CREATE_PAGE) && getTextElement(driver, Business_PageManagementUI.HEADER_TITLE_PAGE).equalsIgnoreCase("Danh sách trang");
    }

    public boolean checkPopupCreatePageDisplay() {
        return checkElementIsDisplayed(driver, Business_PageManagementUI.POPUP_CREATE_NEW_PAGE);
    }

    public boolean checkCreatedPageSuccess(WebDriver driver, String pageName) {
        waitElementToVisible(driver, Business_PageManagementUI.BUTTON_CREATE_NEW_PAGE);
        waitElementToVisible(driver, Business_PageManagementUI.BUTTON_ASSIGNED_PAGE);
        return getTextElement(driver, Business_PageManagementUI.PAGE_NAME_ON_DETAIL).contains(pageName)
                && getTextElement(driver, Business_PageManagementUI.PAGE_NAME_ON_LIST).contains(pageName);
    }

    public String getOwnerOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, Business_PageManagementUI.OWNER_PAGE,pageName));
        return getTextElement(driver, Business_PageManagementUI.OWNER_PAGE, pageName);
    }

    public String getPageIdOfDirectPage(WebDriver driver, String pageName) {
        System.out.println("Ownern of page: " + getTextElement(driver, Business_PageManagementUI.ID_PAGE,pageName));
        return getTextElement(driver, Business_PageManagementUI.ID_PAGE,pageName);
    }

    public void clickToCreatePageToDisplayPopupCreatePage() {
        waitForElementClickable(driver, Business_PageManagementUI.BUTTON_CREATE_NEW_PAGE);
        clickToElement(driver, Business_PageManagementUI.BUTTON_CREATE_NEW_PAGE);
    }
}
