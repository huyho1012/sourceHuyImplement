package Project.Shared;

import Interfaces.hahalolo_newsfeed.StartApp.Signup_AccountUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;


public class SignUpPO extends CommonStartAppPO {
    WebDriver driver;
    public String lastNameField = "";
    public String firstNameField ="";
    public String passwordField = "";
    public String accountField = "";
    public String confirmPassField = "";

    // Khởi tạo constructor
    public SignUpPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra title của Form Đăng ký theo ngôn ngữ hệ thống
    public boolean checkTitleFormSignUpAccountByLanguage(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.TITLE_FORM_REGISTER_ACCOUNT);
        String titleForm = getTextElement(driver, Signup_AccountUI.TITLE_FORM_REGISTER_ACCOUNT);
        String contentByLang = "";
        if(languageSystem.equals("vi")){
            contentByLang = "Tham gia Hahalolo ngay!";
        } else if(languageSystem.equals("eng")){
            contentByLang = "";
        }

        return titleForm.contains(contentByLang);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra Form Đăng ký hiển thị hay không
    public boolean checkFormSignUpAccountIsDisplayed(){
        return checkElementIsDisplayed(driver, Signup_AccountUI.DYNAMIC_FIELD, firstNameField)
                && checkElementIsDisplayed(driver, Signup_AccountUI.DYNAMIC_FIELD, lastNameField)
                & checkElementIsDisplayed(driver, Signup_AccountUI.DYNAMIC_FIELD,passwordField)
                && checkElementIsDisplayed(driver, Signup_AccountUI.DYNAMIC_FIELD,confirmPassField)
                && checkElementIsDisplayed(driver, Signup_AccountUI.DYNAMIC_FIELD, accountField)
                && checkElementIsDisplayed(driver, Signup_AccountUI.TITLE_FORM_REGISTER_ACCOUNT);
    }

    // Form Đăng ký tài khoản - Hàm nhập giá trị cho ô First Name
    public void enterDataToFieldFirstName(String firstName){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, firstNameField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, firstName, firstNameField);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra placeholder của Field First name theo ngôn ngữ hệ thống
    public boolean verifyTextPlaceholderOfFieldFirstName(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,firstNameField);
        String placeholder = getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder", firstNameField);
        String placeHolderByLang ="";
        if(languageSystem.equals("vi")){
            placeHolderByLang = "Tên";
        }
        else if(languageSystem.equals("eng")){
            placeHolderByLang = "";
        }

        if(languageSystem.equals(placeHolderByLang)){
            return true;
        }
        else{
            System.out.println(placeholder);
            return false;
        }
    }

    // Form Đăng ký tài khoản - Hàm nhập giá trị cho ô Last Name
    public void enterDataToFieldLastName(String lastName){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, lastNameField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, lastName, lastNameField);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra placeholder của Field Last name theo ngôn ngữ hệ thống
    public boolean verifyTextPlaceholderOfFieldLastName(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,lastNameField);
        String placeholder = getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder", lastNameField);
        String placeHolderByLang ="";
        if(languageSystem.equals("vi")){
            placeHolderByLang = "Họ";
        }
        else if(languageSystem.equals("eng")){
            placeHolderByLang = "";
        }

        if(languageSystem.equals(placeHolderByLang)){
            return true;
        }
        else{
            System.out.println(placeholder);
            return false;
        }
    }

    // Form Đăng ký tài khoản - Hàm nhập giá trị cho ô Account
    public void enterDataToFieldAccount(String accountName){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, accountField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, accountName, accountField);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra placeholder của Field Account theo ngôn ngữ hệ thống
    public boolean verifyTextPlaceholderOfFieldAccount(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,accountField);
        String placeholder = getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder", accountField);
        String placeHolderByLang ="";
        if(languageSystem.equals("vi")){
            placeHolderByLang = "Điện thoại hoặc Email";
        }
        else if(languageSystem.equals("eng")){
            placeHolderByLang = "Phone number or Email";
        }

        if(languageSystem.equals(placeHolderByLang)){
            return true;
        }
        else{
            System.out.println(placeholder);
            return false;
        }
    }

    // Form Đăng ký tài khoản - Hàm nhập giá trị cho Field Password
    public void enterDataToFieldPassword(String password){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, passwordField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, password, passwordField);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra placeholder của Field Password theo ngôn ngữ hệ thống
    public boolean verifyTextPlaceholderOfFieldPassword(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,accountField);
        String placeholder = getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder", accountField);
        String placeHolderByLang ="";
        if(languageSystem.equals("vi")){
            placeHolderByLang = "Điện thoại hoặc Email";
        }
        else if(languageSystem.equals("eng")){
            placeHolderByLang = "Phone number or Email";
        }

        if(languageSystem.equals(placeHolderByLang)){
            return true;
        }
        else{
            System.out.println(placeholder);
            return false;
        }
    }

    // Form Đăng ký tài khoản - Hàm nhập giá trị cho Field ConfirmPassword
    public void enterDataToFieldConfirmPassword(String confirmPass){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, confirmPassField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, confirmPass, confirmPassField);
    }

    // Form Đăng ký tài khoản - Hàm kiểm tra placeholder của Field ConfirmPassword theo ngôn ngữ hệ thống
    public boolean verifyTextPlaceholderOfFieldConfirmPassword(String languageSystem){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,accountField);
        String placeholder = getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder", accountField);
        String placeHolderByLang ="";
        if(languageSystem.equals("vi")){
            placeHolderByLang = "Điện thoại hoặc Email";
        }
        else if(languageSystem.equals("eng")){
            placeHolderByLang = "Phone number or Email";
        }

        if(languageSystem.equals(placeHolderByLang)){
            return true;
        }
        else{
            System.out.println(placeholder);
            return false;
        }
    }



    public void enterDataToDynamicFieldOnFormSignUp(String nameField , String dataValue){
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD, nameField);
        sendKeyToElement(driver, Signup_AccountUI.DYNAMIC_FIELD, dataValue, nameField);
    }

    public void choosePhoneCodeOnFormSignUp(String countryCode){
        waitForElementClickable(driver, Signup_AccountUI.DROPDOWN_PHONE_CODE);
        selectItemInCustomDropdownByScroll(driver, Signup_AccountUI.DROPDOWN_PHONE_CODE, Signup_AccountUI.DROPDOWN_ITEM_PHONE_CODE,countryCode);
    }

    public String getMessageValidateDynamicFieldOnFormSignUp(String nameField){
        waitElementToVisible(driver, Signup_AccountUI.MESSAGE_VALIDATE_DYNAMIC_FIELD, nameField);
        return getTextElement(driver, Signup_AccountUI.MESSAGE_VALIDATE_DYNAMIC_FIELD, nameField);
    }

    public void clickToButtonSignUp(){
        waitForElementClickable(driver, Signup_AccountUI.BUTTON_SIGNUP);
        clickToElement(driver, Signup_AccountUI.BUTTON_SIGNUP);
    }

    public String getMessageValidateDropdownPhoneCode(){
        waitElementToVisible(driver, Signup_AccountUI.MESSAGE_VALIDATE_DROPDOWN_PHONE_AREA);
        return getTextElement(driver, Signup_AccountUI.MESSAGE_VALIDATE_DROPDOWN_PHONE_AREA);
    }

    public String getUserAccountToDisplay(){
        waitElementToVisible(driver, Signup_AccountUI.CREATED_USERNAME);
        return getTextElement(driver, Signup_AccountUI.CREATED_USERNAME );
    }

    public String getTitleFormVerifyAccount(){
        waitElementToVisible(driver, Signup_AccountUI.TITLE_FORM_VERIFY_ACCOUNT);
        return getTextElement(driver, Signup_AccountUI.TITLE_FORM_VERIFY_ACCOUNT);
    }

    public void enterDataFieldVerifyCode(String verifyCode){
        waitElementToVisible(driver, Signup_AccountUI.FIELD_VERIFY_CODE);
        sendKeyToElement(driver, Signup_AccountUI.FIELD_VERIFY_CODE,verifyCode);
    }

    public void clickToButtonVerify(){
        waitForElementClickable(driver, Signup_AccountUI.BUTTON_VERIFY_ACCOUNT);
        clickToElement(driver, Signup_AccountUI.BUTTON_VERIFY_ACCOUNT);
    }

    public void clickToButtonResendCode(){
        waitForElementClickable(driver, Signup_AccountUI.BUTTON_RESEND_CODE);
        clickToElement(driver, Signup_AccountUI.BUTTON_RESEND_CODE);
    }

    public String getTitleFormVerifyAccountByPhone(String languageSystem){
        String titleByLang = "";
        if(languageSystem == "vi"){
            titleByLang = "";
        }
        else if(languageSystem == "eng"){
            titleByLang = "";
        }
        return titleByLang;
    }

    public String getTitleFormVerifyAccountByEmail(String languageSystem){
        String titleByLang = "";
            if(languageSystem == "vi"){
                titleByLang = "";
            }
            else if(languageSystem == "eng"){
                titleByLang = "";
            }
        return titleByLang;
    }

    public boolean checkFormVerifyAccountByEmailDisplayed(String languageSystem) {
        String formTitle = getPageTitle(driver);
        String titleByLang = getTitleFormVerifyAccountByEmail(languageSystem);
        return titleByLang.equalsIgnoreCase(formTitle) && checkElementIsDisplayed(driver, Signup_AccountUI.FORM_VERIFY_ACCOUNT);
    }

    public boolean checkFormVerifyAccountByPhoneIsDisplayed(String languageSystem) {
        String formTitle = getPageTitle(driver);
        String titleByLang = getTitleFormVerifyAccountByPhone(languageSystem);
        return titleByLang.equalsIgnoreCase(formTitle) && checkElementIsDisplayed(driver, Signup_AccountUI.FORM_VERIFY_ACCOUNT);
    }

    public String getVerifyCodeByEmail(String emailAddress){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, "https://www.mailinator.com/");
        waitElementToVisible(driver, Signup_AccountUI.FIELD_EMAIL);
        sendKeyToElement(driver, Signup_AccountUI.FIELD_EMAIL, emailAddress);
        clickToElement(driver, Signup_AccountUI.BUTTON_SEARCH_EMAIL);
        String email = getEmailWithoutDomain(emailAddress);
        clickToElement(driver, Signup_AccountUI.LINK_EMAIL_VERIFY,email);
        switchToIframeOrFrame(driver, Signup_AccountUI.IFRAME_EMAIL);
        String code = getTextElement(driver, Signup_AccountUI.DATA_VERIFY_CODE);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return code;
    }

    public String getPlaceholderDynamicFieldOnSignUpForm(String dynamicField) {
        waitElementToVisible(driver, Signup_AccountUI.DYNAMIC_FIELD,dynamicField);
        return getAttributeValue(driver, Signup_AccountUI.DYNAMIC_FIELD,"placeholder",dynamicField);
    }

    public String getTextButtonSignUp() {
        waitElementToVisible(driver, Signup_AccountUI.BUTTON_SIGNUP);
        return getTextElement(driver, Signup_AccountUI.BUTTON_SIGNUP);
    }

    public String getColorButtonSignUp(){
        waitElementToVisible(driver, Signup_AccountUI.BUTTON_SIGNUP);
        String colorButton =  getAttributeValue(driver, Signup_AccountUI.BUTTON_SIGNUP ,"background-color");
        return Color.fromString(colorButton).asHex();
    }

    public void enterAllDataOnFormSignup(String firstName, String lastName, String accountName, String password, String confirPass){
        // Nhập giá trị vào field first name
        enterDataToFieldFirstName(firstName);
        // Nhập giá trị vào field last name
        enterDataToFieldLastName(lastName);
        // Nhập giá trị vào field User account
        enterDataToFieldAccount(accountName);
        // Nhập giá trị vào field Password
        enterDataToFieldPassword(password);
        // Nhập giá trị vào field Confirm password
        enterDataToFieldConfirmPassword(confirPass);
    }
    public boolean verifyUIButtonSignUp(String languageSystem){
        String contextButton = getTextElement(driver, Signup_AccountUI.BUTTON_SIGNUP);
        String contextLang = "";
        if(languageSystem == "vi"){
            contextButton = "";
        }else if(languageSystem == "eng"){
            contextButton = "";
        }
        String colorButton = getColorButtonSignUp();

        return contextButton.equals(contextLang) && contextButton.equals("");
    }
    public void signUpWithNewAccountByEmail(String firstName, String lastName, String email, String password, String confirmPass){
        // Step 1 - Nhập tên của người dùng
        enterDataToDynamicFieldOnFormSignUp("nv104", firstName);
        // Step 2 - Nhập họ của người dùng
        enterDataToDynamicFieldOnFormSignUp("nv103", lastName);
        // Step 3 - Nhập email để đăng ký
        enterDataToDynamicFieldOnFormSignUp("nv108", email);
        // Step 4 - Nhập mật khẩu tài khoản
        enterDataToDynamicFieldOnFormSignUp("nv109", password);
        // Step 5 - Xác nhận lại mật khảu
        enterDataToDynamicFieldOnFormSignUp("repeatPassword", confirmPass);
        // Step 6 - Nhấn nút xác nhận đăng ký tài khoản
        clickToButtonSignUp();
        // Step 7 - Xác nhân người dùng đăng ký tài khoản bằng email
        verifyTrue(getTitleFormVerifyAccount().contains(""));
        // Step 8 - Kiểm tra email người dùng nhập ở bước 3 hiển thị chính xác hay không
        verifyEquals(getUserAccountToDisplay(), email);
        // Step 9 - Lấy mã xác minh đăng ký tài khoản và nhập vào ô Mã xác minh
        String code = getVerifyCodeByEmail(email);
        enterDataFieldVerifyCode(code);
        // Step 10 - Nhấn nút xác minh để hoàn tất quy trình đăng ký tài khoản
        clickToButtonVerify();
    }
}
