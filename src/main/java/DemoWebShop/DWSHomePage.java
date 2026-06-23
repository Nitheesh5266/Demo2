package DemoWebShop;
 
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class DWSHomePage {
    WebDriver driver;
    public DWSHomePage(WebDriver driver){
        this.driver=driver;
    }
    By Books= By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a");
    By GiftCards=By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[7]/a");
    public WebElement Books(){
        return driver.findElement(Books);
    }
    public WebElement GiftCards(){
        return driver.findElement(GiftCards);
    }
}