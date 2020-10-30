package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.Create_Edit_PromoUI;
import org.openqa.selenium.WebDriver;

public class TourPromotionPO extends PromotionPO {
    WebDriver driver;
    public TourPromotionPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void enterTourNameForSeacrching(String tourName){
        waitElementToVisible(driver, Create_Edit_PromoUI.SEARCH_TOUR_FIELD);
        sendKeyToElement(driver, Create_Edit_PromoUI.SEARCH_TOUR_FIELD, tourName);
        setTimeDelay(1);
    }

    public void clickToSeacrhTour(String tourName){
        waitElementToVisible(driver, Create_Edit_PromoUI.BUTTON_SEARCH_TOUR);
        clickToElement(driver, Create_Edit_PromoUI.BUTTON_SEARCH_TOUR);
        setTimeDelay(1);
    }

    public void addRedicrectTourTrToSelectedApplyPromo(String tourName){
        waitElementToVisible(driver, Create_Edit_PromoUI.ICON_ADD_DIRECT_TOUR);
        clickToElement(driver, Create_Edit_PromoUI.ICON_ADD_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }
    public void removeTourOnSelectedApplyPromo(String tourName){
        waitElementToVisible(driver, Create_Edit_PromoUI.BUTTON_REMOVE_DIRECT_TOUR);
        clickToElement(driver, Create_Edit_PromoUI.BUTTON_REMOVE_DIRECT_TOUR,tourName);
        setTimeDelay(1);
    }

    public void chooseTypeTour(String typeTour){
        waitElementToVisible(driver, Create_Edit_PromoUI.TYPE_TOUR_OPTION);
        clickToElement(driver, Create_Edit_PromoUI.TYPE_TOUR_OPTION,typeTour);
        setTimeDelay(1);
    }

    public void chooseTopicTour(String topicTour){
        waitElementToVisible(driver, Create_Edit_PromoUI.TOPIC_TOUR_OPTION);
        clickToElement(driver, Create_Edit_PromoUI.TOPIC_TOUR_OPTION,topicTour);
        setTimeDelay(1);
    }

    public void chooseExceedTour(String tourName){
        waitElementToVisible(driver, Create_Edit_PromoUI.EXCEED_TOUR_ITEM);
        clickToElement(driver, Create_Edit_PromoUI.EXCEED_TOUR_ITEM,tourName);
        setTimeDelay(1);
    }


    public void clickIconAddTourToSelectedList(String tourName) {
        waitElementToVisible(driver, Create_Edit_PromoUI.PROMOTION_SIMPLE_MODE);
        waitElementToVisible(driver, Create_Edit_PromoUI.ICON_ADD_DIRECT_TOUR, tourName);
        clickToElement(driver, Create_Edit_PromoUI.ICON_ADD_DIRECT_TOUR, tourName);
        setTimeDelay(1);
    }



    public boolean getPromotionDisountLevel() {
        return true;
    }
}
