package Project.Newsfeed.PersonalWall.Handnote;

import org.openqa.selenium.WebDriver;

public class Handnote_TourPO {
    WebDriver driver;
    public Handnote_TourPO(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkHandnoteTourPageIsDisplay() {
        return true;
    }
}
