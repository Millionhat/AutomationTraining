import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SaucedomoCatalogPage;
import pages.SaucedomoCheckOutPage;
import pages.SaucedomoLogInPage;
import pages.SaucedomoShoppingCartPage;
import pages.SaucedomoVerificationPage;


/**
 * Test class in charge of evaluating the process of buying a T Shirt.
 */
public class BuyTshirtProcessTest {
  private SaucedomoLogInPage logIn;
  private SaucedomoCatalogPage catalog;
  private SaucedomoShoppingCartPage shoppingCart;
  private SaucedomoCheckOutPage checkOut;
  private SaucedomoVerificationPage verification;
  private WebDriver driver;

  @BeforeClass
  public static void setupWebDriver() {
    WebDriverManager.chromedriver().setup();
  }

  /**
   * This method is in charge of setting up the chrome driver for the test.
   */
  @BeforeMethod
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    catalog = new SaucedomoCatalogPage(driver);
    checkOut = new SaucedomoCheckOutPage(driver);
    logIn = new SaucedomoLogInPage(driver);
    shoppingCart = new SaucedomoShoppingCartPage(driver);
    verification = new SaucedomoVerificationPage(driver);
  }

  @Test(description = "This test is in charge of navigating through the webpage and"
      + "simulating the process of acquisition for a t-shirt")
  public void buyTshirtTest() {
    logIn.visitLogin();
    logIn.logIn("standard_user", "secret_sauce");

    catalog.selectItem();
    catalog.goToShoppingCart();

    shoppingCart.goToCheckOut();

    checkOut.fillOutForm("Juan", "Palma", "77601");

    verification.finishProcess();

    Object container = driver.findElement(By.id("checkout_complete_container"));
    String result = driver.findElement(By.id("checkout_complete_container"))
        .findElement(By.className("complete-header")).getText();
    Assert.assertNotNull(container);
    Assert.assertTrue(result.contains("THANK YOU"));
  }

  @AfterMethod
  public void destroy() {
    driver.quit();
  }
}
