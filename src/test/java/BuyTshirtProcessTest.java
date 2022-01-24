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
  private SaucedomoLogInPage logIn = new SaucedomoLogInPage();
  private SaucedomoCatalogPage catalog = new SaucedomoCatalogPage();
  private SaucedomoShoppingCartPage shoppingCart = new SaucedomoShoppingCartPage();
  private SaucedomoCheckOutPage checkOut = new SaucedomoCheckOutPage();
  private SaucedomoVerificationPage verification = new SaucedomoVerificationPage();
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
  }

  @Test(description = "This test is in charge of navigating through the webpage and"
      + "simulating the process of acquisition for a t-shirt")
  public void buyTshirtTest() {
    logIn.visitLogin(driver);
    logIn.fillUserName(driver);
    logIn.fillPassword(driver);
    logIn.submitInfo(driver);

    catalog.selectItem(driver);
    catalog.goToShoppingCart(driver);

    shoppingCart.goToCheckOut(driver);

    checkOut.fillOutName(driver);
    checkOut.fillOutLastName(driver);
    checkOut.fillOutPostalCode(driver);
    checkOut.proceedToVerification(driver);

    verification.finishProcess(driver);

    Assert.assertNotNull(driver.findElement(By.id("checkout_complete_container")));
    Assert.assertTrue(driver.findElement(By.id("checkout_complete_container"))
        .findElement(By.className("complete-header")).getText().contains("THANK YOU"));
  }

  @AfterMethod
  public void destroy() {
    driver.quit();
  }
}
