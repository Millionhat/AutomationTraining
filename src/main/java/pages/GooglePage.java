package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Object class for the google webpage.
 */
public class GooglePage {


  @FindBy(how = How.NAME, using = "q")
  private WebElement searchBar;
  private WebDriver driver;

  public GooglePage() {
    driver = WebDriverContainer.getInstance();
    PageFactory.initElements(driver, this);
  }

  public GooglePage goToGoogle() {
    driver.get("https://www.google.com/");
    return this;
  }

  /**
   * Method in charge of executing the google search.
   *
   * @param search String
   * @return Returns the instance of the class
   */
  public GooglePage search(String search) {
    searchBar.clear();
    searchBar.sendKeys(search + Keys.RETURN);
    return this;
  }

  public String getPageTitle() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.titleContains("perficient"));
    return driver.getTitle();
  }
}
