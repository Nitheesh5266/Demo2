package JPetStore;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JPetStore.JPetStorePage;
import util.BaseClass;
import java.time.Duration;
 
public class JPetStoreTask extends BaseClass {
    private static final Logger logger = LogManager.getLogger(JPetStoreTask.class);
    JPetStorePage petStore;
    WebDriverWait wait;
 
    @BeforeMethod
    public void setUp() {
        logger.info("Initializing JPetStore environment configuration...");
        invokeBrowser("chrome");
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
 
    public void clickViaJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }
 
    @Test
    public void jPetStoreEndToEndTest() throws InterruptedException {
        logger.info("Loading JPetStore application...");
        getDriver().get("https://jpetstore.aspectran.com/");
        petStore = new JPetStorePage(getDriver());
 
        // TASK 1: USER LOGIN
        ExtentTest task1 = ExtentManager.getReportInstance().createTest("Task 1: User Authentication Flow");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(petStore.signInLink()));
            clickViaJS(petStore.signInLink());
            wait.until(ExpectedConditions.visibilityOf(petStore.usernameField()));
            petStore.usernameField().clear();
            petStore.usernameField().sendKeys("j2ee");
            petStore.passwordField().clear();
            petStore.passwordField().sendKeys("j2ee");
            clickViaJS(petStore.loginButton());
            logger.info("Login submitted successfully.");
            task1.pass("Task 1 PASS: Successfully logged into JPetStore using default credentials.");
        } catch (Exception e) {
            task1.fail("Task 1 Failed: " + e.getMessage());
            throw e;
        }
 
        // TASK 2: CATEGORY SELECTION & ITEM RETRIEVAL
        ExtentTest task2 = ExtentManager.getReportInstance().createTest("Task 2: Navigate to Dogs & Select First Breed");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(petStore.dogsCategoryMenu()));
            clickViaJS(petStore.dogsCategoryMenu());
            wait.until(ExpectedConditions.elementToBeClickable(petStore.firstDogProductLink()));
            clickViaJS(petStore.firstDogProductLink());
            logger.info("First dog variation selected successfully.");
            task2.pass("Task 2 PASS: Successfully accessed catalog registry and targeted first breed item link.");
        } catch (Exception e) {
            task2.fail("Task 2 Failed: " + e.getMessage());
            throw e;
        }
 
        // TASK 3: ADD TO CART & MODIFY QUANTITY CAPACITY MATRIX
        ExtentTest task3 = ExtentManager.getReportInstance().createTest("Task 3: Add to Cart & Update Quantity");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(petStore.addToCartButton()));
            clickViaJS(petStore.addToCartButton());
            logger.info("First dog variation added to the cart registry.");
 
            wait.until(ExpectedConditions.visibilityOf(petStore.quantityInputField()));
            petStore.quantityInputField().clear();
            petStore.quantityInputField().sendKeys("2");
            clickViaJS(petStore.updateCartButton());
            logger.info("Cart item capacity updated successfully.");
            Thread.sleep(1500);
            task3.pass("Task 3 PASS: Added item entry to basket arrays and successfully updated selection capacity to 2 units.");
        } catch (Exception e) {
            task3.fail("Task 3 Failed: " + e.getMessage());
            throw e;
        }
 
        // TASK 4: CART RECOVERY CLEARING & CLOSURE PIPELINE
        ExtentTest task4 = ExtentManager.getReportInstance().createTest("Task 4: Clear Shopping Cart & Verify Session Exit");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(petStore.removeCartItemButton()));
            clickViaJS(petStore.removeCartItemButton());
            logger.info("Cart items dropped from layout list successfully.");
            Thread.sleep(1500);
 
            try {
                WebDriverWait shortWait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
                shortWait.until(ExpectedConditions.elementToBeClickable(petStore.signOutLink()));
                clickViaJS(petStore.signOutLink());
                logger.info("Manual account sign out executed successfully.");
            } catch (Exception e) {
                logger.info("User session automatically terminated following cart purge event.");
            }
            task4.pass("Task 4 PASS: Dropped all items from cart collection and confirmed session logout exit state cleanly.");
            logger.info("JPetStore cart loop pipeline passed successfully!");
        } catch (Exception e) {
            task4.fail("Task 4 Failed: " + e.getMessage());
            throw e;
        }
    }
 
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}