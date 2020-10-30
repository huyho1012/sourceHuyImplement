package Project.Wallet;

import Common.HelperFunction.AbstractPage;
import Interfaces.hahalolo_wallet.Wallet_HomeUI;
import org.openqa.selenium.WebDriver;

public class WalletHomePagePO extends AbstractPage {
    WebDriver driver;
    public WalletHomePagePO(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkBusinessPaymentAccountPageDisplay() {
        waitForPageLoading(driver);
        return checkElementIsDisplayed(driver, Wallet_HomeUI.MENU_WALLET) && checkElementIsDisplayed(driver, Wallet_HomeUI.AVAILABLE_COLLUM)
                && checkElementIsDisplayed(driver, Wallet_HomeUI.WAITING_COLLUM) && checkElementIsDisplayed(driver, Wallet_HomeUI.FROZEN_COLLUM)
                && checkElementIsDisplayed(driver, Wallet_HomeUI.PENDING_COLLUM)
                && getTextElement(driver, Wallet_HomeUI.TYPE_DISPLAYED_ON_DROPDOWN).equalsIgnoreCase("Tài khoản thanh toán doanh nghiệp");
    }

    public String getPaymentAccName() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, Wallet_HomeUI.MENU_WALLET);
        return getTextElement(driver, Wallet_HomeUI.PAYMENT_ACCOUNT_NAME);
    }
}
