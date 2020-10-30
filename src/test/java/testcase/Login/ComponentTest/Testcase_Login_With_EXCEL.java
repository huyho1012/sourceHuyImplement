package testcase.Login.ComponentTest;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.ExcelUitls.ExcelUtil;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Shared.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Testcase_Login_With_EXCEL extends AbstractTest {
    DriverManager driverManager;
    LoginPO newsfeedLogin;
    NewsfeedHomepagePO newsFeedHomePage;
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeTest
    public void preconditionTest(String browserName) {
        ExcelUtil.setExcelFileSheet();

        log.info("Precondition - Step 1. Create Browser Driver ");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Precondition - Step 3. Change system language To Vi");
        newsfeedLogin.clickToChangeLanguageToVI();
    }

    @Test
    public void TC01_Login_With_Invalid_Information(){
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(1));
        ExcelUtil.setRowNumber(1);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(),ExcelUtil.getCellData(1,4));
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(),ExcelUtil.getCellData(1,5));
    }

    @Test
    public void TC02_Login_With_Account_Not_Exist_On_Hahalolo() {
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(2));
        ExcelUtil.setRowNumber(2);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(2, 5));
    }

    @Test
    public void TC03_Login_With_Incorrect_Password(){
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(3));
        ExcelUtil.setRowNumber(3);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(3, 5));
    }

    @Test
    public void T04_Login_With_Invalid_Password(){
        log.info("Step 1. Blank password");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(4));
        ExcelUtil.setRowNumber(4);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(4, 5));

        log.info("Step 2. All white space");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(5));
        ExcelUtil.setRowNumber(5);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(5, 5));

        log.info("Step 3. Password less than 6 chars");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(6));
        ExcelUtil.setRowNumber(6);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(6, 5));

        log.info("Step 4. Password more than 129 chars");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(7));
        ExcelUtil.setRowNumber(7);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(7, 5));

        log.info("Step 5. Password contains one white space");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(8));
        ExcelUtil.setRowNumber(8);
        verifyEquals(newsfeedLogin.getMessageValidateFieldPassword(), ExcelUtil.getCellData(8, 5));
    }

    @Test
    public void TC05_Login_With_Invalid_Account() {
        log.info("Step 1 - Blank Username");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(9));
        ExcelUtil.setRowNumber(9);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(9, 4));

        log.info("Step 2. Enter username all white space");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(10));
        ExcelUtil.setRowNumber(10);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(10, 4));

        log.info("Step 3. Email not contains domain");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(11));
        ExcelUtil.setRowNumber(11);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(11, 4));

        log.info("Step 4. Email contain whitespace on first position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(12));
        ExcelUtil.setRowNumber(12);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(12, 4));

        log.info("Step 5. Email contain whitespace on last position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(13));
        ExcelUtil.setRowNumber(13);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(13, 4));

        log.info("Step 6. Email contain whitespace on middle position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(14));
        ExcelUtil.setRowNumber(14);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(14, 4));

        log.info("Step 7 - Invalid email contain special character");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(15));
        ExcelUtil.setRowNumber(15);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(15, 4));

        log.info("Step 8 - Phone contain whitespace on first position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(16));
        ExcelUtil.setRowNumber(16);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(16, 4));

        log.info("Step 9 - Phone contain whitespace on middle position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(17));
        ExcelUtil.setRowNumber(17);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(17, 4));

        log.info("Step 10 - Phone contain whitespace on last position");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(18));
        ExcelUtil.setRowNumber(18);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(18, 4));

        log.info("Step 11 - Phone less than 8 number chars");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(19));
        ExcelUtil.setRowNumber(19);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(19, 4));

        log.info("Step 12 - Phone greater than 20 number chars");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(20));
        ExcelUtil.setRowNumber(20);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(20, 4));

        log.info("Step 13 - Invalid phone contains phone area with Character '+'");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(21));
        ExcelUtil.setRowNumber(21);
        verifyEquals(newsfeedLogin.getMessageValidateFieldUsername(), ExcelUtil.getCellData(21, 4));
    }

    @Test
    public void TC06_Login_With_Valid_Account(){
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(22));
        ExcelUtil.setRowNumber(22);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 4. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedHomepageIsDisplayed("vi"));
        log.info("Step 5. Logout account");
        newsFeedHomePage.clickToItemSettingOnHeaderSection("ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Step 6. Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }
    @Test
    public void TC07_Login_With_Uppercase_Email(){
        log.info("Step 1. Login account");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(23));
        ExcelUtil.setRowNumber(23);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify Login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedHomepageIsDisplayed("vi"));

        log.info("Step 3 - Logout account");
        newsFeedHomePage.clickToItemSettingOnHeaderSection("ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Step 4 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }

    @Test
    public void TC08_Login_With_Valid_Phone(){
        log.info("Step 1. Login account");
        newsfeedLogin.loginNewsfeedHahaloloByUsingExcelFile(ExcelUtil.getRowData(24));
        ExcelUtil.setRowNumber(24);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify login success");
        verifyTrue(newsFeedHomePage.checkNewsfeedHomepageIsDisplayed("vi"));

        log.info("Step 3 - Logout account");
        newsFeedHomePage.clickToItemSettingOnHeaderSection("ic-logout-c");
        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Step 4 - Check Logout account success");
        verifyTrue(newsfeedLogin.checkNewsfeedLoginPageIsDisplayed());
    }
}
