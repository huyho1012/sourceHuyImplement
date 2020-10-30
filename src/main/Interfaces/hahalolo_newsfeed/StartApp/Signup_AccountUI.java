package Interfaces.hahalolo_newsfeed.StartApp;

public class Signup_AccountUI {
    // Form SignUp Account
    public static final String FORM_REGISTER_ACCOUNT = "//form[@id = 'signup_form']";
    public static final String TITLE_FORM_REGISTER_ACCOUNT = "//div[@class = 'form-signup-header']/div";
    public static final String DYNAMIC_FIELD = "//input[@name = '%s']";
    public static final String MESSAGE_VALIDATE_DYNAMIC_FIELD = "//input[@name = '%s']/following-sibling::*[contains(@class,'invalid-feedback')]";
    public static final String MESSAGE_VALIDATE_DROPDOWN_PHONE_AREA = "//select[@id = 'select-phone-code']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String DROPDOWN_PHONE_CODE ="//select[@id = 'select-phone-code']/following-sibling::div//input";
    public static final String DROPDOWN_ITEM_PHONE_CODE ="//select[@id = 'select-phone-code']/following-sibling::div//div[@class = 'item']";
    public static final String BUTTON_SIGNUP = "//button[@id='signUpButton']";
    // Mailinator
    public static final String FIELD_EMAIL = "//input[@id = 'addOverlay']";
    public static final String BUTTON_SEARCH_EMAIL = "//button[@id = 'go-to-public']";
    public static final String LINK_EMAIL_VERIFY = "//tr[contains(@id,'%s')][1]/td[3]";
    public static final String IFRAME_EMAIL = "//iframe[@id='msg_body']" ;
    public static final String DATA_VERIFY_CODE = "//td/h2";
    // Form verify account
    public static final String FORM_VERIFY_ACCOUNT = "//div[contains(@data-bind,'active-confirm-code')]";
    public static final String CREATED_USERNAME = "//p[contains(@data-bind, 'dataVM.nv108')]/b";
    public static final String TITLE_FORM_VERIFY_ACCOUNT ="//h3[contains(@data-bind,'dataVM.type_acc')]";
    public static final String FIELD_VERIFY_CODE = "//input[@name ='code']";
    public static final String BUTTON_VERIFY_ACCOUNT = "//button[contains(@data-bind,'verifyAcc')]";
    public static final String BUTTON_RESEND_CODE = "//button[@id = 'btnResendCode']" ;
}