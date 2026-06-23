package TestNg;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
 
public class ToolTipDemo {
 
	@Test
	public void toolTipTest() {
 
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
 
		// Switch to iframe
		driver.switchTo().frame(0);
 
		// Locate element
		WebElement input = driver.findElement(By.id("age"));
 
		// Perform hover
		Actions a = new Actions(driver);
		a.moveToElement(input).perform();
 
		// Capture visible tooltip text (BEST WAY)
		WebElement tooltip = driver.findElement(By.className("ui-tooltip-content"));
 
		System.out.println("Tooltip Text: " + tooltip.getText());
 
		driver.quit();
	}
}