package testcase.Newsfeed.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSettingPO;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PersonalWall.About.PerAbout_OverviewPO;
import Project.Shared.LoginPO;
import Project.Shared.SignUpPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_Function_Update_USERNAME extends AbstractTest {
    DriverManager driverManager;
    DataHelper data;
    WebDriver driver;
    LoginPO loginNewsfeedPage;
    NewsfeedHomepagePO newsFeedHomePage;
    GeneralAccountSettingPO accountSettingPage;
    SignUpPO registerAccountPage;
    PerAbout_OverviewPO perAboutOverviewPage;

    String userName;
    String languageSystem;
    String urlUsername;

    @Parameters("browser")
    @BeforeTest(description = "Khởi tạo trình duyệt và vào màn hình Account General Setting")
    public void preconditionStep(String browserName){
        data = DataHelper.getData();
        log.info("Create driver");
        driverManager = BrowserInitialization.getBrowser(browserName);
        log.info("Open Browser and Go to Hahalolo Newsfeed");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        loginNewsfeedPage = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Change language system to VI");
        loginNewsfeedPage.clickToChangeLanguageToVI();
        languageSystem = loginNewsfeedPage.getLanguageOfSystemHahalolo();
        log.info("Login to Hahalolo");
        loginNewsfeedPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, GlobalVariables.USER_EMAIL_PASSWORD);
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);
        String fullName =  newsFeedHomePage.getFullNameDisplayOnWidgetMyAccount();
        log.info("Kiểm tra trang Hahalolo - Newsfeed hiển thị thành công");
        verifyTrue(newsFeedHomePage.checkNewsfeedHomepageIsDisplayed(languageSystem));
        log.info("Go To Account setting");
        setTimeDelay(2);
        newsFeedHomePage.clickToItemSettingOnHeaderSection("ic-cog-c");
        accountSettingPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Verify General Account setting");
        verifyTrue(accountSettingPage.checkGeneralAccountSettingTabIsDisplayed(languageSystem,fullName));
    }

    @Test
    public void TC01_Check_Interface_Of_Item_OnFunctionUsername(){
        log.info("Verìy text of title function Update Username");
        verifyTrue(accountSettingPage.verifyTitleFunctionUsernameByLanguage(languageSystem));
        log.info("Verify text of content function Update username");
        accountSettingPage.clickToIconEditUsername();
        setTimeDelay(2);
        verifyTrue(accountSettingPage.verifyContentFunctionUsernameByLanguage(languageSystem));
        log.info("Verify text of content function Update username");
        verifyTrue(accountSettingPage.verifyNoteFunctionUsernameByLanguage(languageSystem));
        log.info("Verify UI Button Save change on Form Update username");
        verifyTrue(accountSettingPage.checkVerifyButtonSaveChangesOnFormEditUsername(languageSystem));
        log.info("Verify UI Button Cancel on Form Update username");
        verifyTrue(accountSettingPage.checkVerifyButtonCancelOnFormEditUsername(languageSystem));
    }

    @Test(enabled = false)
    public void TC02_Check_User_Interaction_OnFunctionUsername(){
        log.info("Kiểm tra thao tác nhấn icon chỉnh sửa Người dùng");
        log.info("Step 1. Nhấn vào nút chỉnh sửa định danh người dùng");
        accountSettingPage.clickToIconEditUsername();
        log.info("Kiểm tra form Chỉnh sửa định danh người dùng hiển thị");
        verifyTrue(accountSettingPage.checkFormEditUsernameIsDisplayed());

        log.info("Kiểm tra thao tác nhập/ xóa dữ liệu dữ liệu tại Fied username");
        log.info("Step 1. Nhập giá trị vào ô định danh người dùng ");
        userName = "huyho";
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra dữ liệu hiển thị trên Fied username");
        verifyEquals(accountSettingPage.getValueDisplayOnFieldUsername(), userName);
        log.info("Step 3. Xóa dữ liệu của Fied username");
        accountSettingPage.clearValueDisplayOnFieldUsername();
        log.info("Step 4. Kiểm tra dữ liệu hiển thị trên Fied username");
        verifyEquals(accountSettingPage.getValueDisplayOnFieldUsername(), "");


        log.info("Kiểm tra thao tác nhấn nút Cancel on Form Edit Username ");
        log.info("Step 1. Nhấn vào nút Cancel");
        accountSettingPage.clickTobuttonSaveOnFormEditUserName();
        log.info("Step 2. Kiểm tra form Chỉnh sửa Username bị đóng");
        verifyFalse(accountSettingPage.checkFormEditUsernameIsDisplayed());

        log.info("Kiểm tra thao tác nhấn nút Save changes on Form Edit Username ");
        log.info("Step 1. Nhấn vào icon Edit Username");
        accountSettingPage.clickTobuttonSaveOnFormEditUserName();
        log.info("Step 2. Kiểm tra form Ediy Username hiển thị");
        verifyFalse(accountSettingPage.checkFormEditUsernameIsDisplayed());
        log.info("Step 3.  Nhập giá trị vào ô định danh người dùng ");
        userName = "huyho";
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 4. Nhấn vào nút Save change");
        accountSettingPage.clickTobuttonSaveOnFormEditUserName();
        log.info("Step 5. Kiểm tra form Edit Username bị đóng");
        verifyFalse(accountSettingPage.checkFormEditUsernameIsDisplayed());
        log.info("Step 6. Kiểm tra giá trị Username thay đổi");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false, description = "Cập nhạt Username với các trường không hợp lệ")
    public void TC03_Update_Username_With_Invalid_Information(){
        log.info("Nhấn vào icon Edit Username");
        accountSettingPage.clickToIconEditUsername();

        log.info("Trường hợp 1 - Để trống Username");
        log.info("Step 1. Xóa dữ liệu hiển thị tại ô Username");
        accountSettingPage.clearValueDisplayOnFieldUsername();
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());

        log.info("Trường hợp 2 - Username chứa những ký tự khoảng trắng");
        userName = "    ";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername(),"Phải có ít nhất 5 kí tự");

        log.info("Trường hợp 3 - Username chứa ký tự khoảng trắng ở giữa giá trị");
        userName = "huy hodoan";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Trường hợp 4 - Username kết thúc có dấu .");
        userName = "huyhodoan.";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự đặc biệt không đúng chỗ");

        log.info("Trường hợp 5 - Username có chứa ký tự đặc biêt");
        userName = "huyhodo@an";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Trường hợp 6 - Username có số lượng ký tự <5");
        userName = "huya";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Phải có ít nhất 5 kí tự");

        log.info("Trường hợp 7 - Username có số lượng ký tự > 50");
        userName = randomName(51);
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Tên người dùng vượt số ký tự tối đa cho phép");

        log.info("Trường hợp 8 - Username là 1 đoạn Script");
        userName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Trường hợp 9 - Username là 1 đoạn HTML code");
        userName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Trường hợp 9 - Username là một chuỗi có dấu");
        userName = "huayhô";
        log.info("Step 1. Nhập giá trị vào field Username");
        accountSettingPage.enterDataToFieldUsername(userName);
        log.info("Step 2. Kiểm tra trạng thái enable/disable của nút Save Changes");
        verifyFalse(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());
        log.info("Step 3. Kiểm tra thông báo hiển thị tại Form Edit Username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("End step. Cancel function change username");
        accountSettingPage.clickToButtonCancelOnFormEditUsername();
    }

    @Test(enabled = false, description = "Cập nhạt Username với trường hợp hợp lệ")
    public void TC04_Update_Username_With_Valid_Username() {
        log.info("Prepare data");
        userName = "huyho" + randomNumber(22000);

        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false, description = "Cập nhạt Username với trường hợp viết hoa toàn bộ chữ cái")
    public void TC05_Update_Username_With_Username_IS_All_Uppercase_Characters() {
        log.info("Prepare data");
        userName = "HUYHO" + randomNumber(22000);

        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false, description = "Cập nhạt Username với trường hợp viết hoa toàn bộ chữ cái")
    public void TC06_Update_Username_With_Username_Has_Uppercase_Character_On_Data() {
        userName = "HuyHo" + randomNumber(22000);

        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 1. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
        urlUsername = accountSettingPage.getUsernameURLIsDisplayedOnTabGeneralSetting();
        log.info("Step 2. Nhần vào Trang cá nhân của người dùng");
        accountSettingPage.clickToAvatarOnHeaderSection();

        log.info("Step 3. Kiểm tra url của người dùng hiển thị chính xác");
        verifyEquals(perAboutOverviewPage.getCurrentURL(driver), urlUsername);
        log.info("Step 4. Trở vè lại trang Account Setting");
        perAboutOverviewPage.clickForwardToPage(driver);

    }

    @Test(enabled = false, description = "Cập nhạt Username với trường hợp dữ liệu chỉ toàn là số")
    public void TC07_Update_Username_With_Username_Is_Number() {
        log.info("Prepare data");
        userName = String.valueOf(randomNumber(1000000000));
        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false, description = "Cập nhạt Username với trường hợp dữ liệu tổ hợp chữ + số")
    public void TC08_Update_Username_With_Username_Is_AlphaNumber(){
        log.info("Prepare data");
        userName = removeAllWhitespace(data.getFirstName()) + randomNumber(20000);

        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false)
    public void TC09_Update_UserName_With_Data_Has_Endwith_Is_Dot(){
        log.info("Prepare data");
        userName = "huy.hodoan."+randomNumber(300000);

        accountSettingPage.updateUsernameWithValue(userName);
        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(),userName);
    }

    @Test(enabled = false)
    public void TC10_Update_Username_With_Case_NewAccount(){
        log.info("End step. Logot account");
        accountSettingPage.clickToItemSettingOnHeaderSection("ic-logout-c");
        registerAccountPage = PageGeneration.createFormRegister(driver);
        log.info("Prepare data");
        String firstName  = data.getFirstName();
        String lastName = data.getLastName();
        String email = randomVirtualEmail();
        userName = "huy.hodoan."+randomNumber(300000);

        log.info("Step 1. Register new account");
        registerAccountPage.signUpWithNewAccountByEmail(firstName, lastName, email, "123456", "123456");
        newsFeedHomePage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 2. Verify register new account successfully");
        verifyTrue(newsFeedHomePage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Step 3. Cancel update new info");
        newsFeedHomePage.clickToButtonCancelOnPopupUpdateInformation();
        String fullname = newsFeedHomePage.getFullNameDisplayOnWidgetMyAccount();

        log.info("Step 4. Go to General account setting");
        newsFeedHomePage.clickToItemSettingOnHeaderSection("ic-cog-c");
        accountSettingPage = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 5. Verify General account display successfully");
        verifyTrue(accountSettingPage.checkGeneralAccountSettingTabIsDisplayed(fullname,languageSystem));

        log.info("Step 6. Check content of Function Change username");
        verifyTrue(accountSettingPage.verifyContentCaseNoSetUpUsername(languageSystem));

        log.info("Step 7. Open function Edit username");
        accountSettingPage.clickToIconEditUsername();

        log.info("Step 2. Enter username");
        accountSettingPage.enterDataToFieldUsername(userName);

        log.info("Step 3. Verify message of Fucntion Change username");
        verifyEquals(accountSettingPage.getMessageValidateFunctionUsername(), "Tên người dùng khả dụng");

        log.info("Step 4. Verify status of button save change username");
        verifyTrue(accountSettingPage.checkStatusEnableButtonSaveChangeOnFormEditUsername());

        log.info("Step 5. Click to save change username");
        accountSettingPage.clickTobuttonSaveOnFormEditUserName();

        log.info("Step 6. Verify username has been change successfully");
        verifyEquals(accountSettingPage.getUsernameIsDisplayedOnTabGeneralSetting(), userName);
        String urlUserName = accountSettingPage.getUsernameURLIsDisplayedOnTabGeneralSetting();

        log.info("Step 6. Go to Personal About - Overview");
        accountSettingPage.clickToAvatarOnHeaderSection();
        perAboutOverviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 6. Verify personal URL with urlUsername");
        verifyEquals(perAboutOverviewPage.getCurrentURL(driver),urlUserName);

    }

}
