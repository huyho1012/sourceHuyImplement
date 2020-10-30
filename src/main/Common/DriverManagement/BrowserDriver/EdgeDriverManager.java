package Common.DriverManagement.BrowserDriver;

import Common.DriverManagement.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
}
