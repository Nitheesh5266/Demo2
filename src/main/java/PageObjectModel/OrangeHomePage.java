package PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class OrangeHomePage {
    WebDriver driver;
    public OrangeHomePage(WebDriver driver){
        this.driver=driver;
    }
    By UpGrade= By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/a/button");
    By User=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul");
    public WebElement UpGrade(){
        return driver.findElement(UpGrade);
    }
    public WebElement User(){
        return driver.findElement(User);
    }
}