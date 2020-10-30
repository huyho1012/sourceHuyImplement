package Interfaces.hahalolo_wallet;

public class Wallet_OverviewUI {
    public static final String TITLE_OVERVIEW_WALLET = "//div[contains(@class,'wallet-home')]//h1";
    public static final String BUTTON_CREATE_BUSI_PAYMENT_ACCOUNT = "//button[contains(@data-bind,'onModalCreateWallet.bind($data,1)')]";
    public static final String BUTTON_CREATE_PER_PAYMENT_ACCOUNT = "//button[contains(@data-bind,'onModalCreateWallet.bind($data,0)')]";
    public static final String PAYMENT_ACCOUNT_NAME_FIELD = "//input[@name = 'walletName']";
    public static final String CURRENCY_DROPDOWN = "//select[@name = 'busCurrency']/following-sibling::div//input";
    public static final String CURRENCY_ITEM = "//select[@name = 'busCurrency']/following-sibling::div//div[@class='selectize-dropdown-content']//div[contains(@class,'option')]";
    public static final String FINISH_BUTTON = "//button[contains(@data-bind,'onCreateWallet')]";
    public static final String POPUP_CREATE_PAYMENT_ACCOUNT = "//div[@id='modal__create-wallet']";
}