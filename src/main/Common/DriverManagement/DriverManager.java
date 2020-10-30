package Common.DriverManagement;

import Common.HelperFunction.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends AbstractPage {
    protected WebDriver driver;
    protected abstract void createDriver();
    public void quitDriver(){
        if(driver!= null){
            driver.close();
            driver = null;
        }
    }
    public WebDriver getDriver(String urlPage){
        if(driver == null){
            createDriver();
        }
        driver.get(urlPage);
        driver.manage().window().maximize();
        return driver;
    }
}
