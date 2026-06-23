package RediffTCs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RediffTest extends BaseClass {

    RediffLoginPage loginPage;
    RediffHomePage homePage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        invokeBrowser(browser);
    }

    @Test
    public void rediffTestCase() throws InterruptedException {

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        // Login Page
        loginPage = new RediffLoginPage(driver);
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");

        Thread.sleep(2000);

        loginPage.clickHome();

        // Home Page
        homePage = new RediffHomePage(driver);
        homePage.clickNews();

        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        closeBrowser();
    }
}
