package Project.Newsfeed.PersonalWall;

import Interfaces.hahalolo_newsfeed.PersonaWall.Personal_CommonUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class PersonalCommonPO extends HeaderPagePO {
    WebDriver driver;

    public PersonalCommonPO(WebDriver webDriver) {
        super(webDriver);
    }

    public String getGenderNameByValue(String languageSytem, String genderType) {
        if(languageSytem == "vi"){
            if(genderType == "M"){
                return "Nam";
            }else if(genderType =="F"){
                return "Nữ";
            }else if(genderType =="N"){
                return "Khác";
            }else
                return null;
        }
        else if(languageSytem == "en") {
            if (genderType == "M") {
                return "Male";
            } else if (genderType == "F") {
                return "Female";
            } else if (genderType == "N") {
                return "Other";
            } else
                return null;
        }
        return null;
    }

    public void clickToUploadAvatarByLocalImage(String imageLink){
        waitForElementClickable(driver, Personal_CommonUI.UPLOAD_AVATAR_ICON);
        clickToElement(driver, Personal_CommonUI.UPLOAD_AVATAR_ICON);
        waitForElementClickable(driver, Personal_CommonUI.UPLOAD_AVATAR_FROM_LOCAL);
        clickToElement(driver, Personal_CommonUI.UPLOAD_AVATAR_FROM_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void clickToUploadCoverByLocalImage(String imageLink){
        waitForElementClickable(driver, Personal_CommonUI.UPLOAD_COVER_ICON);
        clickToElement(driver, Personal_CommonUI.UPLOAD_COVER_ICON);
        waitForElementClickable(driver, Personal_CommonUI.UPLOAD_COVER_FROM_LOCAL);
        clickToElement(driver, Personal_CommonUI.UPLOAD_COVER_FROM_LOCAL);
        uploadOneFileByAutoIT(driver,imageLink);
    }

    public void saveChangeImage(){
        waitForElementClickable(driver, Personal_CommonUI.BUTTON_SAVE_CHANGE_COVER);
        clickToElement(driver, Personal_CommonUI.BUTTON_SAVE_CHANGE_COVER);
    }

    public void crossAvatarImage(WebDriver driver){
        waitElementToVisible(driver, Personal_CommonUI.CROSS_IMAGE_POPUP);
        waitForElementClickable(driver, Personal_CommonUI.BUTTON_SAVE_CROSS_IMAGE);
        clickToElement(driver, Personal_CommonUI.BUTTON_SAVE_CROSS_IMAGE);
    }

    public String getErrMessageOfValidationFileUpload(){
        waitElementToVisible(driver, Personal_CommonUI.VALIDATION_ERR_MESS);
        return  getTextElement(driver, Personal_CommonUI.VALIDATION_ERR_MESS);
    }

    public boolean checkCoverImageDisplayWithCaseNoImage() {
        waitElementToVisible(driver, Personal_CommonUI.COVER_IMAGE);
        String imageLink = getImageOfCover();
        return imageLink.equals("cover-default.jpg");
    }

    public boolean checkUploadAvatarUserSuccess(String avatarBeforeChange) {
        waitElementToVisible(driver, Personal_CommonUI.UPLOAD_AVATAR_ICON);
        String avatarAfterChange = getImageURLOfAvatar();
        return avatarBeforeChange.contains(avatarAfterChange);
    }

    public boolean checkCoverImageUploadSuccessfully(String coverBeforeChange) {
        waitElementToVisible(driver, Personal_CommonUI.UPLOAD_COVER_ICON);
        String avatarAfterChange = getImageOfCover();
        return avatarAfterChange.contains(coverBeforeChange);
    }

    public boolean checkAvatarUserDisplayWithGenderType(String genderName){
        String imageLink = getImageURLOfAvatar();
        if(genderName.equalsIgnoreCase("nam")|| genderName.equalsIgnoreCase("male")){
            return imageLink.contains("avatar-male-256px.png");

        } else if(genderName.equalsIgnoreCase("nữ")||genderName.equalsIgnoreCase("female")){
            return imageLink.contains("avatar-female-256px.png");
        } else if(genderName.contains("Khác") || genderName.equalsIgnoreCase("other")){
            return imageLink.contains("avatar-user-256px.png");
        }
        return false;
    }

    public String getImageURLOfAvatar() {
        String imageURL = getCSSValueOfElement(driver, Personal_CommonUI.AVATAR_IMAGE,"background-image");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }

    public String getImageOfCover() {
        String imageURL = getAttributeValue(driver, Personal_CommonUI.COVER_IMAGE,"src");
        String[] imageLink = imageURL.split("/");
        String imagePath = imageLink[imageLink.length-1];
        return imagePath.replaceAll("[^\\w\\.\\-]", "");
    }


    public Object getIntroduceDataDisplayonHeader() {
        waitElementToVisible(driver, Personal_CommonUI.INTRODUCE_HEADER);
        return getTextElement(driver, Personal_CommonUI.INTRODUCE_HEADER);
    }

    public String handleIntroduceDataOnHeader(String content){
        if(content.length()>200){
            return content.substring(0,200)+"...";
        }
        else
            return content;
    }
}

