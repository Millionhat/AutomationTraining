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

  private WebDriver driver;

  @FindBy(how = How.ID, using = "user-name")
  private WebElement userNameBox;

  @FindBy(how = How.ID, using = "password")
  private WebElement passwordBox;

  @FindBy(how = How.ID, using = "login-button")
  private WebElement loginBtn;

  public SaucedomoLogInPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void visitLogin() {
    driver.get("https://www.saucedemo.com/");
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
