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

public class CheckValidation_Tour_Information_04 extends AbstractTest {
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

    String attAddress = "address";
    String attCountry = "country";


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

    //-----------------------------Field Địa chỉ-----------------------------
    @Test(description = "Check khi không nhập vào địa chỉ")
    public void TC01_Check_Validate_Address_Is_Null()
    {
        log.info("Step 1: Không nhập vào địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 2: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledIsDisplay(attAddress));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnField(attAddress), dataDetailTourInformation.getAlert_Address_Is_Required());

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào giá trị số của địa chỉ")
    public void TC02_Check_Validate_Address_Is_Number()
    {
        log.info("Step 1: Nhập vào giá trị là số địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Number());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attAddress));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào giá trị số lẻ của địa chỉ")
    public void TC03_Check_Validate_Address_Is_Decimal()
    {
        log.info("Step 1: Nhập vào giá trị là số lẻ địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Decimal());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attAddress));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào giá trị số âm của địa chỉ")
    public void TC04_Check_Validate_Address_Is_Negative()
    {
        log.info("Step 1: Nhập vào giá trị là số âm địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Negative());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attAddress));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào ký tự đặc biệt địa chỉ")
    public void TC05_Check_Validate_Address_Is_Special_Char()
    {
        log.info("Step 1: Nhập vào giá trị là ký tự đặc biệt địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Special_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attAddress));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào là 1 đoạn script của địa chỉ")
    public void TC06_Check_Validate_Address_Is_Script()
    {
        log.info("Step 1: Nhập vào giá trị là 1 đoạn script địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Script());

        log.info("Step 2: Enter");
        tourInfoTabPO.enterOnField(attAddress);

        log.info("Step 3: Check alert có xuất hiện bởi script không");
        verifyTrue(tourInfoTabPO.checkAlertIsDisplayByScript());

        log.info("Step 4: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "Check khi nhập vào là ký tự chữ của địa chỉ")
    public void TC07_Check_Validate_Address_Is_Char()
    {
        log.info("Step 1: Nhập vào giá trị là ký tự chữ địa chỉ");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 2: Kiểm tra giá trị vừa nhập");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 3: Click button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra giá trị sau khi click Save");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), dataDetailTourInformation.getValue_Is_Char());

        log.info("Step 5: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnFiledUnDisplay(attAddress));

        tourInfoTabPO.closeToastMessage();
    }

    @Test(description = "(Chưa làm được)Check khi nhập vào địa chỉ có thực và duy nhất")
    public void TC08_Check_Validate_Address_Is_Valid_And_Only()
    {
        log.info("Step 1: Nhập vào địa chỉ có thực và duy nhất");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getAddress_Is_Valid_And_Only());

        log.info("Step 2: Click button GPS");
        tourInfoTabPO.clickToButtonGPS();

        log.info("Step 3: Kiểm tra text trong các dropdown Quốc gia/Thành phố/Huyện có xuất hiện text");
        //Chưa có cách verify chỗ này
    }

    @Test(description = "Check khi nhập vào địa chỉ có nhiều location")
    public void TC09_Check_Validate_Address_Has_Many_Location()
    {
        String subTextOnLocation;
        log.info("Step 1: Nhập vào địa chỉ có nhiều chi nhánh");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getAddress_Has_Many_Location());

        log.info("Step 2: Click button GPS");
        tourInfoTabPO.clickToButtonGPS();

        log.info("Step 3: Chờ cho modal find location xuất hiện + chọn địa điểm đầu tiên");
        tourInfoTabPO.chooseLocationOnModal(1);
        subTextOnLocation = tourInfoTabPO.getSubTextOfLocation(1);

        log.info("Step 4: Click button thêm địa điểm + chờ cho field địa điểm clickable");
        tourInfoTabPO.clickToButtonAddLocation();

        log.info("Step 5: Kiểm tra Modal find location không còn hiển thị");
        verifyTrue(tourInfoTabPO.checkModalLocationUnDisplay());

        log.info("Step 6: So sánh địa điểm trong field địa điểm với subtext của địa điểm đã chọn trong modal location");
        verifyEquals(tourInfoTabPO.getValueOnFiled(attAddress), subTextOnLocation);

        refreshPage(driver);
    }

    @Test(description = "Check khi nhập vào địa chỉ không có thực")
    public void TC10_Check_Validate_Address_Is_Invalid()
    {
        log.info("Step 1: Nhập vào địa chỉ không có thực");
        tourInfoTabPO.enterValueToDynamicField(attAddress, dataDetailTourInformation.getAddress_Is_Invalid());

        log.info("Step 2: Click button GPS");
        tourInfoTabPO.clickToButtonGPS();

        log.info("Step 3: Kiểm tra toast lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());

        log.info("Step 4: So sánh message lỗi trong toast");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Address_Is_Invalid());
    }

    //-----------------------------Dropdown Quốc gia-----------------------------
//    @Test(description = "Check dropdown quốc gia khi có chọn 1 quốc gia")
    public void TC11_Check_Dropdown_When_Select_Valid_Country()
    {
        log.info("Step 1: Chọn quốc gia Vietnam");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 2: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_1());
    }

    //    @Test(description = "Check dropdown quốc gia khi chọn Việtnam và chọn tiếp Anh")
    public void TC12_Check_Dropdown_When_Select_2_Valid_Country()
    {
        log.info("Step 1: Chọn quốc gia Vietnam");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 2: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 3: Chọn quốc gia Japan");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_2());

        log.info("Step 4: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_2());
    }

    //    @Test(description = "Check dropdown quốc gia khi chọn Việtnam và chọn tiếp Anh và chọn lại Vietnam")
    public void TC13_Check_Dropdown_When_Select_3_Valid_Country()
    {
        log.info("Step 1: Chọn quốc gia Vietnam");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 2: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 3: Chọn quốc gia Japan");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_2());

        log.info("Step 4: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_2());

        log.info("Step 5: Chọn quốc gia Japan");
        tourInfoTabPO.chooseItemInDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Valid_1());

        log.info("Step 6: Check quốc gia vừa chọn có hiển thị trong field");
        verifyEquals(tourInfoTabPO.getValueSelectedOnDynamicDropdown(attCountry), dataDetailTourInformation.getCountry_Is_Valid_1());
    }

    //    @Test(description = "Check dropdown quốc gia khi nhập vào tên quốc gia invalid")
    public void TC14_Check_Dropdown_When_Input_Invalid_Country()
    {
        log.info("Step 1: Nhập vào quốc gia");
        tourInfoTabPO.enterValueToDynamicDropdown(attCountry, dataDetailTourInformation.getCountry_Is_Invalid());

        log.info("Step 2: Click vào button Save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra giá trị vừa nhập phải bằng rỗng");
        verifyEquals(tourInfoTabPO.getValueOnDropdown(attCountry), dataDetailTourInformation.getValue_Is_Null());

        log.info("Step 4: Check cảnh báo lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnDropdownIsDisplay(attCountry));

        log.info("Step 5: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnDropdown(attCountry), dataDetailTourInformation.getAlert_Country_Is_Required());
    }

    @AfterTest(alwaysRun = true)
    public void endTest()
    {
        closeBrowserAndDriver(driver);
    }
}
