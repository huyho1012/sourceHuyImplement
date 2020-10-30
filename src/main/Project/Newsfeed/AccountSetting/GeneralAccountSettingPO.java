package Project.Newsfeed.AccountSetting;

import Interfaces.hahalolo_newsfeed.AccountSetting.Account_GeneralSettingUI;
import org.openqa.selenium.WebDriver;

public class GeneralAccountSettingPO extends AccountCommonPO {
    WebDriver driver;

    // Hàm tạo contrustor
    public GeneralAccountSettingPO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    // General Settng Account - Kiểm tra title của tab theo ngôn ngữ
    public boolean verifyTextTitleTabGeneral(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.TITLE_PAGE, "setting_general");
        String titlePage = getTextElement(driver, Account_GeneralSettingUI.TITLE_PAGE, "setting_general");
        if (languageSystem.equals("vi")) {
            return titlePage.equalsIgnoreCase("Thiết lập tài khoản chung");
        } else if (languageSystem.equals("eng")) {
            return titlePage.equalsIgnoreCase("General Account Setting");
        } else {
            System.out.println(titlePage);
            return false;
        }
    }

    // General Settng Account - Kiểm tra hiển thị của tab
    public boolean checkGeneralAccountSettingTabIsDisplayed(String fullName, String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MENU.NAVIGATION_MENU);

        String tabTitlePage = getPageTitle(driver);
        String fullNameData = getFullNameIsDisplayedOnTabGeneralSetting();
        String attributeClass = getAttributeValue(driver, Account_GeneralSettingUI.MENU.NAVIGATION_ITEM_MENU, "class", "setting_general");

        String currentTabPage = "";
        if (languageSystem.equals("vi")) {
            currentTabPage = "Cài đặt tài khoản | Hahalolo";
        } else if (languageSystem.equals("eng")) {
            currentTabPage = "Account setting | Hahalolo";
        }
        return  tabTitlePage.equals(currentTabPage)
                && verifyTextTitleTabGeneral(languageSystem)
                && attributeClass.endsWith("active")
                && fullNameData.equals(fullName);
    }

    // Chức năng Edit Full name - Lấy title của Section Fullname
    public boolean verifyTitleFullNameSectionByLanguage(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FULLNAME.BUTTON_EDIT);
        String titleSection = getTextElement(driver, Account_GeneralSettingUI.FULLNAME.TITLE_FUNCTION);
        if (languageSystem.equals("vi")) {
            return titleSection.equals("Họ và tên");
        } else if (languageSystem.equals("eng")) {
            return titleSection.equals("Full name");
        } else {
            return false;
        }
    }

    // Chức năng Edit Full name - Lấy Fullname hiển thị tại tab
    public String getFullNameIsDisplayedOnTabGeneralSetting() {
        setTimeDelay(5);
        return getTextElement(driver, Account_GeneralSettingUI.FULLNAME.DATA_DISPLAY);
    }

    // Chức năng Edit Full name - Nhấn vào nút Chỉnh sửa Full name
    public void clickToButtonEditFullName() {
        waitForElementClickable(driver, Account_GeneralSettingUI.FULLNAME.BUTTON_EDIT);
        clickToElement(driver, Account_GeneralSettingUI.FULLNAME.BUTTON_EDIT);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Kiểm tra hiển thị của Form Edit Fullname
    public boolean checkFormEditFullNameIsDisplayed() {
        if(checkElementUndisplayed(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME)
                && checkElementUndisplayed(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME)
                && checkElementUndisplayed(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME)){
            return false;
        }
        return true;
    }

    // Chức năng Edit Full name - Form Edit Fullname - Kiểm tra nội dung của Label field Firstname theo ngôn ngữ
    public boolean verifyTextLabelFieldFirstName(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.LABEL_TEXT_FIELD_FIRSTNAME);
        String labelFirstName = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.LABEL_TEXT_FIELD_FIRSTNAME);
        if (languageSystem.equals("vi")) {
            return labelFirstName.equals("Tên");
        } else if (languageSystem.equals("eng")) {
            return labelFirstName.equals("First name");
        } else {
            System.out.println("Giá trị text của field là: " + labelFirstName);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy giá trị hiển thị tại ô Firstname
    public String getDataDisplayOnFieldFirstName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME);
        return getAttributeValue(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME, "value");
    }

    // Chức năng Edit Full name - Form Edit Fullname - Nhập giá trị ô Firstname
    public void enterDataToFieldFirstName(String firstName) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME);
        sendKeyToElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME, firstName);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Xoá dữ liệu hiển thị tại ô Firstname
    public void removeDataToFieldFirstName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME);
        removeValueOnElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_FIRSTNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy nội dung text của thông báo lỗi tại field Firstname
    public String getMessageValidateFieldFirstName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_FIRSTNAME);
        return getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_FIRSTNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Kiểm tra nội dung của Label field Middlename theo ngôn ngữ
    public boolean verifyTextLabelFieldMiddleName(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME);
        String labelMiddleName = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.LABEL_TEXT_FIELD_MIDNAME);
        if (languageSystem.equals("vi")) {
            return labelMiddleName.equals("Chữ lót");
        } else if (languageSystem.equals("eng")) {
            return labelMiddleName.equals("Middle name");
        } else {
            System.out.println("Giá trị text của field là: " + labelMiddleName);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy giá trị hiển thị tại ô Middlename
    public String getDataDisplayOnFieldMiddleName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME);
        return getAttributeValue(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME, "value");
    }

    // Chức năng Edit Full name - Form Edit Fullname - Nhập giá trị ô Middlename
    public void enterDataToFieldMiddlename(String midName) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME);
        sendKeyToElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME, midName);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Xoá dữ liệu hiển thị tại ô Middlename
    public void removeDataToFieldMiddleName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME);
        removeValueOnElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_MIDNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy nội dung text của thông báo lỗi tại field Middlename
    public String getMessageValidateFieldMiddleName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_MIDNAME);
        return getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_MIDNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Kiểm tra nội dung text của label field Lastname theo ngôn ngữ
    public boolean verifyTextLabelFieldLastName(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME);
        String labelLastName = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.LABEL_FIELD_LASTNAME);
        if (languageSystem.equals("vi")) {
            return labelLastName.equals("Họ");
        } else if (languageSystem.equals("eng")) {
            return labelLastName.equals("Last name");
        }
        else {
            System.out.println("Giá trị text của field là: " + labelLastName);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy giá trị hiển thị tại ô Lastname
    public String getDataDisplayOnFieldLastName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME);
        return getAttributeValue(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME, "value");
    }

    // Chức năng Edit Full name - Form Edit Fullname - Nhập giá trị ô Lastname
    public void enterDataToFieldLastname(String lastName) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME);
        sendKeyToElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME, lastName);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Xoá dữ liệu hiển thị tại ô Lastname
    public void removeDataToFieldLastName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME);
        removeValueOnElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.TEXT_FIELD_LASTNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Lấy nội dung text của thông báo lỗi tại field Lastname
    public String getMessageValidateFieldLastName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_LASTNAME);
        return getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.MESSAGE_VALIDATE_TEXT_FIELD_LASTNAME);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Hàm xử lý thao tác nhấn nút Save changes
    public void clickToButtonSaveChangesOnFormEditFullname() {
        waitForElementClickable(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_SAVE_CHANGE);
        clickToElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_SAVE_CHANGE);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Hàm verfy UI của nút Save changes
    public boolean checkVerifyUIButtonSaveChangesOnFormEditFullName(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_SAVE_CHANGE);
        String colorButton = getColorElementWithHexaCode(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_SAVE_CHANGE);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_SAVE_CHANGE);
        if (languageSystem.equals("vi")) {
            return textButton.equals("Lưu thay đổi") && colorButton.equals("#166986");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("Save Changes") && colorButton.equals("#166986");
        } else {
            System.out.println("Giá trị của Button: " + textButton);
            System.out.println("Giá trị của color: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Edit Fullname - Hàm xử lý thao tác nhấn nút Cancel
    public void clickToButtonCancelOnFormEditFullname() {
        waitForElementClickable(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_CANCEL);
        clickToElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_CANCEL);
    }

    // Chức năng Edit Full name - Form Edit Fullname - Hàm verfy UI của nút Cancel
    public boolean checkVerifyUIButtonCancelOnFormEditFullName(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_CANCEL);
        String colorButton = getColorElementWithHexaCode(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_CANCEL);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_FULLNAME.BUTTON_CANCEL);

        if (languageSystem.equals("vi")) {
            return textButton.equals("Hủy bỏ") && colorButton.equals("#343a40");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("Cancel") && colorButton.equals("#343a40");
        } else {
            System.out.println("Giá trị của Button: " + textButton);
            System.out.println("Giá trị của color: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Confirm Password - Kiểm tra nội dung của Title theo ngôn ngữ
    public boolean verifyTextTitleByLangFormConfirmPassword(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TITLE_MODEL);
        String titleForm = getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TITLE_MODEL);
        if (languageSystem.equals("vi")) {
            return titleForm.equals("Xác nhận mật khẩu");
        } else if (languageSystem.equals("eng")) {
            return titleForm.equals("Confirm password");
        }
        return false;
    }

    // Chức năng Edit Full name - Form Confirm Password - Kiểm tra nội dung của Content theo ngôn ngữ
    public boolean verifyTextContentByLangFormConfirmPassword(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.CONTENT_MODEL);
        String titleForm = getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.CONTENT_MODEL);
        if (languageSystem.equals("vi")) {
            return titleForm.equals("Vì vấn đề bảo mật, vui lòng nhập lại mật khẩu để tiếp tục.");
        } else if (languageSystem.equals("eng")) {
            return titleForm.equals("For your security, you must re-enter your password to continue.");
        }
        return false;
    }

    // Chức năng Edit Full name - Form Confirm Password - Kiểm tra form Xác nhận mật khẩu hiển thị
    public boolean checkFormConfirmPasswordIsDisplayed() {
        setTimeDelay(1);
        if (checkElementUndisplayed(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TITLE_MODEL)
                && checkElementUndisplayed(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.CONTENT_MODEL)
                && checkElementUndisplayed(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM)
                && checkElementUndisplayed(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL)) {
            return false;
        }
        return true;
    }

    // Chức năng Edit Full name - Form Confirm Password - Kiểm tra nội dung của Label field Password theo ngôn ngữ
    public boolean verifyTextLabelFieldPasswordByLanguage(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.LABEL_TEXT_FIELD_PASSWORD);
        String labelField = getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.LABEL_TEXT_FIELD_PASSWORD);
        if (languageSystem.equals("vi")) {
            return labelField.equals("Mật khẩu");
        } else if (languageSystem.equals("eng")) {
            return labelField.equals("Password");
        }
        return false;
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm nhập giá trị ô Password
    public void enterDataToFieldPassword(String password) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD);
        sendKeyToElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD, password);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm lấy giá trị ô Password
    public String getDataDisplayOnFieldPassword() {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD);
        return getAttributeValue(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD, "value");
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm lấy nội dung text của thông báo lỗi tại field Password
    public String getMessageValidateFieldPassword() {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.MESSAGE_VALIDATE_TEXT_FIELD_PASSWORD);
        return getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.MESSAGE_VALIDATE_TEXT_FIELD_PASSWORD);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm lấy nội dung text của thông báo lỗi tại function Confirm password
    public String getMessageValidateOfFormConfirmPass() {
        setTimeDelay(1);
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.MESSAGE_VALIDATE_CHANGE_PASSWORD);
        return getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.MESSAGE_VALIDATE_CHANGE_PASSWORD);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm nhấn vào nút Confirm
    public void clickToButtonConfirmOnFormConfirmPass() {
        waitForElementClickable(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM);
        clickToElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm check verify UI nút Confirm pasword
    public boolean checkVerifyUIButtonConfirmOnFormConfirmPass(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM);
        String colorButton = getColorElementWithHexaCode(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CONFIRM);

        if (languageSystem.equals("vi")) {
            return textButton.equals("Xác nhận") && colorButton.equals("#166986");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("Confirm") && colorButton.equals("#166986");
        } else {
            System.out.println("Giá trị của Button: " + textButton);
            System.out.println("Giá trị của color: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm nhấn vào nút Cancel
    public void clickToButtonCancelOnFormConfirmPass() {
        waitForElementClickable(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL);
        clickToElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL);
        setTimeDelay(1);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm check verify UI nút Cancel
    public boolean checkVerifyUIButtonCancelOnFormConfirmPass(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL);
        String colorButton = getColorElementWithHexaCode(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.BUTTON_CANCEL);

        if (languageSystem.equals("vi")) {
            return textButton.equals("Hủy bỏ") && colorButton.equals("#343a40");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("Cancel") && colorButton.equals("#343a40");
        } else {
            System.out.println("Giá trị của Button: " + textButton);
            System.out.println("Giá trị của color: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm lấy nội dung text của thông báo của chức năng
    public String getMessageValidateChangeFullName() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FULLNAME.MESSSAGE_VALIDATE_CHANGE_FULNAME);
        return getTextElement(driver, Account_GeneralSettingUI.FULLNAME.MESSSAGE_VALIDATE_CHANGE_FULNAME);
    }

    // Chức năng Edit Full name - Form Confirm Password - Hàm nhập các thông tin về Họ Tên
    public void enterValueToAllFieldOnFormEditFullname(String firstName, String middleName, String lastName, String password) {
        clickToButtonEditFullName();
        enterDataToFieldFirstName(firstName);
        enterDataToFieldMiddlename(middleName);
        enterDataToFieldLastname(lastName);
        clickToButtonSaveChangesOnFormEditFullname();
    }
    // Chức năng Edit Full name - Form Confirm Password - Hàm nhập các thông tin về Họ Tên
    public void updateFullName(String firstName, String middleName, String lastName, String password) {
        clickToButtonEditFullName();
        enterDataToFieldFirstName(firstName);
        enterDataToFieldMiddlename(middleName);
        enterDataToFieldLastname(lastName);
        setTimeDelay(1);
        clickToButtonSaveChangesOnFormEditFullname();
        setTimeDelay(1);
        enterDataToFieldPassword(password);
        setTimeDelay(1);
        clickToButtonConfirmOnFormConfirmPass();
    }

    // Function Username

    // Chức năng Edit Username - Hàm kiểm tra text Tiêu đề của Function Username theo ngôn ngữ hệ thống
    public boolean verifyTitleFunctionUsernameByLanguage(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.ICON_LOADING_DATA);
        String textTitle = getTextElement(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.ICON_LOADING_DATA);
        if (languageSystem.equals("vi")) {
            return textTitle.equals("Tên người dùng");
        } else if (languageSystem.equals("eng")) {
            return textTitle.equals("Username");
        } else {
            System.out.println(textTitle);
            return false;
        }
    }

    // Chức năng Edit Username - Hàm kiểm tra text Content của Function Username theo ngôn ngữ hệ thống
    public boolean verifyContentFunctionUsernameByLanguage(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.CONTENT_DISPLAY);
        String textContent = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.CONTENT_DISPLAY);
        if (languageSystem.equals("vi")) {
            return textContent.equals("Tên người dùng phải trùng với tên hiển thị trên dòng thời gian của bạn");
        } else if (languageSystem.equals("eng")) {
            return textContent.equals("The username must match the name displayed on your timeline");
        }
        else {
            System.out.println(textContent);
            return false;
        }
    }

    // Chức năng Edit Username - Hàm kiểm tra text Ghi chú của Function Username theo ngôn ngữ hệ thống
    public boolean verifyNoteFunctionUsernameByLanguage(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.NOTE_DISPLAY);
        String textNote = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.NOTE_DISPLAY);
        if (languageSystem.equals("vi")) {
            return textNote.equals("Chú ý: Tên người dùng nên bao gồm tên đã xác thực của bạn.");
        } else if (languageSystem.equals("eng")) {
            return textNote.equals("Note: The username should include your verified name.");
        } else {
            System.out.println(textNote);
            return false;
        }

    }

    // Chức năng Edit Username - Hàm kiểm tra UI của button Save changes
    public boolean checkVerifyButtonSaveChangesOnFormEditUsername(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
        String colorButton = getColorElementWithHexaCode(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);

        if (languageSystem.equals("vi")) {
            return textButton.equals("Lưu thay đổi") && colorButton.equals("#166986");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("Save Changes") && colorButton.equals("#166986");
        } else {
            System.out.println("Giá trị của button: " + textButton);
            System.out.println("giá trị màu của button: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Username - Hàm kiểm tra UI của button Cancel
    public boolean checkVerifyButtonCancelOnFormEditUsername(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_CANCEL);
        String textButton = getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_CANCEL);
        String colorButton = getColorElementWithHexaCode(driver,  Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_CANCEL);

        if (languageSystem.equals("vi")) {
            return textButton.equals("Hủy bỏ") && colorButton.equals("#343a40");
        } else if (languageSystem.equals("eng")) {
            return textButton.equals("") && colorButton.equals("#343a40");
        } else {
            System.out.println("Giá trị của button: " + textButton);
            System.out.println("giá trị màu của button: " + colorButton);
            return false;
        }
    }

    // Chức năng Edit Username - Hàm thực thi thao tác nhấn edit Username
    public void clickToIconEditUsername() {
        waitForElementClickable(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.BUTTON_EDIT);
        clickToElement(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.BUTTON_EDIT);
    }

    // Chức năng Edit Username - Hàm kiểm tra trạng thái enable/disable của button Save changes
    public boolean checkStatusEnableButtonSaveChangeOnFormEditUsername() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
        return checkElementIsEnabled(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
    }

    // Chức năng Edit Username - Hàm nhập giá trị của ô Username
    public void enterDataToFieldUsername(String userName) {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME);
        sendKeyToElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME, userName);
    }

    // Chức năng Edit Username - Hàm xóa dũ liệu hiển thị tai ô Username
    public void clearValueDisplayOnFieldUsername() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME);
        removeValueOnElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME);
    }

    // Chức năng Edit Username - Hàm lấy giá giá trị hiển thị của ô Username
    public String getValueDisplayOnFieldUsername(){
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME);
        return getAttributeValue(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.TEXT_FIELD_USERNAME,"value");
    }

    // Chức năng Edit Username - Hàm lấy thông báo của chức nằng cập nhật định danh người dùng
    public String getMessageValidateFunctionUsername() {
        waitElementToVisible(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.MESSAGE_VALIDATE_TEXT_FIELD_USERNAME);
        return getTextElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.MESSAGE_VALIDATE_TEXT_FIELD_USERNAME);
    }

    // Chức năng Edit Username - Hàm thực thi thao tác hủy bỏ cập nhật đinh danh người dùng
    public void clickToButtonCancelOnFormEditUsername() {
        waitForElementClickable(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_CANCEL);
        clickToElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_CANCEL);
    }

    // Chức năng Edit Username - Hàm thực thi thao tác lưu cập nhật đinh danh người dùng
    public void clickTobuttonSaveOnFormEditUserName() {
        waitForElementClickable(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
        clickToElement(driver, Account_GeneralSettingUI.FORM_EDIT_USERNAME.BUTTON_SAVE);
    }

    // Chức năng Edit Username - Hàm lấy nội dung thông báo trường hợp người dùng chưa setting lại username
    public boolean verifyContentCaseNoSetUpUsername(String languageSystem) {
        waitElementToVisible(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.NO_USERNAME);
        String contentNoti = getTextElement(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.NO_USERNAME);

        if(languageSystem.equals("vi")){
            return contentNoti.equals("Bạn chưa thiết lập tên người dùng");
        }
        else if (languageSystem.equals("eng")){
            return contentNoti.equals("");
        }
        else {
            System.out.println("giá trị nội dung là: " + contentNoti);
            return false;
        }

    }

    // Chức năng Edit Username - Hàm kiểm tra form chỉnh sửa định danh người dùng hiển thị
    public boolean checkFormEditUsernameIsDisplayed() {
        return true;
    }

    // Chức năng Edit Username - Hàm tên URL định danh người dùng
    public String getUsernameURLIsDisplayedOnTabGeneralSetting() {
        waitElementToVisible(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.URL_USERNAME_DISPlAY);
        return getTextElement(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.URL_USERNAME_DISPlAY);
    }

    // Chức năng Edit Username - Hàm tên định danh người dùng hiển thị
    public String getUsernameIsDisplayedOnTabGeneralSetting() {
        String url = getTextElement(driver, Account_GeneralSettingUI.USERNAME_FUNCTION.URL_USERNAME_DISPlAY);
        String[] username = url.split("/");
        return username[username.length - 1];
    }

    // Chức năng Edit Username
    public void updateUsernameWithValue(String userName){
        clickToIconEditUsername();
        enterDataToFieldUsername(userName);
        clickTobuttonSaveOnFormEditUserName();
    }

    public void removeDataToFieldPassword() {
        waitElementToVisible(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD);
        removeValueOnElement(driver, Account_GeneralSettingUI.MODEL_CONFIRM_PASSWORD.TEXT_FIELD_PASSWORD);
    }
}
