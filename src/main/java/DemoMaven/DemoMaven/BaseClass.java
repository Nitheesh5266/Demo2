package DemoMaven.DemoMaven;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    public static WebDriver driver;

    // invoke the browser
    public static void invokeBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", 
                               "C:\\ChromeDriver\\chromedriver.exe");   // ✅ Updated path
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        // Common settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // screenshot method
    public static void screenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/screenshot_" + System.currentTimeMillis() + ".png");
        FileHandler.copy(src, dest);
        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
    }

    // close browser
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}