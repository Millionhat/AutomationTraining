package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Object class for the google webpage.
 */
public class GooglePage {

  private WebDriver driver;

  @FindBy(how = How.NAME, using = "q")
  private WebElement searchBar;

  public GooglePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void goToGoogle() {
    driver.get("https://www.google.com/");
  }

  public void search(String search) {
    searchBar.clear();
    searchBar.sendKeys(search + Keys.RETURN);
  }

  public String getPageTitle() {
    return driver.getTitle();
  }
}
