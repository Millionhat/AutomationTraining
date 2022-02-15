package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * Object class for the shopping cart page.
 */
public class SaucedomoShoppingCartPage {

  private WebDriver driver;

  @FindBy(how = How.ID, using = "checkout")
  private WebElement checkoutBtn;

  public SaucedomoShoppingCartPage() throws MalformedURLException {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  public SaucedomoCheckOutPage goToCheckOut() throws MalformedURLException {
    checkoutBtn.click();
    return new SaucedomoCheckOutPage();
  }
}
