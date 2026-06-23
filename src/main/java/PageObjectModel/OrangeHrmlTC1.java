package PageObjectModel;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class OrangeHrmlTC1 extends BaseClass {
    OrangeHrmLoginPage olp;
    OrangeHomePage  ohp;
    @BeforeMethod
    public void setUP(){
        invokeBrowser("chrome");
    }
    @Test
    public void OrangeHrmTC1() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        olp = new OrangeHrmLoginPage(driver);//calling the home page class
        olp.userName().sendKeys("Admin");
        olp.password().sendKeys("admin123");
        Thread.sleep(2000);
        olp.OrangeHrmHome().click();//link-> Home page
        //How to perform actions on home page
        ohp = new OrangeHomePage(driver);
        ohp.UpGrade().click();//click the new link
        Thread.sleep(2000);
    }
    @Test
    public void OrangeHrmTC2() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        olp = new OrangeHrmLoginPage(driver);//calling the home page class
        olp.userName().sendKeys("Admin");
        olp.password().sendKeys("admin123");
        Thread.sleep(2000);
        olp.OrangeHrmHome().click();//link-> Home page
        //How to perform actions on home page
    }
    @AfterMethod
    public void tearDown() throws InterruptedException
    {
        //closeBrowser();
    }
}