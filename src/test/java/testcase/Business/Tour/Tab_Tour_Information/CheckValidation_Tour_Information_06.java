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

public class CheckValidation_Tour_Information_06 extends AbstractTest {
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


    String attRegulations = "common.separate_regulations";


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

    //-----------------------------Field Mô tả ngắn-----------------------------
    @Test(description = "Check khi không nhập mô tả ngắn")
    public void TC01_Check_Short_Des_Is_Null()
    {
        log.info("Step 1: Không nhập vào mô tả ngắn");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra cảnh báo lỗi có xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesIsDisplay());

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnShortDes(), dataDetailTourInformation.getAlert_ShortDes_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số của mô tả ngắn")
    public void TC02_Check_Short_Des_Is_Number()
    {
        log.info("Step 1: Nhập vào giá trị là số");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số lẻ mô tả ngắn")
    public void TC03_Check_Short_Des_Is_Decimal()
    {
        log.info("Step 1: Nhập vào giá trị là số lẻ");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số âm mô tả ngắn")
    public void TC04_Check_Short_Des_Is_Negative()
    {
        log.info("Step 1: Nhập vào giá trị là số âm");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị đặc biệt mô tả ngắn")
    public void TC05_Check_Short_Des_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào giá trị là số âm");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập 1 đoạn script mô tả ngắn")
    public void TC06_Check_Short_Des_Is_Script()
    {
        log.info("Step 1: Nhập vào giá trị là số âm");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra alert box không xuất hiện bởi script");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());

        log.info("Step 5: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 6: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là ký tự chữ mô tả ngắn")
    public void TC07_Check_Short_Des_Is_Char()
    {
        log.info("Step 1: Nhập vào giá trị là số âm");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị nhỏ hơn min mô tả ngắn")
    public void TC08_Check_Short_Des_Is_Less_Min()
    {
        log.info("Step 1: Nhập vào giá trị nhỏ hơn min");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_Less_Min());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getShortDes_Less_Min());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getShortDes_Less_Min());

        log.info("Step 5: Kiểm tra cảnh báo lỗi có xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesIsDisplay());

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnShortDes(), dataDetailTourInformation.getAlert_ShortDes_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị lớn hơn max mô tả ngắn => Chỉ nhập được đến ký tự thứ 400")
    public void TC09_Check_Short_Des_Is_More_Max()
    {
        log.info("Step 1: Nhập vào giá trị lớn hơn max");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_More_Max());

        log.info("Step 2: So sánh giá trị vừa nhập (Chỉ tới ký tự thứ 400)");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), tourInfoTabPO.getValueAvailOfShortDes(tourInfoTabPO.getValueOfShortDes()));

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: So sánh lại giá trị");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), tourInfoTabPO.getValueAvailOfShortDes(tourInfoTabPO.getValueOfShortDes()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị valid mô tả ngắn")
    public void TC10_Check_Short_Des_Is_Valid()
    {
        log.info("Step 1: Nhập vào giá trị là valid");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getShortDes_Is_Valid());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getValueOfShortDes(), dataDetailTourInformation.getShortDes_Is_Valid());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesUnDisplay());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng đầu mô tả ngắn")
    public void TC11_Check_Short_Des_Has_Start_Space()
    {
        log.info("Step 1: Nhập vào giá trị có khoảng trắng đầu");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_Start_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfShortDes()), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getShortDes_Start_Space()));

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfShortDes()), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getShortDes_Start_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesIsDisplay());

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnShortDes(), dataDetailTourInformation.getAlert_ShortDes_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng cuối mô tả ngắn")
    public void TC12_Check_Short_Des_Has_End_Space()
    {
        log.info("Step 1: Nhập vào giá trị có khoảng trắng cuối");
        tourInfoTabPO.enterValueToShortDes(dataDetailTourInformation.getShortDes_End_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfShortDes()), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getShortDes_End_Space()));

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click button save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfShortDes()), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getShortDes_End_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnShortDesIsDisplay());

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnShortDes(), dataDetailTourInformation.getAlert_ShortDes_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    //-----------------------------Field quy định riêng-----------------------------
    @Test(description = "Check khi không nhập giá trị của quy định riêng")
    public void TC013_Check_Validate_Separate_Regulations_Is_Null()
    {
        log.info("Step 1: Không nhập vào quy định riêng");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attRegulations));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attRegulations), dataDetailTourInformation.getAlert_PriRegulations_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số của quy định riêng")
    public void TC14_Check_Validate_Separate_Regulations_Is_Number()
    {
        log.info("Step 1: Nnhập vào quy định riêng là số");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số lẻ của quy định riêng")
    public void TC15_Check_Validate_Separate_Regulations_Is_Decimal()
    {
        log.info("Step 1: Nnhập vào quy định riêng là số lẻ");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là ký tự đặc biệt của quy định riêng")
    public void TC16_Check_Validate_Separate_Regulations_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào quy định riêng là ký tự đặc biệt");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là 1 đoạn script của quy định riêng")
    public void TC17_Check_Validate_Separate_Regulations_Is_Script()
    {
        log.info("Step 1: Nhập vào quy định riêng là 1 đoạn script");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Enter");
        tourInfoTabPO.enterOnTextArea(attRegulations);

        log.info("Step 3: Kiểm alert box không hiển thị bởi script");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());
    }

    @Test(description = "Check khi nhập giá trị là ký tự chữ của quy định riêng")
    public void TC18_Check_Validate_Separate_Regulations_Is_Char()
    {
        log.info("Step 1: Nhập vào quy định riêng là ký tự chữ");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị < min của quy định riêng")
    public void TC19_Check_Validate_Separate_Regulations_Less_Min()
    {
        log.info("Step 1: Nhập vào quy định riêng < min");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getPriRegulations_Less_Min());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getPriRegulations_Less_Min());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getPriRegulations_Less_Min());

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attRegulations), dataDetailTourInformation.getAlert_PriRegulations_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị valid của quy định riêng")
    public void TC20_Check_Validate_Separate_Regulations_Is_Valid()
    {
        log.info("Step 1: Nhập vào quy định riêng valid");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getPriRegulations_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getPriRegulations_Is_Valid());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations), dataDetailTourInformation.getPriRegulations_Is_Valid());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attRegulations));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng đầu của quy định riêng")
    public void TC21_Check_Validate_Separate_Regulations_Has_Start_Space()
    {
        log.info("Step 1: Nhập vào quy định riêng có khoảng trắng đầu");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getPriRegulations_Start_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPriRegulations_Start_Space()));

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPriRegulations_Start_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attRegulations));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attRegulations), dataDetailTourInformation.getAlert_PriRegulations_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng cuối của quy định riêng")
    public void TC22_Check_Validate_Separate_Regulations_Has_End_Space()
    {
        log.info("Step 1: Nhập vào quy định riêng có khoảng cuối đầu");
        tourInfoTabPO.enterValueToDynamicTextArea(attRegulations, dataDetailTourInformation.getPriRegulations_End_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPriRegulations_End_Space()));

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attRegulations)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPriRegulations_End_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attRegulations));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attRegulations), dataDetailTourInformation.getAlert_PriRegulations_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }


    @AfterTest(alwaysRun = true)
    public void endTest()
    {
        closeBrowserAndDriver(driver);
    }
}
