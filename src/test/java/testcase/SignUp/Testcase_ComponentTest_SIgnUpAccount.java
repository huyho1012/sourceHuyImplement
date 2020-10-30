package testcase.SignUp;

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
import org.testng.annotations.*;

public class Testcase_ComponentTest_SIgnUpAccount extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    SignUpPO signUpPageObject;
    LoginPO newsfeedLoginPageObject;
    NewsfeedHomepagePO newsfeedPage;
    PerAbout_OverviewPO overviewPage;
    GeneralAccountSettingPO generalSettingAccountPage;
    // Khai báo giá trị nhập vào
    String email, firstName, lastName, password, phone, confirmPass;
    String verifyCode;
    String languageSystem;

    String fieldFirstName = "nv104";
    String fieldLastName = "nv103";
    String fieldUserAccount ="nv108";
    String fieldPassword ="nv109";
    String fieldConfirmPass = "repeatPassword";

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        log.info("Khởi tạo driver");
        driverManager = BrowserInitialization.getBrowser(urlPage);
        log.info("Open browser and go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPageObject = PageGeneration.createNewsfeedLoginPage(driver);
        log.info("Change language system to Vietnamese");
        newsfeedLoginPageObject.clickToChangeLanguageToVI();
        signUpPageObject = PageGeneration.createFormRegister(driver);
        languageSystem = signUpPageObject.getLanguageOfSystemHahalolo();

    }

    @Test(description = "Đăng ký tài khoản với các trường hợp không hợp lệ của field First name")
    public void TC01_Register_Account_With_Invalid_FirstName(){
        log.info("Khởi tạo giá trị cho các field");
        firstName = data.getFirstName();
        email = randomVirtualEmail();
        password = GlobalVariables.ADMIN_PASSWORD;
        confirmPass = GlobalVariables.ADMIN_PASSWORD;

        log.info("Trường hợp 1 - Để trống ô First name");
        firstName = "";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên là bắt buộc.");

        log.info("Trường hợp 2 - First name chỉ chứa những ký tự khoảng trắng");
        firstName = "    ";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên là bắt buộc.");

        log.info("Trường hợp 3 - First name chỉ chứa số");
        firstName = String.valueOf(randomNumber(20));
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên không chứa số.");

        log.info("Trường hợp 4 - First name chỉ chứa những số + chữ");
        firstName =  data.getFirstName()+ randomNumber(10);
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên không chứa số.");

        log.info("Trường hợp 5 - First name chứa những ký tự đặc biệt");
        firstName = "H@ang @anh";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên không chứa ký tự đặc biệt.");

        log.info("Trường hợp 6 - First name là một đoạn Script");
        firstName = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp( fieldFirstName),"Tên không chứa ký tự đặc biệt.");

        log.info("Trường hợp 7 - First name là một đoạn HTML");
        firstName = GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Firstname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldFirstName),"Tên không chứa ký tự đặc biệt.");
    }

    @Test(description = "Đăng ký tài khoản với các trường hợp không hợp lệ của field Last name")
    public void TC02_Register_Account_With_Invalid_LastName(){
        signUpPageObject.refreshPage(driver);
        log.info("Khởi tạo giá trị cho các field");
        firstName = data.getFirstName();
        email = randomVirtualEmail();
        password = GlobalVariables.ADMIN_PASSWORD;
        confirmPass = GlobalVariables.ADMIN_PASSWORD;

        log.info("Trường hợp 1 - Để trống không nhập ô Lastname");
        lastName = "";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ là bắt buộc.");

        log.info("Trường hợp 2 - Lastname chỉ chứa các ký tự khoảng trắng");
        lastName = "    ";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ là bắt buộc.");

        log.info("Trường hợp 3 - Lastname chỉ chứa số");
        lastName = String.valueOf(randomNumber(12));
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ không chứa số.");

        log.info("Trường hợp 4 - Lastname chứa giá trị cả số + chữ");
        lastName = data.getLastName()+ randomNumber(12);
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ không chứa số.");

        log.info("Trường hợp 5 - Lastname chứa các ký tự đặc biệt");
        lastName ="H@ Do@an";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ không chứa ký tự đặc biệt.");

        log.info("Trường hợp 6 - Lastname là một đoạn script code");
        lastName =  GlobalVariables.SCRPIT_CODE;
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ không chứa ký tự đặc biệt.");

        log.info("Trường hợp 7 - Lastname là một đoạn HTML code");
        lastName =  GlobalVariables.HTML_CODE;
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Lastname");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldLastName),"Họ không chứa ký tự đặc biệt.");
    }

    @Test(description = "Đăng ký tài khoản với các trường hợp không hợp lệ của field Email")
    public void TC03_Register_Account_With_Invalid_Email() {
        log.info("Khởi tạo dữ liệu");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        password = GlobalVariables.ADMIN_PASSWORD;
        confirmPass = GlobalVariables.ADMIN_PASSWORD;

        log.info("Trường hợp 1 - Email để rỗng");
        email = "";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản là bắt buộc.");

        log.info("Trường hợp 2 - Email chứa toàn ký tự khoảng trắng");
        email = "    ";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản là bắt buộc.");

        log.info("Trường hợp 3 - Email không có domain");
        email = "huyho12@gmail.";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");

        log.info("Trường hợp 3 - Email đã được đăng ký tài khoản");
        email = "balo_04@mailinator.com";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Case: Email contains special characters");
        email = "huy!@hoho@mailinator.com";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldPassword), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on first position");
        email = " huy@mailinator.com";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on middle position");
        email = "huy ho@mailinator.com";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");

        log.info("Case: Email contains whitespace on last position");
        email = "huyho@mailinator.com ";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, email, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC03_Register_Account_With_Invalid_PhoneNumber() {
        log.info("Khởi tạo dữ liệu");
        firstName = data.getFirstName();
        lastName = data.getLastName();
        password = GlobalVariables.ADMIN_PASSWORD;
        confirmPass = GlobalVariables.ADMIN_PASSWORD;

        log.info("Trường hợp 1 - Để rỗng số điện thoại");
        phone = "";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account [Email]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản là bắt buộc.");

        log.info("Trường hợp 2 - Số điện thoại chỉ chứa những khoảng trắng");
        phone = "     ";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 2. Nhấn vào nút Đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản là bắt buộc.");

        log.info("Trường hợp 3 - Số điện thoại <8 số");
        phone = randomCharNumber(5);
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 3. Nhấn nút đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");

        log.info("Trường hợp 4 - Số điện thoại > 20 số");
        phone = randomCharNumber(21);
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 3. Nhấn nút đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 3. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");

        log.info("Trường hợp 5 - Mã vùng với số điện thoại không hợp lệ");
        phone = "0541565555";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 2. Chọn mã vùng điện thoại");
        signUpPageObject.choosePhoneCodeOnFormSignUp("(+84) Viet Nam");
        log.info("Step 3. Nhấn nút đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 4. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Số điện thoại không hợp lệ.");

        log.info("Trường hợp 6 - Nhập số điện thoại đã được đăng ký trước");
        phone = "0936709449";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 2. Chọn mã vùng điện thoại");
        signUpPageObject.choosePhoneCodeOnFormSignUp("(+84) Viet Nam");
        log.info("Step 3. Nhấn nút đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 4. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Trường hợp 7 - Nhập số điện thoại có chứa mã vùng (+84)");
        phone = "+840936709449";
        log.info("Step 1. Nhập các giá trị field");
        signUpPageObject.enterAllDataOnFormSignup(firstName, lastName, phone, password, confirmPass);
        log.info("Step 2. Chọn mã vùng điện thoại");
        signUpPageObject.choosePhoneCodeOnFormSignUp("(+84) Viet Nam");
        log.info("Step 3. Nhấn nút đăng ký");
        signUpPageObject.clickToButtonSignUp();
        log.info("Step 4. Kiểm tra thông báo lỗi tại Field Account [Phone]");
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp(fieldUserAccount), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC04_Register_Account_With_Invalid_Password(){

        log.info("Step 1. Enter blank Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("nv109"),"Mật khẩu là bắt buộc.");

        log.info("Step 2. Enter Password <6 chars");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","12345");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 3. Enter Password > 128 chars");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109",randomPassword(129));
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 4. Enter Password contains whitespace");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123 456");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("nv109"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Precondition");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123456");
    }
    @Test
    public void TC05_Register_Account_With_Invalid_Confirm_Password(){
        log.info("Step 1. Do not input Confirm Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2. Enter Confirm Password contains whitespace");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","123 456");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 3. Enter Confirm Password <6 chars");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","12345");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4. Enter ConfirmPassword > 128 chars");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword",randomPassword(129));
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 5. Enter Password not same confirm pass");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","1234567");
        signUpPageObject.clickToButtonSignUp();
        verifyEquals(signUpPageObject.getMessageValidateDynamicFieldOnFormSignUp("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void TC06_Register_Account_With_Email_Is_UpperCase() {
        signUpPageObject.refreshPage(driver);
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input email");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv108",email.toUpperCase());

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify email of account display");
        signUpPageObject.clickToButtonSignUp();
        verifyTrue(signUpPageObject.getTitleFormVerifyAccount().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterDataFieldVerifyCode(verifyCode);
        signUpPageObject.clickToButtonVerify();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem);

        log.info("Step 9. Click cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();
        String fullName = newsfeedPage.getFullNameDisplayOnWidgetMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToLinkEditProfileOnWidgetMyAccount();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemSettingOnHeaderSection("ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }
    @Test
    public void TC07_Register_Account_With_Email_Contains_More_Two_Dots() {
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Email");
        email = randomVirtualEmail();
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify account display");
        signUpPageObject.clickToButtonSignUp();
        verifyTrue(signUpPageObject.getTitleFormVerifyAccount().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterDataFieldVerifyCode(verifyCode);
        signUpPageObject.clickToButtonVerify();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem);

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();
        String fullName = newsfeedPage.getFullNameDisplayOnWidgetMyAccount();

        log.info("Step 10. Go To Personal about -Overview");
        newsfeedPage.clickToLinkEditProfileOnWidgetMyAccount();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12. Logout account");
        overviewPage.clickToItemSettingOnHeaderSection("ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }

    @Test (enabled = false)
    public void TC08_Register_Account_With_Phone_Contains_PhoneCode() {
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv104", firstName);

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv108","840936709449");

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button and verify phone of account display");
        signUpPageObject.clickToButtonSignUp();
        verifyTrue(signUpPageObject.getTitleFormVerifyAccount().contains("Số điện thoại"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), "840936709449");

        log.info("Step 7. Input verify code and verify account");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterDataFieldVerifyCode(verifyCode);
        signUpPageObject.clickToButtonVerify();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check form update info display");
        newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem);

        log.info("Step 9. Click cancel update");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();
        String fullName = newsfeedPage.getFullNameDisplayOnWidgetMyAccount();

        log.info("Step 10. Go To Personal about");
        newsfeedPage.clickToLinkEditProfileOnWidgetMyAccount();
        overviewPage = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Step 11. Check email display");
        verifyEquals(overviewPage.getEmailIsDisplayOnIntroduceWidget(), email);

        log.info("Step 12 - Logout account");
        overviewPage.clickToItemSettingOnHeaderSection("ic-logout-c");
        signUpPageObject = PageGeneration.createFormRegister(driver);
    }

    public void TC09_Register_Account_With_Uppercase_Firstname(){
        log.info("Step 1. Input FirstName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv104", firstName.toUpperCase());

        log.info("Step 2. Input LastName");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv103", lastName);

        log.info("Step 3. Input Phone");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv108",email);

        log.info("Step 4. Input Password");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("nv109","123456");

        log.info("Step 5. Input ConfirmPass");
        signUpPageObject.enterDataToDynamicFieldOnFormSignUp("repeatPassword","123456");

        log.info("Step 6. Click SignUp button");
        signUpPageObject.clickToButtonSignUp();

        log.info("Step 6. Verify form register account by email display successfully");
        verifyTrue(signUpPageObject.getTitleFormVerifyAccount().endsWith("email"));
        verifyEquals(signUpPageObject.getUserAccountToDisplay(), email);

        log.info("Step 7. Input verify code");
        verifyCode = signUpPageObject.getVerifyCodeByEmail(email);
        signUpPageObject.enterDataFieldVerifyCode(verifyCode);

        log.info("Step 7. Click verify button");
        signUpPageObject.clickToButtonVerify();
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Step 8. Check verify account succesfully and check form update info is display");
        newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem);

        log.info("Step 9. Click cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();
        String fullName = newsfeedPage.getFullNameDisplayOnWidgetMyAccount();

        log.info("Step 9. Verify fullname display on My account");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(),"");

        log.info("Step 10. Go to General Account Setting");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);

        log.info("Step 10. Verify General Account Setting display successfully");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(),"");

        generalSettingAccountPage.clickToItemSettingOnHeaderSection("");
        signUpPageObject = PageGeneration.createFormRegister(driver);

    }

    public void TC10_Register_Account_With_Lowercase_Firstname(){
        firstName = data.getFirstName().toLowerCase();
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC11_Register_Account_With_Firstname_Has_Whitespace_On_First_Position(){
        firstName = " " + data.getFirstName();
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC12_Register_Account_With_Firstname_Has_Whitespace_On_Last_Position(){
        firstName = data.getFirstName() + " ";
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC13_Register_Account_With_Firstname_Has_More_Than_2_Whitespace_On_Middle_Position(){
        firstName = "Huy Hồ";
        lastName = data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC14_Register_Account_With_Uppercase_LastName(){
        firstName = data.getFirstName();
        lastName = data.getLastName().toUpperCase();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC15_Register_Account_With_Lowercase_LastName(){
        firstName = data.getFirstName();
        lastName = data.getLastName().toLowerCase();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }

    public void TC16_Register_Account_With_LastName_Has_Whitespace_On_First_Position(){
        firstName = data.getFirstName();
        lastName = "  " + data.getLastName();
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);

    }

    public void TC17_Register_Account_With_LastName_Has_Whitespace_On_Last_Position(){
        firstName = data.getFirstName();
        lastName = data.getLastName() + "  ";
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);

    }

    public void TC18_Register_Account_With_LastName_Has_Whitespace_On_Middle_Position() {
        firstName = data.getFirstName();
        lastName = "Hồ   Doãn";
        email = randomVirtualEmail();
        String fullName = getFullName(firstName, lastName);
        password = "123456";
        confirmPass = "123456";

        log.info("Sign up new account with information");
        signUpPageObject.signUpWithNewAccountByEmail(firstName,lastName,email,password,confirmPass);
        newsfeedPage = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Check Register account successfully");
        verifyTrue(newsfeedPage.checkNewsfeedHomepageIsDisplayAfterRegisterAccount(languageSystem));

        log.info("Click to cancel update information");
        newsfeedPage.clickToButtonCancelOnPopupUpdateInformation();

        log.info("Verify account display on My account widget display correctly");
        verifyEquals(newsfeedPage.getFullNameDisplayOnWidgetMyAccount(), fullName);

        log.info("Go to Account setting page");
        newsfeedPage.clickToItemSettingOnHeaderSection("");
        generalSettingAccountPage = PageGeneration.createGeneralAccountSettingPage(driver);
        log.info("Check acount setting page display succesfully");
        verifyTrue(generalSettingAccountPage.checkGeneralAccountSettingTabIsDisplayed(fullName, languageSystem));

        log.info("Check full name display on General account setting");
        verifyEquals(generalSettingAccountPage.getFullNameIsDisplayedOnTabGeneralSetting(), fullName);
    }
}
