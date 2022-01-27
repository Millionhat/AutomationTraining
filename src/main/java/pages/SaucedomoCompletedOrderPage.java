package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the Completed Process page.
 */
public class SaucedomoCompletedOrderPage {

  @FindBy(how = How.ID, using = "checkout_complete_container")
  private WebElement checkoutContainer;

  @FindBy(how = How.CLASS_NAME, using = "complete-header")
  private WebElement header;

  public SaucedomoCompletedOrderPage() {
    PageFactory.initElements(WebDriverContainer.getInstance(), this);
  }

  public Object getCompletionContainer() {
    return checkoutContainer;
  }

  public String getContainerHeader() {
    return header.getText();
  }
}
