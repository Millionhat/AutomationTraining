package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.net.MalformedURLException;
import org.openqa.selenium.support.PageFactory;


/**
 * Object class for the Catalog page.
 */
public class SaucedomoCatalogPage {

  private WebDriver driver;

  @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bolt-t-shirt")
  private WebElement addToCart;

  @FindBy(how = How.ID, using = "shopping_cart_container")
  private  WebElement shoppingCart;

  public SaucedomoCatalogPage() throws MalformedURLException {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  public SaucedomoCatalogPage selectItem() {
    addToCart.click();
    return this;
  }

  public SaucedomoShoppingCartPage goToShoppingCart() throws MalformedURLException {
    shoppingCart.click();
    return new SaucedomoShoppingCartPage();
  }
}
