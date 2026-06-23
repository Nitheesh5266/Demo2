package HRMSHtml;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HRMSHtml.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HRMSSteps2 {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on HRMSLogin page")
    public void user_is_on_hrms_login_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("User enters username as {string} and {string}")
    public void user_enters_username_as_and(String name, String password) {

        loginPage = new LoginPage(driver);
        loginPage.userName(name);
        loginPage.password(password);
        loginPage.submit();
    }

    @Then("user login validation should be {string}")
    public void user_should_be_able_to_login_if_valid_credentials_are_passed(String result) throws InterruptedException {

        String expectedURL = "dashboard";
        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains(expectedURL);

        if(result.equalsIgnoreCase("pass"))
        {
            Assert.assertTrue(isLoggedIn);
            System.out.println("Credentials are valid");
        }
        else
        {
            Assert.assertFalse(isLoggedIn);
            System.out.println("Invalid Credentials");
        }

        driver.quit();
    }
}