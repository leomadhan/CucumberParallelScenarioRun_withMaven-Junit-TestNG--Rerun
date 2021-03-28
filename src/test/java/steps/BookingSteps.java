package steps;

import com.auto.unit.DriverUnit;
import com.auto.util.ExcelReader;
import com.pageobjects.BookingPage;
import com.pageobjects.LoginPage;
import com.pageobjects.AccountsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class BookingSteps {

    private LoginPage loginPage = new LoginPage(DriverUnit.getDriver());
    private AccountsPage accountsPage = new AccountsPage(DriverUnit.getDriver());
    private BookingPage bookingPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverUnit.getDriver()
                .get("https://www.phptravels.net/login");
        bookingPage = loginPage.doLogin(userName, password);
    }

    @Given("user navigates to Booking page")
    public void user_navigates_to_Booking_page() {
        bookingPage.navigateToBookingPage();
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException, ParseException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("C:\\Users\\madha\\Downloads\\Tedt\\src\\test\\resources\\testdata\\HotelsBooking.xlsx", sheetName);

        String destination = testData.get(rowNumber).get("Destination");
        String checkIn = testData.get(rowNumber).get("CheckIn");
        String checkOut = testData.get(rowNumber).get("CheckOut");
        String adults = testData.get(rowNumber).get("Adults");
        String child = testData.get(rowNumber).get("Child");
        bookingPage.fillBookingForm(destination, checkIn, checkOut, adults, child);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        bookingPage.clickOnSearch();
    }

    @When("user show hotels list and book")
    public void user_show_hotels_list_and_book() {
        bookingPage.selectRoomType();
        bookingPage.clickOnBookNow();
    }

    @When("user confirm booking")
    public void user_confirm_booking() {
        bookingPage.confirmBooking();
    }

    @Then("user see the booking details in accounts page")
    public void user_see_the_booking_details_in_accounts_page() {
        accountsPage.navigateToAccountsPage();
        String actualBookings = bookingPage.getBookingDetails();
        System.out.println("BookedHotels:"+actualBookings);
        //Assert.assertTrue(actualBookings.contains(expBookings));
    }
}

