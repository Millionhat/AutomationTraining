package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the checkout page.
 */
public class SaucedomoCheckOutPage {

  private WebDriver driver;

  public SaucedomoCheckOutPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * This is the method in charge of filling out the checkout form and submitting it.
   *
   * @param name this is a String containing the first name of the buyer
   * @param lastName this is a String containing the last name of the buyer
   * @param pc this is a String containing the postal code for the buyer delivery address
   */
  public void fillOutForm(String name, String lastName, String pc) {
    driver.findElement(By.id("first-name")).sendKeys(name);
    driver.findElement(By.id("last-name")).sendKeys(lastName);
    driver.findElement(By.id("postal-code")).sendKeys(pc);
    driver.findElement(By.id("continue")).click();
  }
}
