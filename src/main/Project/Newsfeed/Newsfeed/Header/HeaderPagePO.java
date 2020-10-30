package Project.Newsfeed.Newsfeed.Header;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_business.Business.Business_VerificationRequestUI;
import Interfaces.hahalolo_business.Tour.Tour_DashboardUI;
import Interfaces.hahalolo_newsfeed.Header.HeaderUI;
import org.openqa.selenium.WebDriver;

public class HeaderPagePO extends AbstractPage {
    WebDriver driver;
    public HeaderPagePO(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickToItemSettingOnHeaderSection(String nameItem){
        setTimeDelay(1);
        waitForElementClickable(driver, HeaderUI.SETTING_ICON);
        clickToElement(driver, HeaderUI.SETTING_ICON);
        waitForElementClickable(driver, HeaderUI.SETTING_ITEM, nameItem);
        clickToElement(driver, HeaderUI.SETTING_ITEM,nameItem);
    }

    public void clickToItemHelperOnHeaderSection(String nameItem){
        waitForElementClickable(driver, HeaderUI.HELPER_ICON);
        clickToElement(driver, HeaderUI.HELPER_ICON);
        setTimeDelay(1);
        waitForElementClickable(driver, HeaderUI.HELPER_ITEM, nameItem);
        clickToElement(driver, HeaderUI.HELPER_ITEM,nameItem);
    }

    public void clickToAvatarOnHeaderSection() {
        waitForElementClickable(driver, HeaderUI.USER_AVATAR);
        clickToElement(driver, HeaderUI.USER_AVATAR);
    }

    public void clickToHaloLogoOnHeaderSection(){
        waitForElementClickable(driver, HeaderUI.LOGO_HALO);
        clickToElement(driver, HeaderUI.LOGO_HALO);
    }

    public void clickToIconWalletOnHeaderSection(){
        waitForElementClickable(driver, HeaderUI.ICON_WALLET);
        clickToElement(driver, HeaderUI.ICON_WALLET);
    }

    public void clickToIconCartOnHeaderSection(){
        waitForElementClickable(driver, HeaderUI.CART_ICON);
        clickToElement(driver, HeaderUI.CART_ICON);
    }

    // Business Language
    public void clickToChangeLanguageOnBusinessHeaderSection(String languageName){
        waitForElementClickable(driver, HeaderUI.ICON_BUSINESS_LANGUAGE);
        clickToElement(driver, HeaderUI.ICON_BUSINESS_LANGUAGE);
        setTimeDelay(1);
        waitForElementClickable(driver, HeaderUI.BUSINESS_LANGUAGE_ITEM, languageName);
        clickToElement(driver, HeaderUI.BUSINESS_LANGUAGE_ITEM, languageName);
    }

    public String getImageOfLanguageDisplayOnHeaderSection(){
        waitElementsToVisible(driver, HeaderUI.ICON_BUSINESS_LANGUAGE);
        String srcImage =  getAttributeValue(driver, HeaderUI.ICON_BUSINESS_LANGUAGE_IMAGE,"data-src");
        String[] a = srcImage.split("/");
        return a[a.length-1];
    }

    public boolean checkLanguageIsSelectedOnHeaderSection(String languageName){
        return getAttributeValue(driver, HeaderUI.BUSINESS_LANGUAGE_ITEM, "class", languageName).endsWith("active");
    }

    // Currency
    public void clickToSymbolCurrencyOnHeaderSection() {
        waitForElementClickable(driver, HeaderUI.ICON_SYMBOL_CURRENCY);
        clickToElement(driver, HeaderUI.ICON_SYMBOL_CURRENCY);
    }

    public String getSymbolCurrencyDisplayOnHeaderSection(){
        waitElementToVisible(driver, HeaderUI.ICON_SYMBOL_CURRENCY);
        return getTextElement(driver, HeaderUI.ICON_SYMBOL_CURRENCY);
    }

    public void clickItemOnBusinessNavMenu(String businessItem) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Business_VerificationRequestUI.BUSINESS_NAVBAR_INFO);
        clickToElement(driver, HeaderUI.BUSINESS_NAVBAR_MENU , businessItem);
    }

    public void clickItemOnTourNavMenu(String itemMenu) {
        clickToElementByJS(driver, Tour_DashboardUI.ITEM_ON_TOUR_BUSINESS,itemMenu);
    }




}
