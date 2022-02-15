package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.net.MalformedURLException;
import org.openqa.selenium.support.PageFactory;


/**
 * Object class for the LogIn page.
 */

public class SaucedomoLogInPage {

  private WebDriver driver;

  @FindBy(how = How.ID, using = "user-name")
  private WebElement userNameBox;

  @FindBy(how = How.ID, using = "password")
  private WebElement passwordBox;

  @FindBy(how = How.ID, using = "login-button")
  private WebElement loginBtn;

  public SaucedomoLogInPage() throws MalformedURLException {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  public SaucedomoLogInPage visitLogin() {
    driver.get("https://www.saucedemo.com/");
    return this;
  }

  /**
   * This method is in charge of submitting the users information into the
   * Log in page and submit it.
   *
   * @param username string that contains the username of the user
   * @param password string that contains the password from the user
   */
  public SaucedomoCatalogPage logIn(String username, String password) throws MalformedURLException {
    userNameBox.sendKeys(username);
    passwordBox.sendKeys(password);
    loginBtn.click();
    return new SaucedomoCatalogPage();
  }

}
