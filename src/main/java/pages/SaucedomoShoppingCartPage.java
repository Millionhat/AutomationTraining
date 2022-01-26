package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the shopping cart page.
 */
public class SaucedomoShoppingCartPage {

  @FindBy(how = How.ID, using = "checkout")
  private WebElement checkoutBtn;

  public SaucedomoShoppingCartPage() {
    PageFactory.initElements(WebDriverContainer.getInstance().getDriver(), this);
  }

  public void goToCheckOut() {
    checkoutBtn.click();
  }
}
