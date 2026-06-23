package DemoMaven.DemoMaven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.BaseClass;

public class DoubleClickDemo extends BaseClass {

    public static void main(String[] args) throws InterruptedException, IOException {

        // Launch browser
        invokeBrowser("chrome");

        // Open URL (✅ FIXED)
        driver.get("https://demoqa.com/buttons");

        Actions act = new Actions(driver);

        Thread.sleep(2000);

        // Double Click
        WebElement btnElmt = driver.findElement(By.id("doubleClickBtn"));
        act.doubleClick(btnElmt).perform();

        Thread.sleep(2000);

        screenShot();

        // Navigate to Drag & Drop page (✅ FIXED)
        driver.navigate().to("https://demoqa.com/droppable");

        Thread.sleep(2000);

        // Drag and Drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        act.dragAndDrop(source, target).perform();

        System.out.println(driver.getTitle());

        // closeBrowser();
    }

    private static void screenShot() {
        // You can implement later
        System.out.println("Screenshot captured (method placeholder)");
    }
}
