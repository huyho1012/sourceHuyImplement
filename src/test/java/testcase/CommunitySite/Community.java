package testcase.CommunitySite;

import Common.DriverManagement.DriverManager;

import Common.HelperFunction.AbstractTest;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Shared.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Community extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    LoginPO newsfeedLogin;
    NewsfeedHomepagePO newsfeedHomepagePO;
    @Parameters({"browser"})
    @BeforeTest
    public void preconditionTest(String browserName) {
//        log.info("Precondition - Step 1. Create Browser Driver ");
//        driverManager = BrowserInitialization.getBrowser(browserName);
//        log.info("Precondition - Step 2. Open browser and go to Newsfeed login");
//        driver = driverManager.getDriver(GlobalVariables.newsfeedURL);
//        newsfeedLogin = PageGeneration.createNewsfeedLoginPage(driver);
//        log.info("Precondition - Step 3. Change system language To Vi");
//        newsfeedLogin.clickToChangeLanguageToVI(driver);
//        newsfeedLogin.Login("balo_04@mailinator.com","123456");
//        newsfeedHomepage = PageGeneration.createNewsfeedHomepage(driver);
    }
    @Test
    public void Test() {

    }
}
