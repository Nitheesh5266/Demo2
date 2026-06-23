package HRMSHtml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userName = By.name("username");
    By password = By.name("password");
    By login = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void userName(String name)
    {
        driver.findElement(userName).sendKeys(name);
    }

    public void password(String pwd)
    {
        driver.findElement(password).sendKeys(pwd);
    }

    public void submit()
    {
        driver.findElement(login).click();
    }
}