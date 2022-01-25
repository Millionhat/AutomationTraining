package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the verification page.
 */
public class SaucedomoVerificationPage {

  @FindBy(how = How.ID, using = "finish")
  private WebElement finishBtn;

  public SaucedomoVerificationPage() {
    PageFactory.initElements(WebDriverContainer.driver, this);
  }

  public void finishProcess() {
    finishBtn.click();
  }

}
