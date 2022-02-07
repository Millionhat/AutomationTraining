package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the verification page.
 */
public class SaucedomoVerificationPage {

  private WebDriver driver;

  @FindBy(how = How.ID, using = "finish")
  private WebElement finishBtn;

  public SaucedomoVerificationPage() {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  public void finishProcess() {
    finishBtn.click();
  }

}
