package Interfaces.hahalolo_newsfeed.PersonaWall.About;

public class PersonalAbout_WorkAndEducationUI {

    // Workplace section
    public static final String ADD_A_WORKPLACE_BUTTON = "//div[contains(@data-bind,'doOpen.formAddWorkplace')]//button";
    public static final String DROPDOWN_OPTION_OF_WORKPLACE = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_OPTION_OF_WORKPLACE = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditWorkplace')]";
    public static final String REMOVE_OPTION_OF_WORKPLACE = "//div[@id='workplace']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";

    //Form add Workplace
    public static final String FORMADD_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]";
    public static final String FORMADD_WORKPLACE_COMPANY_NAME_ITEM = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//div[@class='selectize-dropdown-content']//div[position()=1]" ;
    public static final String FORMADD_WORKPLACE_COMPANY_NAME_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//input";
    public static final String FORMADD_WORKPLACE_POSITION_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv212']";
    public static final String FORMADD_WORKPLACE_ADDRESS_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv213']";
    public static final String FORMADD_WORKPLACE_DESC_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv214']";
    public static final String FORMADD_WORKPLACE_TIME_PERIOD_CHECKBOX = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@id = 'working']/following-sibling::label";
    public static final String FORMADD_WORKPLACE_SELECTED_DATE_DROPDOWN = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String FORMADD_WORKPLACE_SELECTED_DATE_ITEM = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String FORMADD_WORKPLACE_SCOPE_DROPDOWN = "//div[contains(@data-bind,'workplaceVM.cid')]//button[@data-toggle ='dropdown']";
    public static final String FORMADD_WORKPLACE_SCOPE_ITEM =  "//div[contains(@data-bind,'workplaceVM.cid')]//div[contains(@class, 'dropdown-menu')]/div";

    //Form Edit Workplace
    public static final String FORMEDIT_WORKPLACE = "//div[contains(@data-bind,'workplaceVM.cid')]";
    public static final String FORMEDIT_WORKPLACE_ITEM_ = "//div[contains(@class,'edit_workplace_item')]";
    public static final String FORMEDIT_WORKPLACE_COMPANY_NAME_ITEM = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//div[@class='selectize-dropdown-content']//div[position()=1]" ;
    public static final String FORMEDIT_WORKPLACE_COMPANY_NAME_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv211']/following-sibling::div//input";
    public static final String FORMEDIT_WORKPLACE_POSITION_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv212']";
    public static final String FORMEDIT_WORKPLACE_ADDRESS_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv213']";
    public static final String FORMEDIT_WORKPLACE_DESC_FIELD = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@name = 'nv214']";
    public static final String FORMEDIT_WORKPLACE_TIME_PERIOD_CHECKBOX = "//div[contains(@data-bind,'workplaceVM.cid')]//input[@id = 'working']/following-sibling::label";
    public static final String FORMEDIT_WORKPLACE_SELECTED_DATE_DROPDOWN = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String FORMEDIT_WORKPLACE_SELECTED_DATE_ITEM = "//div[contains(@data-bind,'workplaceVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String FORMEDIT_WORKPLACE_SCOPE_DROPDOWN = "//div[contains(@data-bind,'workplaceVM.cid')]//button[@data-toggle ='dropdown']";
    public static final String FORMEDIT_WORKPLACE_SCOPE_ITEM =  "//div[contains(@data-bind,'workplaceVM.cid')]//div[contains(@class, 'dropdown-menu')]/div";


    public static final String CASE_ADD_CHECKBOX_GRADUATED = "//input[@id = '%s']/following-sibling::label";
    public static final String CHECKBOX_GRADUATED_CASE_EDIT = "//input[@id = '%s''%s']/following-sibling::label";
    // Workplace section


    public static final String WORKPLACE_SEARCH_ADDRESS_ICON = "//div[@id = 'workplace']//input[@name = 'nv213']/following-sibling::div/button";

    public static final String BUTTON_SAVE_CHANGE_WORKPLACE = "//button[contains(@data-bind,'doAdd.workplace')]";
    public static final String CANCEL_ADD_WORKPLACE = "//button[contains(@data-bind,'doCancel.addWorkplace')]";

    public static final String WORKPLACE_LIST = "//div[@id ='workplace']//ul[contains(@class,'list-user')]" ;
    public static final String WORKPLACE_COMPANY_NAME = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//a[contains(@data-bind,'nv211')]";
    public static final String WORKPLACE_POSITION = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//span[contains(@data-bind,'nv212')]";
    public static final String WORKPLACE_TIMERANGE = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//span[contains(@data-bind,'nv216')]";
    public static final String WORKPLACE_ADDRESS = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//span[contains(@data-bind,'nv213')]";
    public static final String WORKPLACE_SCOPE = "//div[@id ='workplace']//ul[contains(@class,'list-user')]//i";


    // List University
    public static final String ADD_NEW_UNIVERSITY_BUTTON = "//div[contains(@data-bind,'doOpen.formAddUniversity')]";
    public static final String OPTION_DROPDOWN_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text(),'%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//span[@data-toggle ='dropdown']";
    public static final String EDIT_FUNCTION_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'openConfirmDelete')]";
    public static final String REMOVE_FUNCTION_UNIVERSITY_BY_NAME = "//div[@id='education']//a[contains(@data-bind,'nv211')][contains(text()='%s')]/ancestor::div[@class= 'infocard__content']/following-sibling::div//div[contains(@data-bind,'formEditWorkplace')]";

    public static final String OPTION_DROPDOWN_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//span[@data-toggle ='dropdown']";
    public static final String EDIT_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'formEditUniversity')]";
    public static final String REMOVE_ITEM_UNIVERSITY_BY_INDEX = "//div[@id='education']//ul[contains(@class,'list-user')][position()='%s']//div[contains(@data-bind,'openConfirmDelete')]";


    public static final String UNIVERSITY_NAME_ITEM ="//div[contains(@data-bind,'universityVM.cid')]//input[@name = 'nv211']/following-sibling::div//div[@class='selectize-dropdown-content']//div[position()=1]" ;
    public static final String UNIVERSITY_NAME_FIELD = "//div[contains(@data-bind,'universityVM.cid')]//input[@name = 'nv211']/following-sibling::div//input" ;
    public static final String UNIVERSITY_ADDRESS_FIELD = "//div[contains(@data-bind,'universityVM.cid')]//input[@name = 'nv213']";
    public static final String UNIVERSITY_DESC_FIELD = "//div[contains(@data-bind,'universityVM.cid')]//input[@name = 'nv214']";
    public static final String UNIVERSITY_SELECTED_DATE_DROPDOWN = "//div[contains(@data-bind,'universityVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String UNIVERSITY_SELECTED_DATE_ITEM = "//div[contains(@data-bind,'universityVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";
    public static final String UNIVERSITY_GRADUATE_CHECKBOX = "";
    public static final String UNIVERSITY_SCOPE_DROPDOWN = "//div[contains(@data-bind,'universityVM.cid')]//button[@data-toggle ='dropdown']";
    public static final String UNIVERSITY_SCOPE_ITEM =  "//div[contains(@data-bind,'universityVM.cid')]//div[contains(@class, 'dropdown-menu')]/div";

    public static final String UNIVERSITY_SEARCH_ADDRESS_ICON = "//div[@id = 'workplace']//input[@name = 'nv213']/following-sibling::div/button";
    public static final String BUTTON_SAVE_CHANGE_UNIVERSITY = "//button[contains(@data-bind,'doAdd.university')]";
    public static final String BUTTON_CANCEL_SAVE_CHANGE_UNIVERSITY = "//button[contains(@data-bind,'doCancel.addUniversity')]";
    // Highschool Section
    public static final String ADD_NEW_HIGHSCHOOL_BUTTON = "//div[contains(@data-bind,'doOpen.formAddHighschool')]";
    public static final String HIGHSCHOOL_NAME_FIELD ="//div[contains(@data-bind,'highschoolVM.cid')]//input[@name = 'nv211']/following-sibling::div//input" ;
    public static final String HIGHSCHOOL_NAME_ITEM ="//div[contains(@data-bind,'highschoolVM.cid')]//input[@name = 'nv211']/following-sibling::div//div[@class='selectize-dropdown-content']//div[position()=1]" ;
    public static final String HIGHSCHOOL_ADDRESS_FIELD = "//div[contains(@data-bind,'highschoolVM.cid')]//input[@name = 'nv213']";
    public static final String HIGHSCHOOL_DESCRIPTION_FIELD = "//div[contains(@data-bind,'highschoolVM.cid')]//input[@name = 'nv214']";
    public static final String HIGHSCHOOL_SCOPE_DOWN = "//div[contains(@data-bind,'highschoolVM.cid')]//button[@data-toggle ='dropdown']";
    public static final String HIGHSCHOOL_SCOPE_ITEM = "//div[contains(@data-bind,'highschoolVM.cid')]//div[contains(@class, 'dropdown-menu')]/div";
    public static final String HIGHSCHOOL_SELECTED_DATE_DROPDOWN = "//div[contains(@data-bind,'highschoolVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div/div[contains(@class,'selectize-input')]";
    public static final String HIGHSCHOOL_SELECTED_DATE_ITEM = "//div[contains(@data-bind,'highschoolVM.cid')]//select[contains(@data-bind,'%s')]/following-sibling::div//div[@class='selectize-dropdown-content']//div";

    public static final String HIGHSCHOOL_LIST = "//div[@id ='education']/following-sibling::div//ul[contains(@class,'list-user')]";
    public static final String HIGHSCHOOL_NAME = "//div[@id ='education']/following-sibling::div//ul[contains(@class,'list-user')]//a[contains(@data-bind,'nv211')]";
    public static final String HIGHSCHOOL_ADDRESS = "//div[@id ='education']/following-sibling::div//ul[contains(@class,'list-user')]//div[contains(@data-bind,'nv213')]";
    public static final String HIGHSCHOOL_SCOPE = "//div[@id ='education']/following-sibling::div//ul[contains(@class,'list-user')]//i";

    public static final String UNIVERSITY_LIST = "//div[@id ='education']//ul[contains(@class,'list-user')]";
    public static final String UNIVERSITY_NAME ="//div[@id ='education']//ul[contains(@class,'list-user')]//a[contains(@data-bind,'nv211')]";
    public static final String UNIVERSITY_ADDRESS = "//div[@id ='education']//ul[contains(@class,'list-user')]//div[contains(@data-bind,'nv213')]";
    public static final String UNIVERSITY_SCOPE = "//div[@id ='education']//ul[contains(@class,'list-user')]//i";

    public static final String BUTTON_SAVE_CHANGE_HIGHSCHOOL = "//button[contains(@data-bind,'doAdd.highschool')]";
    public static final String BUTTON_CANCEL_SAVE_CHANGE_HiGHSCHOOL = "//button[contains(@data-bind,'doCancel.addHighschool')]";



}

//selectbox: workplaceVM.years(), value: workplaceVM.yearFrom, optionsCaption: '--'
//selectbox: years, value: yearFrom, optionsCaption: '--'
//selectbox: universityVM.years(),value: universityVM.yearFrom, optionsCaption: '--'
//selectbox: years(), value: yearFrom, optionsCaption: '--'
//
// selectbox: highschoolVM.years(), value: highschoolVM.yearFrom, optionsCaption: '--'
//        selectbox: years(), value: yearFrom, optionsCaption: '--'