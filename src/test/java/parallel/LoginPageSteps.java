package parallel;

import com.auto.unit.DriverUnit;
import com.auto.util.CommonUtil;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class LoginPageSteps {

    private static String expectedUsername;

    private LoginPage loginpage = new LoginPage(DriverUnit.getDriver());
    private HomePage homepage = new HomePage(DriverUnit.getDriver());

    private CommonUtil util = new CommonUtil();

    public LoginPageSteps() {
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        homepage.launchHomePage();
        homepage.navigateToLoginPage();
        loginpage.verifyLoginPageLoaded();
    }

    @When("user enter username {string}")
    public void user_enter_username(String username) {
        loginpage.enterUserName(username);
    }

    @When("user enter password {string}")
    public void user_enter_password(String password) {
        loginpage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginpage.clickOnLogin();
    }

}
