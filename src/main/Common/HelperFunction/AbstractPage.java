package Common.HelperFunction;

import Common.GlobalVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private WebDriver driver;
    private Actions action;
    private WebDriverWait explicitWait;
    private Alert alert;
    private Select select;
    private WebElement element;
    private List<WebElement> elements;
    private JavascriptExecutor jsExecutor;
    private final long timeWait = 20;

    public void setTimeDelay(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openURL(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeWait, TimeUnit.SECONDS);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void clickBackToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void clickForwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void acceptAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        alertPresence(driver);
        driver.switchTo().alert();
        return alert.getText();
    }

    public void sendKeyToAlert(WebDriver driver, String valueName) {
        alertPresence(driver);
        driver.switchTo().alert();
        alert.sendKeys(valueName);
    }

    public void alertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean checkAlertIsDisplay(WebDriver driver)
    {
        try
        {
            driver.switchTo().alert();
            return false;
        }
        catch (NoAlertPresentException exception)
        {
            return true;
        }
    }

    public void openNewWindow(WebDriver driver, String urlLink){
        jsExecutor =(JavascriptExecutor) driver;
        jsExecutor.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        openURL(driver,urlLink);
    }

    public void switchWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String current : allWindow) {
            if (current.equals(parentID)) {
                driver.switchTo().window(current);
                break;
            }
        }
    }

    public void switchWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String currentTab : allWindow) {
            driver.switchTo().window(currentTab);
            String titleCurrentTab = getPageTitle(driver);
            if(titleCurrentTab.equals(title)) {
                break;
            }
        }
    }

    public void closeAllTabWithoutParentWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String currentTab : allWindow) {
            if (!currentTab.equals(parentID)) {
                driver.switchTo().window(currentTab);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> findElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public String castToObject(String locator, String... values){
        return  String.format(locator, values);
    }


    public void clickToElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
        element = findElement(driver, castToObject(locator, values));
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueName) {
        element = findElement(driver, locator);
        element.clear();
        element.sendKeys(valueName);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueName, String... values) {
        element = findElement(driver, castToObject(locator, values));
        element.clear();
        element.sendKeys(valueName);
    }

    public void removeValueOnElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
        element.clear();
    }

    public void removeValueOnElement(WebDriver driver, String locator, String... values) {
        element = findElement(driver, castToObject(locator, values));
        element.clear();
    }

    public String getTextElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
        return element.getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... values) {
        element = findElement(driver, castToObject(locator, values));
        return element.getText();
    }

    public String getAttributeValue(WebDriver driver, String locator, String valueAttribute) {
        element = findElement(driver, locator);
        return element.getAttribute(valueAttribute);
    }

    public String getAttributeValue(WebDriver driver, String locator, String valueAttribute, String...values) {
        element = findElement(driver, castToObject(locator, values));
        return element.getAttribute(valueAttribute);
    }

    public boolean checkElementIsDisplayed(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return element.isDisplayed();
    }

    public boolean checkElementIsDisplayed(WebDriver driver, String locator, String... values){
        element = findElement(driver, castToObject(locator, values));
        return element.isDisplayed();
    }

    public boolean checkElementUndisplayed(WebDriver driver, String locator)
    {
        elements = findElements(driver,locator);

        if(elements.size() == 0)
        {
            System.out.println("This element not in DOM");
            return true;
        }else if(elements.size() > 0 && !elements.get(0).isDisplayed())
        {
            System.out.println("This element in DOM but not display");
            return true;
        }else
        {
            System.out.println("This element in DOM and display");
            return false;
        }
    }

    public boolean checkElementUndisplayed(WebDriver driver, String locator, String... values)
    {
        elements = driver.findElements(By.xpath(castToObject(locator, values)));

        if(elements.size() == 0)
        {
            System.out.println("This element not in DOM");
            return true;
        }else if(elements.size() > 0 && elements.get(0).isDisplayed())
        {
            System.out.println("This element in DOM but not display");
            return true;
        }else
        {
            System.out.println("This element in DOM and display");
            return false;
        }
    }

    public boolean checkElementIsEnabled(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return element.isEnabled();
    }

    public boolean checkElementIsEnabled(WebDriver driver, String locator, String... values){
        element = findElement(driver, castToObject(locator, values));
        return element.isEnabled();
    }

    public boolean checkElementIsSelected(WebDriver driver, String locator){
        element = findElement(driver, locator);
        return element.isSelected();
    }

    public boolean checkElementIsSelected(WebDriver driver, String locator, String... values){
        element = findElement(driver, castToObject(locator, values));
        return element.isSelected();
    }

    public void selectItemInDropdownByValue(WebDriver driver, String dropdownLocator, String valueItem) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.selectByValue(valueItem);
    }

    public void selectItemInDropdownByValue(WebDriver driver, String dropdownLocator, String valueItem, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.selectByValue(valueItem);
    }

    public void selectItemInDropdownByText(WebDriver driver, String dropdownLocator, String valueItem) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdownByText(WebDriver driver, String dropdownLocator, String valueItem, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdownByIndex(WebDriver driver, String dropdownLocator, int index) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectItemInDropdownByIndex(WebDriver driver, String dropdownLocator, int index, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.selectByIndex(index);
    }



    public void deselectItemInDropdownByValue(WebDriver driver, String dropdownLocator, String valueItem) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.deselectByValue(valueItem);
    }

    public void deselectItemInDropdownByValue(WebDriver driver, String dropdownLocator, String valueItem, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.deselectByValue(valueItem);
    }

    public void deselectItemInDropdownByText(WebDriver driver, String dropdownLocator, String valueItem) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.deselectByVisibleText(valueItem);
    }

    public void deselectItemInDropdownByText(WebDriver driver, String dropdownLocator, String valueItem, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.deselectByVisibleText(valueItem);
    }

    public void deselectAllItemOnDropdown(WebDriver driver, String dropdownLocator) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        select.deselectAll();
    }

    public void deselectAllItemOnDropdown(WebDriver driver, String dropdownLocator, String... values) {
        element = findElement(driver, castToObject(dropdownLocator, values));
        select = new Select(element);
        select.deselectAll();
    }

    public String getFirstSelectedItemInDropdown(WebDriver driver, String dropdownLocator) {
        element = findElement(driver, dropdownLocator);
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getFirstSelectedItemInDropdown(WebDriver driver, String dropdownLocator, String... values) {
        element = findElement(driver, castToObject(dropdownLocator,values));
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public boolean checkDropdownAreAllowMutitpleOption(WebDriver driver, String drodown) {
        element = findElement(driver, drodown);
        select = new Select(element);
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue){
        element = findElement(driver, customDropdown);
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        setTimeDelay(1);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemOnDropdown)));
        elements = findElements(driver,itemOnDropdown);
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                item.click();
                setTimeDelay(1);
                break;
            }
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue, String... values){
        waitForElementClickable(driver, castToObject(customDropdown,values));
        clickToElement(driver,castToObject(customDropdown,values));
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(castToObject(itemOnDropdown,values))));
        elements = findElements(driver,castToObject(itemOnDropdown,values));
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                item.click();
                break;
            }
        }
    }

    public void selectItemInCustomDropdownByJS(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue){
        element = findElement(driver, customDropdown);
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemOnDropdown)));
        elements = findElements(driver,itemOnDropdown);
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].click();",item);
                setTimeDelay(1);
                break;
            }
        }
    }

    public void selectItemInCustomDropdownByJS(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue, String... values){
        element = findElement(driver, customDropdown);
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemOnDropdown)));
        elements = findElements(driver, castToObject(itemOnDropdown, values));
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].click();",item);
                setTimeDelay(1);
                break;
            }
        }
    }

    public void selectItemInCustomDropdownByScroll(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue){
        element = findElement(driver, customDropdown);
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        setTimeDelay(1);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemOnDropdown)));
        elements = findElements(driver,itemOnDropdown);
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                item.click();
                setTimeDelay(1);
                break;
            }
        }
    }

    public void selectItemInCustomDropdownByScroll(WebDriver driver, String customDropdown, String itemOnDropdown, String expectedValue, String... values){
        element = findElement(driver, castToObject(customDropdown,values));
        waitForElementClickable(driver, customDropdown);
        clickToElement(driver,customDropdown);
        setTimeDelay(1);
        explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(castToObject(itemOnDropdown,values))));
        elements = findElements(driver,itemOnDropdown);
        for(WebElement item: elements){
            if(item.getText().contains(expectedValue)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                item.click();
                setTimeDelay(1);
                break;
            }
        }
    }

    public void clickToChooseCheckBox(WebDriver driver, String checkboxLocator){
        element = findElement(driver, checkboxLocator);
        if(!element.isSelected()){
           element.click();
        }
    }

    public void clickToChooseCheckBox(WebDriver driver, String checkboxLocator, String... values){
        element = findElement(driver, castToObject(checkboxLocator, values));
        if(!element.isSelected()){
            element.click();
        }
    }

    public void uncheckItemOnCheckBox(WebDriver driver, String checkboxLocator){
        element = findElement(driver, checkboxLocator);
        if(element.isSelected()) {
            element.click();
        }
    }

    public void uncheckItemOnCheckBox(WebDriver driver, String checkboxLocator, String... values){
        element = findElement(driver, castToObject(checkboxLocator, values));
        if(element.isSelected()) {
            element.click();
        }
    }

    public int countNumberItemOfElement(WebDriver driver, String locator){
        elements = findElements(driver,locator);
        return elements.size();
    }

    public int countNumberItemOfElement(WebDriver driver, String locator, String... values){
        elements = findElements(driver,castToObject(locator, values));
        return elements.size();
    }

    public void switchToIframeOrFrame(WebDriver driver, String locator){
        element = findElement(driver, locator);
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(WebDriver driver){
       driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator, String... values){
        element = findElement(driver,castToObject(locator, values));
        action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void hoverToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        element = findElement(driver, locator);
        action = new Actions(driver);
        action.sendKeys(element,key);
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values){
        element = findElement(driver, castToObject(locator, values));
        action = new Actions(driver);
        action.sendKeys(element,key);
    }

    public Object executeForBrowser(WebDriver driver, String javaSript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaSript);
    }

    public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
        jsExecutor = (JavascriptExecutor)driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void negativeToURLByJS(WebDriver driver, String urlPage){
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.location = '" + urlPage + "'");
    }

    public void scrollToBottomPage(WebDriver driver) {
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locator) {
        element = findElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].click();",element);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... values){
        element = findElement(driver, castToObject(locator, values));
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollIntoElementByJS(WebDriver driver, String locator){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollIntoElementByJS(WebDriver driver, String locator, String... values){
        element = findElement(driver, castToObject(locator,values));
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean checkElementIsCheckedByJS(WebDriver driver, String locator)
    {
        jsExecutor =(JavascriptExecutor)driver;
        element = findElement(driver, locator);
        return (boolean)jsExecutor.executeScript("return arguments[0].checked;", element);
    }

    public boolean checkElementIsCheckedByJS(WebDriver driver, String locator, String... values)
    {
        jsExecutor =(JavascriptExecutor)driver;
        element = findElement(driver, castToObject(locator, values));
        return (boolean)jsExecutor.executeScript("return arguments[0].checked;", element);
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String valueData){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+ valueData +"')", element);
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String valueData, String... values){
        element = findElement(driver, castToObject(locator,values));
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value','"+ valueData +"')",element);
    }

    public void removeAttributeOfElementByJS(WebDriver driver, String locator, String attributeName){
        element = findElement(driver,locator);
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('"+attributeName+"')",element);
    }

    public void removeAttributeOfElementByJS(WebDriver driver, String locator, String attributeName, String... values){
        element = findElement(driver, castToObject(locator, values));
        jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('"+ attributeName +"')", element);
    }

    public void waitElementToVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitElementToVisible(WebDriver driver, String locator, String... values){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(castToObject(locator, values))));
    }

    public void waitForElementToPresence(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String...values){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(castToObject(locator,values))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String values){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(castToObject(locator,values))));
    }

    public void waitForPageLoading(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(timeWait, TimeUnit.SECONDS);
    }

    public void uploadOneFileBySendKey(WebDriver driver, String locator, String fileName){
        waitElementToVisible(driver,locator);
        sendKeyToElement(driver,locator,fileName);
    }

    public void uploadMultipleFileBySendKey(WebDriver driver,String locator, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName += GlobalVariables.UPLOAD_FOLDER+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        waitElementToVisible(driver,locator);
        sendKeyToElement(driver,locator,fullFileName);
    }

    public void uploadFileByRobot(String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName +=  GlobalVariables.UPLOAD_FOLDER+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        StringSelection select = new StringSelection(fullFileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null);
        try {
            Robot robot = new Robot();
            setTimeDelay(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            setTimeDelay(1);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void uploadMultipleFileByAutoIT(WebDriver driver, String... fileNames){
        String fullFileName = "";
        String folderImages = System.getProperty("user.dir") + "\\Upload\\";
        String uploadChrome = System.getProperty("user.dir") + "/Extension/AutoIT/chromeUploadMultiple.exe";
        String uploadFirefox = System.getProperty("user.dir") + "/Extension/AutoIT/firefoxUploadMultiple.exe";
        for(String file : fileNames){
            fullFileName = fullFileName + "\"" + folderImages + file + "\"" +" ";
        }
        fullFileName = fullFileName.trim();
        System.out.println(fullFileName);
        if (driver.toString().contains("firefox")){
            try {
                Runtime.getRuntime().exec(new String[] {uploadFirefox, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (driver.toString().contains("chrome")) {
            try {
                Runtime.getRuntime().exec(new String[]{uploadChrome, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadOneFileByAutoIT(WebDriver driver, String fileName){
        String uploadChrome = System.getProperty("user.dir") + "/Extension/AutoIT/chromeUploadOneTime.exe";
        String uploadFirefox = System.getProperty("user.dir") + "/Extension/AutoIT/firefoxUploadOneTime.exe";
        String folderImages = System.getProperty("user.dir") + "\\Upload\\";
        fileName =  folderImages + fileName;
        if (driver.toString().contains("firefox")){
            try {
                Runtime.getRuntime().exec(new String[] {uploadFirefox, fileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (driver.toString().contains("chrome")) {
            try {
                Runtime.getRuntime().exec(new String[]{uploadChrome, fileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void scrollToTopPage(WebDriver driver){
        jsExecutor =(JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        setTimeDelay(1);
    }

    public String getCSSValueOfElement(WebDriver driver, String locator, String valueCSS){
        element = findElement(driver,locator);
        return element.getCssValue(valueCSS);
    }

    public String convertRpgToHexaCode(WebDriver driver,String locator, String cssValue){
        element =findElement(driver, locator);
        String colorCode= element.getCssValue(cssValue);
        return Color.fromString(colorCode).asHex();
    }

    public String getAttributeClassWithAfter(WebDriver driver, String classLocator, String cssValue){
        WebElement switchLabel = driver.findElement(By.cssSelector(classLocator));
        jsExecutor = (JavascriptExecutor)driver;
        return jsExecutor.executeScript("return window.getComputedStyle(arguments[0],':after').getPropertyValue('"+cssValue+"');",switchLabel).toString();
    }

    public String getAttributeClassWithBefore(WebDriver driver, String classLocator, String cssValue){
        WebElement switchLabel = driver.findElement(By.cssSelector(classLocator));
        jsExecutor = (JavascriptExecutor)driver;
        return jsExecutor.executeScript("return window.getComputedStyle(arguments[0],':before').getPropertyValue('"+cssValue+"');",switchLabel).toString();
    }

    protected Date getDateTimeNow(){
        Date date = new Date();
        return date;
    }

    public void waitElementsToVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, timeWait);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public String getColorElementWithHexaCode(WebDriver driver, String locator){
        waitElementToVisible(driver,locator);
        String colorButton = getCSSValueOfElement(driver, locator, "background-color");
        return  Color.fromString(colorButton).asHex();
    }

}



