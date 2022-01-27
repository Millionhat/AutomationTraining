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
import pages.WebDriverContainer;

/**
 * Test class in charge of evaluating a google search using the Selenium Library.
 */
public class GoogleSearchTest {

  private WebDriver wdc;
  private GooglePage google;


  @BeforeClass
  public static void setupWebDriver() {
    WebDriverManager.chromedriver().setup();
  }

  /**
  * This method is in charge of setting up the chrome driver for the test.
  */
  @BeforeMethod
  public void setup() {
    wdc = WebDriverContainer.getInstance();
    google  = new GooglePage();
  }

  @Test (description = "This test is in charge of redirecting "
      + "to the google website and searching for an specified subject")
  public void searchAtGoogle() {
    Reporter.log("The chrome version being used is the latest available on the linux repo");
    google.goToGoogle();

    google.search("perficient");
    String title = google.getPageTitle();
    Assert.assertTrue(title.contains("perficient"));
  }

  @AfterMethod
  public void destroy() {
    //wdc.quit();
  }
}
