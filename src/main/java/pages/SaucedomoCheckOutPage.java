package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * Object class for the checkout page.
 */
public class SaucedomoCheckOutPage {

  private WebDriver driver;

  @FindBy(how = How.ID, using = "first-name")
  private WebElement personName;

  @FindBy(how = How.ID, using = "last-name")
  private  WebElement personLastName;

  @FindBy(how = How.ID, using = "postal-code")
  private WebElement postalCode;

  @FindBy(how = How.ID, using = "continue")
  private WebElement continueButton;

  public SaucedomoCheckOutPage() throws MalformedURLException {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  /**
   * This is the method in charge of filling out the checkout form and submitting it.
   *
   * @param name this is a String containing the first name of the buyer
   * @param lastName this is a String containing the last name of the buyer
   * @param pc this is a String containing the postal code for the buyer delivery address
   */
  public SaucedomoVerificationPage fillOutForm(String name, String lastName, String pc) throws MalformedURLException {
    personName.sendKeys(name);
    personLastName.sendKeys(lastName);
    postalCode.sendKeys(pc);
    continueButton.click();

    return new SaucedomoVerificationPage();
  }
}
