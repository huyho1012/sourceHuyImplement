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
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckValidation_Tour_Information_07 extends AbstractTest {
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

    String attPolicy = "common.policy";
    String attInstallment = "installment_policy";

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

    //-----------------------------Field chính sách-----------------------------
    @Test(description = "Check khi không nhập giá trị của chính sách")
    public void TC01_Check_Validate_Policy_Is_Null()
    {
        log.info("Step 1: Không nhập vào chính sách");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attPolicy));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attPolicy), dataDetailTourInformation.getAlert_Policy_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số của chính sách")
    public void TC02_Check_Validate_Policy_Is_Number()
    {
        log.info("Step 1: Nnhập vào chính sách là số");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số lẻ của chính sách")
    public void TC03_Check_Validate_Policy_Is_Decimal()
    {
        log.info("Step 1: Nnhập vào chính sách là số lẻ");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là ký tự đặc biệt của chính sách")
    public void TC04_Check_Validate_Policy_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào chính sách là ký tự đặc biệt");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là 1 đoạn script của chính sách")
    public void TC05_Check_Validate_Policy_Is_Script()
    {
        log.info("Step 1: Nhập vào chính sách là 1 đoạn script");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Enter");
        tourInfoTabPO.enterOnTextArea(attPolicy);

        log.info("Step 3: Kiểm alert box không hiển thị bởi script");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());
    }

    @Test(description = "Check khi nhập giá trị là ký tự chữ của chính sách")
    public void TC06_Check_Validate_Policy_Is_Char()
    {
        log.info("Step 1: Nhập vào chính sách là ký tự chữ");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị < min của chính sách")
    public void TC07_Check_Validate_Separate_Regulations_Less_Min()
    {
        log.info("Step 1: Nhập vào chính sách < min");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getPolicy_Less_Min());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getPolicy_Less_Min());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getPolicy_Less_Min());

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attPolicy), dataDetailTourInformation.getAlert_Policy_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị valid của chính sách")
    public void TC08_Check_Validate_Policy_Is_Valid()
    {
        log.info("Step 1: Nhập vào chính sách valid");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getPolicy_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getPolicy_Is_Valid());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy), dataDetailTourInformation.getPolicy_Is_Valid());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attPolicy));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng đầu của chính sách")
    public void TC09_Check_Validate_Policy_Has_Start_Space()
    {
        log.info("Step 1: Nhập vào chính sách có khoảng trắng đầu");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getPolicy_Start_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPolicy_Start_Space()));

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPolicy_Start_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attPolicy));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attPolicy), dataDetailTourInformation.getAlert_Policy_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị có khoảng trắng cuối của chính sách")
    public void TC10_Check_Validate_Policy_Has_End_Space()
    {
        log.info("Step 1: Nhập vào chính sách có khoảng cuối đầu");
        tourInfoTabPO.enterValueToDynamicTextArea(attPolicy, dataDetailTourInformation.getPolicy_End_Space());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPolicy_End_Space()));

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getTextAfterTrim(tourInfoTabPO.getValueOfDynamicTextArea(attPolicy)), tourInfoTabPO.getTextAfterTrim(dataDetailTourInformation.getPolicy_End_Space()));

        log.info("Step 5: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaIsDisplay(attPolicy));

        log.info("Step 6: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDynamicTextArea(attPolicy), dataDetailTourInformation.getAlert_Policy_Less_Min());

        tourInfoTabPO.closeToastMessage();
    }

    //-----------------------------Field chính sách trả góp-----------------------------
    @Test(description = "Check khi không nhập vào chính sách trả góp")
    public void TC11_Check_Validate_Policy_Installment_Is_Null()
    {
        log.info("Step 1: Không nhập vào chính sách trả góp");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 3: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số của chính sách trả góp")
    public void TC12_Check_Validate_Policy_Installment_Is_Number()
    {
        log.info("Step 1: Nnhập vào chính sách là số trả góp");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là số lẻ của chính sách trả góp")
    public void TC13_Check_Validate_Policy_Installment_Is_Decimal()
    {
        log.info("Step 1: Nnhập vào chính sách là số lẻ trả góp");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là ký tự đặc biệt của chính sách trả góp")
    public void TC14_Check_Validate_Policy_Installment_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào chính sách trả góp là ký tự đặc biệt");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là 1 đoạn script của chính sách trả góp")
    public void TC15_Check_Validate_Policy_Installment_Is_Script()
    {
        log.info("Step 1: Nhập vào chính sách trả góp là 1 đoạn script");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Enter");
        tourInfoTabPO.enterOnTextArea(attInstallment);

        log.info("Step 3: Kiểm alert box không hiển thị bởi script");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());
    }

    @Test(description = "Check khi nhập giá trị là ký tự chữ của chính sách trả góp")
    public void TC16_Check_Validate_Policy_Installment_Is_Char()
    {
        log.info("Step 1: Nhập vào chính sách trả góp là ký tự chữ");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập giá trị là valid của chính sách trả góp")
    public void TC17_Check_Validate_Policy_Installment_Is_Valid()
    {
        log.info("Step 1: Nnhập vào chính sách trả góp là số lẻ");
        tourInfoTabPO.enterValueToDynamicTextArea(attInstallment, dataDetailTourInformation.getPolicy_Installment_Is_Valid());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getPolicy_Installment_Is_Valid());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnBottom();

        log.info("Step 4: Kiểm tra giá trị sau khi click save");
        verifyEquals(tourInfoTabPO.getValueOfDynamicTextArea(attInstallment), dataDetailTourInformation.getPolicy_Installment_Is_Valid());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDynamicTextAreaUnDisplay(attInstallment));

        tourInfoTabPO.closeToastMessage();
    }

    @AfterTest(alwaysRun = true)
    public void endTest()
    {
        closeBrowserAndDriver(driver);
    }
}
