package testcase.Newsfeed.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContactPO;
import Project.Newsfeed.PersonalWall.About.PerAbout_OverviewPO;
import Project.Shared.LoginPO;
import Project.Shared.SignUpPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_Component_Update_Birthday extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;
    String birthday;
    String languageSystem;

    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    PerAbout_OverviewPO perAboutOverviewTab;
    PerAbout_BasicInfoAndContactPO perAboutBasicTab;
    SignUpPO signUpPage;

    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open browser and go to Newsfeed Login page");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language to Vi");
        newsfeedLoginPage.clickToChangeLanguageToVI();
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo();

        log.info("Login to newsfeed");
        newsfeedLoginPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT,"123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Newsfeed page display successfully");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));
        log.info("Click to Edit profile");
        newsfeedHomepagePO.clickToLinkEditProfileOnWidgetMyAccount();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Check Personal About - Overview");
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        String birthdayOnWidget = perAboutOverviewTab.getBirthdayDisplayOnIntroduceWidget();
        log.info("Go to Personal About - Basic info and contact");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicTab = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Check birthday display");
        verifyEquals(birthdayOnWidget, perAboutBasicTab.getBirthdayIsDisplayedOnBasicInfoAndContactTab(languageSystem));
    }

    @Test
    public void TC01_Update_Birthday_Of_User(){
        birthday = "12-10-1992";
        log.info("Click To update birhday");
        perAboutBasicTab.clickToIconEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormEditBirthdayIsDisplayed());

        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday(birthday);

        log.info("Change scope of birthday");
        perAboutBasicTab.changeScopeOfBirthday("Công khai");

        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();

        log.info("Check birthday change successfully");
        verifyEquals(perAboutBasicTab.getBirthdayIsDisplayedOnBasicInfoAndContactTab(languageSystem),"12-10-1992");
    }

    @Test
    public void TC02_Update_Birthday_Of_User_Less_Than_13_Years_Old(){
        birthday = "01-10-2020";
        log.info("Click To update birhday");
        perAboutBasicTab.clickToIconEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormEditBirthdayIsDisplayed());

        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday(birthday);

        log.info("Change scope of birthday");
        perAboutBasicTab.changeScopeOfBirthday("Công khai");

        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();

        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"");
    }

    @Test
    public void TC03_Update_Birthday_Of_User_Invalid_Birthday(){
        log.info("Click To update birhday");
        perAboutBasicTab.clickToIconEditBirthday();
        log.info("Check Update Birthday form display");
        verifyTrue(perAboutBasicTab.checkFormEditBirthdayIsDisplayed());

        log.info("Case blank");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday("");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");

        log.info("Case enter all whitespace");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday("          ");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");

        log.info("Case enter character");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday("fsdfdsfd");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");

        log.info("Case enter special character");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday("@@@@@@");
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");

        log.info("Case enter HTML code");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday(GlobalVariables.HTML_CODE);
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");

        log.info("Case enter Script code");
        log.info("Enter birthday");
        perAboutBasicTab.enterDataToCalendarBirhday(GlobalVariables.SCRPIT_CODE);
        log.info("Click to save change birthday");
        perAboutBasicTab.clickToButtonSaveBirthday();
        log.info("Check error Validation");
        verifyEquals(perAboutBasicTab.getMessageValidateCalendarBirthday(),"Ngày không hợp lệ");
    }
}
