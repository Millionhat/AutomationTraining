package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Object class for the google webpage.
 */
public class GooglePage {

  private String location = "q";
  private WebDriver driver;

  public GooglePage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToGoogle() {
    driver.get("https://www.google.com/");
  }

  public void search(String search) {
    driver.findElement(By.name(location)).clear();
    driver.findElement(By.name(location)).sendKeys(search + Keys.RETURN);
  }
}
