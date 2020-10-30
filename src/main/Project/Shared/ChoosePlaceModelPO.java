package Project.Shared;

import Common.HelperFunction.AbstractPage;
import Interfaces.Shared.Choose_Place_ModelUI;
import org.openqa.selenium.WebDriver;

public class ChoosePlaceModelPO extends AbstractPage {
    WebDriver driver;

    public ChoosePlaceModelPO(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkModelChooosePlaceIsDisplayed(){
        return checkElementIsDisplayed(driver, Choose_Place_ModelUI.MODEL_LOCATION);
    }

    public void chooseAddressItem() {
        waitForElementToPresence(driver, Choose_Place_ModelUI.LIST_LOCATION);
        waitForElementClickable(driver, Choose_Place_ModelUI.ITEM_LOCATION);
        clickToElement(driver, Choose_Place_ModelUI.ITEM_LOCATION);
    }

    public void clickToSaveAddress() {
        setTimeDelay(2);
        waitForElementClickable(driver, Choose_Place_ModelUI.ADD_LOCATION_BUTTON);
        clickToElement(driver, Choose_Place_ModelUI.ADD_LOCATION_BUTTON);
    }

    public String getPlaceNameOfSelectedITemOnList(){
        return getTextElement(driver, Choose_Place_ModelUI.ITEM_LOCATION_PLACE);
    }
}
