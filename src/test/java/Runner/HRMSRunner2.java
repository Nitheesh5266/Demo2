package Runner;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature2/HRMSHTML1.feature",
    glue = "StepDef",
    monochrome = true,
    plugin = {"pretty","html:target/HRMS2.html"}
)
public class HRMSRunner2 {
 
}
 