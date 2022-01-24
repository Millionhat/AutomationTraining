package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaucedomoVerificationPage {

  public void finishProcess(WebDriver driver) {
    driver.findElement(By.id("finish")).click();
  }

}
