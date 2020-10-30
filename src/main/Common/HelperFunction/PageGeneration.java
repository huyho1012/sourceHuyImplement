package Common.HelperFunction;


import Project.Business.Promotion.DetailPromoPO;
import Project.Business.Promotion.TourPromotionPO;
import Project.Business.Tour.Setting.PubishPagePOPO;
import Project.Newsfeed.AccountSetting.GeneralAccountSettingPO;
import Project.Newsfeed.Boooking.BoookingTourPO;
import Project.Newsfeed.Boooking.PaymentGateWay.Stripe_PO;
import Project.Newsfeed.Boooking.PaymentInfoPO;
import Project.Newsfeed.Newsfeed.Header.ChangeCurrencyPO;
import Project.Newsfeed.PageWall.TourDetailPO;
import Project.Newsfeed.PersonalWall.About.*;
import Project.Newsfeed.PersonalWall.Handnote.Handnote_TourPO;
import Project.Newsfeed.PersonalWall.Timeline.NewsfeedPersonalTimelinePO;
import Project.Shared.ChoosePlaceModelPO;
import Project.Shared.LoginPO;
import Project.Backend.BackendHomePagePO;
import Project.Backend.BackendVerifyBusiManagementPO;
import Project.Business.Business.*;
import Project.Business.Tour.Management.Detail.*;
import Project.Business.Tour.Management.List.TourManagementPagePO;
import Project.Business.Tour.Setting.TourGeneralSettingPagePO;
import Project.Business.Tour.Topic.TourTopicPagePO;
import Project.Business.Tour.TourDashboardPagePO;
import Project.Newsfeed.Newsfeed.NewsfeedHomepagePO;
import Project.Shared.SignUpPO;
import Project.Wallet.WalletHomePagePO;
import Project.Wallet.WalletOverviewPagePO;
import org.openqa.selenium.WebDriver;

public class PageGeneration {

    public static LoginPO createNewsfeedLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static SignUpPO createFormRegister(WebDriver driver) {
        return new SignUpPO(driver);
    }

    public static NewsfeedHomepagePO createNewsfeedHomepage(WebDriver driver) {
        return new NewsfeedHomepagePO(driver);
    }

    public static GeneralAccountSettingPO createGeneralAccountSettingPage(WebDriver driver) {
        return new GeneralAccountSettingPO(driver);
    }

    public static BusinessOverviewPagePO createBusinessOverviewPage(WebDriver driver) {
        return new BusinessOverviewPagePO(driver);
    }

    public static BusinessDashboardPagePO createBusinessDashboardPage(WebDriver driver) {
        return new BusinessDashboardPagePO(driver);
    }

    public static BusinessListPagePO createBusinessListPage(WebDriver driver)
    {
        return new BusinessListPagePO(driver);
    }

    public static BusinessVerificationRequestPO createVerifyBusinessTypeEnterpriseForm(WebDriver driver) {
        return new BusinessVerificationRequestPO(driver);
    }

    public static BusinessInfoPagePO createBusinessInfoPage(WebDriver driver) {
        return new BusinessInfoPagePO(driver);
    }

    public static LoginPO createLoginBackEndPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static BackendHomePagePO createBackendHomepage(WebDriver driver) {
        return new BackendHomePagePO(driver);
    }

    public static BackendVerifyBusiManagementPO createVerifyBusinessManagement(WebDriver driver) {
        return new BackendVerifyBusiManagementPO(driver);
    }

    public static LoginPO createWalletLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static WalletOverviewPagePO createWalletOverviewPage(WebDriver driver) {
        return new WalletOverviewPagePO(driver);
    }

    public static BusinessPagePOManagementPO goToPageListManagement(WebDriver driver) {
        return new BusinessPagePOManagementPO(driver);
    }

    public static TourDashboardPagePO createTourDashboardPage(WebDriver driver) {
        return new TourDashboardPagePO(driver);
    }

    public static TourGeneralSettingPagePO createTourGeneralSettingPage(WebDriver driver) {
        return new TourGeneralSettingPagePO(driver);
    }

    public static TourTopicPagePO createTourTopicListPage(WebDriver driver) {
        return new TourTopicPagePO(driver);
    }

    public static TourManagementPagePO createTourManagementPage(WebDriver driver) {
        return new TourManagementPagePO(driver);
    }

    public static WalletHomePagePO createWalletHomepage(WebDriver driver) {
        return new WalletHomePagePO(driver);
    }

    public static TourInfoTabPO createTourInfoTab(WebDriver driver) {
        return new TourInfoTabPO(driver);
    }

    public static BusinessPagePOManagementPO openCreatePagePopup(WebDriver driver) {
        return new BusinessPagePOManagementPO(driver);
    }

    public static TourPartTabPO createTourPartTab(WebDriver driver) {
        return new TourPartTabPO(driver);
    }

    public static TourPriceTabPO createTourPriceTab(WebDriver driver) {
        return new TourPriceTabPO(driver);
    }

    public static TourServiceTabPO createTourServiceTab(WebDriver driver) {
        return new TourServiceTabPO(driver);
    }

    public static TourSchedulerTabPO createTourSchedulerTab(WebDriver driver) {
        return new TourSchedulerTabPO(driver);
    }

    public static TourPromotionTabPO createTourPromotionTab(WebDriver driver) {
        return new TourPromotionTabPO(driver);
    }

    public static TourSettingTabPO createTourSettingTab(WebDriver driver) {
        return new TourSettingTabPO(driver);
    }

    public static TourServicePricePO createTourServicePriceTab(WebDriver driver) {
        return new TourServicePricePO(driver);
    }

    public static TourPromotionPO goToCreateEditPromotionPage(WebDriver driver) {
        return new TourPromotionPO(driver);
    }

    public static PubishPagePOPO createPageSetting(WebDriver driver) {
        return new PubishPagePOPO(driver);
    }

    public static DetailPromoPO createViewDetailPromoPage(WebDriver driver) {
        return new DetailPromoPO(driver);
    }

    public static TourDetailPO createTourDetailBookingPage(WebDriver driver) {
        return new TourDetailPO(driver);
    }

    public static BoookingTourPO createTourBookingPage(WebDriver driver) {
        return new BoookingTourPO(driver);
    }

    public static PaymentInfoPO createPaymentInfo(WebDriver driver) {
        return new PaymentInfoPO(driver);
    }

    public static Handnote_TourPO createTourHandnotePage(WebDriver driver) {
        return new Handnote_TourPO(driver);
    }

    public static Stripe_PO createPaymentWithStripe(WebDriver driver) {
        return new Stripe_PO(driver);
    }

    public static PaymentInfoPO createPageBookingSuccess(WebDriver driver) {
        return new PaymentInfoPO(driver);
    }

    public static NewsfeedPersonalTimelinePO createPersonalTimeLinePage(WebDriver driver) {
        return new NewsfeedPersonalTimelinePO(driver);
    }

    public static PerAbout_OverviewPO createPerAboutOverviewTab(WebDriver driver) {
        return new PerAbout_OverviewPO(driver);
    }

    public static PerAbout_WorkAndEducationPO createPerAboutWorkEducationTab(WebDriver driver) {
        return new PerAbout_WorkAndEducationPO(driver);
    }

    public static PerAbout_PlacesYouLivedPO createPerAboutPlaceLivingTab(WebDriver driver){
        return new PerAbout_PlacesYouLivedPO(driver);
    }

    public static PerAbout_BasicInfoAndContactPO createperBasicInfoAndContactPage(WebDriver driver) {
        return new PerAbout_BasicInfoAndContactPO(driver);
    }

    public static PerAbout_DetailsAboutYouPO createPersonalDetailsAboutYouTab(WebDriver driver) {
        return new PerAbout_DetailsAboutYouPO(driver);
    }

    public static ChangeCurrencyPO openModelChangeCurrency(WebDriver driver) {
        return new ChangeCurrencyPO(driver);
    }

    public static ChoosePlaceModelPO openModelChooseLocation(WebDriver driver) {
        return new ChoosePlaceModelPO(driver);
    }
}