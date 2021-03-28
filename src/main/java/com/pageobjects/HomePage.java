package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;


    @FindBy(how = How.CSS, using = "div.dropdown-login > #dropdownCurrency")
    private WebElement drpdwnbtn_MyAccount;

    @FindBy(how = How.CSS, using = "div.dropdown-login > div.dropdown-menu-right  a")
    private WebElement linkbtn_Login;


    public HomePage(WebDriver localdriver) {
        this.driver = localdriver;
        PageFactory.initElements(localdriver, this);
    }

    public void launchHomePage() {
        driver.get("https://www.phptravels.net/home");
    }

    public void navigateToLoginPage() {
        drpdwnbtn_MyAccount.click();
        if (linkbtn_Login.isDisplayed()) {
            linkbtn_Login.click();
        }
    }

}

