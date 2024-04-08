import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeMethod
    void initBrowserTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
