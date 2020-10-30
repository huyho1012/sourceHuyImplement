package Interfaces.Shared;

public class Choose_Place_ModelUI {
    public static final String MODEL_LOCATION = "//div[contains(@class, 'js-place-modal')]";
    public static final String LIST_LOCATION = "//div[contains(@id,'js-place-modal')]//div[contains(@class,'list-group')]";
    public static final String TITLE_FORM = "//div[contains(@class, 'js-place-modal')]//h5";
    public static final String ADD_LOCATION_BUTTON = "//div[contains(@class, 'js-place-modal')]//button[text() ='Thêm địa điểm']";
    public static final String MAP_CONTENT = "//div[contains(@class,'js-map-content')]";
    public static final String ITEM_LOCATION = "//div[contains(@id,'js-place-modal')]//a[contains(@class,'list-group-item')][position()=1]" ;
    public static final String ITEM_LOCATION_PLACE = "//div[contains(@id,'js-place-modal')]//a[contains(@class,'list-group-item')][position()=1]/h6" ;
}
