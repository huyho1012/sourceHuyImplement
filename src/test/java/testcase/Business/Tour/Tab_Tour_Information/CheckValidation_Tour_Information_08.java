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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckValidation_Tour_Information_08 extends AbstractTest {
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

    String attBtnLogo = "uploadLogo";
    String attBtnCover = "uploadCover";
    String attBtnAlbum = "uploadGalleries";
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

    //-----------------------------Ảnh Logo-----------------------------
//    @Test(description = "Không chọn logo")
    public void TC01_Check_Logo_Is_Empty()
    {
        log.info("Step 1: Không chọn ảnh logo");

        log.info("Step 2: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();;

        log.info("Step 3: Kiểm tra cảnh báo lỗi có xuất hiện");
        verifyTrue(tourInfoTabPO.checkAlertOnImageIsDisplay(attLogo));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnImage(attLogo), dataDetailTourInformation.getAlert_Logo_Is_Required());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();
    }

//    @Test(description = "Chọn logo file png")
    public void TC_02_Check_Logo_Format_Is_PNG()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_PNG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_PNG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file jpg")
    public void TC_03_Check_Logo_Format_Is_JPG()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_JPG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_JPG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file jpeg")
    public void TC_04_Check_Logo_Format_Is_JPEG()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_JPEG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_JPEG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file webp")
    public void TC_05_Check_Logo_Format_Is_WEBP()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_WEBP());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_WEBP()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file bmp")
    public void TC_06_Check_Logo_Format_Is_BMP()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_BMP());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_BMP()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file tif")
    public void TC_07_Check_Logo_Format_Is_TIF()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_TIF());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_TIF()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file tiff")
    public void TC_08_Check_Logo_Format_Is_TIFF()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_TIFF());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_TIFF()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file ico")
    public void TC_09_Check_Logo_Format_Is_ICO()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_ICO());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attLogo));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkLogoIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageLogo(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_ICO()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attLogo);
    }

//    @Test(description = "Chọn logo file gif")
    public void TC10_Check_Logo_Format_Is_GIF()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up ảnh gif từ local");
        tourInfoTabPO.uploadImageNoSuport(dataDetailTourInformation.getImage_Format_GIF());

        log.info("Step 3: Kiểm tra toast lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Incorect_Format_File());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 6: Close media manager");
        tourInfoTabPO.closeMediaManager();
    }


//    @Test(description = "Chọn logo file heic (không hỗ trợ)")
    public void TC11_Check_Logo_Format_Is_HEIC()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnLogo);

        log.info("Step 2: Up ảnh heic từ local");
        tourInfoTabPO.uploadImageNoSuport(dataDetailTourInformation.getImage_Format_HEIC());

        log.info("Step 3: Kiểm tra toast lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Incorect_Format_File());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 6: Close media manager");
        tourInfoTabPO.closeMediaManager();
    }


    //-----------------------------Ảnh Cover-----------------------------
//    @Test(description = "Không chọn cover")
    public void TC12_Check_Cover_Format_Is_Empty()
    {
        log.info("Step 1: Không chọn ảnh");

        log.info("Step 2: Click button add image");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 3: Kiểm tra tại cover có cảnh báo lỗi");
        verifyTrue(tourInfoTabPO.checkAlertOnImageIsDisplay(attCover));

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getAlertOnImage(attCover), dataDetailTourInformation.getAlert_Cover_Is_Required());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();
    }

//    @Test(description = "Chọn cover file png")
    public void TC_13_Check_Cover_Format_Is_PNG()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_PNG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_PNG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file jpg")
    public void TC_14_Check_Cover_Format_Is_JPG()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_JPG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_JPG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file jpeg")
    public void TC_15_Check_Cover_Format_Is_JPEG()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_JPEG());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_JPEG()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file webp")
    public void TC_16_Check_Cover_Format_Is_WEBP()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_WEBP());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_WEBP()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file bmp")
    public void TC_17_Check_Cover_Format_Is_BMP()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_BMP());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_BMP()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file tif")
    public void TC_18_Check_Cover_Format_Is_TIF()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_TIF());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_TIF()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file tiff")
    public void TC_19_Check_Cover_Format_Is_TIFF()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_TIFF());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_TIFF()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file ico")
    public void TC_20_Check_Cover_Format_Is_ICO()
    {
        log.info("Step 1: Click button add cover");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up và chọn ảnh png từ local");
        tourInfoTabPO.uploadImage(dataDetailTourInformation.getImage_Format_ICO());

        log.info("Step 3: Click button save");
        tourInfoTabPO.clickToButtonSaveTourOnHeader();

        log.info("Step 4: Kiểm tra cảnh báo lỗi không hiển thị");
        verifyTrue(tourInfoTabPO.checkAlertOnImageUnDisplay(attCover));

        log.info("Step 5: Kiểm tra ảnh có hiển thị");
        verifyTrue(tourInfoTabPO.checkCoverIsDisplay());

        log.info("Step 6: Kiểm tra đuôi ảnh");
        verifyEquals(tourInfoTabPO.getExtensionOfImageCover(), tourInfoTabPO.getPareImage(dataDetailTourInformation.getImage_Format_ICO()));

        log.info("Step 7: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 8: Remove ảnh");
        tourInfoTabPO.removeImage(attCover);
    }

//    @Test(description = "Chọn cover file gif")
    public void TC21_Check_Cover_Format_Is_GIF()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up ảnh gif từ local");
        tourInfoTabPO.uploadImageNoSuport(dataDetailTourInformation.getImage_Format_GIF());

        log.info("Step 3: Kiểm tra toast lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Incorect_Format_File());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 6: Close media manager");
        tourInfoTabPO.closeMediaManager();
    }

//    @Test(description = "Chọn cover file heic")
    public void TC22_Check_Cover_Format_Is_HEIC()
    {
        log.info("Step 1: Click button add logo");
        tourInfoTabPO.clickToButtonAddImage(attBtnCover);

        log.info("Step 2: Up ảnh gif từ local");
        tourInfoTabPO.uploadImageNoSuport(dataDetailTourInformation.getImage_Format_HEIC());

        log.info("Step 3: Kiểm tra toast lỗi có hiển thị");
        verifyTrue(tourInfoTabPO.checkToastIsDisplay());

        log.info("Step 4: So sánh cảnh báo lỗi");
        verifyEquals(tourInfoTabPO.getTextOfToast(), dataDetailTourInformation.getMessageToast_Incorect_Format_File());

        log.info("Step 5: Đóng toast");
        tourInfoTabPO.closeToastMessage();

        log.info("Step 6: Close media manager");
        tourInfoTabPO.closeMediaManager();
    }

    

//    @AfterTest(alwaysRun = true)
//    public void endTest()
//    {
//        closeBrowserAndDriver(driver);
//    }
}
