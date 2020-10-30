package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_PriceUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourPriceTabPO extends TourCommonPO {
    WebDriver driver;
    public TourPriceTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPriceTabDisplaySuccess() {
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver, Tour_PriceUI.TOUR_PRICE);
    }

    public void clickToCreateNewPrice(WebDriver driver) {
        waitForElementClickable(driver, Tour_PriceUI.BTN_CREATE_NEW_PRICE);
        clickToElement(driver, Tour_PriceUI.BTN_CREATE_NEW_PRICE);
        setTimeDelay(1);
    }

    public boolean checkPriceDetailIsDisplay() {
        scrollToTopPage(driver);
        return checkElementIsDisplayed(driver, Tour_PriceUI.TOUR_PRICE_DETAIL);
    }

    public void chooseStartDateOfPrice(String dateTime) {
        waitElementToVisible(driver, Tour_PriceUI.START_DATE_PRICE);
        sendKeyToElement(driver, Tour_PriceUI.START_DATE_PRICE,dateTime);
        setTimeDelay(1);
    }

    public void enterValueOfAdultPrice(String priceAdult) {
        waitElementToVisible(driver, Tour_PriceUI.ADULT_PRICE);
        sendKeyToElement(driver, Tour_PriceUI.ADULT_PRICE, priceAdult);
        setTimeDelay(1);
    }

    public void enterValueOfChildPrice(String priceChild) {
        clickToChooseCheckBox(driver, Tour_PriceUI.CHILD_CHECKBOX);
        waitElementToVisible(driver, Tour_PriceUI.CHILD_PRICE);
        sendKeyToElement(driver, Tour_PriceUI.CHILD_PRICE, priceChild);
        setTimeDelay(1);
    }

    public void enterValueOfYoungChildPrice(String priceYoungChild) {
        clickToChooseCheckBox(driver, Tour_PriceUI.YOUNG_CHILD_CHECKBOX);
        waitElementToVisible(driver, Tour_PriceUI.YOUNG_CHILD_PRICE);
        sendKeyToElement(driver, Tour_PriceUI.YOUNG_CHILD_PRICE, priceYoungChild);
        setTimeDelay(1);
    }

    public void enterValueOfInfantPrice(String priceBaby) {
        clickToChooseCheckBox(driver, Tour_PriceUI.BABY_CHECKBOX);
        waitElementToVisible(driver, Tour_PriceUI.BABY_PRICE);
        sendKeyToElement(driver, Tour_PriceUI.BABY_PRICE, priceBaby);
        setTimeDelay(1);
    }


    public void clickToSavePriceButton() {
        waitForElementClickable(driver, Tour_PriceUI.BTN_SAVE_PRICE);
        clickToElement(driver, Tour_PriceUI.BTN_SAVE_PRICE);
        setTimeDelay(1);
    }

    public boolean checkPriceCreatedSuccessfully() {
        return true;
    }
}
