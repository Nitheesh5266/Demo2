package Runner;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/feature/Tester1.feature",
		glue="StepDef", monochrome=true,
		tags = "@regression or @smoke"
		)
public class TestRunner2 {
 
}