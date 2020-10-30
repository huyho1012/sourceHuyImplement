package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.Account_GeneralSettingUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class AccountCommonPO extends HeaderPagePO {

    WebDriver driver;

    /* Hàm tạo contrustor */
    public AccountCommonPO(WebDriver webDriver) {
        super(webDriver);
    }

    /* Hàm nhấn vào item của menu Account setting */
    public void clickToItemOnAccountSettingMenu(String itemMenu) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MENU.NAVIGATION_MENU);
        waitForElementClickable(driver, Account_GeneralSettingUI.MENU.NAVIGATION_ITEM_MENU, itemMenu);
        clickToElement(driver, Account_GeneralSettingUI.MENU.NAVIGATION_ITEM_MENU, itemMenu);
    }
}
