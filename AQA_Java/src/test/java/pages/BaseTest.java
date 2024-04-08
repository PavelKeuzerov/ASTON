package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.TestInstance;

import java.time.Duration;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver = WebDriverManager.chromedriver().create();
    protected MainPage mainPage = new MainPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeMethod
    void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void fillBasket() {
        driver.manage().window().setSize(new Dimension(1300, 1000));
//        driver.manage().window();
        mainPage = new MainPage(driver);
        while (mainPage.addToBasketButtonList.isEmpty()) {
            driver.get("https://www.wildberries.ru/");
            mainPage = new MainPage(driver);
            webDriverWait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath
                            ("//div[@class='product-card__wrapper']")));
        }
    }

//    @AfterMethod
//    void clearCookies() {
//        driver.manage().deleteAllCookies();
//    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

}