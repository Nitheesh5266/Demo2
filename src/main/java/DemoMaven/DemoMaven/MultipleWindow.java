package DemoMaven.DemoMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.BaseClass;

public class MultipleWindow  extends BaseClass{
 
	public static void main(String[] args) throws InterruptedException {
		// invoke the browser
		invokeBrowser("chrome");
		driver.get("https://accounts.google.com/v3/signin/accountchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ddm=1&ec=asw-gmail-globalnav-signin&flowEntry=AccountChooser&flowName=GlifWebSignIn&service=mail&dsh=S1396332267%3A1772438750488400%22");
		System.out.println(driver.getTitle());
		//click on Help or T&C
		WebElement helplnk = driver.findElement(By.linkText("Help"));
		helplnk.click();//child window
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parent = it.next();//parent window
		String helpWindow = it.next();//child window
		Thread.sleep(2000);
		//switch from parent to child window
		driver.switchTo().window(helpWindow);
		Thread.sleep(2000);//condition wait
		System.out.println(driver.getTitle());
		//switch to parent window
		driver.switchTo().window(parent);
		Thread.sleep(2000);//explicit wait
		//another way
		//driver.switchTo().defaultContent();//remains in the child
		System.out.println(driver.getTitle());
		closeBrowser();
	}
 
}
 