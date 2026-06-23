package DemoMaven;


import util.BaseClass;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
 
public class MathSeleniumTest {
 
    @Test

    public void testMathAndBrowser() {
 
        WebDriver driver = new ChromeDriver();

        driver.get("https://example.com");
 
        int a = 8;

        int b = 4;
 
        int sum = a + b;

        int max = Math.max(a, b);

        int min = Math.min(a, b);

        double sqrt = Math.sqrt(25);

        double power = Math.pow(2, 3);
 
        System.out.println("Sum: " + sum);

        System.out.println("Max: " + max);

        System.out.println("Min: " + min);

        System.out.println("Square Root: " + sqrt);

        System.out.println("Power: " + power);
 
        System.out.println("Title: " + driver.getTitle());
 
        driver.quit();

    }

}
 