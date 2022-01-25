package pages;

import org.openqa.selenium.WebDriver;

public class WebDriverContainer {

  public static WebDriver driver;

  public WebDriverContainer(WebDriver driver){
    this.driver = driver;
  }
}
