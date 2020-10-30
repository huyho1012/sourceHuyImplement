package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_PlacesYouLivedUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_CommonUI;
import org.openqa.selenium.WebDriver;

public class PerAbout_PlacesYouLivedPO extends PerAbout_CommonPO {
    WebDriver driver;
    public PerAbout_PlacesYouLivedPO(WebDriver webDriver){
        super(webDriver );
        driver = webDriver;
    }

    public boolean checkPerAboutPlacesYouLivedIsDisplay(){
        return getTextElement(driver, Personal_CommonUI.TITLE_TAB_ABOUT,"about_location").equalsIgnoreCase("Thành phố đang sống và quê quán")
            && getAttributeValue(driver, Personal_CommonUI.ABOUT_ITEM_MENU,"class","#about_location").endsWith("active");
    }

    public boolean checkDisplayOfPerAboutWithCaseCreateNewAccount(){
        return checkPerAboutPlacesYouLivedIsDisplay()
                && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_CURRENT_CITY)
                 && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_HOMETOWN);
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseNoHometown(){
        return checkPerAboutPlacesYouLivedIsDisplay() && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_HOMETOWN);
    }

    public boolean checkPerAboutPlacesYouLivedDisplayWithcaseHaveHometown(){
        return checkPerAboutPlacesYouLivedIsDisplay() && checkElementIsDisplayed(driver, PersonalAbout_PlacesYouLivedUI.HOME_TOWN_DATA);
    }

    public void clickToAddNewCurrentCity(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_CURRENT_CITY);
    }

    public void enterDataToCurrentCityField(String currentLiving){
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.CURRENT_CITY_FIELD);
        sendKeyToElement(driver, PersonalAbout_PlacesYouLivedUI.CURRENT_CITY_FIELD,currentLiving);
    }

    public void clickToSaveCurrentLiving(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_CURRENT_CITY);
    }

    public void clickToCancelSaveCurrentLiving(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_CANCEL_SAVE_CURRENT_CITY);
    }

    public void clickToAddNewHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.ADD_NEW_HOMETOWN);
    }

    public void enterDataToHomeTownField(String homeTown){
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.HOMETOWN_FIELD);
        sendKeyToElement(driver, PersonalAbout_PlacesYouLivedUI.HOMETOWN_FIELD,homeTown);
    }

    public void clickToSaveHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_HOMETOWN);
    }

    public void clickToCancelSaveHomeTown(){
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_CANCEL_SAVE_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_CANCEL_SAVE_HOMETOWN);
    }

    public void clickToSearchAddressOfCurrentCity() {
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.ICON_SEARCH_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.ICON_SEARCH_CURRENT_CITY);
    }

    public void clickToSearchAddressOfHomeTown() {
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.ICON_SEARCH_HOMETOWN);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.ICON_SEARCH_HOMETOWN);
    }

    public void chooseScopeOfCurrentCity() {
    }

    public void clickToSaveCurrentCity() {
        waitForElementClickable(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_CURRENT_CITY);
        clickToElement(driver, PersonalAbout_PlacesYouLivedUI.BUTTON_SAVE_CURRENT_CITY);
    }

    public String getCurrentCityData() {
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.CURRENT_CITY_DATA);
        return getTextElement(driver, PersonalAbout_PlacesYouLivedUI.CURRENT_CITY_DATA);
    }

    public String getScopeOfCurrentCity() {
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.CURRENT_CITY_DATA);
        return getTextElement(driver, PersonalAbout_PlacesYouLivedUI.SCOPE_CURRENT_CITY);
    }

    public void chooseScopeOfHomeTown() {
    }

    public Object getHomeTownData() {
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.HOME_TOWN_DATA);
        return getTextElement(driver, PersonalAbout_PlacesYouLivedUI.HOME_TOWN_DATA);
    }

    public Object getScopeOfHomeTown() {
        waitElementToVisible(driver, PersonalAbout_PlacesYouLivedUI.HOME_TOWN_DATA);
        return getTextElement(driver, PersonalAbout_PlacesYouLivedUI.SCOPE_HOMETOWN);
    }

}
