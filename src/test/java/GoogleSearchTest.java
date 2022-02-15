import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import pages.GooglePage;


/**
 * Test class in charge of evaluating a google search using the Selenium Library.
 */
public class GoogleSearchTest {

  private GooglePage google;

  /**
  * This method is in charge of setting up the chrome driver for the test.
  */
  @BeforeMethod
  public void setup() throws MalformedURLException {
    google  = new GooglePage();
  }

  @Test (description = "This test is in charge of redirecting "
      + "to the google website and searching for an specified subject")
  public void searchAtGoogle() {
    Reporter.log("The chrome version being used is the latest available on the linux repo");
    String title = google.goToGoogle()
        .search("perficient").getPageTitle();

    Assert.assertEquals(title, "perficient - Google Search");
  }

}
