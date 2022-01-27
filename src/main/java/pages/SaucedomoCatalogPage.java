package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the Catalog page.
 */
public class SaucedomoCatalogPage {

  @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bolt-t-shirt")
  private WebElement addToCart;

  @FindBy(how = How.ID, using = "shopping_cart_container")
  private  WebElement shoppingCart;

  public SaucedomoCatalogPage() {
    PageFactory.initElements(WebDriverContainer.getInstance(), this);
  }

  public void selectItem() {
    addToCart.click();
  }

  public void goToShoppingCart() {
    shoppingCart.click();
  }
}
