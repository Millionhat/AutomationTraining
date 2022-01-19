import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test (description = "This test is in charge of redirecting to the google website and searching for an specified subject")
    public void searchAtGoogle(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("mjolnir"
        + Keys.RETURN);
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("perficient"
                + Keys.RETURN);
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.id("rso")).findElements(By.xpath("/*")).get(0).findElement(By.tagName("h3")).click();
        Assert.assertTrue(driver.getTitle().contains("Perficient"));
    }

    @AfterMethod
    public void destroy(){
        driver.close();
    }
}
