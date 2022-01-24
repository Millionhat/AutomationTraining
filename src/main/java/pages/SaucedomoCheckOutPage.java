package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the checkout page.
 */
public class SaucedomoCheckOutPage {

  public void fillOutName(WebDriver driver) {
    driver.findElement(By.id("first-name")).sendKeys("Juan");
  }

  public void fillOutLastName(WebDriver driver) {
    driver.findElement(By.id("last-name")).sendKeys("Palma");
  }

  public void fillOutPostalCode(WebDriver driver) {
    driver.findElement(By.id("postal-code")).sendKeys("77901");
  }

  public void proceedToVerification(WebDriver driver) {
    driver.findElement(By.id("continue")).click();
  }
}
