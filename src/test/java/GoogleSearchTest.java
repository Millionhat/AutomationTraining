import com.beust.jcommander.Parameter;
import com.saucelabs.saucerest.SauceREST;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.WebDriverContainer;

import java.net.MalformedURLException;

/**
 * Test class in charge of evaluating a google search using the Selenium Library.
 */
public class GoogleSearchTest {

  private GooglePage google;
  private SauceREST sauceClient;
  private String sessionId;

  /**
  * This method is in charge of setting up the chrome driver for the test.
  */
  @BeforeMethod
  public void setup() throws MalformedURLException {
    google  = new GooglePage();
    sauceClient = WebDriverContainer.getSauceClient();
    sessionId = WebDriverContainer.getSessionId();
  }

  @Test (description = "This test is in charge of redirecting "
      + "to the google website and searching for an specified subject")
  public void searchAtGoogle() {
    Reporter.log("The chrome version being used is the latest available on the linux repo");
    String title = google.goToGoogle()
        .search("perficient").getPageTitle();

    Assert.assertEquals(title, "perficient - Google Search");
  }


  @Rule
  public TestRule watcher = new TestWatcher() {
    @Override
    protected void succeeded(Description description) {
      if (sessionId!=null && sauceClient!=null) {
        sauceClient.jobPassed(sessionId);
      }
    }

    @Override
    protected void failed(Throwable e, Description description) {
      if (sessionId!=null && sauceClient!=null) {
        sauceClient.jobFailed(sessionId);
      }
    }
  };

}
