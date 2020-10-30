package Project.Business.Business;


import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import Interfaces.hahalolo_business.Business.Business_ListPageUI;
import org.openqa.selenium.WebDriver;

public class BusinessListPagePO extends HeaderPagePO
{
    WebDriver driver;
    public BusinessListPagePO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public void clickToPageOnList(String tourPageName)
    {
        waitElementToVisible(driver, Business_ListPageUI.LISTPAGE_PAGE_NAME, tourPageName);
        scrollIntoElementByJS(driver, Business_ListPageUI.LISTPAGE_PAGE_NAME, tourPageName);
        clickToElement(driver, Business_ListPageUI.LISTPAGE_PAGE_NAME, tourPageName);
    }

    public void clickToTextLinkManagerPage()
    {
        waitElementsToVisible(driver, Business_ListPageUI.TEXTLINK_MANAGERMENT_PAGE);
        clickToElement(driver, Business_ListPageUI.TEXTLINK_MANAGERMENT_PAGE);
    }
}
