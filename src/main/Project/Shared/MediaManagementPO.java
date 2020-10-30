package Project.Shared;

import Common.HelperFunction.AbstractPage;
import Interfaces.Shared.Media_ManagementUI;
import org.openqa.selenium.WebDriver;

public class MediaManagementPO extends AbstractPage {
    WebDriver driver;

    public MediaManagementPO(WebDriver webDriver){
        driver = webDriver;
    }

    public void uploadImagesFromLocalToMedia(WebDriver driver, String[] fileName){
        waitElementToVisible(driver, Media_ManagementUI.UPLOAD_BUTTON);
        clickToElement(driver, Media_ManagementUI.UPLOAD_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
    }

    public void uploadImageFromLocalToMedia(WebDriver driver, String fileName){
        waitElementToVisible(driver, Media_ManagementUI.UPLOAD_BUTTON);
        clickToElement(driver, Media_ManagementUI.UPLOAD_BUTTON);
        uploadMultipleFileByAutoIT(driver,fileName);
    }

    public void waitImageOnMediaManagerDisplay()
    {
        waitElementToVisible(driver, Media_ManagementUI.LIST_IMAGE_ON_MEDIA_MANAGER);
    }

    public void selectImageOnMediaManager(int imageCount)
    {
        waitImageOnMediaManagerDisplay();
        for (int i = 1; i <= imageCount; i++)
        {
            clickToElement(driver, Media_ManagementUI.IMAGE_ON_MEDIA_MANAGER_IMAGE, String.valueOf(i));
            setTimeDelay(1);
        }
    }

    public void clickToSelectButton()
    {
        waitElementsToVisible(driver, Media_ManagementUI.BUTTON_SELECT);
        clickToElement(driver, Media_ManagementUI.BUTTON_SELECT);
    }

    public void clickToButtonClose()
    {
        waitElementToVisible(driver, Media_ManagementUI.BUTTON_CLOSE);
        clickToElement(driver, Media_ManagementUI.BUTTON_CLOSE);
    }
}
