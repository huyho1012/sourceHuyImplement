package testcase.Newsfeed.About.DetailsAboutYou;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PersonalWall.About.PerAbout_DetailsAboutYouPO;
import Project.Newsfeed.PersonalWall.About.PerAbout_OverviewPO;
import Project.Shared.LoginPO;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_PersonalAbout_OtherName extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;
    Lorem lorem;
    // Khai báo param
    String languageSystem;
    String otherName;
    // Khai báo Page Object
    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    PerAbout_OverviewPO perOverviewTab;
    PerAbout_DetailsAboutYouPO perDetailAboutTab;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName){
        dataHelper = DataHelper.getData();
        lorem = LoremIpsum.getInstance();

        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Go to Login page");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language system to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI();
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo();

        log.info("Login newsfeed");
        newsfeedLoginPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, "123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));

        log.info("Go to Overview tab");
        newsfeedHomepagePO.clickToLinkEditProfileOnWidgetMyAccount();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        verifyTrue(perOverviewTab.checkPerAboutOverviewTabIsDisplay());

        log.info("Go to Details about you tab");
        perOverviewTab.clickToTabItemOnAbout("#about_details");
        perDetailAboutTab = PageGeneration.createPersonalDetailsAboutYouTab(driver);
    }

    @Test
    public void TC01_Check_UI_Component_Item_On_Introduce_Section(){
        log.info("Verify content title of Othername section");
        verifyTrue(perDetailAboutTab.verifyTextTitleOfOtherNameSection(languageSystem));

        log.info("Check Add new other name button as same as design");
        verifyTrue(perDetailAboutTab.verifyTextOfButtonAddOtherName(languageSystem));

        log.info("Check Save button as same as design");
        perDetailAboutTab.clickToButtonAddNewOtherName();
        verifyTrue(perDetailAboutTab.verifyUIButtonSaveOnOtherName(languageSystem));

        log.info("Check Other name field as same as design");
        verifyTrue(perDetailAboutTab.verifyPlaceHolderOfFieldOtherName(languageSystem));
        verifyTrue(perDetailAboutTab.verifyContentLabelOfFieldOtherName(languageSystem));

        log.info("Check Cancel button as same as design");
        verifyTrue(perDetailAboutTab.verifyUIButtonCancelOnOtherName(languageSystem));

        perDetailAboutTab.clickToButtonCancelOnFormOtherName();
    }

    @Test
    public void TC02_Check_User_Interactor_Component_Item_On_Introduce_Section(){
        log.info("Check action click to button Add new other name");
        log.info("Step 1. Click button Add a nickname, a birth name");
        perDetailAboutTab.clickToButtonAddNewOtherName();
        log.info("Steo 2. Check form Add other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());

        log.info("Check action send key to other name field");
        otherName = "Huy Đẹp Trai";
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 2. Check values of field");
        verifyEquals(perDetailAboutTab.getValueInputDisplayOnFieldOtherName(), otherName);

        log.info("Check action click save button");
        log.info("Step 1. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 2. Check action click save success");
        verifyFalse(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        String otherNameDisplay = perDetailAboutTab.getOtherNameDisplayOnDetailsAbout();
        log.info("Step 3. Check other name create successfully");
        verifyEquals(otherNameDisplay,otherName);

        log.info("Check action click button edit item Other name ");
        log.info("Step 1. Click button edit");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form edit introduce display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());

        log.info("Check action cancel save");
        log.info("Step 1. Click button cancel");
        perDetailAboutTab.clickToButtonCancelOnFormOtherName();
        log.info("Step 2. Check close form Edit introduce successfully");
        verifyFalse(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Verify data is not changed");
        verifyEquals(otherNameDisplay,perDetailAboutTab.getOtherNameDisplayOnDetailsAbout());

        log.info("Check action remove data on Other name field");
        log.info("Step 1 . Click to edit");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Remove data on field");
        perDetailAboutTab.enterDataToFieldOtherName("");
        log.info("Step 3. Check values of field is remove successfully");
        verifyEquals(perDetailAboutTab.getValueInputDisplayOnFieldOtherName(),"");
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify data is removed and display button Write something about yourself");
        verifyTrue(perDetailAboutTab.checkButtonAddOtherNameIsDisplayed());
    }

    @Test
    public void TC03_Update_With_Blank_OtherName() {
        otherName = "";
        log.info("Step 1. Click button Add a nickname, a birth name");
        perDetailAboutTab.clickToButtonAddNewOtherName();
        log.info("Step 2. Check form Add other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify button Write something about yourself still display");
        verifyTrue(perDetailAboutTab.checkButtonAddOtherNameIsDisplayed());
    }

    @Test(enabled = false)
    public void TC04_Update_With_OtherName_Contains_All_Whitespace() {
        otherName = "     ";
        log.info("Step 1. Click button Add a nickname, a birth name");
        perDetailAboutTab.clickToButtonAddNewOtherName();
        log.info("Step 2. Check form Add other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify button Write something about yourself still display");
        verifyTrue(perDetailAboutTab.checkButtonAddOtherNameIsDisplayed());
    }

    @Test
    public void TC05_Update_With_OtherName_Contains_Whitespace_On_First_Position(){
        otherName = "     "+ dataHelper.getLastName();
        log.info("Step 1. Click button Add a nickname, a birth name");
        perDetailAboutTab.clickToButtonAddNewOtherName();
        log.info("Step 2. Check form Add other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        System.out.println(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout());
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(), otherName.trim());
    }

    @Test
    public void TC06_Update_With_OtherName_Contains_Whitespace_On_Last_Position(){
        otherName =  dataHelper.getLastName() +"     ";
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(), otherName.trim());
    }

    @Test(enabled = false)
    public void TC07_Update_With_OtherName_Contains_More_2_Whitespace_On_Middle_Position(){
        otherName = "Huy   totana   ha";
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        System.out.println(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout());
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(),otherName.replaceAll("( )+", " "));
    }

    @Test
    public void TC08_Update_With_Othername_Contains_Only_Number(){
        otherName = String.valueOf(randomNumber(40000));
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        System.out.println(otherName);
        log.info("Step 5. Verify Other name display");
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(),otherName);
    }

    @Test
    public void TC09_Update_With_Othername_Contains_Number_And_Character(){
        otherName = dataHelper.getFirstName()+ randomNumber(22);
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(),otherName);
    }

    @Test
    public void TC10_Update_With_Othername_Contains_Specical_Character(){
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());

        log.info("Case special characters");
        otherName = "@@@@@@";
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 2. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 3. Verify error message");
        verifyEquals(perDetailAboutTab.getMessageValidateOfFieldOtherName(),"Biệt danh không chứa ký tự đặc biệt.");

        log.info("Case HMTL Code");
        otherName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 2. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 3. Verify error message");
        verifyEquals(perDetailAboutTab.getMessageValidateOfFieldOtherName(),"Biệt danh không chứa ký tự đặc biệt.");

        log.info("Case Script Code");
        otherName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 2. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 3. Verify error message");
        verifyEquals(perDetailAboutTab.getMessageValidateOfFieldOtherName(),"Biệt danh không chứa ký tự đặc biệt.");

        log.info("Case greater than 50 number");
        otherName = randomName(500);
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 2. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 3. Verify error message");
        verifyEquals(perDetailAboutTab.getMessageValidateOfFieldOtherName(),"Giới hạn tối đa của Biệt danh là 50 kí tự");

        perDetailAboutTab.clickToButtonCancelOnFormOtherName();
    }

    @Test
    public void TC11_Update_With_Othername_Is_Uppercase(){
        otherName = dataHelper.getFirstName().toUpperCase();
        log.info("Step 1. Click button Edit other name");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(), otherName);
    }

    @Test
    public void TC12_Update_OtherName_With_Data_Is_Lowercase(){
        otherName = dataHelper.getFirstName().toLowerCase();
        log.info("Step 1. Click to Edit Introduce");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Step 2. Check form Edit other name display");
        verifyTrue(perDetailAboutTab.checkFormAddEditOtherNameIsDisplayed());
        log.info("Step 3. Enter data to field");
        perDetailAboutTab.enterDataToFieldOtherName(otherName);
        log.info("Step 4. Click to button save");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        log.info("Step 5. Verify Other name display");
        verifyEquals(perDetailAboutTab.getOtherNameDisplayOnDetailsAbout(),otherName);
    }

    @AfterClass(alwaysRun = true)
    public void endStep(){
        log.info("Click to Edit Introduce");
        perDetailAboutTab.clickToButtonEditOtherName();
        log.info("Enter Introduce");
        perDetailAboutTab.enterDataToFieldOtherName("");
        log.info("Click save Introduce");
        perDetailAboutTab.clickToButtonSaveOnFormOtherName();
        closeBrowserAndDriver(driver);
    }
}
