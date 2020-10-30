package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_CommonUI;
import Project.Newsfeed.PersonalWall.PersonalCommonPO;
import org.openqa.selenium.WebDriver;

public class PerAbout_CommonPO extends PersonalCommonPO {
    WebDriver driver;
    public PerAbout_CommonPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPersonalPageIsDisplay(String fullName) {
        waitElementToVisible(driver, Personal_CommonUI.PERSONAL_PAGE);
        return getPageTitle(driver).equalsIgnoreCase("Giới thiệu - Trang cá nhân | Hahalolo")
                && getTextElement(driver, Personal_CommonUI.FULLNAME_ON_COVER).equalsIgnoreCase(fullName);
    }

    public void clickToTabItemOnAbout(String aboutItem){
        waitElementToVisible(driver, Personal_CommonUI.ABOUT_MENU);
        waitForElementClickable(driver, Personal_CommonUI.ABOUT_ITEM_MENU,aboutItem);
        clickToElement(driver, Personal_CommonUI.ABOUT_ITEM_MENU,aboutItem);
    }

    public boolean checkTabIsSelected(String aboutItem){
        waitElementToVisible(driver, Personal_CommonUI.ABOUT_ITEM_MENU,aboutItem);
        System.out.println("Da vao dayperAboutWorkEducationTab");
        return getAttributeValue(driver, Personal_CommonUI.ABOUT_ITEM_MENU,"class",aboutItem).contains("active");
    }


    public Object getIntroduceInfoOnHeaderCover() {
        return true;
    }
}
