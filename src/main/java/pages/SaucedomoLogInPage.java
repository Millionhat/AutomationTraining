package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the LogIn page.
 */

public class SaucedomoLogInPage {

  @FindBy(how = How.ID, using = "user-name")
  private WebElement userNameBox;

  @FindBy(how = How.ID, using = "password")
  private WebElement passwordBox;

  @FindBy(how = How.ID, using = "login-button")
  private WebElement loginBtn;

  public SaucedomoLogInPage() {
    PageFactory.initElements(WebDriverContainer.getInstance(), this);
  }

  public void visitLogin() {
    WebDriverContainer.getInstance().get("https://www.saucedemo.com/");
  }

  /**
   * This method is in charge of submitting the users information into the
   * Log in page and submit it.
   *
   * @param username string that contains the username of the user
   * @param password string that contains the password from the user
   */
  public void logIn(String username, String password) {
    userNameBox.sendKeys(username);
    passwordBox.sendKeys(password);
    loginBtn.click();
  }

}
