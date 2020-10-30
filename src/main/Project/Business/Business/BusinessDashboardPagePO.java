package Project.Business.Business;

import Interfaces.hahalolo_business.Business.Business_DashboardUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPagePO extends HeaderPagePO {

    WebDriver driver;
    public BusinessDashboardPagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }


    public void clickToNavItemPage()
    {
        waitElementsToVisible(driver, Business_DashboardUI.HEADER_MENU_PAGE);
        clickToElement(driver, Business_DashboardUI.HEADER_MENU_PAGE);
    }

    public String getStatusVerifyOfBusiness() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Business_DashboardUI.DASBOARD_PAGE);
        return getTextElement(driver, Business_DashboardUI.TITLE_CONTENT_VERIFY_BUSINESS);
    }

    public void clickToVerifyBusiness(WebDriver driver) {
        waitForElementClickable(driver, Business_DashboardUI.BUTTON_SEND_VERIFY);
        clickToElement(driver, Business_DashboardUI.BUTTON_SEND_VERIFY);
    }

    public boolean checkPageIsDisplaySuccessfully() {
       waitElementToVisible(driver, Business_DashboardUI.DASBOARD_PAGE);
        return getTextElement(driver, Business_DashboardUI.DASBOARD_TITLE).equalsIgnoreCase("Quản lý tài khoản kinh doanh")
                && checkElementIsDisplayed(driver, Business_DashboardUI.FORM_BUSI_INFO) && checkElementIsDisplayed(driver, Business_DashboardUI.FORM_BUSI_PAGE)
                && checkElementIsDisplayed(driver, Business_DashboardUI.FORM_BUSI_STAFF);
    }

    public void clickCreatePageNowButton() {
        waitElementToVisible(driver, Business_DashboardUI.DASBOARD_PAGE);
        waitForElementClickable(driver, Business_DashboardUI.BUTTON_CREATE_PAGE_NOW);
        clickToElement(driver, Business_DashboardUI.BUTTON_CREATE_PAGE_NOW);
        setTimeDelay(1);
    }

    public String getContentTitleOfSectionNoPage() {
        waitElementToVisible(driver, Business_DashboardUI.DASBOARD_PAGE);
        return getTextElement(driver, Business_DashboardUI.PAGE_SECTION_TITLE);
    }

    public boolean checkTitleCreateBusinessSuccess() {
        return getTextElement(driver, Business_DashboardUI.TITLE_CREATE_NEW_BUSINESS_SUCCESS).equalsIgnoreCase("Chúc mừng bạn đã tạo tài khoản doanh nghiệp!");
    }
}
