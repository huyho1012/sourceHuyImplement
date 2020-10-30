package Project.Business.Promotion;

import Interfaces.Shared.Media_ManagementUI;
import Interfaces.hahalolo_business.Promotion.Create_Edit_PromoUI;
import Project.Business.Tour.Management.TourCommonPO;
import Project.Shared.MediaManagementPO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PromotionPO extends TourCommonPO {
    WebDriver driver;
    MediaManagementPO media;

    public PromotionPO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public void publicPromotion(){
        scrollToTopPage(driver);
        waitForElementClickable(driver, Create_Edit_PromoUI.PROMO_STATUS_MODE);
        clickToElement(driver, Create_Edit_PromoUI.PROMO_STATUS_MODE);
    }

    public void unpublicPromo(){
        waitForElementClickable(driver, Create_Edit_PromoUI.PROMO_STATUS_MODE);
        clickToElement(driver, Create_Edit_PromoUI.PROMO_STATUS_MODE);
    }
    public void enterPromoName(String promoName) {
        waitElementToVisible(driver, Create_Edit_PromoUI.PROMO_NAME_FIELD);
        sendKeyToElement(driver, Create_Edit_PromoUI.PROMO_NAME_FIELD,promoName);
    }

    public void enterPromoDesc(String promoDesc) {
        waitElementToVisible(driver, Create_Edit_PromoUI.PROMO_DESC_TEXTAREA);
        sendKeyToElement(driver, Create_Edit_PromoUI.PROMO_DESC_TEXTAREA,promoDesc);
    }

    public void chooseLanguagePromotion(String language) {
        selectItemInCustomDropdownByScroll(driver, Create_Edit_PromoUI.LANGUAGE_DROPDOWN, Create_Edit_PromoUI.LANGUAGE_ITEM,language);
    }
    public void chooseCurrencyPromotion(String currency) {
        selectItemInCustomDropdownByScroll(driver, Create_Edit_PromoUI.CURRENCY_DROPDOWN, Create_Edit_PromoUI.CURRENCY_ITEM,currency);
    }

    public void enterDateRangeApply(String dateRange){
        waitForElementClickable(driver, Create_Edit_PromoUI.PROMOTION_DATE_RANGE);
        sendKeyToElement(driver, Create_Edit_PromoUI.PROMOTION_DATE_RANGE, dateRange);
        sendKeyBoardToElement(driver, Create_Edit_PromoUI.PROMOTION_DATE_RANGE, Keys.ENTER);
        setTimeDelay(1);
    }

    public void clickAddImagePromo(String fileImage){
        waitForElementClickable(driver, Create_Edit_PromoUI.BUTTON_ADD_PROMO_IMAGE);
        clickToElement(driver, Create_Edit_PromoUI.BUTTON_ADD_PROMO_IMAGE);
        media = new MediaManagementPO(driver);
        media.uploadImageFromLocalToMedia(driver,fileImage);
        waitElementToVisible(driver, Media_ManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver, Media_ManagementUI.BUTTON_SELECT);
        clickToElement(driver, Media_ManagementUI.BUTTON_SELECT);
    }

    public void chooseTypeDiscount(int numOption) {
        clickToElement(driver, Create_Edit_PromoUI.TITlE_HEADER);
        switch(numOption){
            case 1:
                waitForElementClickable(driver, Create_Edit_PromoUI.DISCOUNT_TOTAL_ORDER);
                clickToElement(driver, Create_Edit_PromoUI.DISCOUNT_TOTAL_ORDER);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, Create_Edit_PromoUI.DISCOUNT_PER_ADULT);
                clickToElement(driver, Create_Edit_PromoUI.DISCOUNT_PER_ADULT);
                setTimeDelay(1);
                break;
            default:
                break;
        }
    }

    public void chooseTypePromo(int numOption) {
        clickToElement(driver, Create_Edit_PromoUI.TITlE_HEADER);
        switch(numOption){
            case 1:
                waitForElementClickable(driver, Create_Edit_PromoUI.FIXED_AMOUNT);
                clickToElement(driver, Create_Edit_PromoUI.FIXED_AMOUNT);
                setTimeDelay(1);
                break;
            case 2:
                waitForElementClickable(driver, Create_Edit_PromoUI.PERCENT_ORIGINAL_PRICE);
                clickToElement(driver, Create_Edit_PromoUI.PERCENT_ORIGINAL_PRICE);
                setTimeDelay(1);
                break;
           default:
               break;
        }
    }

    public void enterDiscountAmount(String discountAmount) {
        waitElementToVisible(driver, Create_Edit_PromoUI.DISCOUNT_AMOUNT);
        sendKeyToElement(driver, Create_Edit_PromoUI.DISCOUNT_AMOUNT, discountAmount);
    }

    public void enterMinOrderValue(String minOrderValue) {
        waitElementToVisible(driver, Create_Edit_PromoUI.MIN_ORDER_VALUE);
        sendKeyToElement(driver, Create_Edit_PromoUI.MIN_ORDER_VALUE, minOrderValue);
    }

    public void enterMinAdultPerson(String minAdultPer) {
        waitElementToVisible(driver, Create_Edit_PromoUI.MIN_ADULT_PEOPLE);
        sendKeyToElement(driver, Create_Edit_PromoUI.MIN_ADULT_PEOPLE, minAdultPer);
    }

    public void chooseModeAdvance(){
        if(checkStatusOfModeButton()){
            waitForElementClickable(driver, Create_Edit_PromoUI.APPLY_MODE);
            clickToElement(driver, Create_Edit_PromoUI.APPLY_MODE);
        }
    }

    public void chooseModeSimple(){
        waitForElementClickable(driver, Create_Edit_PromoUI.APPLY_MODE);
        clickToElement(driver, Create_Edit_PromoUI.APPLY_MODE);
    }

    private boolean checkStatusOfModeButton() {
        return true;
    }

    public void clickSaveButton(){
        waitForElementClickable(driver, Create_Edit_PromoUI.BUTTON_SAVE_PROMO);
        clickToElement(driver, Create_Edit_PromoUI.BUTTON_SAVE_PROMO);
    }

    public void clickTOAddPromoLevel(){
        waitForElementClickable(driver, Create_Edit_PromoUI.ICON_ADD_PROMO_LEVEL);
        clickToElement(driver, Create_Edit_PromoUI.ICON_ADD_PROMO_LEVEL);
    }


    public String getPromotionNameDisplayOnPromoDetail() {
        return null;
    }
    public String getPromotionDescDisplayOnPromoDetail() {
        return null;
    }

    public Object getPromotionStatusDisplayOnPromoDetail() {
        return null;
    }

    public Object getPromotionLanguageDisplayOnPromoDetail() {
        return null;
    }


    public String getTextOfDiscountType(int numOption) {
        clickToElement(driver, Create_Edit_PromoUI.TITlE_HEADER);
        if(numOption == 1)
            return getTextElement(driver, Create_Edit_PromoUI.DISCOUNT_TOTAL_ORDER);
        else if(numOption == 2)
            return getTextElement(driver, Create_Edit_PromoUI.DISCOUNT_PER_ADULT);
        else
            return null;
    }

    public String getTextOfPromoType(int numOption) {
        clickToElement(driver, Create_Edit_PromoUI.TITlE_HEADER);
        if(numOption == 1)
            return getTextElement(driver, Create_Edit_PromoUI.FIXED_AMOUNT);
        else if(numOption == 2)
            return getTextElement(driver, Create_Edit_PromoUI.PERCENT_ORIGINAL_PRICE);
        else
            return null;
    }
}
