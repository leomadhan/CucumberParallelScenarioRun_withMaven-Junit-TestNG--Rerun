package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;*/

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread",
        "rerun:target/Junitfailedrerun.txt"
        },
        features = {"src/test/resources/features/Booking.feature"},
        glue = {"steps", "AppHooks"})
//plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}
public class RunCucumberTest {

    /*@BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setExtentXServerUrl("http://localhost:1337");
        extentProperties.setProjectName("MyProject");
        extentProperties.setReportPath("test reports/HtmlReport.html");
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }*/

}
