package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the verification page.
 */
public class SaucedomoVerificationPage {

  private WebDriver driver;

  public SaucedomoVerificationPage(WebDriver driver) {
    this.driver = driver;
  }

  public void finishProcess() {
    driver.findElement(By.id("finish")).click();
  }

}
