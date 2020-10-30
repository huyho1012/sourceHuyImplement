package Testcase.Business.Tour.Tab_Tour_Information;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Business.Business.BusinessDashboardPagePO;
import Project.Business.Business.BusinessListPagePO;
import Project.Business.Business.BusinessOverviewPagePO;
import Project.Business.Tour.Management.Detail.TourInfoTabPO;
import Project.Business.Tour.TourDashboardPagePO;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Shared.LoginPO;
import Testdata.Business.Tour.Dashboad.Data_Dashboard_Tour;
import Testdata.Business.Tour.Detail_Information.Data_Detail_Tour_Information;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckValidation_Tour_Information_01 extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    LoginPO loginPageObject;
    NewsfeedHomepagePO newsfeedHomepagePO;
    BusinessOverviewPagePO businessOverviewPagePO;
    BusinessDashboardPagePO businessDashboardPagePO;
    BusinessListPagePO businessListPagePO;
    TourDashboardPagePO tourDashboardPagePO;
    TourInfoTabPO tourInfoTabPO;
    Data_Dashboard_Tour dataDashboardTour;
    Data_Detail_Tour_Information dataDetailTourInformation;
    String languageSys;

    String attNameTour = "tv151";
    String attSKU = "tv102";


    @Parameters("browser")
    @BeforeTest
    public void preStepConditionStep(String browserName) throws IOException
    {
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);

        log.info("Login newsfeed");
        loginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
        languageSys = loginPageObject.getLanguageOfSystemHahalolo();
        loginPageObject.loginToNewsfeedHahalolo(GlobalVariables.EMAIL_TAI, GlobalVariables.PASS_TAI);

        log.info("Điều hướng qua business page");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed(languageSys));
//        newsfeedHomepagePO.negativeToURLByJS(driver, GlobalVariables.LINK_TEST_BUSINESS);
        newsfeedHomepagePO.negativeToURLByJS(driver, "https://test-business.hahalolo.com/5ec214c3bc502605ccd3f771/tour/5ec215a9bc502605ccd3f774/info/5f87b83fbc502609c228aaff?lang=vi&tab=information");

//        log.info("Click button [Quản lý tài khoản]");
//        businessOverviewPagePO = PageGeneration.createBusinessOverviewPage(driver);
//        businessOverviewPagePO.clickToAccountManagementButton();
//
//        log.info("Click menu [Trang]");
//        businessDashboardPagePO = PageGeneration.createBusinessDashboardPage(driver);
//        businessDashboardPagePO.clickToNavItemPage();
//
//        log.info("Click vào page ở list sidebar left");
//        businessListPagePO = PageGeneration.createBusinessListPage(driver);
//        businessListPagePO.clickToPageOnList("HetTien Tour");
//
//        log.info("Click vào textlink Quản lý trang");
//        businessListPagePO.clickToTextLinkManagerPage();
//
//        log.info("Kiểm tra page loaded");
//        tourDashboardPagePO = PageGeneration.createTourDashboardPage(driver);
//        verifyTrue(tourDashboardPagePO.checkPageIsDisplay("HetTien Tour")); //Cần phải check tất cả component của page(Sẽ update)
////
        dataDashboardTour  = Data_Dashboard_Tour.getDashboardTourData(GlobalVariables.ROOT_FOLDER + "\\src\\test\\java\\Testdata\\Business\\Tour\\Dashboad\\Data_Dashboard_Tour.json");
        dataDetailTourInformation = Data_Detail_Tour_Information.getDataDetailTourInformation(GlobalVariables.ROOT_FOLDER + "\\src\\test\\java\\Testdata\\Business\\Tour\\Detail_Information\\Data_Detail_Tour_Information.json");
//
//        log.info("Click vào button [Tạo Tour]");
//        tourDashboardPagePO.clickToButtonCreateTour();
//        log.info("Nhập tên tour");
//        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_Valid());
//        log.info("Chọn topic");
//        tourDashboardPagePO.selectTopicOnPopupCreateTour("Biển là nhà");
//        log.info("Click button save");
//        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();
//        log.info("Check cảnh báo của tên tour không hiển thị");
//        verifyTrue(tourDashboardPagePO.checkAlertOnTourNameUndisplay());
//        log.info("Check cảnh báo của topic không hiển thị");
//        verifyTrue(tourDashboardPagePO.checkAlertOnTourTopicUndisplay());
//        log.info("Check chuyển màn hình tour information có tiêu đề chi tiết + tên tour");
        tourInfoTabPO = PageGeneration.createTourInfoTab(driver);
//        verifyEquals(tourInfoTabPO.getHeaderTitle(), dataDashboardTour.getNameTour_Valid());
    }

    //-----------------------------Field Tên tour-----------------------------

    @Test(description = "Check khi nhập vào ký tự số của tên tour")
    public void TC01_Check_Validate_Name_Tour_Is_Number() {
        log.info("Step 1: Nhập vào ký tự là số của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 4: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi không nhập tên tour")
    public void TC02_Check_Validate_Name_Tour_Is_Null()
    {
        log.info("Step 1: Không nhập vào tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 4: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getAlertOnField(attNameTour), dataDetailTourInformation.getAlert_NameTour_Is_Required());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự số lẻ của tên tour")
    public void TC03_Check_Validate_Name_Tour_Is_Decimal()
    {
        log.info("Step 1: Nhập vào ký tự là số lẻ của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự số âm của tên tour")
    public void TC04_Check_Validate_Name_Tour_Is_Negative() {
        log.info("Step 1: Nhập vào ký tự là số âm của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào kí tự đặc biệt của tên tour")
    public void TC05_Check_Validate_Name_Tour_Is_Special_Char() {
        log.info("Step 1: Nhập vào ký tự đặc biệt của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào script của tên tour")
    public void TC06_Check_Validate_Name_Tour_Is_Script() {
        log.info("Step 1: Nhập vào 1 đoạn script của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra có đoạn script không làm alert xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());

        log.info("Step 4: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự chữ của tên tour")
    public void TC07_Check_Validate_Name_Tour_Is_Char()
    {
        log.info("Step 1: Nhập vào ký tự chữ của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào chuỗi hợp lệ của tên tour")
    public void TC08_Check_Validate_Name_Tour_Is_Valid()
    {
        log.info("Step 1: Nhập vào chuỗi hợp lệ của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_Is_Valid());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_Is_Valid());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_Is_Valid());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 4 ký tự của tên tour")
    public void TC09_Check_Validate_Name_Tour_Has_4_Char()
    {
        log.info("Step 1: Nhập vào 4 ký tự của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_4_char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_4_char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_4_char());

        log.info("Step 5: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 6: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getAlertOnField(attNameTour), dataDetailTourInformation.getAlert_NameTour_Less_Min());

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 5 ký tự của tên tour")
    public void TC10_Check_Validate_Name_Tour_Has_5_Char()
    {
        log.info("Step 1: Nhập vào 5 ký tự của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_5_char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_5_char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_5_char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 255 ký tự của tên tour")
    public void TC11_Check_Validate_Name_Tour_Has_255_Char()
    {
        log.info("Step 1: Nhập vào 255 ký tự của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_255_char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_255_char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_255_char());
    }

    @Test(description = "Check khi nhập vào 256 ký tự của tên tour")
    public void TC12_Check_Validate_Name_Tour_Has_256_Char()
    {
        log.info("Step 1: Nhập vào 256 ký tự của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_256_char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_256_char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_256_char());

        log.info("Step 6: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getAlertOnField(attNameTour), dataDetailTourInformation.getAlert_NameTour_More_Max());

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng của tên tour")
    public void TC13_Check_Validate_Name_Tour_Has_5_Space_Char()
    {
        log.info("Step 1: Nhập vào 5 ký tự trắng của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_5_space());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 4: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getAlertOnField(attNameTour), dataDetailTourInformation.getAlert_NameTour_Is_Required());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng ở đầu chuỗi của tên tour")
    public void TC14_Check_Validate_Name_Tour_Has_Space_Head()
    {
        log.info("Step 1: Nhập vào chuỗi có ký tự trắng ở đầu của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_Start_Space());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_Start_Space());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getNameTour_Start_Space()));

        log.info("Step 6: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getAlertOnField(attNameTour)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getAlert_NameTour_Less_Min()));

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng ở cuối chuỗi của tên tour")
    public void TC15_Check_Validate_Name_Tour_Has_Space_Last()
    {
        log.info("Step 1: Nhập vào chuỗi có ký tự trắng ở đầu của tên tour");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_End_Space());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_End_Space());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tên tour có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attNameTour));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getNameTour_End_Space()));

        log.info("Step 6: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getAlertOnField(attNameTour)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getAlert_NameTour_Less_Min()));

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    //-----------------------------Field Mã lưu kho-----------------------------
    @Test(description = "Check khi không nhập SKU")
    public void TC16_Check_Validate_SKU_Is_Null()
    {
        log.info("Step 1: Không nhập vào SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 4: So sánh cảnh báo của SKU");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_Is_Required());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự số của SKU")
    public void TC17_Check_Validate_SKU_Is_Number()
    {
        log.info("Step 1: Nhập vào ký tự là số của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự số lẻ của SKU")
    public void TC18_Check_Validate_SKU_Is_Decimal()
    {
        log.info("Step 1: Nhập vào ký tự là số lẻ của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự số âm của SKU")
    public void TC19_Check_Validate_SKU_Is_Negative()
    {
        log.info("Step 1: Nhập vào ký tự là số âm của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào kí tự đặc biệt của SKU")
    public void TC20_Check_Validate_SKU_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào ký tự đặc biệt của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào script của SKU")
    public void TC21_Check_Validate_SKU_Is_Script()
    {
        log.info("Step 1: Nhập vào 1 đoạn script của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra có đoạn script không làm alert xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());

        log.info("Step 5: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 6: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự chữ của SKU")
    public void TC22_Check_Validate_SKU_Is_Char()
    {
        log.info("Step 1: Nhập vào ký tự chữ của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào chuỗi hợp lệ của SKU")
    public void TC23_Check_Validate_SKU_Is_Valid()
    {
        log.info("Step 1: Nhập vào chuỗi hợp lệ của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_Is_Valid());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_Is_Valid());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_Is_Valid());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 2 ký tự của SKU")
    public void TC24_Check_Validate_SKU_Has_2_Char()
    {
        log.info("Step 1: Nhập vào 2 ký tự của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_2_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_2_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 5: So sánh cảnh báo của SKU");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_Less_Min());

        log.info("Step 6: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_2_Char());

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 3 ký tự của SKU")
    public void TC25_Check_Validate_SKU_Has_3_Char()
    {
        log.info("Step 1: Nhập vào 3 ký tự của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_3_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_3_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_3_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 255 ký tự của SKU")
    public void TC26_Check_Validate_SKU_Has_255_Char()
    {
        log.info("Step 1: Nhập vào 255 ký tự của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_255_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_255_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_255_Char());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 256 ký tự của SKU")
    public void TC27_Check_Validate_SKU_Has_256_Char()
    {
        log.info("Step 1: Nhập vào 256 ký tự của SKUr");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_256_Char());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_256_Char());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_256_Char());

        log.info("Step 6: So sánh cảnh báo của SKU");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_More_Max());

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng của SKU")
    public void TC28_Check_Validate_SKU_Has_5_Space_Char()
    {
        log.info("Step 1: Nhập vào 5 ký tự trắng của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_5_Space());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 4: So sánh cảnh báo của SKU");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_Is_Required());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng ở đầu chuỗi của SKU")
    public void TC29_Check_Validate_SKU_Has_Space_Head()
    {
        log.info("Step 1: Nhập vào chuỗi có ký tự trắng ở đầu của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_Start_Space());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_Start_Space());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 5: So sánh cảnh báo của SKU");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_Less_Min());

        log.info("Step 6: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOnFiled(attSKU)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getSKU_Start_Space()));

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự trắng ở cuối chuỗi của SKU")
    public void TC30_Check_Validate_SKU_Has_Space_Last()
    {
        log.info("Step 1: Nhập vào chuỗi có ký tự trắng ở đầu của SKU");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_End_Space());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_End_Space());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo SKU có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attSKU));

        log.info("Step 5: So sánh cảnh báo của tên tour");
        verifyEquals(tourInfoTabPO.getAlertOnField(attSKU), dataDetailTourInformation.getAlert_SKU_Less_Min());

        log.info("Step 6: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOnFiled(attSKU)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getSKU_End_Space()));

        log.info("Step 7: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @AfterTest(alwaysRun = true)
    public void endTest()
    {
        closeBrowserAndDriver(driver);
    }
}
