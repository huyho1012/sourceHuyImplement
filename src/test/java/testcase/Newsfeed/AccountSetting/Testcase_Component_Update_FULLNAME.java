package testcase.Newsfeed.AccountSetting;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.DummyData.DataHelper;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.AccountSetting.GeneralAccountSettingPO;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Shared.LoginPO;
import Project.Shared.SignUpPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase_Component_Update_FULLNAME extends AbstractTest {
    DataHelper data;
    WebDriver driver;
    DriverManager driverManager;
    LoginPO newsfeedLoginPageObject;
    NewsfeedHomepagePO newsfeedHomepagePO;
    SignUpPO signUpPage;
    GeneralAccountSettingPO generalSetting;

    String firstName, lastName, middleName;
    String userFullname;
    String password,email;
    String languageSystem;

    @Parameters("browser")
    @BeforeTest(description = "Khởi tạo trình duyệt và vào màn hình Account General Setting")
    public void preconnditionTest(String browserName) {
        data = DataHelper.getData();

        log.info("Khởi tạo driver");
        driverManager = BrowserInitialization.getBrowser(browserName);

        log.info("Mở trình duyệt vào truy cập trang Newsfeed Hahalolo");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);

        log.info("Kiểm tra và thay đổi ngôn ngữ của hệ thống sang tiếng việt");
        newsfeedLoginPageObject.clickToChangeLanguageToVI();

        log.info("Lưu lại biến ngôn ngữ hiện tại của hệ thống");
        languageSystem = newsfeedLoginPageObject.getLanguageOfSystemHahalolo();

        log.info("Đăng nhập vào Hahalolo");
        newsfeedLoginPageObject.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT, "123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Lấy thông tin Họ và tên của người dùng đăng nhập");
        userFullname = newsfeedHomepagePO.getFullNameDisplayOnWidgetMyAccount();

        log.info("Xác nhận Đã đăng nhập vào Hahlolo thành công");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed(languageSystem));

        log.info("Truy cập vào tính năng Thiết lập chung tài khoản");
        newsfeedHomepagePO.clickToItemSettingOnHeaderSection( "ic-cog-c");
        generalSetting = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Xác nhận điều hướng tới trang Thiết lập chung tài khoản thành công");
        verifyTrue(generalSetting.checkGeneralAccountSettingTabIsDisplayed(userFullname, languageSystem));
    }


    // 1
    @Test(enabled = false,  description = "Kiểm tra giao diẹn các thành phần tại chức năng Fullname")
    public void TC01_Check_Interface_Of_Item_Component_On_Function_Fullname(){
        log.info("Step 1 - Kiểm tra nội dung của Tiêu đề tab Thiết lập tổng quan theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextTitleTabGeneral(languageSystem));

        log.info("Step 2 - Kiểm tra nội dung tiêu đề chức năng Cập nhật tên người dùng theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTitleFullNameSectionByLanguage(languageSystem));

        log.info("Step 3 - Kiểm tra form cập nhật tên người dùng hiển thị");
        generalSetting.clickToButtonEditFullName();
        verifyTrue(generalSetting.checkFormEditFullNameIsDisplayed());

        log.info("Step 4 - Kiểm tra nội dung của Label ô First name theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextLabelFieldFirstName(languageSystem));

        log.info("Step 5 - Kiểm tra nội dung của Label ô Middle name theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextLabelFieldMiddleName(languageSystem));

        log.info("Step 6 - Kiểm tra nội dung của Label ô Last name theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextLabelFieldLastName(languageSystem));

        log.info("Step 7 - Kiểm tra nội dung và mầu sắc của button Save changes - Form Cập nhật tên người dùng theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.checkVerifyUIButtonSaveChangesOnFormEditFullName(languageSystem));

        log.info("Step 8 - Kiểm tra nội dung và mầu sắc của button Cancel - Form Cập nhật tên người dùng theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.checkVerifyUIButtonCancelOnFormEditFullName(languageSystem));

        log.info("Step 9 - Kiểm tra form xác nhận mật khẩu hiện tại hiển thị");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        verifyTrue(generalSetting.checkFormConfirmPasswordIsDisplayed());

        log.info("Step 10 - Kiểm tra nội dung của Tiêu đề Form xác nhận mật khẩu theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextTitleByLangFormConfirmPassword(languageSystem));

        log.info("Step 11 - Kiểm tra nội dung của Form xác nhận mật khẩu theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextContentByLangFormConfirmPassword(languageSystem));

        log.info("Step 12 - Kiểm tra nội dung của Tiêu đề Form xác nhận mật khẩu theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.verifyTextLabelFieldPasswordByLanguage(languageSystem));

        log.info("Step 13 - Kiểm tra nội dung và mầu sắc của button Confirm -  Form xác nhận mật khẩu theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.checkVerifyUIButtonConfirmOnFormConfirmPass(languageSystem));

        log.info("Step 14 - Kiểm tra nội dung và mầu sắc của button Confirm -  Form xác nhận mật khẩu theo ngôn ngữ hiện tại");
        verifyTrue(generalSetting.checkVerifyUIButtonCancelOnFormConfirmPass(languageSystem));

        generalSetting.refreshPage(driver);
    }

    // 2
    @Test(enabled = false, description = "Kiểm tra các thao tác vào thành phần tại chức năng Fullname")
    public void TC02_Check_User_Interaction_Of_Item_Component_On_Function_Fullname(){
        firstName = data.getFirstName();
        middleName = data.getMiddleName();
        lastName = data.getLastName();
        password = GlobalVariables.ADMIN_PASSWORD;

        log.info("Kiểm tra thao tác nhấn vào icon chỉnh sửa tên người dùng");
        log.info("Step 1. Nhấn vào icon Chỉnh sửa tên người dùng");
        generalSetting.clickToButtonEditFullName();
        log.info("Step 2. Kiểm tra form Cập nhật tên người dùng hiển thị");
        verifyTrue(generalSetting.checkFormEditFullNameIsDisplayed());

        log.info("Kiểm tra thao tác nhập xoá dữ liệu ô First name");
        log.info("Step 1. Xoá dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName("");
        log.info("Step 2. Kiểm tra dữ liệu ô First name đã bị xoá hay chưa ");
        verifyEquals(generalSetting.getDataDisplayOnFieldFirstName(),"");
        log.info("Step 3. Nhập dữ liệu ô First name");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 4. Kiểm tra dữ liệu hiển thị tại ô First name");
        verifyEquals(generalSetting.getDataDisplayOnFieldFirstName(),firstName);

        log.info("Kiểm tra thao tác nhập xoá dữ liệu ô Middle name");
        log.info("Step 1. Xoá dữ liệu ô Middle name");
        generalSetting.enterDataToFieldMiddlename("");
        log.info("Step 2. Kiểm tra dữ liệu ô Middle name đã bị xoá hay chưa ");
        verifyEquals(generalSetting.getDataDisplayOnFieldMiddleName(),"");
        log.info("Step 3. Nhập dữ liệu ô Middle name");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 4. Kiểm tra dữ liệu hiển thị tại ô Middle name");
        verifyEquals(generalSetting.getDataDisplayOnFieldMiddleName(),middleName);

        log.info("Kiểm tra thao tác nhập xoá dữ liệu ô Last name");
        log.info("Step 1. Xoá dữ liệu ô Last name");
        generalSetting.enterDataToFieldLastname("");
        log.info("Step 2. Kiểm tra dữ liệu ô Middle name đã bị xoá hay chưa ");
        verifyEquals(generalSetting.getDataDisplayOnFieldLastName(),"");
        log.info("Step 3. Nhập dữ liệu ô Middle name");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 4. Kiểm tra dữ liệu hiển thị tại ô Middle name");
        verifyEquals(generalSetting.getDataDisplayOnFieldLastName(),lastName);

        log.info("Kiểm tra thao tác nút Save changes");
        log.info("Step 1. Nhấn vào nút Save changes");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 2. Kiểm tra popup Xác nhận mật khẩu xuất hiện");
        verifyTrue(generalSetting.checkFormConfirmPasswordIsDisplayed());

        log.info("Kiểm tra thao tác nhập xoá dữ liệu ô Password");
        log.info("Step 1. Nhập dữ liệu ô Password");
        generalSetting.enterDataToFieldPassword(password);
        log.info("Step 2. Kiểm tra dữ liệu hiển thị tại ô Password");
        verifyEquals(generalSetting.getDataDisplayOnFieldPassword(), password);
        log.info("Step 3, Xoá dữ liệu ô Password");
        generalSetting.enterDataToFieldPassword("");
        log.info("Step 4. Kiểm tra dữ liệu hiển thị tại ô Password");
        verifyEquals(generalSetting.getDataDisplayOnFieldPassword(), "");

        log.info("Kiểm tra thao tác nhấn nút Cancel tại form Xác nhận mật khẩu");
        log.info("Step 1. Nhấn vào nút Cancel");
        generalSetting.clickToButtonCancelOnFormConfirmPass();
        log.info("Step 2. Kiểm tra popup Xác nhận mật khẩu bị đóng hay chưa");
        verifyFalse(generalSetting.checkFormConfirmPasswordIsDisplayed());

        log.info("Kiểm tra thao tác nhấn nút Cancel tại form Chỉnh sửa Fullname");
        log.info("Step 1. Nhấn vào nút Cancel");
        generalSetting.clickToButtonCancelOnFormEditFullname();
        log.info("Step 2. Kiểm tra Form Edit Fullname bị đóng hay chưa");
        verifyFalse(generalSetting.checkFormEditFullNameIsDisplayed());

        log.info("Kiểm tra thao tác nhấn nút Confirm tại form Xác nhận mật khẩu");
        log.info("Step 1. Nhấn vào nút chỉnh sửa Fullname");
        generalSetting.clickToButtonEditFullName();
        log.info("Step 2. Kiểm tra form chỉnh sửa Fullname hiển thị hay không?");
        verifyTrue(generalSetting.checkFormEditFullNameIsDisplayed());
        log.info("Step 3. Nhập dữ liệu vào ô First name");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 4. Nhập dữ liệu vào ô Miđdle name");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 5. Nhập dữ liệu vào ô Last name");
        generalSetting.enterDataToFieldLastname(lastName);
        String fullname = getFullName(firstName,middleName,lastName);
        log.info("Step 6. Nhấn vào nút Save changes");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 7. Kiểm tra form Xác nhận mật khẩu hiển thị hay không?");
        verifyTrue(generalSetting.checkFormConfirmPasswordIsDisplayed());
        log.info("Step 8. Nhập dữ liệu vao ô Password");
        generalSetting.enterDataToFieldPassword("123456");
        log.info("Step 9. Nhấn vào nút Confirm tại popup Xác nhận mật khẩu");
        generalSetting.clickToButtonConfirmOnFormConfirmPass();
        log.info("Step 10. Kiểm tra popup Xác nhận mật khẩu bị đóng hay chưa");
        verifyFalse(generalSetting.checkFormConfirmPasswordIsDisplayed());
        log.info("Step 11. Kiểm tra Form Chỉnh sửa Fullname bị đóng hay chưa");
        verifyFalse(generalSetting.checkFormEditFullNameIsDisplayed());
        log.info("Step 12. Kiểm tra Full name thay đổi thành công");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(),fullname);
    }

    // 3
    @Test(enabled = false, description = "Kiểm tra các trường hợp dữ liệu không hợp lệ ô firstname")
    public void TC03_Update_Fullname_With_Invalid_FirstName() {
        log.info("Nhấn vào nút Chỉnh sửa Full name");
        generalSetting.clickToButtonEditFullName();

        log.info("Trường hợp 1 - Firstname để trống");
        log.info("Step 1. Không nhập dữ liệu vào ô Firstname");
        generalSetting.removeDataToFieldFirstName();
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên là bắt buộc.");

        log.info("Trường hợp 2 - Firstname chứa toàn ký tự khoảng trắng");
        firstName = "    ";
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên là bắt buộc.");

        log.info("Trường hợp 3 - Firstname chỉ chứa số");
        firstName =  String.valueOf(randomNumber(1000000));
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không chứa số.");

        log.info("Trường hợp 4 - Firstname chứa số + chữ");
        firstName =  data.getFirstName() + randomNumber(1000000);
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không chứa số.");

        log.info("Trường hợp 5 - Firstname chứa ký tự đặc biệt");
        firstName = "!@#$%^^&";
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Trường hợp 6 - Firstname là một đoạn HTML code");
        firstName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(firstName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Trường hợp 7 - Firstname là một đoạn Script code");
        firstName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName(GlobalVariables.SCRPIT_CODE);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không chứa ký tự đặc biệt.");

        log.info("Trường hợp 7 - Firstname là một có chứa nhiều hơn 2 khoảng trắng giữa 2 từ");
        log.info("Step 1. Nhập dữ liệu ô Firstname");
        generalSetting.enterDataToFieldFirstName("Huy  Quốc");
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Firstname");
        verifyEquals(generalSetting.getMessageValidateFieldFirstName(), "Tên không được nhập quá 2 kí tự trắng.");
        generalSetting.clickToButtonCancelOnFormEditFullname();
    }

    @Test(description = "Kiểm tra các trường hợp dữ liệu không hợp lệ ô Lastname")
    public void TC04_Update_Fullname_With_Invalid_LastName() {
        log.info("Nhấn vào nút Chỉnh sửa Fullname");
        generalSetting.clickToButtonEditFullName();

        log.info("Trường hợp 1 - Lastname để trống");
        log.info("Step 1. Không nhập dữ liệu vào ô Lastname");
        generalSetting.removeDataToFieldLastName();
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ là bắt buộc.");

        log.info("Trường hợp 2 - Lastname chỉ chứa toàn ký tự khoảng trắng");
        lastName = "   ";
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ là bắt buộc.");

        log.info("Trường hợp 3 - Lastname chỉ chứa toàn số");
        lastName =  String.valueOf(randomNumber(20000));
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không chứa số.");

        log.info("Trường hợp 4 - Lastname chứa số + chữ");
        lastName =  data.getLastName() + randomNumber(20000);
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không chứa số.");

        log.info("Trường hợp 5 - Lastname chứa ký tự đặc biệt");
        lastName = "!@#$%^&";
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Trường hợp 6 - Lastname là một đoạn HTML code");
        lastName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Trường hợp 7 - Lastname là một đoạn Script code");
        lastName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không chứa ký tự đặc biệt.");

        log.info("Trường hợp 8 - Lastname là một có chứa nhiều hơn 2 khoảng trắng giữa 2 từ");
        lastName = "Hồ  Doãn";
        log.info("Step 1. Nhập dữ liệu ô Lastname");
        generalSetting.enterDataToFieldLastname(lastName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Lastname");
        verifyEquals(generalSetting.getMessageValidateFieldLastName(), "Họ không được nhập quá 2 kí tự trắng.");
        generalSetting.clickToButtonCancelOnFormEditFullname();
    }

    @Test( enabled = false, description = "Kiểm tra các trường hợp dữ liệu không hợp lệ ô Middlename")
    public void TC05_Update_Fullname_With_Invalid_Middlename() {
        log.info("Nhấn vào nút Chỉnh sửa Fullname");
        generalSetting.clickToButtonEditFullName();

        log.info("Trường hợp 1 - Middlename chỉ chứa toàn số");
        middleName = String.valueOf(randomNumber(10000));
        log.info("Step 1. Nhập dữ liệu ô Middlename");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Middlename");
        verifyEquals(generalSetting.getMessageValidateFieldMiddleName(), "Chữ lót không chứa số.");

        log.info("Trường hợp 2 - Middlename chứa số + chữ");
        middleName = data.getMiddleName() + randomNumber(100);
        log.info("Step 1. Nhập dữ liệu ô Middlename");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Middlename");
        verifyEquals(generalSetting.getMessageValidateFieldMiddleName(), "Chữ lót không chứa số.");

        log.info("Trường hợp 3 - Middlename chứa ký tự đặc biệt");
        middleName = "!@#$%^%^";
        log.info("Step 1. Nhập dữ liệu ô Middlename");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Middlename");
        verifyEquals(generalSetting.getMessageValidateFieldMiddleName(), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Trường hợp 4 - Middlename là một đoạn Script code");
        middleName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập dữ liệu ô Middlename");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Middlename");
        verifyEquals(generalSetting.getMessageValidateFieldMiddleName(), "Chữ lót không chứa ký tự đặc biệt.");

        log.info("Trường hợp 5 - Middlename là một đoạn HTML code");
        middleName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập dữ liệu ô Middlename");
        generalSetting.enterDataToFieldMiddlename(middleName);
        log.info("Step 2. Nhấn vào nút Lưu Tại form Chỉnh sửa");
        generalSetting.clickToButtonSaveChangesOnFormEditFullname();
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Middlename");
        verifyEquals(generalSetting.getMessageValidateFieldMiddleName(), "Chữ lót không chứa ký tự đặc biệt.");

        generalSetting.clickToButtonCancelOnFormEditFullname();
    }

    @Test( enabled = false, description = "Kiểm tra các trường hợp Fullname vượt quá 75 ký tự")
    public void TC06_Update_Fullname_With_Case_Total_Fullname_Charaters_Exceed_75 () {
        log.info("Trường hợp 1 - First name > 75 chars");
        firstName = randomName(100);
        middleName = data.getMiddleName();
        lastName = data.getLastName();
        password = "123456";

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Giới hạn tối đa của Họ và tên là 75 kí tự");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 2 - Last name > 75 chars");
        firstName = data.getFirstName();
        middleName = data.getMiddleName();
        lastName = randomName(100);

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Giới hạn tối đa của Họ và tên là 75 kí tự");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 3 - Middle name > 75 chars");
        firstName = data.getFirstName();
        middleName = randomName(100);
        lastName = data.getLastName();

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Giới hạn tối đa của Họ và tên là 75 kí tự");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 4 - Total full name > 75 chars");
        firstName = randomName(30);
        middleName = randomName(20);
        lastName = randomName(30);

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Giới hạn tối đa của Họ và tên là 75 kí tự");
        generalSetting.clickToButtonCancelOnFormEditFullname();
    }

    @Test(enabled = false, description = "Kiểm tra các trường hợp Fullname vượt quá 5 từ")
    public void TC07_Update_Fullname_With_Case_Total_Fullname_Words_Exceed_5() {
        log.info("Trường hợp 1 - First Name > 5 Word");
        firstName = "Adam John Leonard Da Vance";
        middleName = "Doãn ";
        lastName = "Hồ";

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Họ và tên không lớn hơn 5 từ.");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 2 - Last Name > 5 Word");
        firstName = "Huy";
        middleName = "Doãn ";
        lastName = "Adam John Leonard Da Vance";

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Họ và tên không lớn hơn 5 từ.");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 3 - Middle Name > 5 Word");
        firstName = "Huy";
        middleName = "Adam John Leonard Da Vance";
        lastName = "Hồ";

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Họ và tên không lớn hơn 5 từ.");
        generalSetting.clickToButtonCancelOnFormEditFullname();

        log.info("Trường hợp 4 - Total Full Name > 5 Words");
        firstName = "Huy Smit";
        middleName = "Adam John e";
        lastName = "Hồ Doan";

        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, lastName, middleName,password);
        verifyEquals(generalSetting.getMessageValidateChangeFullName(),"Họ và tên không lớn hơn 5 từ.");
        generalSetting.clickToButtonCancelOnFormEditFullname();
    }

    @Test(enabled = false, description = "Kiểm tra các trường hợp dữ liệu không hợp lệ ô Password")
    public void TC08_Update_Fullname_With_Invalid_Pass () {
        firstName = data.getFirstName();
        middleName = data.getMiddleName();
        lastName = data.getLastName();

        log.info("Trường hợp 1 - Password để trống");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password ="";
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 2. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateFieldPassword(), "Mật khẩu là bắt buộc.");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 2 - Password chứa toàn ký tự khoảng tráng");
        password ="    ";
        log.info("Step 1. Nhập dữ liệu ô Password");
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 2. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateFieldPassword(), "Mật khẩu là bắt buộc.");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 3 - Password sai");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = "123456789";
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateOfFormConfirmPass(), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 4 - Password số ký tự <6 ký tự");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = randomPassword(5);
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateFieldPassword(), "Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 5 - Password số ký tự > 128 ký tự");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = randomPassword(129);
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateOfFormConfirmPass(), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 6 - Password chứa ký tự khoảng trắng");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = "123 456";
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateOfFormConfirmPass(), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 7 - Password là một đoạn script");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = GlobalVariables.SCRPIT_CODE;
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 2. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateOfFormConfirmPass(), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");
        generalSetting.refreshPage(driver);

        log.info("Trường hợp 8 - Password là một đoạn HTML");
        log.info("Step 1. Nhập dữ liệu ô Password");
        password = GlobalVariables.HTML_CODE;
        generalSetting.updateFullName(firstName,middleName,lastName,password);
        log.info("Step 3. Kiểm tra thông báo lỗi hiển thị của ô Password");
        verifyEquals(generalSetting.getMessageValidateOfFormConfirmPass(), "Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác");
        generalSetting.refreshPage(driver);
    }

    @Test( enabled = false, description = "Kiểm tra cập nhật Full name với trường FirstName là chữ in hoa")
    public void TC09_Update_Fullname_With_Firstname_Uppercase() {
        firstName =  data.getFirstName().toUpperCase();
        lastName = data.getLastName();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        setTimeDelay(2);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường FirstName là chữ thường")
    public void TC10_Update_Fullname_With_Firstname_Lowercase() {
        firstName =  data.getFirstName().toLowerCase();
        lastName = data.getLastName();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName,password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường FirstName có ký tự trắng ở đầu")
    public void TC11_Update_Fullname_With_Firstname_Have_Whitespace_At_First_Position() {
        log.info("Prepare data");
        firstName = "  "+  data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName,password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường FirstName có ký tự trắng ở cuối")
    public void TC12_Update_Fullname_With_Firstname_Have_Whitespace_At_Last_Position() {
        log.info("Prepare data");
        firstName = data.getFirstName() +"  ";
        lastName = data.getLastName();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Lastname là chữ thường")
    public void TC13_Update_Fullname_With_Lastname_Have_Lowercase() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName().toLowerCase();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Lastname là chữ in hoa")
    public void TC14_Update_Fullname_With_Lastname_Have_Uppercase() {
        firstName = data.getFirstName();
        lastName = data.getLastName().toUpperCase();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName ,password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Lastname có ký tự trắng ở đầu")
    public void TC15_Update_Fullname_With_Lastname_Have_Whitespace_At_First_Position() {
        firstName = data.getFirstName();
        lastName = " "+ data.getLastName();
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường FirstName có ký tự trắng ở cuối")
    public void TC16_Update_Fullname_With_Lastname_Have_Whitespace_At_Last_Position() {
        firstName = data.getFirstName();
        lastName = data.getLastName() + "  ";
        middleName = data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename là chữ thường")
    public void TC17_Update_Fullname_With_Middlename_Have_Lowercase () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName().toLowerCase();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename là chữ in hoa")
    public void TC18_Update_Fullname_With_Middlename_Have_Uppercase () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName().toUpperCase();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename có ký tự trắng ở đầu")
    public void TC19_Update_Fullname_With_Middlename_Have_Whitespace_At_First_Position () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = "  "+ data.getMiddleName();
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename có ký tự trắng ở cuối")
    public void TC20_Update_Fullname_With_Middlename_Have_Whitespace_At_Last_Position () {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = data.getMiddleName()+ "   ";
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename rỗng")
    public void TC21_Update_Fullname_With_Blank_Middlename() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = "";
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName, password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với trường Middlename chỉ chứa toàn ký tự đăc biệt")
    public void TC22_Update_Fullname_With_Middlename_Contains_All_Whitespace() {
        log.info("Prepare data");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        middleName = "         ";
        password = "123456";

        log.info("Step 1. Enter data on Form Edit fullname");
        generalSetting.updateFullName(firstName, middleName, lastName , password);
        log.info("Step 5 - Check full name after change");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(), getFullName(firstName, middleName, lastName));
    }

    @Test(enabled = false, description = "Kiểm tra cập nhật Full name với case tạo mới")
    public void TC23_Check_Data_Display_Of_Function_Update_Fullname(){
        log.info("Step 1 - Đăng xuất tài khoản");
        generalSetting.clickToItemSettingOnHeaderSection("ic-logout-c");
        signUpPage = PageGeneration.createFormRegister(driver);

        firstName = data.getFirstName();
        lastName = data.getLastName();
        email = randomVirtualEmail();
        userFullname = getFullName(lastName, firstName);
        password = "123456";
        log.info("Step 2 - Đăng ký tài khoản mới");
        signUpPage.signUpWithNewAccountByEmail(firstName,lastName,email,password,password);
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);
        log.info("Step 3. Kiểm trá xác thực tài khoản thành công");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));
        log.info("Step 4. Huỷ thao tác cập nhật thông tin tài khoản");
        newsfeedHomepagePO.clickToButtonCancelOnPopupUpdateInformation();
        verifyEquals(userFullname, newsfeedHomepagePO.getFullNameDisplayOnWidgetMyAccount());
        log.info("Step 5. Tới trang thiết lập tài khoản");
        newsfeedHomepagePO.clickToItemSettingOnHeaderSection("ic-cog-c");
        log.info("Step 6. Kiêm tra tráng thiết lập tài khoản chung hiển thị");
        verifyTrue(generalSetting.checkGeneralAccountSettingTabIsDisplayed(userFullname,languageSystem));
        log.info("Step 7. Nhấn vào nút chỉnh sủa Fullname");
        generalSetting.clickToButtonEditFullName();
        log.info("Step 8. Kiẻm tra dữ liệu hiển thị tại các field chính xác");
        verifyEquals(generalSetting.getDataDisplayOnFieldFirstName(),firstName);
        verifyEquals(generalSetting.getDataDisplayOnFieldLastName(),lastName);

        firstName = data.getFirstName();
        middleName = data.getMiddleName();
        lastName = data.getLastName();
        userFullname = getFullName(firstName,middleName,lastName);
        log.info("Step 9. Nhập thông tin dữ liệu vào các field");
        generalSetting.enterValueToAllFieldOnFormEditFullname(firstName, middleName, lastName, password);
        log.info("Step 10. Nhập mật khẩu tại form xác nhận mật khâu");
        generalSetting.enterDataToFieldPassword(password);
        log.info("Step 11. Nhấn nút xác nhận tại form xác nhận mật khẩu");
        generalSetting.clickToButtonConfirmOnFormConfirmPass();
        log.info("Step 12. Kiểm tra giá trị Fullname sau khi update");
        verifyEquals(generalSetting.getFullNameIsDisplayedOnTabGeneralSetting(),userFullname);
    }

}




