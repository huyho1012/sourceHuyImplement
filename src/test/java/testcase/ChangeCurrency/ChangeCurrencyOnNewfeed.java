package testcase.ChangeCurrency;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;

import Project.Newsfeed.Boooking.BoookingTourPO;
import Project.Newsfeed.Newsfeed.Header.ChangeCurrencyPO;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PageWall.TourDetailPO;
import Project.Shared.LoginPO;
import org.openqa.selenium.WebDriver;

public class ChangeCurrencyOnNewfeed extends AbstractTest {

    WebDriver driver;
    DriverManager driverManager;
    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    ChangeCurrencyPO currencyModel;

    TourDetailPO tourDetailPOBooking;
    BoookingTourPO tourBooking;

    public void precondition(String browserName) {

        log.info("Create browser driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Open Hahalolo newsfeed login");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Change language system to Vietnamese");
        newsfeedLoginPage.clickToChangeLanguageToVI();

        log.info("Login Hahalolo");
        newsfeedLoginPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, "123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Login Newsfeed Hahalolo successfullyu");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));
    }

    public void TC_01_Check_Action_Close_Model_Change_Currency_By_Clicking_Icon_Close(){

        log.info("Step 1 - Open currency popup");
        newsfeedHomepagePO.clickToSymbolCurrencyOnHeaderSection();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickCloseModelChangeCurrency();
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepagePO.checkModelCurrencyCloseSuccess());
    }

    public void TC_02_Check_Action_Close_Model_Change_Currency_By_Click_Over_Model(){

        log.info("Step 1 - Open currency popup");
        newsfeedHomepagePO.clickToSymbolCurrencyOnHeaderSection();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickOverChangeCurrencyModel();
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepagePO.checkModelCurrencyCloseSuccess());
    }

    public void TC_03_Check_Action_Close_Model_Change_Currency_By_Clickinng_Close_Button(){
        log.info("Step 1 - Open currency popup");
        newsfeedHomepagePO.clickToSymbolCurrencyOnHeaderSection();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());

        log.info("Step 3. Click icon close on Model Change currency");
        currencyModel.clickToButtonCloseOnModel();
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify model change currency close successfully");
        verifyTrue(newsfeedHomepagePO.checkModelCurrencyCloseSuccess());
    }

    public void TC_04_ChangeCurrencyOfHahalolOSystem(){
        log.info("Step 1 - Open currency popup");
        newsfeedHomepagePO.clickToSymbolCurrencyOnHeaderSection();
        currencyModel = PageGeneration.openModelChangeCurrency(driver);

        log.info("Step 2. Check Model Change currency is display successfully");
        verifyTrue(currencyModel.checkModelChangeCurrencyIsDisplay());


        log.info("Step 3. Click to choose curency");
        String currencyCode = "";
        currencyModel.clickToChangeCurrencyOnModelChange(currencyCode);
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 4. Verify Change curency successfully");
        verifyTrue(newsfeedHomepagePO.checkModelCurrencyCloseSuccess());
        verifyEquals(newsfeedHomepagePO.getCurrencyCodeDisplayOnHeader(),currencyCode);

        String currencySymbol = getCurrencySymbol(currencyCode);

        log.info("Step 5. Go to Newsfeed Tab Tour");
        newsfeedHomepagePO.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepagePO.getCurrencySymbolOnTourProduct(), currencySymbol);

        log.info("Step 5. Go to Newsfeed Tab Hotel");
        newsfeedHomepagePO.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepagePO.getCurrencySymbolOnHotelProduct(), currencySymbol);

        log.info("Step 5. Go to Newsfeed Tab Shopping");
        newsfeedHomepagePO.clickToTabItemOnNewsfeedNavigationMenu("");

        log.info("Step 6. Verify currency symbol");
        verifyEquals(newsfeedHomepagePO.getCurrencySymbolOnShoppingProductPost(), currencySymbol);

        log.info("Step. Go to Tour Detail");
        newsfeedHomepagePO.openURL(driver,"");
        tourDetailPOBooking = PageGeneration.createTourDetailBookingPage(driver);

        verifyEquals(tourDetailPOBooking.getCurrencyOnPriceFromSection(), currencySymbol);

        log.info("Step - Go to Tour scheduler");
        tourDetailPOBooking.clickToSchedulerTab();

        verifyTrue(tourDetailPOBooking.checkTourSchedulerTabIsDisplay());

        verifyEquals(tourDetailPOBooking.getCurrencySymbolOfTourItemOnScheduler(), currencyCode);

        log.info("Step - Go to booking Tour");
        tourDetailPOBooking.chooseDepatureDateWantBooking();
        tourBooking = PageGeneration.createTourBookingPage(driver);

        verifyEquals(tourBooking.getCurrencySymbolPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolServicePriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolVATDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolTotalPriceDisplayOnSidebar(),currencyCode);

        verifyEquals(tourBooking.getCurrencySymbolTourPriceDisplayOnDetailStep1(),currencyCode);

        verifyEquals(tourBooking.getCurrencySymbolAdultPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolChildPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolYoungChildPriceDisplayOnPriceTable(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolBabyPriceDisplayOnPriceTable(),currencyCode);

        tourBooking.clickToNextStep(driver);

        verifyTrue(tourBooking.checkTourBookingStep2IsDisplay());
        verifyEquals(tourBooking.getCurrencySymbolAdultPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolChildPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolYoungChildPriceDisplayOnSidebar(),currencyCode);
        verifyEquals(tourBooking.getCurrencySymbolBabyPriceDisplayOnSidebar(), currencyCode);

        verifyEquals(tourBooking.getCurSymbolTotalPriceOfAdultItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfChildItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfYoungChildItemOnTravellerInfo(),currencyCode);
        verifyEquals(tourBooking.getCurSymbolTotalPriceOfBabyItemOnTravellerInfo(), currencyCode);

    }
}
