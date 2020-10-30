package Interfaces.hahalolo_newsfeed.AccountSetting;


public class Account_GeneralSettingUI {
    public static final String TITLE_PAGE = "//div[@id='%s']//div[@class = 'pageUI-about-heading']";
    public static final String ACCOUNT_SETTING_PAGE = "//div[@class = 'pageUI-header__title']";

    public class MENU{
        public static final String NAVIGATION_MENU = "//nav[contains(@class,'pageUI-nav-column')]";
        public static final String NAVIGATION_ITEM_MENU = "//nav[contains(@class,'pageUI-nav-column')]/a[@href= '%s']";
    }
    public class FULLNAME{
        public static final String TITLE_FUNCTION = "//div[contains(@data-bind,'userProfileVM.fullName')]/ancestor::div/preceding-sibling::label";
        public static final String DATA_DISPLAY = "//div[contains(@data-bind,'userProfileVM.fullName')]";
        public static final String ICON_LOADING_DATA = "//div[@class = 'loading-spinner spinner-border text-primary']" ;
        public static final String BUTTON_EDIT =  "//div[contains(@data-bind,'userProfileVM.fullName')]/parent::div//following-sibling::div//i";
        public static final String MESSSAGE_VALIDATE_CHANGE_FULNAME = "//div[contains(@class,'invalid-feedback')]";

    }
    public class FORM_EDIT_FULLNAME{
        public static final String LABEL_TEXT_FIELD_FIRSTNAME = "//input[@name = 'firstName']/parent::div/preceding-sibling::label/span";
        public static final String TEXT_FIELD_FIRSTNAME = "//input[@name= 'firstName']";
        public static final String MESSAGE_VALIDATE_TEXT_FIELD_FIRSTNAME = "//input[@name = 'firstName']/following-sibling::div";

        public static final String LABEL_TEXT_FIELD_MIDNAME = "//input[@name = 'middleName']/parent::div/preceding-sibling::label";
        public static final String TEXT_FIELD_MIDNAME = "//input[@name = 'middleName']";
        public static final String MESSAGE_VALIDATE_TEXT_FIELD_MIDNAME = "//input[@name = 'middleName']/following-sibling::div";
        public static final String LABEL_FIELD_LASTNAME = "//input[@name = 'lastName']/parent::div/preceding-sibling::label/span";
        public static final String TEXT_FIELD_LASTNAME = "//input[@name = 'lastName']";
        public static final String MESSAGE_VALIDATE_TEXT_FIELD_LASTNAME = "//input[@name = 'lastName']/following-sibling::div";

        public static final String BUTTON_SAVE_CHANGE = "//button[contains(@data-bind,'onConfirmSaveName')]";
        public static final String BUTTON_CANCEL = "//button[contains(@data-bind,'onCancelSaveName')]";
    }

    public class MODEL_CONFIRM_PASSWORD{
        public static final String MODEL_SECTION = "//div[@id = 'modalConfirmPw']";
        public static final String TITLE_MODEL = "//div[@id = 'modalConfirmPw']//span[contains(@data-bind,'titleconfirmPass')]";
        public static final String CONTENT_MODEL = "//div[@id = 'modalConfirmPw']//p[contains(@data-bind,'contentChangeName')]";

        public static final String LABEL_TEXT_FIELD_PASSWORD =  "//input[@name = 'confirmPwd']/parent::div/preceding-sibling::label";
        public static final String TEXT_FIELD_PASSWORD = "//div[@id = 'modalConfirmPw']//input[@name = 'confirmPwd']";
        public static final String MESSAGE_VALIDATE_TEXT_FIELD_PASSWORD = "//div[@id = 'modalConfirmPw']//input[@name = 'confirmPwd']/following-sibling::div[contains(@class, 'invalid-feedback')]";

        public static final String MESSAGE_VALIDATE_CHANGE_PASSWORD = "//p[@id='js-result']";
        public static final String BUTTON_CONFIRM = "//button[@id = 'act-confirm-pwd']";
        public static final String BUTTON_CANCEL = "//button[contains(@data-bind,'onSaveName')]/following-sibling::button";
    }

    public class USERNAME_FUNCTION {
        public static final String TITLE_SECTION = "//div[@id = 'js_body_username']/preceding-sibling::label";
        public static final String URL_USERNAME_DISPlAY = "//a[contains(@data-bind,'baseUrlUsername')]";
        public static final String BUTTON_EDIT = "//div[@id ='js_body_username']//i";
        public static final String NO_USERNAME = "";
        public static final String ICON_LOADING_DATA = "//div[@class = 'loading-spinner spinner-border text-primary']" ;
    }

    public class FORM_EDIT_USERNAME {
        public static final String URL_DISPLAY = "//span[contains(@data-bind,'baseUrlUsername')]";
        public static final String CONTENT_DISPLAY = "//div[@id = 'js_body_username']/following-sibling::form//span[contains(@data-bind,'usernamePublicInfo')]";
        public static final String NOTE_DISPLAY = "//div[@id = 'js_body_username']/following-sibling::form//p";
        public static final String ICON_SUCCESS = "//div[@id='jsLoadMsg']/i[@class ='fa fa-check text-success']";
        public static final String ICON_ERROR = "//div[@id='jsLoadMsg']/i[@class ='ffa fa-times text-danger']";
        public static final String TEXT_FIELD_USERNAME = "//input[contains(@data-bind,'valUsername')]";
        public static final String MESSAGE_VALIDATE_TEXT_FIELD_USERNAME = "//div[@id ='jsLoadMsg']//span";
        public static final String BUTTON_SAVE = "//button[@id = 'js_btn_save_username']";
        public static final String BUTTON_CANCEL = "//button[@id = 'js_btn_save_username']/following-sibling::button";

    }











}
