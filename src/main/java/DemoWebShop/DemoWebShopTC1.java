package DemoWebShop;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class DemoWebShopTC1 extends BaseClass {
 
	// WebDriver driver;
//        RediffHomePage rhp;
 
	DWSLoginPage dlf;
	DWSHomePage dhp;
 
	@BeforeMethod
	public void setUp() {
		invokeBrowser("chrome");
	}
 
	@Test
	public void demoltc1() throws InterruptedException, IOException {
		FileInputStream f = new FileInputStream("./src/main/java/DemoWebShop/DemoWebShop.Properties");
		Properties prop = new Properties();
		prop.load(f);
		driver.get(prop.getProperty("url"));
//            driver.get("https://demowebshop.tricentis.com/login");
		dlf = new DWSLoginPage(driver);// calling the home page class
		dlf.Email().sendKeys("admin");
		dlf.password().sendKeys("admin123");
		Thread.sleep(2000);
		dlf.DemoHome().click();// link-> Home page
		// How to perform actions on home page
		dhp = new DWSHomePage(driver);
		dhp.Books().click();// click the new link
		Thread.sleep(2000);
 
	}
 
}