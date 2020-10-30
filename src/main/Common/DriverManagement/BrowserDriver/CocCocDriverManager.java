package Common.DriverManagement.BrowserDriver;

import Common.DriverManagement.DriverManager;
import Common.GlobalVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        System.setProperty("webdriver.chrome.driver", GlobalVariables.ROOT_FOLDER + "/Extension/BrowserDriver/chromedriver_84.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/" + "" + System.getProperty("user.name") + "" + "/AppData/Local/CocCoc/Browser/Application/browser.exe");
        driver = new ChromeDriver(options);
    }
}
