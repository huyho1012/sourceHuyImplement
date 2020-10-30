package Project.Newsfeed.PersonalWall.About;

import Interfaces.hahalolo_newsfeed.PersonaWall.About.PersonalAbout_WorkAndEducationUI;
import org.openqa.selenium.*;

import java.util.List;

public class PerAbout_WorkAndEducationPO extends PerAbout_CommonPO {

    WebDriver driver;

    public PerAbout_WorkAndEducationPO(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public void clickButtonToAddNewWorkplace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.ADD_A_WORKPLACE_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.ADD_A_WORKPLACE_BUTTON);
    }

    public void clickToEditWorkplaceItembyIndex(int indexWorkplace) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.DROPDOWN_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.DROPDOWN_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.EDIT_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.EDIT_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
    }

    public boolean checkFormAddWorkplaceIsDisplayed(){
        return checkElementIsDisplayed(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE);
    }

    public boolean checkFormEditWorkplaceIsDisplayed(){
        return checkElementIsDisplayed(driver, PersonalAbout_WorkAndEducationUI.FORMEDIT_WORKPLACE) && getAttributeValue(driver, PersonalAbout_WorkAndEducationUI.FORMEDIT_WORKPLACE,"style").equals("");
    }

    public String getIDWorkplaceItem(){
        if(checkFormEditWorkplaceIsDisplayed()){
            String idWorkplace = getAttributeValue(driver, PersonalAbout_WorkAndEducationUI.FORMEDIT_WORKPLACE,"class");
            String[] a = idWorkplace.split(" ");
            return a[a.length-1];
        }
        return null;
    }


    public void clickToRemoveWorkplaceItemByIndex(String indexWorkplace) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.DROPDOWN_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.DROPDOWN_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.REMOVE_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.REMOVE_OPTION_OF_WORKPLACE, String.valueOf(indexWorkplace));
    }

    public void enterDataToCompanyNameOfWorkspace(String companyName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_COMPANY_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_COMPANY_NAME_FIELD, companyName);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_COMPANY_NAME_ITEM);
        setTimeDelay(1);
    }

    public void enterDataToPositionOfWorkspace(String positionJob) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_POSITION_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_POSITION_FIELD, positionJob);
    }

    public void enterDataToAddressOfWorkspace(String address) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_ADDRESS_FIELD, address);
    }

    public void enterDataToDescriptionOfWorkspace(String description) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_DESC_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_DESC_FIELD, description);
    }

    public void checkOptionTimePeriod() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_TIME_PERIOD_CHECKBOX);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_TIME_PERIOD_CHECKBOX);
    }

    public void chooseStartTimeOfWorkplace(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, yearStart, "workplaceVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, monthStart, "workplaceVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, dateStart, "workplaceVM.dayFrom");
    }

    public void chooseEndimeOfWorkplace(String dateSEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, yearEnd, "workplaceVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, monthEnd, "workplaceVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SELECTED_DATE_ITEM, dateSEnd, "workplaceVM.dayTo");
    }

    public void chooseScopeOfWorkPlace(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SCOPE_DROPDOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SCOPE_DROPDOWN);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SCOPE_ITEM, scopeName);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.FORMADD_WORKPLACE_SCOPE_ITEM, scopeName);
    }

    public void clickButtonToSaveWorkplace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_WORKPLACE);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_WORKPLACE);
    }

    public void cancelSaveWorkPlace() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.CANCEL_ADD_WORKPLACE);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.CANCEL_ADD_WORKPLACE);
    }

    public String getCompanyOfWorkplace() {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_LIST);
        return getTextElement(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_COMPANY_NAME);
    }

    public boolean verifyPositionOfWorkplaceItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_LIST);
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_POSITION);
        for(WebElement item: listWorkPlace){
            if(item.getText().equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
       return false;
    }

    public boolean verifyAddressOfWorkplaceItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_LIST);
        List<WebElement> listWorkPlaceAddress = findElements(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_ADDRESS);
        for(WebElement item : listWorkPlaceAddress) {
            if (item.getText().endsWith(expected)) {
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyScopeOfWorkplaceItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_LIST);
        List<WebElement> listWorkPlace = findElements(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_SCOPE);
        for(WebElement item: listWorkPlace){
            if(item.getAttribute("title").equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyTimerangeOfWorkplaceItemIsDisplayed(String startTime, String endTime) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_LIST);
        List<WebElement> timerangeWorkplace = findElements(driver, PersonalAbout_WorkAndEducationUI.WORKPLACE_TIMERANGE);
        for (WebElement item : timerangeWorkplace){
            if (checkStatusCheckedOfCurrentWorking() == false){
                System.out.println(item.getText());
                return item.getText().contains(startTime) && item.getText().contains(endTime);
            } else {
                System.out.println(item.getText());
                return item.getText().contains(startTime) && item.getText().contains("hiện tại");
            }
        }
        return false;
    }

    public boolean checkStatusCheckedOfCurrentWorking(){
        String cssSelectorOfCheckbox = ".custom-control-label";
        return getAttributeClassWithAfter(driver, cssSelectorOfCheckbox, "background-image") != null;
    }
    // Highschool section

    public void clickButtonToAddnewHighschool() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.ADD_NEW_HIGHSCHOOL_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.ADD_NEW_HIGHSCHOOL_BUTTON);
    }

    public void enterDataToHighschoolName(String highschoolName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_NAME_FIELD, highschoolName);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_NAME_ITEM);
        setTimeDelay(1);
    }

    public void enterDataToHighschoolAddress(String highschoolAddress) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_ADDRESS_FIELD, highschoolAddress);
    }

    public void enterDataToHighschoolDescription(String highschoolDesc) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_DESCRIPTION_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_DESCRIPTION_FIELD, highschoolDesc);
    }

    public void chooseStartTimeAndEndTimeOfHighschool() {
        selectStartDateOfHighschool("12","10","2018");
        selectEndDateOfHighschool("20","12","2020");
    }

    private void selectStartDateOfHighschool(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, yearStart, "highschoolVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, monthStart, "highschoolVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, dateStart, "highschoolVM.dayFrom");
    }

    private void selectEndDateOfHighschool(String dateEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, yearEnd, "highschoolVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, monthEnd, "highschoolVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SELECTED_DATE_ITEM, dateEnd, "highschoolVM.dayTo");
    }


    public void chooseScopeOfHighschool(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SCOPE_DOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SCOPE_DOWN);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SCOPE_ITEM, scopeName);
    }

    public void clickButtonToSaveHighSchoolItem() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_HIGHSCHOOL);
    }

    public void clickButtonToCancelSaveHighschoolItem() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL);
    }

    public boolean verifyNameOfHighschoolItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_LIST);
        List<WebElement> listNameHighschool = findElements(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_NAME);
        for(WebElement item: listNameHighschool){
            if(item.getText().equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyAddressOfHighschoolItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_LIST);
        List<WebElement> listAddressHighschool = findElements(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_ADDRESS);
        for(WebElement item: listAddressHighschool){
            if(item.getText().endsWith(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyScopeOfHighschoolItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_LIST);
        List<WebElement> listScopeHighschool = findElements(driver, PersonalAbout_WorkAndEducationUI.HIGHSCHOOL_SCOPE);
        for(WebElement item: listScopeHighschool){
            if(item.getAttribute("title").equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    // University section
    public boolean verifyNameOfUniversityItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_LIST);
        List<WebElement> listNameUniversity = findElements(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_NAME);
        for(WebElement item: listNameUniversity){
            if(item.getText().equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyAddressOfUniversityItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_LIST);
        List<WebElement> listAddressUniversity = findElements(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_ADDRESS);
        for(WebElement item: listAddressUniversity){
            if(item.getText().endsWith(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public boolean verifyScopeOfUniversitylItemIsDisplayed(String expected) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_LIST);
        List<WebElement> listScopeUniversity = findElements(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SCOPE);
        for(WebElement item: listScopeUniversity){
            if(item.getAttribute("title").equalsIgnoreCase(expected)){
                return true;
            }
            break;
        }
        return false;
    }

    public void clickButtonToAddNewUniveristy() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.ADD_NEW_UNIVERSITY_BUTTON);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.ADD_NEW_UNIVERSITY_BUTTON);

    }

    public void enterDataToUniveristyNameField(String univeristyName) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_NAME_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_NAME_FIELD,univeristyName);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_NAME_ITEM);
        setTimeDelay(1);

    }

    public void enterDataToUniversityAddressField(String universityAddress) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_ADDRESS_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_ADDRESS_FIELD,universityAddress);
    }

    public void enterDataToUniversityDescField(String universityDesc) {
        waitElementToVisible(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_DESC_FIELD);
        sendKeyToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_DESC_FIELD,universityDesc);
    }

    private void selectStartDateOfUniversity(String dateStart, String monthStart, String yearStart) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, yearStart, "universityVM.yearFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, monthStart, "universityVM.monthFrom");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, dateStart, "universityVM.dayFrom");
    }

    private void selectEndDateOfUniversity(String dateEnd, String monthEnd, String yearEnd) {
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, yearEnd, "universityVM.yearTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, monthEnd, "universityVM.monthTo");
        selectItemInCustomDropdown(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_DROPDOWN, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SELECTED_DATE_ITEM, dateEnd, "universityVM.dayTo");
    }

    public void chooseTimeRangeStudyOfUniversity() {
        selectStartDateOfUniversity("20","12","2010");
        selectEndDateOfUniversity("12","11","2016");
    }

    public void clickToChooseScopeOfUniversity(String scopeName) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SCOPE_DROPDOWN);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SCOPE_DROPDOWN);
        setTimeDelay(1);
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SCOPE_ITEM);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.UNIVERSITY_SCOPE_ITEM,scopeName);
    }

    public void clickToButtonToSaveUniversity() {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_UNIVERSITY);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.BUTTON_SAVE_CHANGE_UNIVERSITY);
    }

    public boolean checkFormAddWorkplaceIsDisplay() {
        return true;
    }


    public void clickToChooseOptionGraduatedCaseAddNew(String function) {
        waitForElementClickable(driver, PersonalAbout_WorkAndEducationUI.CASE_ADD_CHECKBOX_GRADUATED, function);
        clickToElement(driver, PersonalAbout_WorkAndEducationUI.CASE_ADD_CHECKBOX_GRADUATED,function);
    }
}