package Project.Newsfeed.Newsfeed;

import Interfaces.hahalolo_newsfeed.Homepage.Newsfeed_HomePageUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class NewsfeedHomepagePO extends HeaderPagePO {
    WebDriver driver;
    public NewsfeedHomepagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    // Chức năng Cập nhật thông tin tài khoản
    public boolean checkPopupUpdateInformationIsDisplayed() {
        waitElementToVisible(driver, Newsfeed_HomePageUI.UPDATE_INFO_BUTTON);
        return checkElementIsDisplayed(driver, Newsfeed_HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public String getTitlePopupUpdateInformation() {
        if(checkPopupUpdateInformationIsDisplayed()){
            return getTextElement(driver, Newsfeed_HomePageUI.FORM_UPDATE_NEW_INFO_TITLE);
        }
        return null;
    }

    public void chooseBirthdayOnPopUpUpdateInformation(String dayItem, String monthItem, String yearItem) {
        selectItemInCustomDropdown(driver, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_ITEM,dayItem,"day");
        setTimeDelay(1);
        selectItemInCustomDropdown(driver, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_ITEM,monthItem,"month");
        setTimeDelay(1);
        selectItemInCustomDropdown(driver, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_DROPDOWN, Newsfeed_HomePageUI.DYNAMIC_BIRTHDAY_ITEM,yearItem,"year");
        setTimeDelay(1);
    }

    public void chooseGenderOnPopupUpdateInformation(String valueGender) {
        waitForElementClickable(driver, Newsfeed_HomePageUI.GENDER_OPTION,valueGender);
        clickToElement(driver, Newsfeed_HomePageUI.GENDER_OPTION,valueGender);
    }
    public String getGenderBySelectedOption(String valueGender) {
        return getTextElement(driver, Newsfeed_HomePageUI.GENDER_OPTION,valueGender);
    }

    public void chooseNationalityOnPopupUpdateInformation(String countryName) {
        selectItemInCustomDropdownByScroll(driver, Newsfeed_HomePageUI.COUNTRY_DROPDOWN, Newsfeed_HomePageUI.COUNTRY_ITEM, countryName);
    }

    public void clickToButtonConfirmOnPopupUpdateInformation() {
        waitForElementClickable(driver, Newsfeed_HomePageUI.UPDATE_INFO_BUTTON);
        clickToElement(driver, Newsfeed_HomePageUI.UPDATE_INFO_BUTTON);
    }

    public void clickToButtonCancelOnPopupUpdateInformation() {
        waitForElementClickable(driver, Newsfeed_HomePageUI.CANCEL_UPDATE_INFO);
        clickToElement(driver, Newsfeed_HomePageUI.CANCEL_UPDATE_INFO);
    }

    public void updateNewInformationOfAccount(String dayItem, String monthItem, String yearItem, String gender, String nationality){
        chooseBirthdayOnPopUpUpdateInformation(dayItem,monthItem,yearItem);
        setTimeDelay(1);
        chooseGenderOnPopupUpdateInformation(gender);
        setTimeDelay(1);
        chooseNationalityOnPopupUpdateInformation(nationality);
        setTimeDelay(1);
        clickToButtonConfirmOnPopupUpdateInformation();
    }

    // Function on Footer right bar
    public void changeLanguageNewsfeedToVI() {
        waitForElementClickable(driver, Newsfeed_HomePageUI.FOOTER_VI_LANGUAGE);
        clickToElement(driver, Newsfeed_HomePageUI.FOOTER_VI_LANGUAGE);
    }

    public void changeLanguageNewsfeedToEng() {
        waitForElementClickable(driver, Newsfeed_HomePageUI.FOOTER_ENG_LANGUAGE);
        clickToElement(driver, Newsfeed_HomePageUI.FOOTER_ENG_LANGUAGE);
    }

    public void clickIconChangeCurrencyOnRightBar(){
        waitForElementClickable(driver, Newsfeed_HomePageUI.FOOTER_CHANGE_CURRENCY);
        clickToElement(driver, Newsfeed_HomePageUI.FOOTER_CHANGE_CURRENCY);
    }

    public String getCurrencyDisplayOnRightBar(){
        waitElementsToVisible(driver, Newsfeed_HomePageUI.FOOTER_CURRENCY);
        return getTextElement(driver, Newsfeed_HomePageUI.FOOTER_CURRENCY);
    }

    public void clickToItemNavLinkOnFooter(String tabItem){
        waitForElementClickable(driver, Newsfeed_HomePageUI.FOOTER_NAV_LINK);
        clickToElement(driver, Newsfeed_HomePageUI.FOOTER_NAV_LINK);
    }

    // Newsfeed section
    public boolean checkNewsfeedHomepageIsDisplayed(String languageSystem){
        waitElementToVisible(driver, Newsfeed_HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        String urlNewsfeed = "https://test-newsfeed.hahalolo.com/";
        String currentURL = getCurrentURL(driver);
        String titleTab = getPageTitle(driver);
        String getTitleByLang = "";

        if(languageSystem == "vi"){
            getTitleByLang = "Bảng tin | Hahalolo";
        }else if (languageSystem == "eng"){
            getTitleByLang = "";
        }

        return currentURL.equalsIgnoreCase(urlNewsfeed)
                && titleTab.equalsIgnoreCase(getTitleByLang)
                && checkElementIsDisplayed(driver, Newsfeed_HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
    }

    public boolean checkNewsfeedHomepageIsDisplayAfterRegisterAccount(String languageSystem) {
        return checkNewsfeedHomepageIsDisplayed(languageSystem)
                && checkElementIsDisplayed(driver, Newsfeed_HomePageUI.FORM_UPDATE_NEW_INFO);
    }

    public void clickToTabItemOnNewsfeedNavigationMenu(String tabItem) {
        waitElementToVisible(driver, Newsfeed_HomePageUI.NAV_MENU);
        waitForElementClickable(driver, Newsfeed_HomePageUI.NAV_ITEM_MENU);
        clickToElement(driver, Newsfeed_HomePageUI.NAV_ITEM_MENU);
    }

    // Function on Widget My account
    public String getFullNameDisplayOnWidgetMyAccount() {
        waitElementToVisible(driver, Newsfeed_HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        return getTextElement(driver, Newsfeed_HomePageUI.MY_ACCOUNT_FULL_NAME);
    }

    public void clickToLinkEditProfileOnWidgetMyAccount() {
        waitForElementClickable(driver, Newsfeed_HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
        clickToElement(driver, Newsfeed_HomePageUI.MY_ACCOUNT_EDIT_PROFILE_BUTTON);
    }

    public void clickToItemTabOnWidgetMyAccount(String tabItem){
        waitForElementClickable(driver, Newsfeed_HomePageUI.MY_ACCOUNT_TAB_MENU);
        clickToElement(driver, Newsfeed_HomePageUI.MY_ACCOUNT_TAB_MENU,tabItem);
    }

    // Function Change Currency
    public boolean checkModelCurrencyCloseSuccess() {
        return true;
    }

    public String getCurrencyCodeDisplayOnHeader() {
        return null;
    }

    public Object getCurrencySymbolOnTourProduct() {
        return null;
    }


    public Object getCurrencySymbolOnHotelProduct() {
        return null;
    }

    public Object getCurrencySymbolOnShoppingProductPost() {
        return null;
    }


    public void clickToOpenNormalPostEditor(){
        waitElementToVisible(driver, Newsfeed_HomePageUI.NORMAL_EDITOR_FUNCTION);
        clickToElement(driver, Newsfeed_HomePageUI.NORMAL_EDITOR_FUNCTION);
    }


    public void clickToOpenExperiencePostEditor(){
        waitElementToVisible(driver, Newsfeed_HomePageUI.EXPERIENCE_EDITOR_FUNCTION);
        clickToElement(driver, Newsfeed_HomePageUI.EXPERIENCE_EDITOR_FUNCTION);
    }

    public void clickToIconSearchExperience(){
        waitElementToVisible(driver, Newsfeed_HomePageUI.NORMAL_EDITOR_FUNCTION);
        clickToElement(driver, Newsfeed_HomePageUI.NORMAL_EDITOR_FUNCTION);
    }
}
