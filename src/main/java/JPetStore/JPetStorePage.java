package JPetStore;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class JPetStorePage {
    WebDriver driver;
 
    public JPetStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(xpath = "//a[contains(translate(text(), 'SIGN ', 'sign '), 'sign in') or contains(text(), 'Login') or contains(@href, 'signon')]") 
    WebElement signInLink;
 
    @FindBy(name = "username") WebElement usernameField;
    @FindBy(name = "password") WebElement passwordField;
    @FindBy(xpath = "//button[text()='Login']") WebElement loginButton;
    @FindBy(xpath = "//a[contains(@href, 'signoff') or contains(@href, 'logout') or text()='Sign Out']") 
    WebElement signOutLink;
 
    @FindBy(xpath = "//div[@id='QuickLinks']/a[contains(@href, 'DOGS')] | //a[text()='Dogs' or contains(@href, 'DOGS')]") 
    WebElement dogsCategoryMenu;
 
    @FindBy(xpath = "(//table//tr//td/a) | //a[text()='K9-BD-01']") 
    WebElement firstDogProductLink;
 
    @FindBy(xpath = "(//a[text()='Add to Cart']) | //a[contains(@href, 'addItemToCart')]") 
    WebElement addToCartButton;
 
    @FindBy(xpath = "//input[contains(@name, 'quantity') or contains(@name, 'EST')]") 
    WebElement quantityInputField;
 
    @FindBy(xpath = "//button[text()='Update Cart']")  
    WebElement updateCartButton;
 
    @FindBy(xpath = "//a[text()='Remove' or text()='Delete' or contains(@href, 'removeItemFromCart')]") 
    WebElement removeCartItemButton;
 
    public WebElement signInLink() { return signInLink; }
    public WebElement usernameField() { return usernameField; }
    public WebElement passwordField() { return passwordField; }
    public WebElement loginButton() { return loginButton; }
    public WebElement signOutLink() { return signOutLink; }
    public WebElement dogsCategoryMenu() { return dogsCategoryMenu; }
    public WebElement firstDogProductLink() { return firstDogProductLink; }
    public WebElement addToCartButton() { return addToCartButton; }
    public WebElement quantityInputField() { return quantityInputField; }
    public WebElement updateCartButton() { return updateCartButton; }
    public WebElement removeCartItemButton() { return removeCartItemButton; }
}