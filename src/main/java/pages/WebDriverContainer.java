package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Class in charge of storing the webDriver for easy access to the Page classes.
 */
public class WebDriverContainer {

  private static WebDriver driver;

  /**
   * Constructor for the WebDriverContainer Class.
   */
  private WebDriverContainer() {
    String browser = System.getenv("browserName");
    switch (browser) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        break;

      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        firefoxOptions.addArguments("--headless");
        driver = new FirefoxDriver(firefoxOptions);
        break;

      case "edge":
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
        break;

      default:
        throw new RuntimeException("Browser not defined correctly or doesnt exist");
    }
  }

  /**
   * Method in charge of accessing and verifying if the webdriver instance has been created.
   *
   * @return WebDriver
   */
  public static WebDriver getInstance() {
    synchronized (WebDriverContainer.class) {
      if (driver == null) {
        new WebDriverContainer();
      }
    }
    return driver;
  }
}
