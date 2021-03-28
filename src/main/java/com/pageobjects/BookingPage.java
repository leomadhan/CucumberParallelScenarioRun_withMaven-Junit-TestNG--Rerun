package com.pageobjects;

import com.auto.util.CommonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookingPage {
    private WebDriver driver;
    private CommonUtil util = new CommonUtil();

    @FindBy(how = How.CSS, using = "#mobileMenuMain a[title='home']")
    private WebElement lnktxt_Home;

    @FindBy(how = How.CSS, using = "#select2-drop > div > input")
    private WebElement inptxt_destination;

    @FindBy(how = How.CSS, using = "div.locationlistHotels > a.select2-choice > span.select2-chosen")
    private WebElement inpsearch_destination;

    @FindBy(how = How.CSS, using = "li:nth-child(1) > ul > li > div.select2-result-label")
    private WebElement txtres_destination;

    @FindBy(how = How.CSS, using = "#checkin")
    private WebElement datetxt_checkin;

    @FindBy(how = How.CSS, using = "#checkout")
    private WebElement datetxt_checkout;

    @FindBy(how = How.CSS, using = "#hotels > div > div > form > div > div > div.col-lg-2.col-sm-12.col-xs-12 > button")
    private WebElement btn_Search;

    @FindBy(how = How.CSS, using = "div.col.o2 button.bootstrap-touchspin-up")
    private WebElement btn_AdultPlus;

    @FindBy(how = How.CSS, using = "div.col.o2 button.bootstrap-touchspin-down")
    private WebElement btn_AdultMinus;

    @FindBy(how = How.CSS, using = "input[name='adults']")
    private WebElement inp_AdultValue;

    @FindBy(how = How.CSS, using = "div[class='col 01'] button.bootstrap-touchspin-up")
    private WebElement btn_ChildPlus;

    @FindBy(how = How.CSS, using = "div[class='col 01'] button.bootstrap-touchspin-down")
    private WebElement btn_ChildMinus;

    @FindBy(how = How.CSS, using = "input[name='children']")
    private WebElement inp_ChildValue;

    @FindBy(how = How.CSS, using = "div:nth-child(2) > div > div.col-12.col-auto.o1 > div > div.content-bottom.mt-auto > div > div.ml-auto.rtl-mr-auto.o1 > a.btn-sm")
    private WebElement btn_HotelDetails;

    @FindBy(how = How.CSS, using = "#detail-content-sticky-nav-02 div.room-item div.custom-control.custom-checkbox")
    private WebElement chkbx_RoomType;

    @FindBy(how = How.CSS, using = "#detail-content-sticky-nav-02 div.room-item")
    private WebElement sec_RoomDetails;

    @FindBy(how = How.CSS, using = "button.book_button")
    private WebElement btn_BookNow;

    @FindBy(how = How.CSS, using = "button.completebook")
    private WebElement btn_ConfirmBooking;

    @FindBy(how = How.CSS, using = "body > div.body-inner > div.main-wrapper.scrollspy-action > div.main-wrapper.scrollspy-action > div > div > div.success-box.unpaid > div.content")
    private WebElement msg_SuccessMsgWithWarning;

    @FindBy(how = How.CSS, using = "div#bookings > div.row a")
    private List<WebElement> rows_BookingsList;

    @FindBy(how=How.CSS,using="input#checkin")
    private WebElement datetxt_ModifyCheckin;

    @FindBy(how=How.CSS,using="input#checkout")
    private WebElement datetxt_ModifyCheckout;

    @FindBy(how=How.CSS,using="button.btn-secondary")
    private WebElement btn_ModifySearch;


    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToBookingPage() {
        util.waitForPageLoad(driver);
        util.scrollToView(driver, lnktxt_Home);
        lnktxt_Home.click();
    }

    public void fillBookingForm(String destination, String checkIn, String checkOut, String adults, String child) throws ParseException {
        util.waitForPageLoad(driver);
        //Enter Destination
        inpsearch_destination.click();
        for (int i = 0; i < destination.length(); i++) {
            char c = destination.charAt(i);
            if (c == '-') {
                c = ' ';
            }
            String s = new StringBuilder().append(c).toString();
            inptxt_destination.sendKeys(s);
        }
        util.waitForPageLoad(driver);
        util.scrollToView(driver, txtres_destination);
        txtres_destination.click();

        //enter checkin date
        /*Date date = new SimpleDateFormat("dd/MM/yyyy").parse(checkIn);
        String dateValue= new SimpleDateFormat("dd/MM/yyyy").format(date);
        System.out.println("DateCheckIn:"+dateValue);*/
        datetxt_checkin.clear();
        //datetxt_checkin.sendKeys(checkIn);
        datetxt_checkin.sendKeys("10/5/2021");

        //enter checkout date
        datetxt_checkout.clear();
        datetxt_checkout.sendKeys("13/5/2021");

        //update adults
        int actualAdult = Integer.parseInt(inp_AdultValue.getAttribute("value"));
        int expectAdult = Integer.parseInt(adults);
        if (actualAdult != expectAdult) {
            if (actualAdult < expectAdult) {
                int interation = expectAdult - actualAdult;
                while (interation != 0) {
                    btn_AdultPlus.click();
                    interation--;
                }
            }
            if (actualAdult > expectAdult) {
                int interation = actualAdult - expectAdult;
                while (interation != 0) {
                    btn_AdultMinus.click();
                    interation--;
                }
            }
        }
        else{
            System.out.println("no need update adult");
        }


    //update child
        int actualChild = Integer.parseInt(inp_ChildValue.getAttribute("value"));
        int expectChild = Integer.parseInt(child);
        if (actualChild != expectChild) {
            if (expectChild > actualChild) {
                int interation = expectChild - actualChild;
                while (interation != 0) {
                    btn_ChildPlus.click();
                    interation--;
                }
            }
            if (actualChild > expectChild) {
                int intre = actualChild - expectChild;
                while (intre != 0) {
                    btn_ChildMinus.click();
                    intre--;
                }
            }
        }
        else{
            System.out.println("no need update children");
        }
    }

    public void clickOnSearch() {
        btn_Search.click();
    }

    public void selectRoomType() {
        util.waitForPageLoad(driver);
        util.scrollToView(driver,btn_HotelDetails);
        btn_HotelDetails.click();

        /*util.waitForPageLoad(driver);
        util.scrollToView(driver,datetxt_ModifyCheckin);
        datetxt_ModifyCheckin.clear();
        datetxt_ModifyCheckin.sendKeys("10/5/2021");

        datetxt_ModifyCheckout.clear();
        datetxt_ModifyCheckout.sendKeys("13/5/2021");

        util.scrollToView(driver,btn_ModifySearch);
        btn_ModifySearch.click();*/

        util.waitForPageLoad(driver);
        util.scrollToView(driver,sec_RoomDetails);
        chkbx_RoomType.click();
    }

    public void clickOnBookNow() {
        btn_BookNow.click();
    }

    public void confirmBooking() {
        util.waitForPageLoad(driver);
        util.scrollToView(driver,btn_ConfirmBooking);
        btn_ConfirmBooking.click();
    }

    public Boolean isSuccessMsgDisplay() {
        util.waitForPageLoad(driver);
        return msg_SuccessMsgWithWarning.isDisplayed();
    }

    public String getBookingDetails() {
        System.out.println("Booking rows:"+rows_BookingsList.size());
        String actualBookingInfo = rows_BookingsList.get(1).getText();
        return actualBookingInfo;
    }
}
