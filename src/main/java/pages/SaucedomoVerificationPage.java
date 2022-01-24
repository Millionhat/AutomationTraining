package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the verification page.
 */
public class SaucedomoVerificationPage {

  public void finishProcess(WebDriver driver) {
    driver.findElement(By.id("finish")).click();
  }

}
