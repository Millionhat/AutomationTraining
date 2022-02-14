package pages;

import com.saucelabs.saucerest.DataCenter;
import com.saucelabs.saucerest.SauceREST;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class in charge of storing the webDriver for easy access to the Page classes.
 */
public class WebDriverContainer {

  private static WebDriver driver;
  private String browser;
  private String isLocal;
  private String sessionId;
  private SauceREST sauceClient;
  private String testName;
  private TestWatcher watcher;
  /**
   * Constructor for the WebDriverContainer Class.
   */
  private WebDriverContainer() throws MalformedURLException {
    browser = System.getenv("browserName");
    isLocal = System.getenv("isLocal");
    driver = createDriver(browser, isLocal);
    watcher = new SauceTestWatcher();
  }

  private WebDriver createDriver(String browser, String isLocal) throws MalformedURLException {
    switch (isLocal) {
      case "true":
        switch (browser) {
          case "chrome":
            return chromeDriverSetup();

          case "firefox":
            return firefoxDriverSetup();

          case "edge":
            return edgeDriverSetup();

          default:
            throw new RuntimeException("Browser not defined correctly or doesnt exist");
        }
      case "false":
        return createRemoteWebDriver();

      default:
        throw new RuntimeException("Environment not defined");
    }

  }

  private WebDriver createRemoteWebDriver() throws MalformedURLException {
    MutableCapabilities sauceOptions = new MutableCapabilities();
    sauceOptions.setCapability("username",System.getenv("sauceuser"));
    sauceOptions.setCapability("accesskey",System.getenv("saucekey"));

    MutableCapabilities capabilities = new MutableCapabilities();
    capabilities.setCapability("browserVersion", "latest");
    capabilities.setCapability("platformName", "Windows 10");
    capabilities.setCapability("browserName", browser);
    capabilities.setCapability("name", testName);
    capabilities.setCapability("sauce:options", sauceOptions);

    String sauceUrl = System.getenv("sauceUrl");

    WebDriver wd = new RemoteWebDriver(new URL(sauceUrl), capabilities);

    sessionId = ((RemoteWebDriver) wd).getSessionId().toString();
    sauceClient = new SauceREST(System.getenv("sauceuser"), System.getenv("saucekey"), DataCenter.US);
    return wd;
  }

  private WebDriver edgeDriverSetup() {
    WebDriverManager.edgedriver().setup();
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--no-sandbox");
    edgeOptions.addArguments("--disable-dev-shm-usage");
    edgeOptions.addArguments("--headless");
    return new EdgeDriver(edgeOptions);
  }

  private WebDriver firefoxDriverSetup() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--no-sandbox");
    firefoxOptions.addArguments("--disable-dev-shm-usage");
    firefoxOptions.addArguments("--headless");
    return new FirefoxDriver(firefoxOptions);
  }

  private WebDriver chromeDriverSetup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    return new ChromeDriver(options);
  }

  /**
   * Method in charge of accessing and verifying if the webdriver instance has been created.
   *
   * @return WebDriver
   */
  public static WebDriver getInstance() throws MalformedURLException {
    synchronized (WebDriverContainer.class) {
      if (driver == null) {
        new WebDriverContainer();
      }
    }
    return driver;
  }

  public class SauceTestWatcher extends TestWatcher {
    @Override
    protected void succeeded(Description description) {
      sauceClient.jobPassed(sessionId);
    }

    @Override
    protected void failed(Throwable e, Description description) {
      sauceClient.jobFailed(sessionId);
    }

    @Override
    protected void starting(Description description) {
      testName =description.getDisplayName();
    }
  }
}
