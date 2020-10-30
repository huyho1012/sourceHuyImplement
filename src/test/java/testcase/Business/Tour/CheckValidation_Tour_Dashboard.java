package testcase.Business.Tour;

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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckValidation_Tour_Dashboard extends AbstractTest
{
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

    @Parameters("browser")
    @BeforeTest
    public void preStepConditionStep(String browserName) throws IOException
    {
        driverManager = BrowserInitialization.getBrowser(browserName);

        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        loginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Login newsfeed");
        loginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
        loginPageObject.loginToNewsfeedHahalolo(GlobalVariables.EMAIL_TAI, GlobalVariables.PASS_TAI);

        log.info("Điều hướng qua business page");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));
        newsfeedHomepagePO.negativeToURLByJS(driver, GlobalVariables.LINK_TEST_BUSINESS);

        log.info("Click button [Quản lý tài khoản]");
        businessOverviewPagePO = PageGeneration.createBusinessOverviewPage(driver);
        businessOverviewPagePO.clickToAccountManagementButton();

        log.info("Click menu [Trang]");
        businessDashboardPagePO = PageGeneration.createBusinessDashboardPage(driver);
        businessDashboardPagePO.clickToNavItemPage();

        log.info("Click vào page ở list sidebar left");
        businessListPagePO = PageGeneration.createBusinessListPage(driver);
        businessListPagePO.clickToPageOnList("HetTien Tour");

        log.info("Click vào textlink Quản lý trang");
        businessListPagePO.clickToTextLinkManagerPage();

        log.info("Kiểm tra page loaded");
        tourDashboardPagePO = PageGeneration.createTourDashboardPage(driver);
        verifyTrue(tourDashboardPagePO.checkPageIsDisplay("HetTien Tour")); //Cần phải check tất cả component của page(Sẽ update)

        dataDashboardTour  = Data_Dashboard_Tour.getDashboardTourData(GlobalVariables.ROOT_FOLDER + "\\src\\test\\java\\Testdata\\Business\\Tour\\Dashboad\\Data_Dashboard_Tour.json");

        log.info("Step 1: Click vào button [Tạo Tour]");
        tourDashboardPagePO.clickToButtonCreateTour();
    }

    @Test(description = "Không nhập vào name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC01_Check_Validate_Name_Tour_Null_On_Popup_CreateTour()
    {
        log.info("Step 2: Không nhập vào tên tour và click vào button [Lưu]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 3: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 4: So sánh câu cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Is_Required());
    }

    @Test(description = "Nhập vào 4(< MIN) ký tự của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC02_Check_Validate_Name_Tour_Less_Min_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 4 ký tự tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_4_char());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 5: So sánh cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Min());
    }

    @Test(description = "Nhập vào 5(= MIN) ký tự của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC03_Check_Validate_Name_Tour_Equal_Min_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 5 ký tự tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_5_char());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour không hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourNameUndisplay());
    }

    @Test(description = "Nhập vào 256 ký tự của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC04_Check_Validate_Name_Tour_More_Max_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 256 ký tự tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_256_char());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 5: So sánh cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Max());
    }

    @Test(description = "Nhập vào 255 ký tự của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC05_Check_Validate_Name_Tour_Equal_Max_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 255 ký tự tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_255_char());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour không hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourNameUndisplay());
    }

    @Test(description = "Nhập vào 5 khoảng trắng của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC06_Check_Validate_Name_Tour_5_Char_Space_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 5 ký tự khoảng trắng tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_5_space());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 5: So sánh câu cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Is_Required());
    }

    @Test(description = "Nhập vào 1 khoảng trắng và 4 ký tự của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC07_Check_Validate_Name_Tour_Has_Start_Space_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 1 khoảng trắng 4 ký tự tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_Start_Space());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 5: So sánh câu cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Min());
    }

    @Test(description = "Nhập vào 4 ký tự và 1 khoảng trắng của name tour trong popup [Tạo tour] ở dashboard page tour")
    public void TC08_Check_Validate_Name_Tour_Has_Start_Space_On_Popup_CreateTour()
    {
        log.info("Step 2: Nhập vào 4 ký tự 1 khoảng trắng tour name");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_End_Space());

        log.info("Step 3: Click vào button [Save]");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của tên tour có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourName());

        log.info("Step 5: So sánh câu cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourName(), dataDashboardTour.getAlert_NameTour_Min());
    }

    @Test(description = "Không chọn chủ đề tour")
    public void TC09_Check_Validate_When_No_Select_Topic()
    {
        log.info("Step 2: Nhập tên tour");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_Valid());

        log.info("Step 3: Không chọn topic và click button save");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 4: Check cảnh báo của topic có hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourTopic());

        log.info("Step 5: So sánh câu cảnh báo");
        verifyEquals(tourDashboardPagePO.getAlertOnTourTopic(), dataDashboardTour.getAlert_Topic_Is_Required());
    }

    @Test(description = "Check khi valid name tour và có chọn topic")
    public void TC10_Check_Validate_Has_Name_Tour_And_Select_Topic()
    {
        log.info("Step 2: Nhập tên tour");
        tourDashboardPagePO.enterDataToTourName(dataDashboardTour.getNameTour_Valid());

        log.info("Step 3: Chọn topic");
        tourDashboardPagePO.selectTopicOnPopupCreateTour("Biển là nhà");

        log.info("Step 4: Click button save");
        tourDashboardPagePO.clickToButtonSaveOnPopupCreateTour();

        log.info("Step 5: Check cảnh báo của tên tour không hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourNameUndisplay());

        log.info("Step 6: Check cảnh báo của topic không hiển thị");
        verifyTrue(tourDashboardPagePO.checkAlertOnTourTopicUndisplay());

        log.info("Step 7: Check chuyển màn hình tour information có tiêu đề chi tiết + tên tour");
        tourInfoTabPO = PageGeneration.createTourInfoTab(driver);
        verifyEquals(tourInfoTabPO.getHeaderTitle(), dataDashboardTour.getNameTour_Valid());
    }

}
