package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_OverviewUI;
import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_CommonUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PerAbout_OverviewPO extends PerAbout_CommonPO {
    WebDriver driver;
    public PerAbout_OverviewPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPerAboutOverviewTabIsDisplay(){
        waitElementToVisible(driver, Personal_CommonUI.PER_ABOUT);
        waitElementToVisible(driver, Personal_CommonUI.ABOUT_MENU);
        return getAttributeValue(driver, Personal_CommonUI.ABOUT_ITEM_MENU,"class","#about_overview").endsWith("active");
    }
    public void clickAddWorkPlaceButtonToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_ADD_WORKSPACE);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_ADD_WORKSPACE);
    }

    public void clickEditOnWorkplaceSectionToNavigateToWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_WORKPLACE);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_WORKPLACE);
    }

    public boolean checkWorkplaceSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkWorkplaceSectionWithCaseHaveoData(){
       return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_WORKPLACE);
    }

    public String getJobPositionOfWorkPlace(){
        String jobPosition = null;
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_OverviewUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            jobPosition =  getTextElement(driver, PersonalAbout_OverviewUI.JOB_POSITION_OF_WORKPLACE_ITEM);
            return jobPosition;
        }
       return null;
    }

    public String getCompanyNameOfWorkPlace(){
        String companyName;
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_OverviewUI.WORKPLACE_LIST);
        for(WebElement item : listWorkPlace) {
            companyName =  getTextElement(driver, PersonalAbout_OverviewUI.COMPANY_NAME_OF_WORKPLACE_ITEM);
            return companyName;
        }
        return null;
    }

    // Section education
    public void clickAddEducationButtonToNavigateToWorkdAndEducation(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_ADD_EDUCATION);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_ADD_EDUCATION);
    }

    public void clickEditOnEducationSectionToNavigateToTabWorkAndEducation(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_EDUCATION);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_EDUCATION);
    }

    public boolean checkEducationSectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_ADD_WORKSPACE);
    }

    public boolean checkEducationSectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_EDUCATION);
    }

    public String getUniversityName(){
        String universityName;
        List<WebElement> listUniveristy = findElements(driver, PersonalAbout_OverviewUI.UNIVERSITY_LIST);
        for(WebElement item : listUniveristy) {
            universityName =  getTextElement(driver, PersonalAbout_OverviewUI.UNIVERSITY_ITEM);
            return universityName;
        }
        return null;
    }

    public String getHighschoolName(){
        String highschoolName;
        List<WebElement> listHighschool = findElements(driver, PersonalAbout_OverviewUI.HIGHSCHOOL_LIST);
        for(WebElement item : listHighschool) {
            highschoolName =  getTextElement(driver, PersonalAbout_OverviewUI.HIGHSCHOOL_ITEM);
            return highschoolName;
        }
        return null;
    }

    public void clickAddCurrentCityAndHomeTownButtonToNavigateToPlaceYouLived(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_ADD_LIVING_PLACE);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_ADD_LIVING_PLACE);
    }

    public void clickEditOnPlaceLivingSectionToNavigateToTabPlaceYouLived(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_PLACE_LIVING);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseNoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_ADD_LIVING_PLACE);
    }

    public boolean checkHomeTownAndCurrentCitySectionWithCaseHaveoData(){
        return checkElementIsDisplayed(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_PLACE_LIVING);
    }

    public String getCurrentCity(){
        return getTextElement(driver, PersonalAbout_OverviewUI.CURRENT_LIVING_ITEM);
    }

    public String getHomeTown(){
        return  getTextElement(driver, PersonalAbout_OverviewUI.HOMETOWN_ITEM);
    }


    public String getEmailIsDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_EMAIL);
    }

    public String getBirthdayDisplayOnIntroduceWidget() {
        return getTextElement(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_BIRTHDAY);
    }

    public String getGenderDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_GENDER);
        return getTextElement(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_GENDER);
    }

    public String getAddressDisplayOnIntroduceWidget(){
        waitElementToVisible(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_ADDRESS);
        return getTextElement(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_ADDRESS);
    }

    public String getPhoneNumberDisplayOnIntroduceWidget(){
        waitElementToVisible(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_PHONE);
        return getTextElement(driver, PersonalAbout_OverviewUI.WIDGET_INTRO_PHONE);
    }

    public void clickToEditBasicInfoAndContact(){
        waitForElementClickable(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
        clickToElement(driver, PersonalAbout_OverviewUI.BUTTON_EDIT_BASIC_INFO_AND_CONTACT);
    }

    public boolean checkOverViewTabCaseNewAccount() {
        return checkEducationSectionWithCaseNoData() && checkHomeTownAndCurrentCitySectionWithCaseNoData() && checkWorkplaceSectionWithCaseNoData();
    }
}
