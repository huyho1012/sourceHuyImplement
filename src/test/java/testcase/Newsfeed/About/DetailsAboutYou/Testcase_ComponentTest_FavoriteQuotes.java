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

public class Testcase_ComponentTest_FavoriteQuotes extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper;
    Lorem lorem;
    // Khai báo param
    String languageSystem , fullName;
    String quotes;
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
    public void TC01_Update_Favorite_Quote_With_Blank_Data() {
        quotes = "";
        log.info("1. Click to Add faviore quotes");
        perDetailAboutTab.clickToButtonAddFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
    }

    @Test
    public void TC02_Update_Favorite_Quote_With_Data_Contains_All_Whitespace() {
        quotes = "     ";
        log.info("1. Click to Add faviore");
        perDetailAboutTab.clickToButtonAddFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),"");
    }

    @Test
    public void TC03_Update_FavoriteQuote_With_Data_Is_One_Paragarph(){
        quotes = lorem.getParagraphs(1,1);
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),"");
    }

    @Test
    public void TC04_Update_FavoriteQuote_With_Data_Are_More_Than_2_Paragarphs(){
        quotes = lorem.getParagraphs(2,5);
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),replaceMoreWhitespaceToOne(quotes).replaceAll("\n", ""));
    }

    @Test
    public void TC05_Update_FavoriteQuote_With_Data_Is_One_Sentence(){
        quotes = lorem.getWords(10);
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Edit favorite quotes display");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),replaceMoreWhitespaceToOne(quotes));
    }

    @Test
    public void TC06_Update_FavoriteQuote_With_Data_Is_Only_Number(){
        quotes = String.valueOf(randomNumber(3000));
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Edit favorite quotes display");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),quotes);
    }

    @Test
    public void TC7_Update_FavoriteQuote_With_Data_Is_Contains_Special_Characters(){
        quotes = "@#$%^&* %#@##$$";
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),quotes);
    }

    @Test
    public void TC08_Update_FavoriteQuote_With_Data_Is_Contains_HTML_Code(){
        quotes = GlobalVariables.HTML_CODE;
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),quotes);
    }

    @Test
    public void TC09_Update_FavoriteQuote_With_Data_Is_Contains_Script_Code(){
        quotes = GlobalVariables.SCRPIT_CODE;
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Check Form Add/Edit favorite quotes");
        verifyTrue(perDetailAboutTab.checkFormAddEditFavoriteQuoteIsDisplayed());
        log.info("3. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote(quotes);
        log.info("4. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        log.info("5. Verify favorite quotes display on tab");
        verifyEquals(perDetailAboutTab.getFavoriteQuotesDisplayOnDetailsAbout(),quotes);
    }

    @AfterClass(alwaysRun = true)
    public void endStep(){
        log.info("1. Click to Edit favorite quotes");
        perDetailAboutTab.clickToButtonEditFavoriteQuote();
        log.info("2. Enter favorite quotes");
        perDetailAboutTab.enterDataToTextAreaFavoriteQuote("");
        log.info("3. Click to button save quotes");
        perDetailAboutTab.clickToButtonSaveOnFormFavoriteQuote();
        closeBrowserAndDriver(driver);
    }
}
