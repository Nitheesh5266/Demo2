package Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = "src/test/java/feature/HRMS.feature",
		glue="StepDef", monochrome=true,
		plugin= {"pretty","html:target/HRMS.html"}
		)
public class HRMSRunner1 extends AbstractTestNGCucumberTests{
 
}
 