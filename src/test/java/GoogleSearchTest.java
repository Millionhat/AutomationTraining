import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GooglePage;

/**
 * Test class in charge of evaluating a google search using the Selenium Library.
 */
public class GoogleSearchTest {

  private GooglePage google;
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
    google  = new GooglePage(driver);
  }

  @Test (description = "This test is in charge of redirecting "
      + "to the google website and searching for an specified subject")
  public void searchAtGoogle() {
    Reporter.log("The chrome version being used is the latest available on the linux repo");
    google.goToGoogle();

    google.search("Mjolnir");
    Reporter.log("First search task completed");

    google.search("perficient");
    Reporter.log("Second search task completed");

    Assert.assertTrue(driver.getTitle().contains("perficient"));
  }

  @AfterMethod
  public void destroy() {
    driver.quit();
  }
}
