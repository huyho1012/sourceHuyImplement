package Project.Newsfeed.Newsfeed.Header;

import Interfaces.hahalolo_newsfeed.Header.HeaderUI;
import Interfaces.hahalolo_newsfeed.Header.Model_CurrencyUI;
import org.openqa.selenium.WebDriver;

public class ChangeCurrencyPO extends HeaderPagePO {

    WebDriver driver;
    public ChangeCurrencyPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkModelChangeCurrencyIsDisplay(){
        return checkElementIsDisplayed(driver, Model_CurrencyUI.MODEL_CURRENCY);
    }

    public String getTextOfModelChangeCurrency(){
        waitElementToVisible(driver, Model_CurrencyUI.MODEL_CURRENCY);
        return getTextElement(driver, Model_CurrencyUI.TITLE_MODEL);
    }

    public String getCurrencyDisplayOnHeaderMenu(){
        waitElementToVisible(driver, HeaderUI.HOMEPAGE_LINK);
        return getTextElement(driver, HeaderUI.ICON_SYMBOL_CURRENCY);
    }

    public void clickCloseModelChangeCurrency(){
        waitForElementClickable(driver, Model_CurrencyUI.BUTTON_CLOSE_MODEL);
        clickToElement(driver, Model_CurrencyUI.BUTTON_CLOSE_MODEL);
    }


    public void clickOverChangeCurrencyModel() {
    }

    public void clickToButtonCloseOnModel() {
    }

    public void clickToChangeCurrencyOnModelChange(String currencyCode) {
        waitElementToVisible(driver, Model_CurrencyUI.MODEL_CURRENCY);
        waitForElementClickable(driver, Model_CurrencyUI.CURRENCY_ITEM, currencyCode);
        clickToElement(driver, Model_CurrencyUI.CURRENCY_ITEM,currencyCode);
    }
}
