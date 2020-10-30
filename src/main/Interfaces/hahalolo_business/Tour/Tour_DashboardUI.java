package Interfaces.hahalolo_business.Tour;

public class Tour_DashboardUI {
    public static final String TEXT_PAGE_NAME_ON_DASHBOARD = "//span[contains(@data-bind,'pageName')]" ;
    public static final String TOUR_DASHBOARD_PAGE = "//main[@class = 'business-dashboard']";
    public static final String ITEM_ON_TOUR_BUSINESS = "//div[contains(@class,'menu-management')]//a[contains(text(),'%s')]";
    public static final String BUTTON_CREATE_TOUR = "//span[contains(@data-bind,'tour.btnViewlist')]/ancestor::a/following-sibling::button[contains(@data-bind,'tour.btnCreate')]";
    public static final String POPUP_BUTTON_CANCEL = "//button[contains(@data-bind,'common.btn_cancel')]";

    //POPUP CREATE TOPIC
    public static final String POPUP_CREATE_TOPIC_NAME = "//input[contains(@data-bind,'tour.topic.name')]";
    public static final String POPUP_CREATE_TOPIC_ALERT_NAME = "//input[contains(@data-bind,'tour.topic.name')]/following-sibling::div";
    public static final String POPUP_CRAETE_TOPIC_DESCRIPTION = "//textarea[contains(@data-bind,'tour.topic.description')]";
    public static final String POPUP_CREATE_TOPIC_BUTTON_SAVE = "//button[contains(@data-bind,'click: onCreateNewTopic, i18n')]";

    //POPUP CREATE TOUR
    public static final String POPUP_CREATE_TOUR_TEXTBOX_NAME = "//input[contains(@data-bind,'value: tv151')]";
    public static final String POPUP_CREATE_TOUR_TYPE_TOUR_INLAND = "//select[contains(@data-bind, 'value: tn120')]/option[@value='0']";
    public static final String POPUP_CREATE_TOUR_TYPE_TOUR_INTERNATIONAL = "//select[contains(@data-bind, 'value: tn120')]/option[@value='1']";
    public static final String POPUP_CREATE_TOUR_TOPIC = "//select[@name='pt550']";
    public static final String POPUP_CREATE_TOUR_BUTTON_SAVE = "//button[contains(@data-bind,'onCreateNewTour, i18n')]";
    public static final String POPUP_CREATE_TOUR_ALERT_NAME = "//input[contains(@data-bind,'value: tv151')]/following-sibling::div";
    public static final String POPUP_CREATE_TOUR_ALERT_TOPIC_TOUR = "//select[@name='pt550']/following-sibling::div";
}
