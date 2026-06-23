package StepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SauceSteps {

    // ✅ FIXED URL
    private static final String BASE_URL = "https://www.saucedemo.com/";

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By inventoryContainer = By.id("inventory_container");
    private final By inventoryItem = By.className("inventory_item");
    private final By itemName = By.className("inventory_item_name");

    // ✅ Use CSS selector (more stable)
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By cartList = By.className("cart_list");
    private final By cartItemName = By.className("inventory_item_name");

    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    // ✅ Launch browser
    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_saucedemo_login_page() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(BASE_URL);
    }

    // ✅ Login
    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // ✅ Verify login success
    @Then("the user should be redirected to the products page")
    public void the_user_should_be_redirected_to_the_products_page() {

        wait.until(ExpectedConditions.urlContains("inventory.html"));

        boolean isLoaded = wait.until(
                ExpectedConditions.visibilityOfElementLocated(inventoryContainer))
                .isDisplayed();

        Assert.assertTrue("Products page not loaded", isLoaded);
    }

    // ✅ Add items to cart
    @When("the user adds the following items to the cart:")
    public void the_user_adds_the_following_items_to_the_cart(DataTable dataTable) {

        List<String> productNames = dataTable.asList(String.class);

        for (String productName : productNames) {

            List<WebElement> items = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItem));

            boolean found = false;

            for (WebElement item : items) {

                String name = item.findElement(itemName).getText().trim();

                if (name.equalsIgnoreCase(productName.trim())) {

                    WebElement addButton = item.findElement(By.tagName("button"));

                    wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

                    System.out.println("✅ Added: " + name);

                    // ✅ VERY IMPORTANT WAIT (fixes your error)
                    wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("❌ Product not found: " + productName);
            }
        }
    }

    // ✅ Verify cart count
    @Then("the cart badge should show {string} items")
    public void the_cart_badge_should_show_items(String expectedCount) {

        WebElement badge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge));

        String actual = badge.getText().trim();

        System.out.println("✅ Cart count = " + actual);

        Assert.assertEquals("Cart count mismatch", expectedCount, actual);
    }

    // ✅ Open cart
    @When("the user opens the cart page")
    public void the_user_opens_the_cart_page() {
        driver.findElement(cartLink).click();
    }

    // ✅ Verify cart items
    @Then("the cart page should display the following items:")
    public void the_cart_page_should_display_the_following_items(DataTable dataTable) {

        List<String> expectedItems = dataTable.asList(String.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartList));

        List<WebElement> elements = driver.findElements(cartItemName);
        List<String> actualItems = new ArrayList<>();

        for (WebElement el : elements) {
            actualItems.add(el.getText().trim());
        }

        for (String expected : expectedItems) {
            Assert.assertTrue("Missing item: " + expected, actualItems.contains(expected));
        }
    }

    // ✅ Logout
    @When("the user logs out")
    public void the_user_logs_out() {

        driver.findElement(burgerMenuButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).click();
    }

    // ✅ Verify logout
    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {

        boolean visible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginButton))
                .isDisplayed();

        Assert.assertTrue("Logout failed", visible);
    }

    // ✅ Close browser
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
