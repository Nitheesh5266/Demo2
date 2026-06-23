package DemoMaven.DemoMaven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://book.spicejet.com/");

        // From City
        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//div[text()='Chennai']")).click();

        // To City
        driver.findElement(By.xpath("//div[text()='To']")).click();
        driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();

        // Select Today's Date
        driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-0']")).click();

        // Passengers
        driver.findElement(By.xpath("//div[text()='Passengers']")).click();
        driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        driver.findElement(By.xpath("//div[text()='Done']")).click();

        // Currency
        driver.findElement(By.xpath("//div[text()='Currency']")).click();
        driver.findElement(By.xpath("//div[text()='USD']")).click();

        // Senior Citizen Checkbox
        driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();

        // Search Button
        driver.findElement(By.xpath("//div[text()='Search Flight']")).click();
    }
}