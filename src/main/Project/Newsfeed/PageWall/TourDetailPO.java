package Project.Newsfeed.PageWall;

import Interfaces.hahalolo_newsfeed.PageWall.Tour.Tour_Detail_For_BookingUI;
import Project.Newsfeed.Newsfeed.Header.HeaderPagePO;
import org.openqa.selenium.WebDriver;

public class TourDetailPO extends HeaderPagePO {
    WebDriver driver;
    public TourDetailPO(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

//    public boolean checkTourDetailBookingPageIsDisplay() {
//        waitElementToVisible(driver, PersonalCommonUI.HEADER_SECTION);
//        return true;
//    }

    public void clickToSchedulerTab() {
        waitForElementClickable(driver, Tour_Detail_For_BookingUI.TAB_SCHEDULER);
        clickToElement(driver, Tour_Detail_For_BookingUI.TAB_SCHEDULER);
    }

    public void chooseDepatureDateWantBooking() {
        waitForElementClickable(driver, Tour_Detail_For_BookingUI.BUTTON_BOOKING_NOW_FOR_DIRECT_TOUR,"");
        clickToElement(driver, Tour_Detail_For_BookingUI.BUTTON_BOOKING_NOW_FOR_DIRECT_TOUR,"");
    }

    public boolean checkTourSchedulerTabIsDisplay() {
        return true;
    }

    public Object getCurrencyOnPriceFromSection() {
        return null;
    }

    public Object getCurrencySymbolOfTourItemOnScheduler() {
        return null;
    }
}
