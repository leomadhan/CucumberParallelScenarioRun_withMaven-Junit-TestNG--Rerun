package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = "input[name='username']")
    private WebElement inptxt_UserName;

    @FindBy(how = How.CSS, using = "input[name='password']")
    private WebElement inptxt_Password;

    @FindBy(how = How.CSS, using = "#loginfrm > button")
    private WebElement btn_Login;

    public LoginPage(WebDriver localdriver) {
        this.driver = localdriver;
        PageFactory.initElements(localdriver, this);
    }

    public LoginPage() {

    }

    public void enterUserName(String username){
        inptxt_UserName.sendKeys(username);
    }

    public void enterPassword(String password){
        inptxt_Password.sendKeys(password);
    }

    public void clickOnLogin(){
        btn_Login.click();
    }

    public void verifyLoginPageLoaded() {
        System.out.println("Title" + driver.getTitle());
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public BookingPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        enterUserName(un);
        enterPassword(pwd);
        clickOnLogin();
        return new BookingPage(driver);
    }
}
