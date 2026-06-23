package DemoMaven.DemoMaven;

import org.openqa.selenium.By;

import util.BaseClass;

public class MainTest extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        invokeBrowser("chrome");

        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.linkText("English")).click();

        closeBrowser();
    }
}
