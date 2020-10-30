package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_DetailsAboutYouUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class PerAbout_DetailsAboutYouPO extends PerAbout_CommonPO {
    WebDriver driver;

    public PerAbout_DetailsAboutYouPO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkDetailAboutYouIsDisplay() {
        return true;
    }

    // Section Introduce
    public void clickToButtonAddNewIntroduce() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_WRITE_ABOUT_YOURSEFT);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_WRITE_ABOUT_YOURSEFT);
    }

    public void clickToButtonEditIntroduce() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_ABOUT);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_ABOUT);
    }

    public boolean checkFormAddEditIntroduceIsDisplayed() {
        setTimeDelay(2);
        return !getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.FORM_ADD_EDIT_ABOUT, "style").equals("display: none;");
    }

    public void enterDataToIntroduceField(String introduceData) {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_ABOUT);
        sendKeyToElement(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_ABOUT, introduceData);
    }

    public void clickToSaveIntroduceInfo() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_ABOUT);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_ABOUT);
    }

    public void clickToCancelSaveIntroduceInfo() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_ABOUT);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_ABOUT);
    }

    public String getIntroduceDataDisplay() {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.ABOUT_DATA);
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.ABOUT_DATA);
    }

    public String getMessageErrorOfIntroduceField() {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.MESSAGE_VALIDATE_OF_ABOUT);
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.MESSAGE_VALIDATE_OF_ABOUT);
    }

    public boolean verifyTextOfIntroduceSection(String languageSystem, String fullName) {
        String title = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.TITLE_DETAIL_ABOUT_SECTION);
        String context = null;
        if (languageSystem == "vi") {
            context = "Chi tiết về" + " " + fullName;
        } else if (languageSystem == "eng") {
            context = "Details about" + " " + fullName;
        }
        return title.equalsIgnoreCase(context);
    }

    public boolean verifyTextOfButtonAdđNewIntroduction(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_WRITE_ABOUT_YOURSEFT);
        String context = null;
        if (languageSystem == "vi") {
            context = "Thêm giới thiệu về bản thân";
        } else if (languageSystem == "eng") {
            context = "Write something about yourself";
        }
        return contentButton.equalsIgnoreCase(context);
    }

    public boolean verifyTextOfButtonSaveIntroduction(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_ABOUT);
        String context = null;
        if (languageSystem == "vi") {
            context = "Lưu";
        } else if (languageSystem == "eng") {
            context = "Save";
        }

        String colorButton = getCSSValueOfElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_ABOUT, "background-color");
        colorButton = Color.fromString(colorButton).asHex();

        return contentButton.equalsIgnoreCase(context) && colorButton.equals("#166986");
    }

    public boolean verifyTextOfButtonCancelSaveIntroduction(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_ABOUT);
        String context = null;
        if (languageSystem == "vi") {
            context = "Hủy bỏ";
        } else if (languageSystem == "eng") {
            context = "Cancel";
        }

        String colorButton = getCSSValueOfElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_ABOUT, "background-color");
        colorButton = Color.fromString(colorButton).asHex();

        return contentButton.equalsIgnoreCase(context) && colorButton.equalsIgnoreCase("#f8f9fa");
    }

    public boolean verifyContentOfLabelFieldIntroduce(String languageSystem) {
        String contentLabel = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.LABEL_TEXTAREA_ABOUT);
        String context = null;
        if (languageSystem == "vi") {
            context = "Giới thiệu";
        } else if (languageSystem == "eng") {
            context = "About";
        }
        return contentLabel.equalsIgnoreCase(context);
    }

    public String getValueInputDisplayOnIntroduceField() {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_ABOUT);
        return getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_ABOUT, "value");
    }

    public boolean checkButtonAddNewIntroduceIsDisplayed() {
        setTimeDelay(1);
        return findElements(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_WRITE_ABOUT_YOURSEFT).size() > 0;
    }

    public boolean checkButtonEditIntroduceIsDisplayed() {
        setTimeDelay(1);
        return findElements(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_ABOUT).size() > 0;
    }

    // Section Othername
    public void clickToButtonAddNewOtherName() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_OTHER_NAME);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_OTHER_NAME);
    }

    public void clickToButtonEditOtherName() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_OTHER_NAME);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_OTHER_NAME);
    }

    public boolean checkFormAddEditOtherNameIsDisplayed() {
        setTimeDelay(2);
        return !getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.FORM_ADD_EDIT_OTHER_NAME, "style").equals("display: none;");
    }

    public void enterDataToFieldOtherName(String otherName) {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME);
        sendKeyToElement(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME, otherName);
    }

    public void clickToButtonSaveOnFormOtherName() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_OTHER_NAME);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_OTHER_NAME);
    }

    public void clickToButtonCancelOnFormOtherName() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_OTHER_NAME);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_OTHER_NAME);
    }

    public String getOtherNameDisplayOnDetailsAbout() {
        waitElementsToVisible(driver, PersonalAbout_DetailsAboutYouUI.OTHER_NAME_DATA);
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.OTHER_NAME_DATA);
    }

    public String getMessageValidateOfFieldOtherName() {
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.MESSAGE_VALIDATE_OTHER_NAME);
    }

    public String getValueInputDisplayOnFieldOtherName() {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME);
        return getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME, "value");
    }

    public boolean verifyTextTitleOfOtherNameSection(String languageSystem) {
        String title = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.TITLE_OTHER_NAME_SECTION);
        String context = null;
        if (languageSystem == "vi") {
            context = "Tên gọi khác";
        } else if (languageSystem == "eng") {
            context = "Other name";
        }
        System.out.println(context);
        return title.equalsIgnoreCase(context);
    }

    public boolean verifyTextOfButtonAddOtherName(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_OTHER_NAME);
        String context = null;
        if (languageSystem == "vi") {
            context = "Thêm biệt danh, tên khai sinh ....";
        } else if (languageSystem == "eng") {
            context = "Add a nickname, a birth name...";
        }
        return contentButton.equalsIgnoreCase(context);
    }

    public boolean verifyUIButtonSaveOnOtherName(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_OTHER_NAME);
        String context = null;
        // Lấy nội dụng theo ngôn ngũ
        if (languageSystem == "vi") {
            context = "Lưu";
        } else if (languageSystem == "eng") {
            context = "Save";
        }
        // Hàm lấy màu
        String colorButton = getCSSValueOfElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_OTHER_NAME, "background-color");
        colorButton = Color.fromString(colorButton).asHex();
        // Check điều kiện UI
        return contentButton.equalsIgnoreCase(context) && colorButton.equals("#166986");
    }

    public boolean verifyUIButtonCancelOnOtherName(String languageSystem) {
        String contentButton = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_OTHER_NAME);
        String context = null;
        // Lấy nội dụng theo ngôn ngũ
        if (languageSystem == "vi") {
            context = "Hủy bỏ";
        } else if (languageSystem == "eng") {
            context = "Cancel";
        }
        // Hàm lấy màu
        String colorButton = getCSSValueOfElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_OTHER_NAME, "background-color");
        colorButton = Color.fromString(colorButton).asHex();
        // Check điều kiện UI
        return contentButton.equalsIgnoreCase(context) && colorButton.equalsIgnoreCase("#f8f9fa");
    }

    public boolean verifyContentLabelOfFieldOtherName(String languageSystem) {
        String contentLabel = getTextElement(driver, PersonalAbout_DetailsAboutYouUI.LABEL_FIELD_OTHER_NAME);
        String context = null;
        // Lấy nội dụng theo ngôn ngũ
        if (languageSystem == "vi") {
            context = "Tên";
        } else if (languageSystem == "eng") {
            context = "Name";
        }
        // Check điều kiện
        return contentLabel.equalsIgnoreCase(context);
    }

    public boolean verifyPlaceHolderOfFieldOtherName(String languageSystem) {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME);
        String placeholder = getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.FIELD_OTHER_NAME, "placeholder");
        String context = null;
        // Lấy nội dụng theo ngôn ngũ
        if (languageSystem == "vi") {
            context = "Thêm biệt danh, tên khai sinh";
        } else if (languageSystem == "eng") {
            context = "What is your nickname?";
        }
        // Check điều kiện
        return placeholder.equalsIgnoreCase(context);
    }

    public boolean checkButtonAddOtherNameIsDisplayed() {
        setTimeDelay(1);
        return findElements(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_OTHER_NAME).size() > 0;
    }

    public boolean checkButtonEditOtherNameIsDisplayed() {
        setTimeDelay(1);
        return findElements(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_OTHER_NAME).size() > 0;
    }


    // Section Favorite quote
    public void clickToButtonAddFavoriteQuote() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_FAVORITE_QUOTE);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_ADD_NEW_FAVORITE_QUOTE);
    }

    public void clickToButtonEditFavoriteQuote() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_FAVORITE_QUOTE);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_EDIT_FAVORITE_QUOTE);
    }

    public boolean checkFormAddEditFavoriteQuoteIsDisplayed() {
        return !getAttributeValue(driver, PersonalAbout_DetailsAboutYouUI.FORM_ADD_EDIT_FAVORITE_QUOTES, "style").equals("display: none;");
    }

    public void enterDataToTextAreaFavoriteQuote(String favoriteQuote) {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_FAVORITE_QUOTE);
        sendKeyToElement(driver, PersonalAbout_DetailsAboutYouUI.TEXTAREA_FAVORITE_QUOTE, favoriteQuote);
    }

    public String getErrMessOfFavoriteQuoteField() {
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.MESSAGE_VALIDATE_FAVORITE_QUOTE);
    }

    public void clickToButtonSaveOnFormFavoriteQuote() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_SAVE_FAVORITE_QUOTE);
    }

    public void clickToCancelSaveFavoriteQuote() {
        waitForElementClickable(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
        clickToElement(driver, PersonalAbout_DetailsAboutYouUI.BUTTON_CANCEL_SAVE_FAVORITE_QUOTE);
    }

    public String getFavoriteQuotesDisplayOnDetailsAbout() {
        waitElementToVisible(driver, PersonalAbout_DetailsAboutYouUI.FAVORITE_QUOTE_DATA);
        return getTextElement(driver, PersonalAbout_DetailsAboutYouUI.FAVORITE_QUOTE_DATA);
    }
}
