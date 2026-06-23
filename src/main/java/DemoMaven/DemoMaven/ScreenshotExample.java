package DemoMaven.DemoMaven;
 
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
//import org.apache.commons.io.FileUtils;
 
public class ScreenshotExample {
    public static void main(String[] args) throws Exception {
 
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
 
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshot.png");
 
        //File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src, new File("./screenshot/" + "screenshot-" + System.currentTimeMillis() + ".png"));
 
        driver.quit();
    }
}