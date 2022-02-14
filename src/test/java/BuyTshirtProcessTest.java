import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SaucedomoCompletedOrderPage;
import pages.SaucedomoLogInPage;
import pages.WebDriverContainer;

import java.net.MalformedURLException;

/**
 * Test class in charge of evaluating the process of buying a T Shirt.
 */
public class BuyTshirtProcessTest {
  private SaucedomoLogInPage logIn;
  private SaucedomoCompletedOrderPage completed;



  /**
   * This method is in charge of setting up the chrome driver for the test.
   */
  @BeforeMethod
  public void setup() throws MalformedURLException {

    logIn = new SaucedomoLogInPage();
  }

  @Test(description = "This test is in charge of navigating through the webpage and"
      + "simulating the process of acquisition for a t-shirt")
  public void buyTshirtTest() throws MalformedURLException {
    String result = logIn.visitLogin()
        .logIn("standard_user", "secret_sauce")
        .selectItem()
        .goToShoppingCart()
        .goToCheckOut()
        .fillOutForm("Juan", "Palma", "77601")
        .finishProcess().getContainerHeader();
    Assert.assertEquals(result, "THANK YOU FOR YOUR ORDER");

  }

  @AfterClass
  public void closeDriver() throws MalformedURLException {
    WebDriverContainer.getInstance().quit();
  }

}
