package PageObjectModel;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class OrangeHrmLoginPage {
    WebDriver driver;
    public OrangeHrmLoginPage(WebDriver driver){
        this.driver=driver;
    }
    By OrangeHrmHome=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    By userName= By.name("username");
    By password=By.name("password");
    public WebElement userName()
    {
        return driver.findElement(userName);
    }
    public WebElement password(){
        return driver.findElement(password);
    }
    public WebElement OrangeHrmHome(){
        return driver.findElement(OrangeHrmHome);
    }
}
