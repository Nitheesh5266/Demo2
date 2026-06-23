package DemoWebShop;
 
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class DWSLoginPage {
    WebDriver driver;
 
    public DWSLoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
 
 
 
    @FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[1]/a/img")
    WebElement home;
    @FindBy(name="Email") WebElement Email;
    @FindBy(name="Password") WebElement password;
 
    //User defined methods
    //driver.findElement(By.xpath("//input[@name='login']");
    public WebElement Email()
    {
        return Email;
    }
 
    public WebElement password()
    {
        return password;
    }
 
    public WebElement DemoHome()
    {
        return home;
    }
 
}