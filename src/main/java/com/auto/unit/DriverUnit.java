package com.auto.unit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUnit {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> thDriver= new ThreadLocal<>();

    public WebDriver init_driver(String browser){
        System.out.println(("Invoking "+browser+" browser for the run."));
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            thDriver.set(new ChromeDriver());
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            thDriver.set(new FirefoxDriver());
        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            thDriver.set(new EdgeDriver());
        }
        else {
            System.out.println(("Please pass valid browser name or update browser as (chrome/firefox/edge)"));
        }
        driver=getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }

    public static synchronized WebDriver getDriver(){
        return thDriver.get();
    }


}

