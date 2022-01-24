package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaucedomoLogInPage {

  public void visitLogin(WebDriver driver) {
    driver.get("https://www.saucedemo.com/");
  }

  public void fillUserName(WebDriver driver) {
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
  }

  public void fillPassword(WebDriver driver) {
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
  }

  public void submitInfo(WebDriver driver) {
    driver.findElement(By.id("login-button")).click();
  }
}
