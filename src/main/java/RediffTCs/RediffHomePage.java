package RediffTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffHomePage {

    WebDriver driver;

    public RediffHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By news = By.linkText("NEWS");
    By sports = By.linkText("SPORTS");
    By business = By.linkText("BUSINESS");

    // Methods
    public void clickNews() {
        driver.findElement(news).click();
    }

    public void clickSports() {
        driver.findElement(sports).click();
    }

    public void clickBusiness() {
        driver.findElement(business).click();
    }
}