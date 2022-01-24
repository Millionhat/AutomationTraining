package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

  public void goToGoogle(WebDriver driver){
    driver.get("https://www.google.com/");
  }

  public void googleSearch(WebDriver driver, String search){
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys(search + Keys.RETURN);
  }
}
