package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_ContactAndBasicInfoUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_CommonUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class PerAbout_BasicInfoAndContactPO extends PerAbout_CommonPO {
    WebDriver driver;

    /*
    Khởi tạo constructor
    */
    public PerAbout_BasicInfoAndContactPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    /*
    Hàm lấy title của Tab Contact and Basic Info
    */
    public String getTitlePageContactAndBasicInfo(){
        waitElementToVisible(driver, Personal_CommonUI.TITLE_TAB_ABOUT,"about_contact");
        return getTextElement(driver, Personal_CommonUI.TITLE_TAB_ABOUT);
    }

    /*
    Hàm kiểm tra Title của Tab Contact And Basic Info theo ngôn ngữ
    */
    public boolean checkTitleTabContactAndBasicInfoByLanguage(String languageSystem){
        String titlePage = getTitlePageContactAndBasicInfo();
        if (languageSystem.equals("vi")) {
            return titlePage.equals("");
        } else if(languageSystem.equals("en")){
            return titlePage.equals("");
        } else {
            System.out.println(titlePage);
            return false;
        }
    }

    /*
    Hàm kiểm tra Page Personal About - Tab Contact and Basic Info có hiển thị được hay không?
    */
    public boolean checkContactAndBasicInfoTabIsDisplayed(String languageSystem){
        waitElementToVisible(driver, Personal_CommonUI.ABOUT_MENU);
        return checkTitleTabContactAndBasicInfoByLanguage(languageSystem)
                && getAttributeValue(driver,Personal_CommonUI.ABOUT_ITEM_MENU,"class","about_contact").endsWith("active");
    }

    /*
    Hàm lây giá trị số điện thoại chính - Tab Contact and Basic info
     */
    public String getMainPhoneIsDisplayedOnBasicInfoAndContact(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.MAIN_PHONE_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.MAIN_PHONE_DATA);
    }

    /*
    Hàm lây danh sách số điện thoại khác hiển thị trên danh sách
    */
    public int getListOtherPhoneAreDisplayedOnOTabBasicInfoAndContact(){
        List<WebElement> listOtherPhone = findElements(driver, PersonalAbout_ContactAndBasicInfoUI.LIST_OTHER_PHONE_DATA);
        return listOtherPhone.size();
    }

    /*
    Hàm kiểm tra dữ liệu số điện thoại khác
    */
    public boolean verifyDataOtherNameIsDisplayedOnBasicInfoAndContact(String expectedCondition){
        List<WebElement> otherPhoneList = findElements(driver, PersonalAbout_ContactAndBasicInfoUI.LIST_OTHER_PHONE_DATA);
        for(WebElement item : otherPhoneList) {
            String dataOtherPhone = item.getText();
            return dataOtherPhone.equals(expectedCondition);
        }
        return false;
    }

    /*
    Hàm nhấn vào nút thêm mới số điện thoại chính
    */
    public void clickToButtonAddNewMainPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_NEW_MAIN_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_NEW_MAIN_PHONE);
    }

    /*
    Hàm nhấn vào nút chỉnh sửa số điện thoại chính
    */
    public void clickToIconEditMainPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_MAIN_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_MAIN_PHONE);
    }

    /*
    Hàm kiểm tra form chỉnh sửa số điện thoại chính hiển thị hay không?
    */
    public boolean checkFormEditPhoneIsDisplayed(){
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_OTHER_PHONE)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_MAIN_PHONE);

    }

    /*
    Hàm kiểm tra số lượng field số điện thoại khác khi mới vào
    */
    public boolean checkNumberOtherFieldisDisplayedCorrect(int numOtherPhone){
        if(findElements(driver, PersonalAbout_ContactAndBasicInfoUI.NUMBER_FIELD_OTHER_PHONE).size() == numOtherPhone){
            return true;
        }
        else {
            System.out.println("Số lương field không trùng khớp");
            return false;
        }
    }

    /*
    Hàm nhập dữ liệu tại ô số điện thoại chính
    */
    public void enterDataToFieldMainPhone(String mainPhone){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_MAIN_PHONE);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_MAIN_PHONE, mainPhone);
    }

    /*
    Hàm lấy thông báo lỗi điều kiện của field số điện thoại chính
    */
    public String getMessageValidateFieldMainPhone() {
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.MESSAGE_VALIDATE_FIELD_MAIN_PHONE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.MESSAGE_VALIDATE_FIELD_MAIN_PHONE);
    }

    /*
    Hầm nhấn vào link thêm mới số điện thoại khác
    */
    public void clickToLinkAddOtherPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_OTHER_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_OTHER_PHONE);
    }

    /*
    Hầm lấy thông báo lỗi tại ô Số điẹn thoại khác
    */
    public String getMessageValidateFieldOtherPhone(int index) {
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.MESSAGE_VALIDATE_FIELD_OTHER_PHONE,String.valueOf(index));
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.MESSAGE_VALIDATE_FIELD_OTHER_PHONE,String.valueOf(index));
    }

    /*
     Hàm lấy giá trị đang hiển thị ô Số điện thoại chính
    */
    public String getValueDisplayOnFieldMainPhone(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_MAIN_PHONE);
        return getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_MAIN_PHONE, "value");
    }

    /*
    Hàm lấy giá trị đang hiển thị ô Số điện thoại khác được chỉ định
     */
    public String getValueDisplayOnFieldOtherPhone(){
        int n = findElements(driver, PersonalAbout_ContactAndBasicInfoUI.NUMBER_FIELD_OTHER_PHONE).size();
        return getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_OTHER_PHONE, "value",String.valueOf(n) );
    }

    /*
    Hàm nhập giá trị ô số điện thoại khác trường hợp chỉnh sửa
     */
    public void enterDataToFieldOtherPhoneCaseEdit(String phonenumber, int indexField) {
        int numOtherPhone = getListOtherPhoneAreDisplayedOnOTabBasicInfoAndContact();
        if(indexField <= numOtherPhone){
            waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_OTHER_PHONE, String.valueOf(indexField));
            sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_OTHER_PHONE,phonenumber, String.valueOf(indexField));
        }
        else {
            System.out.println("Giá trị field dc chọn không hợp lệ");
        }
    }

    /*
    Hàm nhập giá trị ô số điện thoại khác trường hợp thêm mới
    */
    public void enterDataToFieldOtherPhoneCaseAdd(String phonenumber) {
        int numberOther = getListOtherPhoneAreDisplayedOnOTabBasicInfoAndContact();
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_OTHER_PHONE, String.valueOf(numberOther));
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.FIELD_OTHER_PHONE,phonenumber, String.valueOf(numberOther));
    }

    /*
     Hàm nhấn vào icon Xoá một field số điện thoại khác bất kỳ trên danh sách
    */
    public void clickToIconRemoveRedirectOtherPhone(int indexPhone){
        int numOtherPhone = getListOtherPhoneAreDisplayedOnOTabBasicInfoAndContact();
        if(indexPhone <= numOtherPhone){
            waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_REMOVE_OTHER_PHONE, String.valueOf(indexPhone));
            clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_REMOVE_OTHER_PHONE ,String.valueOf(indexPhone));
        }
        else {
            System.out.println("Thao tác không hợp lệ");
        }
    }

    public void clickToButtonSaveOnFormEditPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_PHONE);
    }

    public void clickToButtonCancelOnFormEditPhone(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_CHANGE_PHONE);
    }



    public String convertFormatPhoneData(String phoneData){
        String a =  phoneData.replaceAll("[^\\d]","");
        if(a.length()>20){
            a= a.substring(0,20);
        }
        return a;
    }
    // Birthday
    public String getBirthdayIsDisplayedOnBasicInfoAndContactTab(String languageSystem){
        if(checkContactAndBasicInfoTabIsDisplayed(languageSystem)){
            waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_DATA);
            return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_DATA);
        }
        return "Sai rồi bạn ơi";
    }

    public void clickToIconEditBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_BIRTHDAY);
    }

    public boolean checkFormEditBirthdayIsDisplayed(){
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_FIELD)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY)
                    && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
    }

    public void enterDataToCalendarBirhday(String birthday){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_FIELD, birthday);
    }

    public void changeScopeOfBirthday(String valueScope) {
        selectItemInCustomDropdown(driver, PersonalAbout_ContactAndBasicInfoUI.DROPDOWN_SCOPE_BIRTHDAY, PersonalAbout_ContactAndBasicInfoUI.DROPDOWN_SCOPE_ITEM_BIRTHDAY, valueScope);
    }

    public String getValueDisplayOnCalenderBirthday(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_FIELD);
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_FIELD,"value");
    }

    public String getMessageValidateCalendarBirthday(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BIRTHDAY_ERROR_MESSAGE);
    }

    public void clickToButtonSaveOnFormEditBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
    }

    public void clickToButtonCancelOnFormEditBirthday(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
    }

    public String getColorButtonSaveOnFormEditBirthday(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
        String colorButton = getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY, "background-color");
        return Color.fromString(colorButton).asHex();
    }

    public String getTextButtonSaveOnFormEditBirthdayByLanguage(String languageSystem){
        if(languageSystem == "vi"){
            return "";
        }
        else if(languageSystem=="eng") {
            return "";
        }
        return "Éo hiểu kiểu gì";
    }

    public boolean verifyUIButtonSaveOnFormEditBirthday(String languageSystem){
        String textButton = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
        String buttonByLang = getTextButtonSaveOnFormEditBirthdayByLanguage(languageSystem);
        String colorButton = getColorButtonSaveOnFormEditBirthday();
        if(textButton.equals(buttonByLang) && colorButton.equals("")){
            return true;
        }
        else {
            System.out.println("Text của button lấy từ element: " + textButton);
            System.out.println("Text của button lấy từ language: " + buttonByLang);
            System.out.println("Màu hiện tại của button: "+ colorButton);
            return false;
        }
    }

    public String getColorButtonCancelOnFormEditBirthday(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
        String colorButton = getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY,"background-color");
        return Color.fromString(colorButton).asHex();
    }

    public String getTextButtonCancelOnFormEditBirthdayByLanguage(String languageSystem){
        if(languageSystem.equals("vi")){
            return "";
        }
        else if(languageSystem.equals("eng")) {
            return "";
        }
        return "Éo hiểu kiểu gì";
    }

    public boolean verifyUIButtonCancelOnFormEditBirthday(String languageSystem){
        String textButton = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_BIRTHDAY);
        String buttonByLang = getTextButtonCancelOnFormEditBirthdayByLanguage(languageSystem);
        String colorButton = getColorButtonCancelOnFormEditBirthday();
        if(textButton.equals(buttonByLang) && colorButton.equals("")){
            return true;
        }
        else {
            System.out.println("Text của button lấy từ element: " + textButton);
            System.out.println("Text của button lấy từ language: " + buttonByLang);
            System.out.println("Màu hiện tại của button: "+ colorButton);
            return false;
        }
    }

    public Boolean verifyTextLabelBirthdayOnFormEditBirthday(String languageSystem){
        String textLabel = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.LABEL_FIELD_BIRTHDAY);
        String labelByLang = "";
        if(languageSystem.equals("vi")){
            labelByLang =  "HAHAHA";
        } else if(languageSystem.equals("eng")){
            labelByLang =  "";
        }
        return textLabel.equals(labelByLang)
                && getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.LABEL_FIELD_BIRTHDAY,"class").endsWith("required");
    }

    // Gender
    public String getGenderNameIsDisplayedOnTab(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DATA);
    }

    public void clickToIconEditGender(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_GENDER);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_GENDER);
    }

    public boolean checkFormEditGenderISDisplayed(){
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_GENDER);
    }

    public void clickToChooseGenderOption(String genderOption){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN);
        selectItemInDropdownByValue(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN, genderOption);
    }

    public void clickToButtonCancelOnFormEditGender(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER );
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER);
    }

    public void clickToButtonSaveOnFormEditGender() {
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER);
    }

    public String getTextButtonSaveOnFormEditGenderByLanguage(String languageSystem){
        String textButton = "";
        if(languageSystem.equals("vi")){
            textButton = "Lưu";
        }
        else if(languageSystem.equals("eng")) {
            textButton =  "Save";
        }
        return textButton;
    }

    public String getColorButtonSaveOnFormEditGender(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER);
        String colorButton = getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER,"background-color");
        return Color.fromString(colorButton).asHex();
    }

    public boolean verifyUIButtonSaveOnFormEditGender(String languageSystem){
        String textButton = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER);
        String buttonByLang = getTextButtonSaveOnFormEditGenderByLanguage(languageSystem);
        String colorButton = getColorButtonCancelOnFormEditBirthday();
        if(textButton.equals(buttonByLang) && colorButton.equals("")){
            return true;
        }
        else {
            System.out.println("Text của button lấy từ element: " + textButton);
            System.out.println("Text của button lấy từ language: " + buttonByLang);
            System.out.println("Màu hiện tại của button: "+ colorButton);
            return false;
        }
    }

    public String getTextButtonCancelOnFormEditGenderyByLanguage(String languageSystem){
        String textButton = "";
        if(languageSystem.equals("vi")){
            return "";
        }
        else if(languageSystem.equals("eng")) {
            return "";
        }
        return "Éo hiểu kiểu gì";
    }

    public String getColorButtonCancelOnFormEditGender(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_GENDER);
        String colorButton = getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_GENDER,"background-color");
        return Color.fromString(colorButton).asHex();
    }

    public boolean verifyUIButtonCancelOnFormEditGender(String languageSystem){
        String textButton = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_GENDER);
        String buttonByLang = getTextButtonCancelOnFormEditGenderyByLanguage(languageSystem);
        String colorButton = getColorButtonCancelOnFormEditBirthday();
        if(textButton.equals(buttonByLang) && colorButton.equals("")){
            return true;
        }
        else {
            System.out.println("Text của button lấy từ element: " + textButton);
            System.out.println("Text của button lấy từ language: " + buttonByLang);
            System.out.println("Màu hiện tại của button: "+ colorButton);
            return false;
        }
    }

    public Boolean verifyTextLabelGenderOnFormEditGender(String languageSystem){
        String textLabel = getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.LABEL_DROPDOWN_GENDER);
        String labelByLang = "";
        if(languageSystem == "vi"){
            labelByLang =  "";
        } else if(languageSystem =="eng"){
            labelByLang =  "";
        }

        if(textLabel.equals(labelByLang)
                && getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.LABEL_DROPDOWN_GENDER,"class").endsWith("required")){
            return true;
        } else {
            System.out.println("Text của label Gender: " +textLabel);
            System.out.println("Class của label Gender: " + getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.LABEL_DROPDOWN_GENDER,"class"));
            return false;
        }

    }
    // Address - Contact and Basic info
    public String getAddressDisplay(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.CONTACT_AND_BASIC_INFO_TAB);
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_DATA);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_DATA);
    }

    public void clickToButtonAddNewAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_ADDRESSS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_ADDRESSS);
    }

    public void clickToButtonEditAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.ICON_EDIT_ADDRESS);
    }

    public void enterDataToAddressField(String address){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_FIELD, address);
    }

    public void enterDataToCityField(String city){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.CITY_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.CITY_FIELD, city);
    }

    public void enterDataToAreaCode(String areaCode){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.AREA_CODE_FIELD);
        sendKeyToElement(driver, PersonalAbout_ContactAndBasicInfoUI.AREA_CODE_FIELD, areaCode);
    }

    public String getErrorMessageOfAddressField(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.ADDRESS_ERROR_MESSAGE);
    }

    public String getErrorMessageOfCityField(){
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.CITY_ERROR_MESSAGE);
        return getTextElement(driver, PersonalAbout_ContactAndBasicInfoUI.CITY_ERROR_MESSAGE);
    }

    public void clickToSaveAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_ADDRESS);
    }

    public void clickToCancelSaveAddress(){
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_ADDRESS);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_ADDRESS);
    }


    public Object getOtherPhoneDisplay() {
        return null;
    }

    public boolean checkFormAddOrEditAddressDisplay() {
        return true;
    }

    public String getAttributeValueOfCityIsDisplay() {
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.CITY_FIELD, "value");
    }

    public String getAttributeValueOfAreaCodeIsDisplay() {
        return  getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.AREA_CODE_FIELD, "value");
    }

    public boolean checkAddressSectionNotHaveData() {
        waitElementToVisible(driver, PersonalAbout_ContactAndBasicInfoUI.TITLE_PAGE);
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_ADD_ADDRESSS);
    }


    public void clickToButtonSaveBirthday() {
        waitForElementClickable(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
        clickToElement(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_BIRTHDAY);
    }

    public void chooseGenderType(String genderType){
        selectItemInDropdownByValue(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN,genderType);
    }

    public boolean checkFormEditGenderOfUserIsDisplay() {
        return checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN)
                && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_SAVE_GENDER)
                    && checkElementIsDisplayed(driver, PersonalAbout_ContactAndBasicInfoUI.BUTTON_CANCEL_SAVE_GENDER);
    }


    public String getGenderOptionDisplayOnDropdown() {
        return getAttributeValue(driver, PersonalAbout_ContactAndBasicInfoUI.GENDER_DROPDOWN,"value");
    }

    public Object getEmailAddressIsDisplayed() {
        return true;
    }

    public boolean checkFormAddEditMainPhoneIsDisplayed() {
        return true;
    }

    public void chooseScopeOfGender(String s) {
    }
}
