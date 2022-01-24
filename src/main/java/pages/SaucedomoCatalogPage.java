package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the Catalog page.
 */
public class SaucedomoCatalogPage {

  public void selectItem(WebDriver driver) {
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
  }

  public void goToShoppingCart(WebDriver driver) {
    driver.findElement(By.id("shopping_cart_container")).click();
  }
}
