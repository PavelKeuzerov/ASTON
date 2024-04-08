import io.github.bonigarcia.wdm.WebDriverManager;
import lesson_15.pages.BasketPage;
import lesson_15.pages.WildberriesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver = WebDriverManager.chromedriver().create();
    protected WildberriesPage mainPage = new WildberriesPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeMethod
    void fillBasket() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver.manage().window().setSize(new Dimension(1300, 1000));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new WildberriesPage(driver);
        while (mainPage.addToBasketButtonList.isEmpty()) {
            driver.get("https://www.wildberries.ru/");
            mainPage = new WildberriesPage(driver);
            webDriverWait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath
                            ("//div[@class='product-card__wrapper']")));
        }
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

}