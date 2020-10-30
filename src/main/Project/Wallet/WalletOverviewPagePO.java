package Project.Wallet;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_wallet.Wallet_OverviewUI;
import org.openqa.selenium.WebDriver;

public class WalletOverviewPagePO extends AbstractPage {
    WebDriver driver;
    public WalletOverviewPagePO(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickButtonCreateWallet(WebDriver driver) {
    }

    public void enterPaymentAccountName(WebDriver driver, String paymentAccountName) {
        waitElementToVisible(driver, Wallet_OverviewUI.PAYMENT_ACCOUNT_NAME_FIELD);
        sendKeyToElement(driver, Wallet_OverviewUI.PAYMENT_ACCOUNT_NAME_FIELD,paymentAccountName);
    }

    public void chooseCurrencyOfAccount(WebDriver driver, String currencyName) {
        selectItemInCustomDropdown(driver, Wallet_OverviewUI.CURRENCY_DROPDOWN, Wallet_OverviewUI.CURRENCY_ITEM, currencyName);
    }

    public void clickCreateBusinessPaymentAccount(WebDriver driver ) {
        waitForElementClickable(driver, Wallet_OverviewUI.BUTTON_CREATE_BUSI_PAYMENT_ACCOUNT);
        clickToElement(driver, Wallet_OverviewUI.BUTTON_CREATE_BUSI_PAYMENT_ACCOUNT);
    }

    public boolean checkPageIsDisplayedSuccessfully() {
        return(checkElementIsDisplayed(driver, Wallet_OverviewUI.TITLE_OVERVIEW_WALLET));
    }

    public boolean checkCreatePaymentAccountPopupIsDisplay() {
        System.out.println(getAttributeValue(driver, Wallet_OverviewUI.POPUP_CREATE_PAYMENT_ACCOUNT,"style"));
        return getAttributeValue(driver, Wallet_OverviewUI.POPUP_CREATE_PAYMENT_ACCOUNT, "style").contains("display: block");
    }

    public void clickToFinishButton(WebDriver driver) {
        waitForElementClickable(driver, Wallet_OverviewUI.FINISH_BUTTON);
        clickToElement(driver, Wallet_OverviewUI.FINISH_BUTTON);
        setTimeDelay(1);
    }
}
