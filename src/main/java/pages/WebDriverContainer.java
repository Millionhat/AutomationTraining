package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
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


  /**
   * Constructor for the WebDriverContainer Class.
   */
  private WebDriverContainer() throws MalformedURLException {
    browser = System.getenv("browserName");
    isLocal = System.getenv("isLocal");
    driver = createDriver();
  }

  private WebDriver createDriver() throws MalformedURLException {
    switch (isLocal){
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
        return remoteDriverSetup();

      default:
        throw new RuntimeException("Running environment not specified");
    }

  }

  private WebDriver remoteDriverSetup() throws MalformedURLException {
    String sauceUrl = System.getenv("sauceUrl");
    MutableCapabilities sauceOptions = new MutableCapabilities();
    sauceOptions.setCapability("username", System.getenv("sauceuser"));
    sauceOptions.setCapability("accesskey", System.getenv("saucekey"));

    MutableCapabilities capabilities = new MutableCapabilities();
    capabilities.setCapability("browserVersion","latest");
    capabilities.setCapability("platfomrName", "Windows 10");
    capabilities.setCapability("sauce:options",sauceOptions);
    capabilities.setCapability("browserName",browser);
    return new RemoteWebDriver(new URL(sauceUrl), capabilities);

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
}
