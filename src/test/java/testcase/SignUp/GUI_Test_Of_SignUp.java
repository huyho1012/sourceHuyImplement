package testcase.SignUp;

import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Shared.LoginPO;
import Project.Shared.SignUpPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GUI_Test_Of_SignUp extends AbstractTest {
    WebDriver driver;
    LoginPO newsfeedLoginPageObject;
    SignUpPO signUpPageObject;
    @Test(enabled = false)
    public void Testcase_Register_01_Check_SignUpForm_With_Eng_Language(){
        newsfeedLoginPageObject.clickToChangeToEng();
        signUpPageObject = PageGeneration.createFormRegister(driver);
        log.info("Check Title Of SignUp form when");
//        verifyEquals(signUpPageObject.getTitleFormSignUpAccount(),"Join Hahalolo Now!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"First name");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Last name");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Phone number or Email");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Password");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Confirm Password");
        verifyEquals(signUpPageObject.getTextButtonSignUp(),"Sign Up");
    }
    @Test(enabled = false)
    public void Testcase_Register_02_Check_SignUpForm_With_VI_Language(){
        newsfeedLoginPageObject.clickToChangeLanguageToVI();
        log.info("Check Title Of SignUp form when");
//        verifyEquals(signUpPageObject.getTitleFormSignUpAccount(),"Tham gia Hahalolo ngay!");
        log.info("Check placeholder of fields");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Tên");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Họ");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Điện thoại hoặc Email");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Mật khẩu");
        verifyEquals(signUpPageObject.getPlaceholderDynamicFieldOnSignUpForm(""),"Mật khẩu xác nhận");
        verifyEquals(signUpPageObject.getTextButtonSignUp(),"Đăng ký");
    }
}
