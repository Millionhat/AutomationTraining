package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class in charge of storing the webDriver for an easy access to the Page classes.
 */
public class WebDriverContainer {

  private static WebDriverContainer instance;
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
    instance = this;
  }

  /**
   * Method in charge of accessing and verifying if the webdriver instance has been created.
   *
   * @return WebDriverContainer
   */
  public static WebDriverContainer getInstance() {
    if (instance == null) {
      synchronized (WebDriverContainer.class) {
        if (instance == null) {
          instance = new WebDriverContainer();
        }
      }
    }
    return instance;
  }

  public void quitDriver() {
    driver.quit();
    instance = null;
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
