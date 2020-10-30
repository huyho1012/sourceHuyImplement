package Project.Business.Tour.Management.Detail;

import Interfaces.hahalolo_business.Tour.Management.Detail.Tour_PromotionUI;
import Project.Business.Tour.Management.TourCommonPO;
import org.openqa.selenium.WebDriver;

public class TourPromotionTabPO extends TourCommonPO {
    WebDriver driver;
    public TourPromotionTabPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPromotionTabDislay() {
        waitElementToVisible(driver, Tour_PromotionUI.TOUR_PROMO_TAB);
        return getTextElement(driver, Tour_PromotionUI.TOUR_PROMO_TAB_TITLE).contains("Danh sách khuyến mãi đang áp dụng");
    }

    public String getMessageNotFoundPromo() {
        waitElementToVisible(driver, Tour_PromotionUI.TOUR_PROMO_TAB);
        return getTextElement(driver, Tour_PromotionUI.DATA_NOT_FOUND_MESSAGE);
    }

    public void clickToCreatePromotionButton() {
        scrollToTopPage(driver);
        waitElementToVisible(driver, Tour_PromotionUI.TOUR_PROMO_TAB);
        waitForElementClickable(driver, Tour_PromotionUI.BUTTON_CREATE_PROMO);
        clickToElement(driver, Tour_PromotionUI.BUTTON_CREATE_PROMO);
    }
}
