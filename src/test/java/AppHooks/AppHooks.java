package AppHooks;

import com.auto.unit.DriverUnit;
import com.auto.util.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;


import java.util.Properties;

public class AppHooks {

    private DriverUnit driverUnit;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order=0)
    public void getProperty(){
        configReader=new ConfigReader();
        prop=configReader.accessProp();
    }

    @Before(order=1)
    public void launchBrowser(){
        String browserName=prop.getProperty("browser");
        driverUnit=new DriverUnit();
        driver= driverUnit.init_driver(browserName);
    }

    /*@After(order=0)
    public void browserTearDown(){
        driver.quit();
    }

    @After(order=1)
    public void failInfoEOS(Scenario sc){
        if(sc.isFailed()){
            String screenshotName=sc.getName().replaceAll(" ","_");
            byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(srcPath,"image/png",screenshotName);
        }
    }*/



}
