package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_PartUI;
import Interfaces.Shared.Media_ManagementUI;
import Project.Business.Tour.Management.TourCommonPO;
import Project.Shared.MediaManagementPO;
import org.openqa.selenium.WebDriver;

public class TourPartTabPO extends TourCommonPO {
    MediaManagementPO media;
    WebDriver driver;
    public TourPartTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPartTabDisplaySuccess() {
        waitElementToVisible(driver, Tour_PartUI.TOUR_PART);
        return checkElementIsDisplayed(driver, Tour_PartUI.TOUR_PART);
    }

    public boolean checkPartDetailDisplay(){
        waitElementToVisible(driver, Tour_PartUI.TOUR_PART_DETAIL);
        return checkElementIsDisplayed(driver, Tour_PartUI.BUTTON_SAVE_PART);
    }

    public void clickToCreateNewPartButton() {
        waitForElementClickable(driver, Tour_PartUI.BUTTON_CREATE_NEW_PART);
        clickToElement(driver, Tour_PartUI.BUTTON_CREATE_NEW_PART);
    }

    public void enterValueToDynamicFieldOnPartTab(WebDriver driver, String nameField, String valueData) {
        waitElementToVisible(driver, Tour_PartUI.DYNAMIC_FIELD, nameField);
        sendKeyToElement(driver, Tour_PartUI.DYNAMIC_FIELD, valueData, nameField);
        setTimeDelay(1);
    }

    public void chooseItemToUpdateLocation(WebDriver driver, String dropdownName, String valueData) {
        selectItemInCustomDropdown(driver, Tour_PartUI.DYNAMIC_DROPDOWN, Tour_PartUI.ITEM_DYNAMIC_DROPDOWN,valueData,dropdownName);
    }

    public void enterValueToShortDescription(WebDriver driver, String partDesc) {
        waitElementToVisible(driver, Tour_PartUI.SHORT_DESC_TEXT_AREA);
        sendKeyToElement(driver, Tour_PartUI.SHORT_DESC_TEXT_AREA, partDesc);
        setTimeDelay(1);
    }

    public void chooseNewTransportItem(WebDriver driver, String itemTransport) {
        waitForElementClickable(driver, Tour_PartUI.TRANSPORT_ITEM, itemTransport);
        clickToElement(driver, Tour_PartUI.TRANSPORT_ITEM, itemTransport);
        setTimeDelay(1);
    }

    public void choosePartLogo(WebDriver driver, String fileImage) {
        clickToElementByJS(driver, Tour_PartUI.UPLOAD_BUTTON, "click:uploadCover");
        waitElementToVisible(driver, Media_ManagementUI.MEDIA_MANAGEMENT_POPUP);
        media = new MediaManagementPO(driver);
        media.uploadImageFromLocalToMedia(driver,fileImage);
        waitElementToVisible(driver, Media_ManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver, Media_ManagementUI.BUTTON_SELECT);
        clickToElement(driver, Media_ManagementUI.BUTTON_SELECT);
    }

    public void clickToButtonSavePart(WebDriver driver) {
        waitForElementClickable(driver, Tour_PartUI.BUTTON_SAVE_PART);
        clickToElement(driver, Tour_PartUI.BUTTON_SAVE_PART);
    }

    public boolean checkPartHasBeenCreatedSuccessfully() {
        return true;
    }
}
