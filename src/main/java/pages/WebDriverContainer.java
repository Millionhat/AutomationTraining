package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class in charge of storing the webDriver for easy access to the Page classes.
 */
public class WebDriverContainer {

  private static WebDriver driver;

  /**
   * Constructor for the WebDriverContainer Class.
   */
  private WebDriverContainer() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
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
