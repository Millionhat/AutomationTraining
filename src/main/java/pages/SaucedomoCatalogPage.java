package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the Catalog page.
 */
public class SaucedomoCatalogPage {

  private WebDriver driver;

  public SaucedomoCatalogPage(WebDriver driver) {
    this.driver = driver;
  }

  public void selectItem() {
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
  }

  public void goToShoppingCart() {
    driver.findElement(By.id("shopping_cart_container")).click();
  }
}
