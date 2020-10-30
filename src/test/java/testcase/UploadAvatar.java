package testcase;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PersonalWall.Timeline.NewsfeedPersonalTimelinePO;
import Project.Shared.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadAvatar extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    NewsfeedPersonalTimelinePO personalTimeline;

    String accountEmail = GlobalVariables.USER_EMAIL_ACCOUNT;
    String accountPass = GlobalVariables.USER_EMAIL_PASSWORD;

    @Parameters("browser")
    @BeforeClass
    public void openNewBrowser(String browserName){
        log.info("Create Driver");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open Browser and Go to Newsfeed Hahalolo");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Change Newsfeed Hahalolo system to VI");
        newsfeedLoginPage.clickToChangeLanguageToVI();
        log.info("Login Newsfeed Hahalolo");
        newsfeedLoginPage.loginToNewsfeedHahalolo(accountEmail, accountPass);
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Verify Newsfeed Homepage display successfully");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));
        log.info("Go to personal wall");
        newsfeedHomepagePO.clickToAvatarOnHeaderSection();
        personalTimeline = PageGeneration.createPersonalTimeLinePage(driver);
    }

    @Test
    public void TC01_Check_Update_Avatar_By_Image_Format(){
        log.info("Image format is jpg");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.jpg");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is png");
        personalTimeline.clickToUploadAvatarByLocalImage( "FormatFile\\a.png");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is gif");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng");

        log.info("Image format is ico");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.ico");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is bmp");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.bmp");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is jpeg");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.jpeg");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is tiff");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng");

        log.info("Image format is webp");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.webp");
        personalTimeline.crossAvatarImage(driver);

        log.info("Image format is tif");
        personalTimeline.clickToUploadAvatarByLocalImage("FormatFile\\a.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng");
    }

    @Test
    public void TC02_Check_Update_Cover_By_Image_Format(){
        log.info("Image format is jpg");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.jpg");
        personalTimeline.saveChangeImage();

        log.info("Image format is png");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.png");
        personalTimeline.saveChangeImage();

        log.info("Image format is gif");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.gif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng");

        log.info("Image format is ico");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.ico");
        personalTimeline.saveChangeImage();

        log.info("Image format is bmp");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.bmp");
        personalTimeline.saveChangeImage();

        log.info("Image format is jpeg");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.jpeg");
        personalTimeline.saveChangeImage();

        log.info("Image format is tiff");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.tiff");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng");

        log.info("Image format is webp");
        personalTimeline.clickToUploadCoverByLocalImage("FormatFile\\a.webp");
        personalTimeline.saveChangeImage();

        log.info("Image format is tif");
        personalTimeline.clickToUploadCoverByLocalImage ("FormatFile\\a.tif");
        verifyEquals(personalTimeline.getErrMessageOfValidationFileUpload(),"Tập tin không đúng định dạng ne");
    }
}
