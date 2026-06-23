package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/feature/HRMS.feature",
    glue = "StepDef",
    tags = "@smoke",
    plugin = {"pretty", "html:target/HRMS2.html"},
    monochrome = true
)
public class HRMSRunner3 extends AbstractTestNGCucumberTests {

}