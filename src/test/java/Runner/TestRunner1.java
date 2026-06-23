package Runner;

import org.junit.runner.RunWith;
 
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/feature/DataTest.feature",
		glue="StepDef", monochrome=true
		)
 
public class TestRunner1 {
}