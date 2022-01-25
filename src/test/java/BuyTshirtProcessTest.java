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
import pages.SaucedomoCompletedOrderPage;
import pages.SaucedomoLogInPage;
import pages.SaucedomoShoppingCartPage;
import pages.SaucedomoVerificationPage;
import pages.WebDriverContainer;

/**
 * Test class in charge of evaluating the process of buying a T Shirt.
 */
public class BuyTshirtProcessTest {
  private SaucedomoLogInPage logIn;
  private SaucedomoCatalogPage catalog;
  private SaucedomoShoppingCartPage shoppingCart;
  private SaucedomoCheckOutPage checkOut;
  private SaucedomoVerificationPage verification;
  private SaucedomoCompletedOrderPage completed;
  private WebDriverContainer wdc;

  @BeforeClass
  public static void setupWebDriver() {
    WebDriverManager.chromedriver().setup();
  }

  /**
   * This method is in charge of setting up the chrome driver for the test.
   */
  @BeforeMethod
  public void setup() {
    wdc = new WebDriverContainer();
    catalog = new SaucedomoCatalogPage();
    checkOut = new SaucedomoCheckOutPage();
    logIn = new SaucedomoLogInPage();
    shoppingCart = new SaucedomoShoppingCartPage();
    verification = new SaucedomoVerificationPage();
    completed = new SaucedomoCompletedOrderPage();
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

    Object container = completed.getCompletionContainer();
    String result = completed.getContainerHeader();
    Assert.assertNotNull(container);
    Assert.assertTrue(result.contains("THANK YOU"));
  }

  @AfterMethod
  public void destroy() {
    wdc.quitDriver();
  }
}
