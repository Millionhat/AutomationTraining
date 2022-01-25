package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Class in charge of storing the webDriver for an easy access to the Page classes.
 */
public class WebDriverContainer {

  public static WebDriver driver;

  /**
   * Constructor for the WebDriverContainer Class.
   */
  public WebDriverContainer() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public void quitDriver() {
    driver.quit();
  }
}
