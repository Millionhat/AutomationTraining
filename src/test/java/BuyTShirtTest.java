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

/**
 * Test class in charge of evaluating the process of buying a T Shirt.
 */
public class BuyTShirtTest {

  private WebDriver driver;

  @BeforeClass
  public static void setupWebDriver(){
    WebDriverManager.chromedriver().setup();
  }

  /**
   * This method is in charge of setting up the chrome driver for the test.
   */
  @BeforeMethod
  public void setup(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
  }

  @Test(description="This test is in charge of navigating through the webpage and"
      + "simulating the process of acquisition for a t-shirt")
  public void BuyTShirtTest() {
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    driver.findElement(By.id("shopping_cart_container")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("Juan");
    driver.findElement(By.id("last-name")).sendKeys("Palma");
    driver.findElement(By.id("postal-code")).sendKeys("77901");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    Assert.assertNotNull(driver.findElement(By.id("checkout_complete_container")));
    Assert.assertTrue(driver.findElement(By.id("checkout_complete_container")).findElement(By.className("complete-header")).getText().contains("THANK YOU"));
  }

  @AfterMethod
  public void destroy(){
    driver.quit();
  }
}
