package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the shopping cart page.
 */
public class SaucedomoShoppingCartPage {

  private WebDriver driver;

  public SaucedomoShoppingCartPage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToCheckOut() {
    driver.findElement(By.id("checkout")).click();
  }
}
