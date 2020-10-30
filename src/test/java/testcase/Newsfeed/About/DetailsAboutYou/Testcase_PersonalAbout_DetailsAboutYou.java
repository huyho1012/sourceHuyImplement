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
import org.testng.annotations.*;

public class Testcase_PersonalAbout_DetailsAboutYou extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;
    Lorem lorem;
    // Khai báo param
    String languageSystem;
    String introduceCode, fullName;
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
        log.info("Create driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open browser and go to Newsfeed Login");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language system to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI();
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo();

        log.info("Login newsfeed");
        newsfeedLoginPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, "123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));
        fullName = newsfeedHomepagePO.getFullNameDisplayOnWidgetMyAccount();
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
        log.info("Verify UI Introduction section");
        verifyTrue(perDetailAboutTab.verifyTextOfIntroduceSection(languageSystem,fullName));
        log.info("Verify UI button Add introduce");
        verifyTrue(perDetailAboutTab.verifyTextOfButtonAdđNewIntroduction(languageSystem));
        log.info("Verify UI button Save introduce");
        perDetailAboutTab.clickToButtonAddNewIntroduce();
        verifyTrue(perDetailAboutTab.verifyTextOfButtonSaveIntroduction(languageSystem));
        log.info("Verify UI button Cancel Save introduce");
        verifyTrue(perDetailAboutTab.verifyTextOfButtonCancelSaveIntroduction(languageSystem));
        log.info("Verify label field Introduce");
        verifyTrue(perDetailAboutTab.verifyContentOfLabelFieldIntroduce(languageSystem));
        perDetailAboutTab.clickToCancelSaveIntroduceInfo();
    }

    @Test
    public void TC02_Check_User_Interactor_Component_Item_On_Introduce_Section(){
        log.info("Check action click to button add new introduction");
        log.info("Step 1. Click button Write something about yourself");
        perDetailAboutTab.clickToButtonAddNewIntroduce();
        log.info("Steo 2. Check form Add introduction display");
        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());

        log.info("Check action send key to Introduce field");
        introduceCode = "Haha bạn khoẻ không";
        log.info("Step 1. Enter data to field");
        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
        log.info("Step 2. Check values of field");
        verifyEquals(perDetailAboutTab.getValueInputDisplayOnIntroduceField(), introduceCode);

        log.info("Check action click save introduce button");
        log.info("Step 1. Click to save introduce");
        perDetailAboutTab.clickToSaveIntroduceInfo();
        log.info("Step 2. Check action save introduce success");
        verifyFalse(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());
        String introduceDisplay = perDetailAboutTab.getIntroduceDataDisplay();
        log.info("Step 3. Verify introduce data");
        verifyEquals(introduceDisplay,introduceCode);

        log.info("Check action click button edit introduce button");
        log.info("Step 1. Click button edit introduce");
        perDetailAboutTab.clickToButtonEditIntroduce();
        log.info("Step 2. Check form edit introduce display");
        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());

        log.info("Check action cancel save Introduce");
        log.info("Step 1. Click button cancel Introduce");
        perDetailAboutTab.clickToCancelSaveIntroduceInfo();
        log.info("Step 2. Check close form Edit introduce successfully");
        verifyFalse(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());
        log.info("Step 3. Verify data is not changed");
        verifyEquals(introduceDisplay,perDetailAboutTab.getIntroduceDataDisplay());

        log.info("Check action remove data on Introduce field");
        log.info("Step 1 . Click to edit Introouce");
        perDetailAboutTab.clickToButtonEditIntroduce();
        log.info("Step 2. Remove data on field");
        perDetailAboutTab.enterDataToIntroduceField("");
        log.info("Step 3. Check values of field is remove successfully");
        verifyEquals(perDetailAboutTab.getValueInputDisplayOnIntroduceField(),"");
        log.info("Step 4. Click to save introduce information");
        perDetailAboutTab.clickToSaveIntroduceInfo();
        log.info("Step 4. Verify data is removed and display button Write something about yourself");
        verifyTrue(perDetailAboutTab.checkButtonAddNewIntroduceIsDisplayed());
        verifyFalse(perDetailAboutTab.checkButtonEditIntroduceIsDisplayed());
    }

    @Test
    public void TC03_Update_Introduce_With_Value_Is_Blank() {
        introduceCode = "";
        log.info("Click to Add introduce");
        perDetailAboutTab.clickToButtonAddNewIntroduce();
        log.info("Check form Add/ Edit Introduce information display");
        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());
        log.info("Enter Introduce");
        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
        log.info("Click save Introduce");
        perDetailAboutTab.clickToSaveIntroduceInfo();
    }

    @Test
    public void TC04_Update_Introduce_With_Value_Contains_All_Whitespaces() {
        introduceCode = "     ";
        log.info("Click to Add introduce");
        perDetailAboutTab.clickToButtonAddNewIntroduce();
        log.info("Check form Add/ Edit Introduce information display");
        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());
        log.info("Enter Introduce");
        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
        log.info("Click save Introduce");
        perDetailAboutTab.clickToSaveIntroduceInfo();
        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),introduceCode.trim());
    }

    @Test
    public void TC05_Update_Introduce_With_Value_Is_Paragarph(){
        introduceCode = lorem.getWords(200).substring(0,600);
        System.out.println(introduceCode.length());
        log.info("Click to Edit Introduce");
        perDetailAboutTab.clickToButtonEditIntroduce();
        log.info("Check form Add/ Edit Introduce information display");
        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplayed());
        log.info("Enter Introduce");
        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
        log.info("Click save Introduce");
        perDetailAboutTab.clickToSaveIntroduceInfo();
        log.info("Verify Introduce display");
        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),replaceMoreWhitespaceToOne(introduceCode));
        log.info("Refresh page");
        perDetailAboutTab.refreshPage(driver);
        log.info("Verify Introduce đata display on Header");
        System.out.println("Thực tế:  " + perDetailAboutTab.getIntroduceDataDisplayonHeader());
        System.out.println("Kết quả:  " + perDetailAboutTab.handleIntroduceDataOnHeader(replaceMoreWhitespaceToOne(introduceCode)));
        System.out.println("Kết quả:  " + replaceMoreWhitespaceToOne(introduceCode));

        verifyEquals(perDetailAboutTab.getIntroduceDataDisplayonHeader(), perDetailAboutTab.handleIntroduceDataOnHeader(replaceMoreWhitespaceToOne(introduceCode)));
    }

//    @Test
//    public void TC04_Update_Introduce_With_Value_More_Than_2_Paragarphs(){
//        introduceCode = lorem.getParagraphs(2,5);
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),replaceMoreWhitespaceToOne(introduceCode).replaceAll("\n", ""));
//    }
//
//    @Test
//    public void TC05_Update_Introduce_With_Value_Is_Sentence(){
//        introduceCode = lorem.getWords(10);
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),replaceMoreWhitespaceToOne(introduceCode));
//    }
//
//    @Test
//    public void TC06_Update_Introduce_With_Value_Contains_Only_Number(){
//        introduceCode = String.valueOf(randomNumber(3000));
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),introduceCode);
//    }
//
//    @Test
//    public void TC7_Update_Introduce_With_Value_Contains_Special_Characters(){
//        introduceCode = "@#$%^&* %#@##$$";
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),introduceCode);
//    }
//
//    @Test
//    public void TC08_Update_Introduce_With_Values_Contains_HTML_Code(){
//        introduceCode = GlobalVariables.HTML_CODE;
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),introduceCode);
//    }
//
//    @Test
//    public void TC09_Update_Introduce_With_Values_Contains_Script_Code(){
//        introduceCode = GlobalVariables.SCRPIT_CODE;
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify Introduce display");
//        verifyEquals(perDetailAboutTab.getIntroduceDataDisplay(),introduceCode);
//    }
//
//    @Test
//    public void TC10_Update_Introduce_With_Value_More_Than_2000_Characters(){
//        introduceCode = randomName(2001);
//        log.info("Click to Edit Introduce");
//        perDetailAboutTab.clickToButtonEditIntroduce();
//        log.info("Check form Add/ Edit Introduce information display");
//        verifyTrue(perDetailAboutTab.checkFormAddEditIntroduceIsDisplay());
//        log.info("Enter Introduce");
//        perDetailAboutTab.enterDataToIntroduceField(introduceCode);
//        log.info("Click save Introduce");
//        perDetailAboutTab.clickToSaveIntroduceInfo();
//        log.info("Verify message error validate ");
//        verifyEquals(perDetailAboutTab.getMessageErrorOfIntroduceField(),"Giới hạn tối đa của Giới thiệu là 2000 kí tự");
//        perDetailAboutTab.clickToCancelSaveIntroduceInfo();
//    }

    @AfterClass(alwaysRun = true)
    public void endStep(){
        log.info("Click to Edit Introduce");
        perDetailAboutTab.clickToButtonEditIntroduce();
        log.info("Enter Introduce");
        perDetailAboutTab.enterDataToIntroduceField("");
        log.info("Click save Introduce");
        perDetailAboutTab.clickToSaveIntroduceInfo();
        closeBrowserAndDriver(driver);
    }
}
