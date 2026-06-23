package TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HtmlUnitDriverDemo {

    @Test
    public void htmlDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // run without UI

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://login.salesforce.com/");

        // get and print page title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // close browser
        driver.quit();
    }
}
