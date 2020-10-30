package testcase.Newsfeed.About.BasicInfoAndContact;

import Common.DriverManagement.BrowserInitialization;
import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import Common.HelperFunction.AbstractTest;
import Common.HelperFunction.PageGeneration;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Newsfeed.PersonalWall.About.PerAbout_BasicInfoAndContactPO;
import Project.Newsfeed.PersonalWall.About.PerAbout_OverviewPO;
import Project.Shared.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Testcase_ComponentTest_PhoneNumber_Function extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    LoginPO newsfeedLoginPage;
    NewsfeedHomepagePO newsfeedHomepagePO;
    PerAbout_OverviewPO perOverviewTab;
    PerAbout_BasicInfoAndContactPO perBasicInfoTab;

    String numberPhone;
    String otherPhone;
    String languageSystem;

    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        driverManager = BrowserInitialization.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.LINK_TEST_NEWSFEED);
        newsfeedLoginPage = PageGeneration.createNewsfeedLoginPage(driver);
        newsfeedLoginPage.clickToChangeLanguageToVI();
        languageSystem = newsfeedLoginPage.getLanguageOfSystemHahalolo();

        log.info("Prestep 1 - Login Hahalolo");
        newsfeedLoginPage.loginToNewsfeedHahalolo(GlobalVariables.USER_EMAIL_ACCOUNT,"123456");
        newsfeedHomepagePO = PageGeneration.createNewsfeedHomepage(driver);

        log.info("Prestep 2 - Check Login successfully");
        verifyTrue(newsfeedHomepagePO.checkNewsfeedHomepageIsDisplayed("vi"));

        log.info("Prestep 3 - Go to Personal About");
        newsfeedHomepagePO.clickToLinkEditProfileOnWidgetMyAccount();
        perOverviewTab = PageGeneration.createPerAboutOverviewTab(driver);

        log.info("Prestep 4. Check personal about overview display successfully");
        verifyTrue(perOverviewTab.checkPerAboutOverviewTabIsDisplay());

        log.info("Prestep 5. Go to Personal About - Basic And Contact Info");
        perOverviewTab.clickToTabItemOnAbout( "#about_contact");
        perBasicInfoTab = PageGeneration.createperBasicInfoAndContactPage(driver);

        log.info("Prestep 6. Check personal about Basic And Contact Info display successfully");
        verifyTrue(perBasicInfoTab.checkContactAndBasicInfoTabIsDisplayed(languageSystem));
    }

    @Test
    public void TC_01_EditPhoneNumberWithInvalidPhone(){
        log.info("Prepare step - Open main phone form");
        perBasicInfoTab.clickToIconEditMainPhone();

        log.info("Case - Make main phone blank");
        numberPhone ="";
        log.info("Step 1 - Remove phone number");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(), perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 2. Click to Save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 3. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains all whitespace");
        numberPhone = "       ";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 3. Check error validation");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains only characters");
        numberPhone = "abcdefgh";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains only special characters");
        numberPhone = "@@@@@@@@@@@";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Số điện thoại là bắt buộc.");

        log.info("Case - Main phone contains less than 8 characters");
        numberPhone = "1234567";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone contains less than 20 characters");
        numberPhone = String.valueOf(randomNumber(21));
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));

        log.info("Case - Main phone is combine character + numberic and number <8");
        numberPhone = "huy1234567";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldMainPhone(),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone is combine character + numberic and number >20");
        numberPhone = "huy123456789ho123456789doan132";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));

        log.info("Case - Main phone is combine character + numberic and number 8-20");
        numberPhone = "Haha9191HoHuy3423";
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));

        log.info("Case - Main phone is script code");
        numberPhone = GlobalVariables.SCRPIT_CODE;
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));

        log.info("Case - Main phone is HTML code");
        numberPhone = GlobalVariables.HTML_CODE;
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldMainPhone(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldMainPhone(),perBasicInfoTab.convertFormatPhoneData(numberPhone));

        perBasicInfoTab.clickToButtonCancelOnFormEditPhone();
    }
    @Test
    public void TC_02_Check_Action_Add_Other_Phone(){
        log.info("Prepare step - Open main phone form");
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();

        log.info("Case - Make other phone blank");
        otherPhone = "";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(), perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 2. Click to Save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Other phone contains all whitespace");
        otherPhone = "       ";
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify other phone value display");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Check error validation");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Other phone contains only characters");
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        otherPhone = "abcdefgh";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Main phone contains only special characters");
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        otherPhone = "@@@@@@@@@@@";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(numberPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone ));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Main phone contains less than 8 characters");
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        otherPhone = "1234567";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldOtherPhone(1),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Main phone contains less than 20 characters");
        otherPhone = String.valueOf(randomNumber(21));
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Other phone is combine character + numberic and number <8");
        otherPhone = "huy1234567";
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
        log.info("Step 4. Check error validation");
        verifyEquals(perBasicInfoTab.getMessageValidateFieldOtherPhone(1),"Giới hạn tối thiểu của Số điện thoại là 8 kí tự");

        log.info("Case - Other phone is combine character + numberic and number >20");
        otherPhone = "huy123456789ho123456789doan132";
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Main phone is combine character + numberic and number 8-20");
        otherPhone = "Haha9191HoHuy3423";
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        log.info("Step 1 - Enter main phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Main phone is script code");
        otherPhone = GlobalVariables.SCRPIT_CODE;
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();

        log.info("Case - Main phone is HTML code");
        otherPhone = GlobalVariables.HTML_CODE;
        perBasicInfoTab.clickToIconEditMainPhone();
        perBasicInfoTab.clickToLinkAddOtherPhone();
        log.info("Step 1 - Enter other phone");
        perBasicInfoTab.enterDataToFieldOtherPhoneCaseAdd(otherPhone);
        log.info("Step 2 - Verify value display on field");
        verifyEquals(perBasicInfoTab.getValueDisplayOnFieldOtherPhone(),perBasicInfoTab.convertFormatPhoneData(otherPhone));
        log.info("Step 3. Click save button");
        perBasicInfoTab.clickToButtonSaveOnFormEditPhone();
    }
}
