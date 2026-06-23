//package StepDef;
// 
//import java.io.File;
//import java.time.Duration;
// 
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
// 
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
// 
//public class Hooks {
// 
//    public static WebDriver driver;
// 
//    @Before
//    public void setup() {
//        System.out.println("Launching browser...");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }
// 
//    @After
//    public void tearDown(Scenario scenario) {
// 
//        if (scenario.isFailed()) {
//            try {
//                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                File dest = new File("screenshots/" + scenario.getName() + ".png");
//                FileUtils.copyFile(src, dest);
//                System.out.println("Screenshot taken for failed test");
//            } catch (Exception e) {
//                System.out.println("Screenshot error: " + e.getMessage());
//            }
//        }
// 
//        System.out.println("Closing browser...");
//        driver.quit();
//    }
//}
// 