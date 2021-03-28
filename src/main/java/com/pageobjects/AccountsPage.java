package com.pageobjects;

import com.auto.unit.DriverUnit;
import com.auto.util.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountsPage {
    private WebDriver driver;

    private CommonUtil util = new CommonUtil();

    @FindBy(how = How.CSS, using = "div.dropdown-login > #dropdownCurrency")
    private WebElement drpdwnbtn_MyAccount;

    @FindBy(how = How.CSS, using = "div.dropdown-login > div.dropdown-menu-right  a")
    private WebElement linkbtn_Login;

    @FindBy(how = How.CSS, using = "body > div.body-inner > div.main-wrapper.scrollspy-action > div:nth-child(2) > div > div > div:nth-child(1) > div > div.col-md-8 > h3")
    private WebElement lbl_AccountName;

    @FindBy(how = How.CSS, using = "body > div.body-inner > div.main-wrapper.scrollspy-action > div.container > div.container.mt25.offset-0 > div > div.row.mywishlist > div.col-12.col-md-4.col-lg-4.o2 > aside > nav > ul > li:nth-child(2) > a")
    private WebElement lnk_MyProfile;

    @FindBy(how = How.CSS, using = "input[name='address1']")
    private WebElement inptxt_Address;

    @FindBy(how = How.CSS, using = "input[name='address2']")
    private WebElement inptxt_Address2;

    @FindBy(how = How.CSS, using = "input[name='city']")
    private WebElement inptxt_City;

    @FindBy(how = How.CSS, using = "input[name='state']")
    private WebElement inptxt_StateRegion;

    @FindBy(how = How.CSS, using = "input[name='zip']")
    private WebElement inptxt_ZipCode;

    @FindBy(how = How.CSS, using = "input[name='phone']")
    private WebElement inptxt_Phone;

    @FindBy(how = How.CSS, using = "div.chosen-container")
    private WebElement drpdownBtn_Country;

    @FindBy(how = How.CSS, using = "button.updateprofile")
    private WebElement btn_Submit;


    public AccountsPage(WebDriver localdriver) {
        this.driver = localdriver;
        PageFactory.initElements(localdriver, this);
    }


    public String getAccountName() {
        util.waitForElementToVisible(driver, lbl_AccountName);
        return lbl_AccountName.getText();
    }

    public void openProfile() {
        util.waitForPageLoad(driver);
        util.scrollToView(driver, lnk_MyProfile);
        //util.clickByJs(driver,lnk_MyProfile);
        lnk_MyProfile.click();
    }

    public void enterAddress(String value) {
        inptxt_Address.clear();
        inptxt_Address.sendKeys(value);
    }

    public String getAddress() {
        return inptxt_Address.getAttribute("value");
    }

    public void enterAddress2(String value) {
        inptxt_Address2.clear();
        inptxt_Address2.sendKeys(value);
    }

    public String getAddress2() {
        return inptxt_Address2.getAttribute("value");
    }

    public void enterCity(String value) {
        inptxt_City.clear();
        inptxt_City.sendKeys(value);
    }

    public String getCity() {
        return inptxt_City.getAttribute("value");
    }

    public void enterStateRegion(String value) {
        inptxt_StateRegion.clear();
        inptxt_StateRegion.sendKeys(value);
    }

    public String getStateRegion() {
        return inptxt_StateRegion.getAttribute("value");
    }

    public void enterZipCode(String value) {
        inptxt_ZipCode.clear();
        inptxt_ZipCode.sendKeys(value);
    }

    public String getZipCode() {
        return inptxt_ZipCode.getAttribute("value");
    }

    public void selectCountry(String value) {
        drpdownBtn_Country.click();
        /*Select select=new Select(driver.findElement(By.cssSelector("select.chosen-the-basic")));
        select.selectByValue(value);*/
        List<WebElement> options = drpdownBtn_Country.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                util.scrollToView(driver, option);
                option.click();
                break;
            }
        }
    }

    public String getCountry() {
        return drpdownBtn_Country.getAttribute("value");
    }

    public void enterPhone(String value) {
        inptxt_Phone.clear();
        inptxt_Phone.sendKeys(value);
    }

    public String getPhone() {
        return inptxt_Phone.getAttribute("value");
    }

    public void clickOnSubmit() {
        util.scrollToView(driver, btn_Submit);
        btn_Submit.click();
    }

    public void navigateToAccountsPage(){
        drpdwnbtn_MyAccount.click();
        if (linkbtn_Login.isDisplayed()) {
            linkbtn_Login.click();
        }
    }
}
