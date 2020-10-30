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

public class Testcase_ComponentTest_GenderFunction extends AbstractTest {
    WebDriver driver;
    DataHelper dataHelper;
    DriverManager driverManager;
    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    SignUpPO signUpPage;
    PerAbout_OverviewPO perAboutOverviewTab;
    PerAbout_BasicInfoAndContactPO perAboutBasicInfoTab;
    String genderName;
    String genderOnIntroduce;
    String languageSystem;
    String genderValue;

    @Parameters("browser")
    @BeforeClass
    public void preconditionStep(String browserName){
        dataHelper = DataHelper.getData();
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
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed(languageSystem));

        log.info("Click to Edit profile");
        newsfeedHomepagePO.clickToLinkEditProfileOnWidgetMyAccount();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Check Personal About - Overview");
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        String genderOnWidget = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();

        log.info("Go to personal about - Basic and Contact Info");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Check Basic And Contact Info display");
        verifyTrue(perAboutBasicInfoTab.checkContactAndBasicInfoTabIsDisplayed(languageSystem));
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(), genderOnWidget);
    }

    @Test
    public void TC01_Update_Gender_Type_Male(){
        log.info("Prepare data");
        genderValue = "M";
        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToIconEditGender();

        log.info("2. Check form edit gender display successfully");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());

        log.info("3. Choose gender type is Male");
        perAboutBasicInfoTab.clickToChooseGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("4. Click to save gender");
        perAboutBasicInfoTab.clickToButtonSaveOnFormEditGender();

        log.info("5. Verify gender display after changing is correctly");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout("#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        genderOnIntroduce = perAboutOverviewTab.getGenderDisplayOnIntroduceWidget();
        verifyEquals(genderOnIntroduce, genderName);
    }

    @Test
    public void TC02_Update_Gender_Type_FeMale(){
        log.info("Prepare data");
        genderValue = "F";

        log.info("Prepare step");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToIconEditGender();

        log.info("2. Choose gender type is Female");
        perAboutBasicInfoTab.clickToChooseGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("3. Click to save gender");
        perAboutBasicInfoTab.clickToButtonSaveOnFormEditGender();

        log.info("4. Verify gender display after changing is Female");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout("#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(), genderName);
    }

    @Test
    public void TC03_Update_Gender_Type_Other(){
        log.info("Prepare data");
        genderValue = "N";

        log.info("Prepare step");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("1. Click to edit gender");
        perAboutBasicInfoTab.clickToIconEditGender();

        log.info("2. Choose gender type is Other");
        perAboutBasicInfoTab.clickToChooseGenderOption(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);

        log.info("3. Click to save gender");
        perAboutBasicInfoTab.clickToButtonSaveOnFormEditGender();

        log.info("4. Verify gender display after changing is Other");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(),genderName);

        log.info("5. Go back to Personal About - Overview");
        perAboutBasicInfoTab.clickToTabItemOnAbout("#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("6. Verify gender on introduce Widget update");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(), genderName);

        log.info("End Step - Logout");
        perAboutOverviewTab.clickToItemSettingOnHeaderSection("ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);
    }

    @Test(description = "M = Male, F = Female, N = Other")
    public void TC04_Check_Update_Gender_With_New_Account(){
        log.info("Step 1. Register with new account");
        log.info("Step 1.1 Prepare data before register account");
        String firstName = dataHelper.getFirstName();
        String lastName = dataHelper.getLastName();
        String email = randomVirtualEmail();
        log.info("Step 1.2 Register account");
        signUpPage.signUpWithNewAccountByEmail(firstName,lastName,email,"123456","123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 1.3 Verify register new account successfully");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Step 2. Update new information");
        log.info("Step 2.1. Prepaid data for update information");
        genderValue = "M";
        log.info("Step 2.1. Update information");
        newsfeedHomepagePO.updateNewInformationOfAccount("12","10","1992",genderValue,"Albania");

        log.info("Step 3. Verify gender information of user");
        log.info("Step 3.1 Go to Overview Tab");
        newsfeedHomepagePO.clickToLinkEditProfileOnWidgetMyAccount();
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        verifyTrue(perAboutOverviewTab.checkPerAboutOverviewTabIsDisplay());
        log.info("Step 3.2 Go to Basic info and contact Tab");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);
        log.info("Step 3.3 Verify Avatar default image display correctsponding with gender type");
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(genderName));
        log.info("Step 3.4. Check Gender on Basic and Contact Info tab display correctly");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(), genderName);

        log.info("4 Edit gender sser with type gender is Other");
        log.info("Step 4.1 Click to Edit icon of gender");
        perAboutBasicInfoTab.clickToIconEditGender();
        log.info("Step 4.2 Check form edit gender display");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());
        log.info("Step 4.3 Choose gender");
        genderValue = "N";
        perAboutBasicInfoTab.chooseGenderType(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem,genderValue);
        log.info("Step 4.4. Click Save button for updating gender");
        perAboutBasicInfoTab.clickToButtonSaveOnFormEditGender();
        log.info("Step 4.5 Check gender display on Basic info and contact");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(),genderName);
        log.info("Step 4.6. Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout("#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Step 4.7 Check gender on Introduce widget");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),genderName);
        log.info("Step 4.8 Reload personal page for upload avatar");
        perAboutOverviewTab.refreshPage(driver);
        log.info("Step 4.9 Check Avatar display with genderName");
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(genderName));
        log.info("Step 4.10. Go To Basic info and contact tab");
        perAboutOverviewTab.clickToTabItemOnAbout("#about_contact");
        perAboutBasicInfoTab  = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Step 5. Edit gender with Gender type is Female");
        log.info("Step 5.1. Click Edit button to open form Edit Gender");
        perAboutBasicInfoTab.clickToIconEditGender();
        log.info("Step 5.2 Check form edit gender display");
        verifyTrue(perAboutBasicInfoTab.checkFormEditGenderOfUserIsDisplay());
        log.info("Step 5.3. Choose gender");
        genderValue = "F";
        perAboutBasicInfoTab.chooseGenderType(genderValue);
        genderName = perAboutBasicInfoTab.getGenderNameByValue(languageSystem, genderValue);
        log.info("Step 5.4. Click save button for updating gender");
        perAboutBasicInfoTab.clickToButtonSaveOnFormEditGender();
        log.info("Step 5.5 Check gender display on Basic info and contact");
        verifyEquals(perAboutBasicInfoTab.getGenderNameIsDisplayedOnTab(),genderName);
        log.info("Step 5.6 Back to Overview tab");
        perAboutBasicInfoTab.clickToTabItemOnAbout("#about_overview");
        perAboutOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);
        log.info("Step 5.7 Check gender on Introduce widget");
        verifyEquals(perAboutOverviewTab.getGenderDisplayOnIntroduceWidget(),genderName);
        log.info("Step 5.8 Reload personal page for upload avatar");
        perAboutOverviewTab.refreshPage(driver);
        log.info("Step 5.9 Check Avatar display with genderName");
        verifyTrue(perAboutOverviewTab.checkAvatarUserDisplayWithGenderType(genderName));
        log.info("Step 5.10 Logout account");
        perAboutOverviewTab.clickToItemSettingOnHeaderSection("ic-logout-c");
    }
}
