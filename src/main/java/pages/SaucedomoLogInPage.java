package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the LogIn page.
 */

public class SaucedomoLogInPage {

  private WebDriver driver;

  public SaucedomoLogInPage(WebDriver driver) {
    this.driver = driver;
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
    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("login-button")).click();
  }

}
