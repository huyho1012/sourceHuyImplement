package Project.Newsfeed.PersonalWall.Timeline;

import Project.Newsfeed.PersonalWall.PersonalCommonPO;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.openqa.selenium.WebDriver;

public class NewsfeedPersonalTimelinePO extends PersonalCommonPO {
    WebDriver driver;

    public NewsfeedPersonalTimelinePO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public boolean checkPersonalTimePageIsDislay() {
        return true;
    }

    public ObjectIdGenerators.StringIdGenerator getFullNameOfUserDisplayOnHeader() {
        return null;
    }
}
