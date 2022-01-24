package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaucedomoShoppingCartPage {

  public void goToCheckOut(WebDriver driver) {
    driver.findElement(By.id("checkout")).click();
  }
}
