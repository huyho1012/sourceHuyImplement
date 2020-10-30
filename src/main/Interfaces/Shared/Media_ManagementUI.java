package Interfaces.Shared;

public class Media_ManagementUI {

    public static final String MEDIA_MANAGEMENT_POPUP = "//div[@id= 'view-media-manager']";
    public static final String UPLOAD_BUTTON = "//button[contains(@data-bind,'onUpload')]";
    public static final String BUTTON_SELECT = "//button[contains(@data-bind,'onSelectMedia')]";


    public static final String ROOT_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[contains(@class,'media-list__item')][position()= '1']//div[@class='media-list__thumb']";
    public static final String ROOT_LIST_IMAGE = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[@class='media-list']";
    public static final String PROCESSING_BAR = "//div[contains(@data-bind,'onCreateAlbum')]/ancestor::div[@id ='media-album-area']/following-sibling::div//div[contains(@class,'media-list__item')][position()= '1']//div[@class='media-list__thumb']//div[contains(@data-bind,'text: progress()')][contains(text(),'100%')]";

    public static final String LIST_IMAGE_ON_MEDIA_MANAGER = "//span[text()='Media']/following::div[@class='media-list']/div/div[@class='media-list__thumb']";
    public static final String IMAGE_ON_MEDIA_MANAGER_IMAGE = "//span[text()='Media']/following::div[@class='media-list']/div[position()= '%s']/div[@class='media-list__thumb']";

    public static final String BUTTON_CLOSE = "//button[@id='js_btn_close_media_manager']/span";
}
