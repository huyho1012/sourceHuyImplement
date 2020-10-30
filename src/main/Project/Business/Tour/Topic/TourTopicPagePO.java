package Project.Business.Tour.Topic;

import Interfaces.Shared.Media_ManagementUI;
import Interfaces.hahalolo_business.Tour.Topic.Tour_TopicUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import Project.Shared.MediaManagementPO;
import org.openqa.selenium.WebDriver;

public class TourTopicPagePO extends HeaderPagePO {
    WebDriver driver;
    MediaManagementPO media;
    public TourTopicPagePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void clickCreateTopic() {
        waitElementToVisible(driver, Tour_TopicUI.TOPIC_PAGE);
        waitElementToVisible(driver, Tour_TopicUI.BUTTON_CREATE_NEW_TOPIC);
        clickToElement(driver, Tour_TopicUI.BUTTON_CREATE_NEW_TOPIC);
    }

    public void chooseTopicImage(String fileName) {
        waitForElementClickable(driver, Tour_TopicUI.BUTTON_ADD_TOPIC_IMAGE);
        clickToElement(driver, Tour_TopicUI.BUTTON_ADD_TOPIC_IMAGE);
        media = new MediaManagementPO(driver);
        media.uploadImageFromLocalToMedia(driver,fileName);
        waitElementToVisible(driver, Media_ManagementUI.PROCESSING_BAR);
        waitForElementClickable(driver, Media_ManagementUI.BUTTON_SELECT);
        clickToElement(driver, Media_ManagementUI.BUTTON_SELECT);
    }

    public void chooseLanguageOfTopic(String langName) {
        clickToElementByJS(driver, Tour_TopicUI.LANGUAGE_ITEM,langName);
    }

    public void enterTopicName(String topicName) {
        waitForElementClickable(driver, Tour_TopicUI.TOPIC_NAME_FIELD);
        sendKeyToElement(driver, Tour_TopicUI.TOPIC_NAME_FIELD, topicName);
        setTimeDelay(1);
    }

    public void enterTopicDescription(String descTopic) {
        waitForElementClickable(driver, Tour_TopicUI.TOPIC_DESCRIPTION_TEXT_AREA);
        sendKeyToElement(driver, Tour_TopicUI.TOPIC_DESCRIPTION_TEXT_AREA, descTopic);
        setTimeDelay(1);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, Tour_TopicUI.BUTTON_SAVE_TOPIC);
        clickToElement(driver, Tour_TopicUI.BUTTON_SAVE_TOPIC);
        setTimeDelay(1);
    }

    public boolean checkPageWithCaseNoTopicDisplay() {
        return checkElementIsDisplayed(driver, Tour_TopicUI.BUTTON_CREATE_NEW_TOPIC);
    }

    public boolean checkCreatedTopicDisplay() {
        return checkElementIsDisplayed(driver, Tour_TopicUI.DISPLAYED_TOPIC_NAME);
    }

    public boolean checkPopupCreateTopicDisplay() {
        return checkElementIsDisplayed(driver, Tour_TopicUI.POPUP_EDIT_ADD_TOPIC);
    }


}
