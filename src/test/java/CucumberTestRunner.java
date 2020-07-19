import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static hooks.ServiceHooks.closeBrowser;
import static hooks.ServiceHooks.launchApp;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        tags = "@LoginWorkday",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        },
        monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        launchApp();
    }

    @Test
    public void CucumberFeatureRunner(){
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        closeBrowser();
    }
}
