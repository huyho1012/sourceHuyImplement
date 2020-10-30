package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_InfoUI;
import Project.Business.Tour.Management.TourCommonPO;
import Project.Shared.MediaManagementPO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TourInfoTabPO extends TourCommonPO {
    WebDriver driver;
    MediaManagementPO media;
    public TourInfoTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void chooseLanguage(String languageName)
    {
        waitElementToVisible(driver, Tour_InfoUI.TAB_INFORMATION);
        selectItemInCustomDropdownByScroll(driver, Tour_InfoUI.DROPDOWN_LANGUAGE, Tour_InfoUI.ITEM_LANGUAGE, languageName);
        setTimeDelay(1);
    }

    public void choooseCurrency(String currencyCode)
    {
        waitElementToVisible(driver, Tour_InfoUI.TAB_INFORMATION);
        selectItemInCustomDropdownByScroll(driver, Tour_InfoUI.DROPDOWN_CURRENCY, Tour_InfoUI.ITEM_CURRENCY, currencyCode);
        setTimeDelay(1);
    }

    public void enterValueToDynamicField(String nameField, String valueData)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        clickToElement(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        sendKeyToElement(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, valueData, nameField);
    }

    public void enterValueToDynamicDropdown(String nameField, String valueData)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_DROPDOWN, nameField);
        sendKeyToElement(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_INPUT, valueData, nameField);
    }

    public void chooseItemInDynamicDropdown(String nameField, String valueData)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_DROPDOWN, nameField);
        System.out.println("Đã wait xong -> Có phần tử xuất hiện");
        clickToElement(driver, Tour_InfoUI.DYNAMIC_DROPDOWN, nameField);
//        selectItemInCustomDropdownByJS(driver, castToObject(Tour_InfoUI.DYNAMIC_DROPDOWN, nameField), castToObject(Tour_InfoUI.ITEM_IN_DYNAMIC_DROPDOWN, nameField), valueData);
    }

    public void doubleClickOnField(String nameField)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        doubleClickToElement(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, nameField);
        sendKeyBoardToElement(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, Keys.ARROW_RIGHT, nameField);
        setTimeDelay(1);
    }

    public String removeSpecialCharOnField(String valueData)
    {
        return valueData.replaceAll("[^a-zA-Z0-9]", "");
    }

    public void enterOnField(String nameField)
    {
        sendKeyBoardToElement(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, Keys.ENTER, nameField);
    }

    public void enterOnDropdown(String nameField)
    {
        sendKeyBoardToElement(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_INPUT, Keys.ENTER, nameField);
    }

    public void enterOnTextArea(String nameField)
    {
        sendKeyBoardToElement(driver, Tour_InfoUI.DYNAMIC_TEXTAREA, Keys.ENTER, nameField);
    }

    public void chooseTypeOfTourInternational()
    {
        waitElementToVisible(driver, Tour_InfoUI.LABEL_INTERNATIONAL_TOUR);
        clickToElement(driver, Tour_InfoUI.LABEL_INTERNATIONAL_TOUR);
    }

    public void chooseTypeOfCanMergeTour()
    {
        waitElementToVisible(driver, Tour_InfoUI.LABEL_MERGE_TOUR);
        clickToElement(driver, Tour_InfoUI.LABEL_MERGE_TOUR);
    }

    public boolean checkTourInternationalIsChecked()
    {
        return checkElementIsCheckedByJS(driver, Tour_InfoUI.CHECKBOX_INTERNATIONAL_TOUR);
    }

    public boolean checkCanMergeTourIsChecked()
    {
        return checkElementIsCheckedByJS(driver, Tour_InfoUI.CHECKBOX_MERGE_TOUR);
    }

    public void clickToButtonGPS()
    {
        waitElementToVisible(driver, Tour_InfoUI.BUTTON_GPS);
        clickToElement(driver, Tour_InfoUI.BUTTON_GPS);
        setTimeDelay(2);
    }

    public void chooseLocationOnModal(int indexOfLocation)
    {
        waitElementToVisible(driver, Tour_InfoUI.MODAL_PLACE);
        waitElementToVisible(driver, Tour_InfoUI.MODAL_PLACE_TITLE_ADDRESS, String.valueOf(indexOfLocation));
        clickToElement(driver, Tour_InfoUI.MODAL_PLACE_TITLE_ADDRESS, String.valueOf(indexOfLocation));
    }

    public String getSubTextOfLocation(int indexOfLocation)
    {
        waitElementToVisible(driver, Tour_InfoUI.MODAL_PLACE_SUB_ADDRESS, String.valueOf(indexOfLocation));
        return getTextElement(driver, Tour_InfoUI.MODAL_PLACE_SUB_ADDRESS, String.valueOf(indexOfLocation));
    }

    public void clickToButtonAddLocation()
    {
        waitElementToVisible(driver,  Tour_InfoUI.MODAL_PLACE_BUTTON_ADD_ADDRESS);
        clickToElement(driver, Tour_InfoUI.MODAL_PLACE_BUTTON_ADD_ADDRESS);
    }

    public boolean checkModalLocationUnDisplay()
    {
        waitForElementInvisible(driver, Tour_InfoUI.MODAL_PLACE);
        return checkElementUndisplayed(driver, Tour_InfoUI.MODAL_PLACE);
    }

    public void clickToButtonAddImage(String fieldName)
    {
        waitForElementClickable(driver, Tour_InfoUI.BUTTON_UPLOAD, fieldName);
        clickToElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD, fieldName);
    }

    public void clickToButtonAddLogo()
    {
        scrollToTopPage(driver);
        waitElementToVisible(driver, Tour_InfoUI.BUTTON_UPLOAD_LOGO);
        scrollIntoElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_LOGO);
        clickToElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_LOGO);
    }

    public void clickToButtonAddCover()
    {
        scrollToTopPage(driver);
        waitElementToVisible(driver, Tour_InfoUI.BUTTON_UPLOAD_COVER_IMAGE);
        scrollIntoElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_COVER_IMAGE);
        clickToElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_COVER_IMAGE);
    }

    public void clickToButtonAddAlbum()
    {
        scrollToTopPage(driver);
        waitElementToVisible(driver, Tour_InfoUI.BUTTON_UPLOAD_GALLERY);
        scrollIntoElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_GALLERY);
        clickToElementByJS(driver, Tour_InfoUI.BUTTON_UPLOAD_GALLERY);
    }

    public void selectImageOnGallery(int countImage)
    {
        media = new MediaManagementPO(driver);
        media.selectImageOnMediaManager(countImage);
        media.clickToSelectButton();
    }

    public void uploadImage(String image)
    {
        media = new MediaManagementPO(driver);
        media.uploadImageFromLocalToMedia(driver, image);
        media.clickToSelectButton();
    }

    public void uploadImageNoSuport(String image)
    {
        media = new MediaManagementPO(driver);
        media.uploadImageFromLocalToMedia(driver, image);
    }

    public void closeMediaManager()
    {
        media = new MediaManagementPO(driver);
        media.clickToButtonClose();
    }

    public void enterValueToShortDes(String valueData)
    {
        waitElementToVisible(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        scrollIntoElementByJS(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, "address");
        sendKeyToElement(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION, valueData);
    }

    public void enterValueToDynamicTextArea(String nameField, String valueData)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_TEXTAREA, nameField);
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        sendKeyToElement(driver, Tour_InfoUI.DYNAMIC_TEXTAREA, valueData, nameField);
    }

    public void clickToButtonSaveTourOnHeader() {
        waitForElementClickable(driver, Tour_InfoUI.BUTTON_SAVE_TOUR_ON_HEADER);
        clickToElementByJS(driver, Tour_InfoUI.BUTTON_SAVE_TOUR_ON_HEADER);
    }

    public void clickToButtonSaveTourOnBottom()
    {
        waitForElementClickable(driver, Tour_InfoUI.BUTTON_SAVE_TOUR_ON_BOTTOM);
        scrollIntoElementByJS(driver, Tour_InfoUI.BUTTON_SAVE_TOUR_ON_BOTTOM);
        clickToElement(driver, Tour_InfoUI.BUTTON_SAVE_TOUR_ON_BOTTOM);
    }

    public void removeImage(String nameField)
    {
        waitElementToVisible(driver, Tour_InfoUI.BUTTON_REMOVE_IMAGE, nameField);
        clickToElement(driver, Tour_InfoUI.BUTTON_REMOVE_IMAGE, nameField);
    }

    public void closeToastMessage()
    {
        waitElementToVisible(driver, Tour_InfoUI.TOAST_MESSAGE);
        clickToElement(driver, Tour_InfoUI.BUTTON_CLOSE_MESSAGE_TOAST);
    }

    public String getHeaderTitle()
    {
        waitElementsToVisible(driver, Tour_InfoUI.TEXT_HEADER_TITLE);
        return getTextElement(driver, Tour_InfoUI.TEXT_HEADER_TITLE);
    }

    public String getAlertOnField(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_FIELD_ALERT, fieldName);
        return getTextElement(driver, Tour_InfoUI.DYNAMIC_FIELD_ALERT, fieldName);
    }

    public String getAlertOnDropdown(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_ALERT, fieldName);
        return getTextElement(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_ALERT, fieldName);
    }

    public String getAlertOnShortDes()
    {
        waitElementToVisible(driver, Tour_InfoUI.ALERT_SHORT_DESCRIPTION);
        return getTextElement(driver, Tour_InfoUI.ALERT_SHORT_DESCRIPTION);
    }

    public String getValueAvailOfShortDes(String dataValue)
    {
        return dataValue.substring(0, 400);
    }

    public String getValueSelectedOnDynamicDropdown(String nameField)
    {
        return getTextElement(driver, Tour_InfoUI.SELECTED_ITEM_IN_DYNAMIC_DROPDOWN, nameField);
    }

    public String getValueOnFiled(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO,fieldName);
        return getAttributeValue(driver, Tour_InfoUI.DYNAMIC_FIELD_TAB_INFO, "value", fieldName);
    }

    public String getValueOnDropdown(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_INPUT, fieldName);
        return getAttributeValue(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_INPUT, "value", fieldName);
    }

    public String getTextAfterTrim(String text)
    {
        return text.trim();
    }

    public boolean checkTourInfoTabDisplay()
    {
        return checkElementIsDisplayed(driver, Tour_InfoUI.TAB_INFORMATION);
    }

    public String getValueOfShortDes()
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        return getAttributeValue(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION, "value");
    }

    public String getValueOfDynamicTextArea(String nameField)
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        return getTextElement(driver, Tour_InfoUI.DYNAMIC_TEXTAREA, nameField);
    }

    public String getAlertOnDynamicTextArea(String nameField)
    {
        waitElementToVisible(driver, Tour_InfoUI.ALERT_DYNAMIC_TEXT_AREA, nameField);
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        return getTextElement(driver, Tour_InfoUI.ALERT_DYNAMIC_TEXT_AREA, nameField);
    }

    public String getAlertOnImage(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.ALERT_IMAGE, fieldName);
        return getTextElement(driver, Tour_InfoUI.ALERT_IMAGE, fieldName);
    }


    public String getURLImageLogo()
    {
        return getAttributeValue(driver, Tour_InfoUI.IMAGE_LOGO, "style");
    }

    public String getURLImageCover()
    {
        return getAttributeValue(driver, Tour_InfoUI.IMAGE_COVER, "src");
    }

    public String getPareImage(String image)
    {
        String pareImage = image;

        String[] array = pareImage.split("a");

        return "a" + array[array.length - 1];
    }

    public String getExtensionOfImageLogo()
    {
        String imagePath = getURLImageLogo();

        String[] array = imagePath.split("x");
        String x = array[array.length - 1];
        x = x.replaceAll("[^\\w\\.\\-]", "");

        String[] array2 = x.split("h");
        return "a" + array2[array2.length - 1];
    }

    public String getExtensionOfImageCover()
    {
        String imagePath = getURLImageCover();

        String[] array = imagePath.split("x");
        String x = array[array.length - 1];
        x = x.replaceAll("[^\\w\\.\\-]", "");

        String[] array2 = x.split("h");
        return "a" + array2[array2.length - 1];
    }

    public String getTextOfToast()
    {
        return getTextElement(driver, Tour_InfoUI.TOAST_MESSAGE);
    }

    public boolean checkAlertOnFiledIsDisplay(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.DYNAMIC_FIELD_ALERT, fieldName);
        return checkElementIsDisplayed(driver, Tour_InfoUI.DYNAMIC_FIELD_ALERT, fieldName);
    }

    public boolean checkAlertOnFiledUnDisplay(String fieldName)
    {
        return checkElementUndisplayed(driver, Tour_InfoUI.DYNAMIC_FIELD_ALERT, fieldName);
    }

    public boolean checkAlertOnDropdownIsDisplay(String fieldName)
    {
        return checkElementUndisplayed(driver, Tour_InfoUI.DYNAMIC_DROPDOWN_ALERT, fieldName);
    }

    public boolean checkAlertOnShortDesIsDisplay()
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        waitElementToVisible(driver, Tour_InfoUI.ALERT_SHORT_DESCRIPTION);
        return checkElementIsDisplayed(driver, Tour_InfoUI.ALERT_SHORT_DESCRIPTION);
    }

    public boolean checkAlertOnDynamicTextAreaIsDisplay(String nameField)
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        waitElementToVisible(driver, Tour_InfoUI.ALERT_DYNAMIC_TEXT_AREA, nameField);
        return checkElementIsDisplayed(driver, Tour_InfoUI.ALERT_DYNAMIC_TEXT_AREA, nameField);
    }

    public boolean checkAlertOnDynamicTextAreaUnDisplay(String nameField)
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.DYNAMIC_TEXTAREA, nameField);
        return checkElementUndisplayed(driver, Tour_InfoUI.ALERT_DYNAMIC_TEXT_AREA, nameField);
    }

    public boolean checkAlertOnShortDesUnDisplay()
    {
        scrollIntoElementByJS(driver, Tour_InfoUI.TEXTAREA_SHORT_DESCRIPTION);
        return checkElementUndisplayed(driver, Tour_InfoUI.ALERT_SHORT_DESCRIPTION);
    }

    public boolean checkAlertOnImageIsDisplay(String fieldName)
    {
        waitElementToVisible(driver, Tour_InfoUI.ALERT_IMAGE, fieldName);
        return checkElementIsDisplayed(driver, Tour_InfoUI.ALERT_IMAGE, fieldName);
    }

    public boolean checkAlertOnImageUnDisplay(String fieldName)
    {
        return checkElementUndisplayed(driver, Tour_InfoUI.ALERT_IMAGE, fieldName);
    }

    public boolean checkLogoIsDisplay()
    {
        setTimeDelay(1);
        return checkElementIsDisplayed(driver, Tour_InfoUI.IMAGE_LOGO);
    }

    public boolean checkCoverIsDisplay()
    {
        setTimeDelay(1);
        return checkElementIsDisplayed(driver, Tour_InfoUI.IMAGE_COVER);
    }

    public boolean checkImageOnGalleryIsDisplay(int countImage)
    {
        return countNumberItemOfElement(driver, Tour_InfoUI.IMAGE_ON_GALLERY) == countImage;
    }

    public boolean checkAlertIsDisplayByScript()
    {
        return checkAlertIsDisplay(driver);
    }

    public boolean checkToastIsDisplay()
    {
        waitElementToVisible(driver, Tour_InfoUI.TOAST_MESSAGE);
        return checkElementIsDisplayed(driver, Tour_InfoUI.TOAST_MESSAGE);
    }

}
