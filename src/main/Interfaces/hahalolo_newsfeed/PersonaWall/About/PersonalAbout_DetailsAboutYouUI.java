package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PersonalAbout_DetailsAboutYouUI {
    public static final String TITLE_DETAIL_ABOUT_SECTION = "//span[contains(@data-bind,'userAbout.detailTab.title')]";
    public static final String BUTTON_WRITE_ABOUT_YOURSEFT = "//div[contains(@data-bind,'doOpen.formAddAboutYou')]//a";
    public static final String BUTTON_EDIT_ABOUT = "//button[contains(@data-bind,'doOpen.formAddAboutYou')]";
    public static final String ABOUT_DATA = "//p[contains(@data-bind,'contactAndBasicInfoVM.nv211_2')]";
    public static final String FORM_ADD_EDIT_ABOUT = "//div[contains(@data-bind,'isShowFormAddAboutYou')]";
    public static final String LABEL_TEXTAREA_ABOUT =  "//textarea[@name = 'nv211_2']/parent::div/preceding-sibling::label";
    public static final String TEXTAREA_ABOUT = "//textarea[@name = 'nv211_2']";
    public static final String MESSAGE_VALIDATE_OF_ABOUT = "//textarea[@name = 'nv211_2']/following-sibling::div" ;
    public static final String BUTTON_SAVE_ABOUT = "//button[@id = 'act-add-introduce-yourself']";
    public static final String BUTTON_CANCEL_SAVE_ABOUT = "//button[contains(@data-bind,'doCancel.addAboutYou')]";

    public static final String TITLE_OTHER_NAME_SECTION = "//div[contains(@data-bind,'common.name.other')]";
    public static final String BUTTON_ADD_NEW_OTHER_NAME ="//div[contains(@data-bind,'doOpen.formAddOtherName')]";
    public static final String BUTTON_EDIT_OTHER_NAME = "//button[contains(@data-bind,'doOpen.formAddOtherName')]";
    public static final String OTHER_NAME_DATA = "//p[contains(@data-bind,'nv213_2')]";
    public static final String FORM_ADD_EDIT_OTHER_NAME = "//div[contains(@data-bind,'isShowFormAddOtherName')]";
    public static final String LABEL_FIELD_OTHER_NAME =  "//input[@name = 'nv213_2']/parent::div/preceding-sibling::label";
    public static final String FIELD_OTHER_NAME = "//input[@name = 'nv213_2']";
    public static final String MESSAGE_VALIDATE_OTHER_NAME = "//input[@name = 'nv213_2']/following-sibling::div" ;
    public static final String BUTTON_SAVE_OTHER_NAME= "//button[contains(@data-bind,'doAdd.otherName')]";
    public static final String BUTTON_CANCEL_SAVE_OTHER_NAME = "//button[contains(@data-bind,'doCancel.addOtherName')]";

    public static final String BUTTON_ADD_NEW_FAVORITE_QUOTE = "//div[contains(@data-bind,'doOpen.formAddFavorite')]";
    public static final String BUTTON_EDIT_FAVORITE_QUOTE = "//button[contains(@data-bind,'doOpen.formAddFavorite')]";
    public static final String FAVORITE_QUOTE_DATA = "//p[contains(@data-bind,'contactAndBasicInfoVM.nv212_2')]";
    public static final String FORM_ADD_EDIT_FAVORITE_QUOTES = "//div[contains(@data-bind,'isShowFormAddFavorite')]";
    public static final String LABEL_TEXTAREA_FAVORITE_QUOTES =  "//textarea[@name = 'nv211_2']/parent::div/preceding-sibling::label";
    public static final String TEXTAREA_FAVORITE_QUOTE = "//textarea[@name = 'nv212_2']";
    public static final String MESSAGE_VALIDATE_FAVORITE_QUOTE = "//textarea[@name = 'nv212_2']/following-sibling::div";
    public static final String BUTTON_SAVE_FAVORITE_QUOTE= "//button[@id = 'act-add-favorite-quotes']";
    public static final String BUTTON_CANCEL_SAVE_FAVORITE_QUOTE ="//button[contains(@data-bind,'doCancel.addFavorite')]";



}
