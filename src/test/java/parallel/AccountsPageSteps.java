package parallel;

import com.auto.unit.DriverUnit;
import com.pageobjects.AccountsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;


public class AccountsPageSteps {
    private static String actualAccountname;


    private AccountsPage accountsPage = new AccountsPage(DriverUnit.getDriver());

    @Then("user should be all to see their name as {string}")
    public void user_should_be_all_to_see_their_name(String expectedName) {
        actualAccountname = accountsPage.getAccountName();
        Assert.assertTrue(actualAccountname.contains(expectedName));
    }

    @Then("user able to access their profile")
    public void user_able_to_access_their_profile() {
        accountsPage.openProfile();
    }

    @Then("user able to update their profile")
    public void user_able_to_update_their_profile(Map<String, String> profileDetails) {
        accountsPage.openProfile();
        for (Map.Entry<String, String> entry : profileDetails.entrySet()) {
            switch (entry.getKey().trim()) {
                case "Address":
                    accountsPage.enterAddress(entry.getValue());
                    break;
                case "Address 2":
                    accountsPage.enterAddress2(entry.getValue());
                    break;
                case "City":
                    accountsPage.enterCity(entry.getValue());
                    break;
                case "State/ Region":
                    accountsPage.enterStateRegion(entry.getValue());
                    break;
                case "Postal/ Zip Code":
                    accountsPage.enterZipCode(entry.getValue());
                    break;
                case "Country":
                    accountsPage.selectCountry(entry.getValue());
                    break;
                case "Phone":
                    accountsPage.enterPhone(entry.getValue());
                    break;
            }
        }

        accountsPage.clickOnSubmit();
    }

    @Then("user able to see the changes")
    public void user_able_to_see_the_changes(Map<String, String> expectedProfileDetails) {
        for (Map.Entry<String, String> entry : expectedProfileDetails.entrySet()) {
            switch (entry.getKey().trim()) {
                case "Address":
                    System.out.println("Actual:"+accountsPage.getAddress()+" expected:"+entry.getValue());
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getAddress()));
                    break;
                case "Address 2":
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getAddress2()));
                    break;
                case "City":
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getCity()));
                    break;
                case "State/ Region":
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getStateRegion()));
                    break;
                case "Postal/ Zip Code":
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getZipCode()));
                    break;
                case "Country":
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getCountry()));
                    break;
                case "Phone":
                    System.out.println("Actual:"+accountsPage.getPhone()+" expected:"+entry.getValue());
                    Assert.assertTrue(entry.getValue().equals(accountsPage.getPhone()));
                    break;
            }
        }

    }

}
