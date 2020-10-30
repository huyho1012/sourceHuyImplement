package Interfaces.hahalolo_business.Tour.Management.Detail;

public class Tour_InfoUI {
    public static final String TAB_INFORMATION = "//div[@id='tour-information']";
    public static final String TEXT_HEADER_TITLE = "//span[contains(@data-bind,'tourInfoVM.tv151')]";

    public static final String DROPDOWN_LANGUAGE = "//select[contains(@data-bind,'langChoose')]/following-sibling::div//div[contains(@class,'selectize-input')]";
    public static final String ITEM_LANGUAGE = "//select[contains(@data-bind,'langChoose')]/following-sibling::div//div[@class ='option']" ;
    public static final String DROPDOWN_CURRENCY = "//select[contains(@data-bind,'currencyChoose')]/following-sibling::div//div[contains(@class,'selectize-input')]";
    public static final String ITEM_CURRENCY = "//select[contains(@data-bind,'currencyChoose')]/following-sibling::div//div[@class ='option']";

    public static final String DYNAMIC_FIELD_TAB_INFO = "//div[@id='tour-information']//input[@name ='%s']";
    public static final String DYNAMIC_FIELD_ALERT = "//div[@id='tour-information']//input[@name ='%s']/following-sibling::div[contains(@class,'invalid-feedback')]";

    public static final String DYNAMIC_DROPDOWN_INPUT = "//div[@id='tour-information']//select[@name ='%s']/following-sibling::div/div[contains(@class,'selectize-input')]/input";
    public static final String DYNAMIC_DROPDOWN = "//div[@id='tour-information']//select[@name ='%s']/following-sibling::div";
    public static final String ITEM_IN_DYNAMIC_DROPDOWN = "//div[@id='tour-information']//select[@name ='%s']/following-sibling::div/div[contains(@class,'selectize-dropdown')]/div/div";
    public static final String SELECTED_ITEM_IN_DYNAMIC_DROPDOWN = "//div[@id='tour-information']//select[@name ='%s']/following-sibling::div//div[@class='item']";

    public static final String DYNAMIC_DROPDOWN_ALERT = "//div[@id='tour-information']//select[@name ='%s']/following-sibling::div[contains(@class,'invalid-feedback')]";

    public static final String TEXTAREA_SHORT_DESCRIPTION = "//textarea[@name ='tv159']";
    public static final String DYNAMIC_TEXTAREA = "//label[contains(@data-bind,'%s')]/following-sibling::div//div[contains(@class,'note-editable')]";

    public static final String LABEL_INTERNATIONAL_TOUR = "//label[@for='isForeignTour']";
    public static final String LABEL_MERGE_TOUR = "//label[@for='canMergeTour']";
    public static final String CHECKBOX_INTERNATIONAL_TOUR = "//input[@id='isForeignTour']";
    public static final String CHECKBOX_MERGE_TOUR = "//input[@id='canMergeTour']";

    public static final String BUTTON_GPS = "//button[@data-bind='click: onSearch']";
    public static final String MODAL_PLACE = "//div[contains(@class,'js-place-modal')]//div[@class='modal-content']";
    public static final String MODAL_PLACE_MAP = "//div[@class='gm-style']";
    public static final String MODAL_PLACE_ALL_ADDRESS = "//div[@class='list-group list-group-flush']/a";
    public static final String MODAL_PLACE_TITLE_ADDRESS = "//div[@class='list-group list-group-flush']/a[position()='%s']/h6";
    public static final String MODAL_PLACE_SUB_ADDRESS = "//div[@class='list-group list-group-flush']/a[position()='%s']/div";
    public static final String MODAL_PLACE_BUTTON_ADD_ADDRESS = "//button[contains(@class,'js-btn-choose')]";

    public static final String BUTTON_UPLOAD = "//button[contains(@data-bind,'%s')]";
    public static final String TEXT_TITLE_LOGO = "//label[contains(@data-bind,'logo')]";
    public static final String TEXT_TITLE_COVER = "//label[contains(@data-bind,'cover')]";
    public static final String TEXT_TITLE_ALBUM = "//label[contains(@data-bind,'gallery')]";
    public static final String BUTTON_UPLOAD_LOGO = "//button[contains(@data-bind,'uploadLogo')]";
    public static final String BUTTON_UPLOAD_COVER_IMAGE = "//button[contains(@data-bind,'uploadCover')]";
    public static final String BUTTON_UPLOAD_GALLERY = "//button[contains(@data-bind,'uploadGalleries')]";

    public static final String IMAGE_LOGO = "//label[contains(@data-bind,'logo')]/following-sibling::div/div";
    public static final String IMAGE_COVER = "//label[contains(@data-bind,'cover')]/following-sibling::div/div/img";
    public static final String BUTTON_REMOVE_IMAGE = "//label[contains(@data-bind,'%s')]/following-sibling::div//button";
    public static final String IMAGE_ON_GALLERY = "//label[contains(@data-bind,'gallery')]/following-sibling::div/div";

    public static final String ALERT_SHORT_DESCRIPTION = "//textarea[@name ='tv159']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String ALERT_DYNAMIC_TEXT_AREA = "//label[contains(@data-bind,'%s')]/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String ALERT_IMAGE = "//label[contains(@data-bind,'%s')]/following-sibling::div/following-sibling::div/span";

    public static final String BUTTON_SAVE_TOUR_ON_BOTTOM = "//button[contains(@data-bind,'tourFormVM.onSaveInfo')]";
    public static final String BUTTON_SAVE_TOUR_ON_HEADER = "//button[contains(@data-bind,'onSaveTourDetail')]";

    public static final String TOAST_MESSAGE = "//div[@id='toast-container']//div[@data-bind='text: msg']";
    public static final String BUTTON_CLOSE_MESSAGE_TOAST = "//div[@id='toast-container']//button";
}
