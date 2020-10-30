package Interfaces.hahalolo_newsfeed.StartApp;

public class LoginUI {

    public static final String FORM_LOGIN_BACKEND_CENSOR = "//signin-signup//div[@class = 'card-body']";
    public static final String FORM_LOGIN_WALLET = "//form[@id = 'signin_form']";

    public static final String LINK_FORGOT_PASSWORD = "//a[@class='forgotpw']";
    public static final String BUTTON_LOGIN ="//button[(text() = 'Đăng nhập')]";

    public static final String FIELD_USER_NAME = "//input[@name = 'identity']";
    public static final String FIELD_PASSWORD = "//input[@name = 'password']";
    public static final String FIELD_CAPTCHA_CODE = "//input[@id='captchaCode']";
    public static final String IMAGE_CAPTCHA_CODE = "";
    public static final String ICON_RESET_CAPTCHA_CODE = "//button[contains(@data-bind,'refreshCaptcha')]";

    public static final String MESSAGE_VALIDATE_FIELD_USERNAME = "//input[@name = 'identity']/following-sibling::div";
    public static final String MESSAGE_VALIDATE_FIELD_PASSWORD = "//input[@name = 'password']/following-sibling::div";
    public static final String MESSAGE_VALIDATE_FIELD_CAPTCHA_CODE = "//input[@id = 'captchaCode']/following-sibling::div";

}
