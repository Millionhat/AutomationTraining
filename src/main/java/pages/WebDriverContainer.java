package pages;

import org.openqa.selenium.WebDriver;

/**
 * Class in charge of storing the webDriver for an easy access to the Page clases
 */
public class WebDriverContainer {

  public static WebDriver driver;

  public WebDriverContainer(WebDriver driver){
    this.driver = driver;
  }
}
