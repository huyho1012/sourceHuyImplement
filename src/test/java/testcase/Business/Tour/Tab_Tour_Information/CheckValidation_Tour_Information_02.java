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

public class CheckValidation_Tour_Information_02 extends AbstractTest {
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
    String attTotalDay = "tn123";
    String attBasicPrice = "tn133";
    String attClosingDay = "tn130";
    String attAddress = "address";
    String attRegulations = "common.separate_regulations";
    String attPolicy = "common.policy";
    String attLogo = "logo";
    String attCover = "cover";
    String attAlbum = "gallery";

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

    //-----------------------------Field Số ngày đi tour-----------------------------
    @Test(description = "Check khi không nhập vào tổng số ngày")
    public void TC01_Check_Validate_TotalDay_Is_Null()
    {
        log.info("Step 1: Không nhập vào tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo tổng số ngày có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attTotalDay));

        log.info("Step 4: So sánh cảnh báo của tổng số ngày");
        verifyEquals(tourInfoTabPO.getAlertOnField(attTotalDay), dataDetailTourInformation.getAlert_TotalDay_Is_Required());

        log.info("Step 5: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự là số của tổng số ngày")
    public void TC02_Check_Validate_TotalDay_Is_Number()
    {
        log.info("Step 1: Nhập vào ký tự là số của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: So sánh text đã nhập trước khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button [Save]");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Check cảnh báo tổng số ngày không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attTotalDay));

        log.info("Step 5: So sánh text đã nhập sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 6: Close toast");
        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự là số âm của tổng số ngày => FE tự parse sang số dương")
    public void TC03_Check_Validate_TotalDay_Is_Negative()
    {
        log.info("Step 1: Nhập vào ký tự là số âm của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check cảnh báo lỗi không hiển thị");
        tourInfoTabPO.checkAlertOnFiledUnDisplay(attTotalDay);

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự đặc biệt tổng số ngày => FE tự parse sang rỗng")
    public void TC04_Check_Validate_TotalDay_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào ký tự là kí tự đặc biệt của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: So sánh giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attTotalDay));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attTotalDay), dataDetailTourInformation.getAlert_TotalDay_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào 1 đoạn script tổng số ngày")
    public void TC05_Check_Validate_TotalDay_Is_Script()
    {
        log.info("Step 1: Nhập vào ký tự là 1 đoạn script của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: So sánh giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attTotalDay));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attTotalDay), dataDetailTourInformation.getAlert_TotalDay_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự chữ tổng số ngày")
    public void TC06_Check_Validate_TotalDay_Is_Char()
    {
        log.info("Step 1: Nhập vào ký tự là ký tự chữ của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: So sánh giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attTotalDay));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attTotalDay), dataDetailTourInformation.getAlert_TotalDay_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào tổng số ngày hợp lệ")
    public void TC07_Check_Validate_TotalDay_Is_Valid()
    {
        log.info("Step 1: Nhập vào giá trị hợp lệ của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getTotalDay_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getTotalDay_Is_Valid());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: So sánh giá trị vừa nhập sau khi click button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getTotalDay_Is_Valid());

        log.info("step 5: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attTotalDay));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào tổng số ngày bằng max")
    public void TC08_Check_Validate_TotalDay_Is_Valid()
    {
        log.info("Step 1: Nhập vào giá trị = max của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getTotalDay_Equal_Max());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getTotalDay_Equal_Max());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: So sánh giá trị vừa nhập sau khi click button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getTotalDay_Equal_Max());

        log.info("step 5: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attTotalDay));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào tổng số ngày lớn hơn max")
    public void TC09_Check_Validate_TotalDay_Is_Valid()
    {
        log.info("Step 1: Nhập vào giá trị > max của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getTotalDay_More_Max());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attTotalDay), dataDetailTourInformation.getTotalDay_More_Max());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attTotalDay));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attTotalDay), dataDetailTourInformation.getAlert_TotalDay_More_Max());

        tourInfoTabPO.closeToastMessage();
    }

//    @Test(description = "Check khi nhập vào ký tự là số lẻ của tổng số ngày")
    public void TC10_Check_Validate_TotalDay_Is_Decimal()
    {
        log.info("Step 1: Nhập vào tên tour valid");
        tourInfoTabPO.enterValueToDynamicField(attNameTour, dataDetailTourInformation.getNameTour_Is_Valid());

        log.info("Step 2: Nhập vào mã lưu kho valid");
        tourInfoTabPO.enterValueToDynamicField(attSKU, dataDetailTourInformation.getSKU_Is_Valid());

        log.info("Step 3: Nhập vào ký tự là số lẻ của tổng số ngày");
        tourInfoTabPO.enterValueToDynamicField(attTotalDay, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 4: Nhập vào giá cơ bản valid");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Null());
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Is_Valid());

        log.info("Step 5: Nhập vào hạn chót đặt tour");
        tourInfoTabPO.enterValueToDynamicField(attClosingDay, dataDetailTourInformation.getClosingDays_Is_Valid());

        log.info("Step 6: Nhập địa chỉ valid");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getAddress_Is_Valid_And_Only());
        log.info("Step 7: Click button định vị địa chỉ");
        tourInfoTabPO.clickToButtonGPS();

        log.info("Step 8: Nhập vào mô tả ngắn valid");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_Is_Valid());

        log.info("Step 9: Nhập vào quy định riêng valid");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getPriRegulations_Is_Valid());

        log.info("Step 10: Nhập vào chính sách");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getPolicy_Is_Valid());

        log.info("Step 11: Click button [Thêm logo]");
        tourInfoTabPO.clickToButtonAddLogo();
        log.info("Step 12: Chọn ảnh logo trong gallery");
        tourInfoTabPO.selectImageOnGallery(1);
        log.info("Step 13: Kiểm tra hình vừa mới chọn trong gallery");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 14: Click button [Thêm ảnh bìa]");
        tourInfoTabPO.clickToButtonAddCover();
        log.info("Step 15: Chọn ảnh bìa trong gallery");
        tourInfoTabPO.selectImageOnGallery(1);
        log.info("Step 16: Kiểm tra hình vừa mới chọn trong gallery");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 17: Click button [Thêm album ảnh]");
        tourInfoTabPO.clickToButtonAddAlbum();
        log.info("Step 18: Chọn ảnh trong gallery");
        tourInfoTabPO.selectImageOnGallery(2);
        log.info("Step 19: Kiểm tra hình vừa mới chọn trong gallery");
        verifyTrue(tourInfoTabPO.checkImageOnGalleryIsDisplay(2));

        log.info("Step 20: Click button Save Tour infor");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 21: So sánh tên tour đã nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attNameTour), dataDetailTourInformation.getNameTour_Is_Valid());
        log.info("Step 22: So sánh mã lưu kho đã nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attSKU), dataDetailTourInformation.getSKU_Is_Valid());
        log.info("Step 23: So sánh giá cơ bản đã nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getPriceBasic_Is_Valid() +"0");
        log.info("Step 24: So sánh hạn chót đặt tour");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attClosingDay), dataDetailTourInformation.getClosingDays_Is_Valid());
        log.info("Step 25: So sánh mô tả vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getShortDes_Is_Valid());
        log.info("Step 26: So sánh quy định vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getPriRegulations_Is_Valid());
        log.info("Step 27: So sánh chính sách vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getPolicy_Is_Valid());

        log.info("Step 28: Check toast có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());
        log.info("Step 29: So sánh nội dung lỗi");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Update_Failed());

        log.info("Step 30: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        tourInfoTabPO.refreshPage(driver);
    }

    //-----------------------------Field Giá cơ bản-----------------------------
    @Test(description = "Check khi giá cơ bản khi không nhập vào")
    public void TC11_Check_Validate_Basic_Price_Is_Null()
    {
        log.info("Step 1: Không nhập vào giá cơ bản"); //Trick mới send được chuỗi rỗng
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 5: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attBasicPrice));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attBasicPrice), dataDetailTourInformation.getAlert_BasicPrice_Is_Required());

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào giá trị số nguyên dương")
    public void TC12_Check_Validate_Basic_Price_Is_Number()
    {
        log.info("Step 1: Nhập vào giá trị số nguyên dương");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Number());

        log.info("step 5: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attBasicPrice));

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào giá trị số lẻ")
    public void TC13_Check_Validate_Basic_Price_Is_Decimal()
    {
        log.info("Step 1: Nhập vào giá trị số lẻ");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getValue_Is_Decimal()));

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getValue_Is_Decimal()));

        log.info("step 5: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attBasicPrice));

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào giá trị số nguyên âm")
    public void TC14_Check_Validate_Basic_Price_Is_Negative()
    {
        log.info("Step 1: Nhập vào giá trị số âm");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getValue_Is_Negative()));

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getValue_Is_Negative()));
        System.out.println(tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getValue_Is_Negative()));

        log.info("step 5: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attBasicPrice));

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào kí tự đặc biệt")
    public void TC15_Check_Validate_Basic_Price_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào giá trị ký tự đặc biệt");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Is_Valid());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 5: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attBasicPrice));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attBasicPrice), dataDetailTourInformation.getAlert_BasicPrice_Is_Required());

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào 1 đoạn script")
    public void TC16_Check_Validate_Basic_Price_Is_Script()
    {
        log.info("Step 1: Nhập vào giá trị 1 đoạn script");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Check alert có xuất hiện bởi đoạn script hay không");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào kí tự chữ")
    public void TC17_Check_Validate_Basic_Price_Is_Char()
    {
        log.info("Step 1: Nhập vào giá trị là ký tự chữ");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Is_Valid());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getValue_Is_Null());

        log.info("step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attBasicPrice));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attBasicPrice), dataDetailTourInformation.getAlert_BasicPrice_Is_Required());

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào giá trị hợp lệ")
    public void TC18_Check_Validate_Basic_Price_Is_Valid()
    {
        log.info("Step 1: Nhập vào giá trị là ký tự chữ");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Is_Valid());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị trước khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getPriceBasic_Is_Valid());

        log.info("Step 3: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Button Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), dataDetailTourInformation.getPriceBasic_Is_Valid());

        log.info("step 5: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attBasicPrice));

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào giá trị > max")
    public void TC19_Check_Validate_Basic_Price_Is_More_Max()
    {
        log.info("Step 1: Nhập vào giá trị lớn hơn max");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_More_Max());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("step 3: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attBasicPrice));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attBasicPrice), dataDetailTourInformation.getAlert_BasicPrice_More_Max());

        tourInfoTabPO.closeToastMessage();
        tourInfoTabPO.refreshPage(driver);
    }

    @Test(description = "Check khi giá cơ bản khi nhập vào = max")
    public void TC20_Check_Validate_Basic_Price_Is_Equal_Max()
    {
        log.info("Step 1: Nhập vào giá trị lớn = max");
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getValue_Is_Number());
        tourInfoTabPO.doubleClickOnField(attBasicPrice);
        tourInfoTabPO.enterValueToDynamicField(attBasicPrice, dataDetailTourInformation.getPriceBasic_Equal_Max());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: So sánh giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attBasicPrice), tourInfoTabPO.removeSpecialCharOnField(dataDetailTourInformation.getPriceBasic_Equal_Max()));

        log.info("step 4: Check cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attBasicPrice));

        tourInfoTabPO.closeToastMessage();
    }

    @AfterTest(alwaysRun = true)
    public void endTest()
    {
        closeBrowserAndDriver(driver);
    }
}
