import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AppTest {

    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @Test
    void BlockCheck() {
        String onlinePaymentTitle = driver.findElement(By.xpath("//h2[contains(.,'Онлайн пополнение')]"))
                .getText().replaceAll("\n", " ");
        Assertions.assertEquals("Онлайн пополнение без комиссии", onlinePaymentTitle);
    }

    @Test
    void CheckingLogos() {
        List<WebElement> elementList = driver.findElements(By.xpath("//img[contains(@src, '/pay')]"));
        for (WebElement we :
                elementList) {
            Assertions.assertTrue(we.isDisplayed());
        }
    }

    @Test
    void CheckMoreAboutServices() {
        String expectedURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        driver.findElement(By.xpath("//a[contains(.,'Подробнее о сервисе')]")).click();
        Assertions.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    void CheckingContinueButton() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("2");
        driver.findElement(By.xpath("//button[contains(.,'Продолжить')][1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='bepaid-app']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='header__payment']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='header__payment-info']")).getText()
                .contains("Оплата: Услуги связи Номер:"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}