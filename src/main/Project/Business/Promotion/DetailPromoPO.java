package Project.Business.Promotion;

import Interfaces.hahalolo_business.Promotion.Promotion_DetailUI;
import org.openqa.selenium.WebDriver;

public class DetailPromoPO extends PromotionPO {
    WebDriver driver;
    public DetailPromoPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }
    public boolean checkViewDetailPromotionDisplay() {
        return true;
    }

    public String getPromoNameOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_NAME);
    }

    public String getPromoDescOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_DESC);
    }

    public String getStatusOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_STATUS);
    }

    public String getLanguageOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_LANGUAGE);
    }

    public String getCurrencyOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_LANGUAGE);
    }

    public String getDateRangeOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_APPLY_TIME);
    }

    public String geDiscountTypeOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.DISCOUNT_TYPE);
    }

    public String getPromoTypeOnDetail() {
        return getTextElement(driver, Promotion_DetailUI.PROMO_TYPE);
    }

    public String getTourTypeAppliedOnDetail() {
        return null;
    }

    public String getListTourAppliedOnPromoDetail() {
        return null;
    }

}
