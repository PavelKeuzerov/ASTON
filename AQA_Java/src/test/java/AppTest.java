import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest extends BaseTest {
    public void gotoMenu() {
        driver.findElement
                        (By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"))
                .click();
        driver.findElement
                        (By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]"))
                .click();
    }

    @Test(description = "checking the operation of the communication service link")
    public void communicationServicesTest() {
        gotoMenu();

        WebElement numberTextBox = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        String numberPlaceholderText = numberTextBox.getAttribute("placeholder");
        Assert.assertEquals(numberPlaceholderText, "Номер телефона");

        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        String pricePlaceholderText = priceTextBox.getAttribute("placeholder");
        Assert.assertEquals(pricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        String emailPlaceHolderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceHolderText, "E-mail для отправки чека");
    }

    @Test(description = "checking the operation of the home internet link")
    public void homeInternetTest() {
        gotoMenu();

        WebElement subNumberTextBox = driver.findElement(By.xpath("//*[@id=\"internet-phone\"]"));
        String numPlaceholderText = subNumberTextBox.getAttribute("placeholder");
        Assert.assertEquals(numPlaceholderText, "Номер абонента");

        WebElement intPriceTextBox = driver.findElement(By.xpath("//*[@id=\"internet-sum\"]"));
        String intPricePlaceholderText = intPriceTextBox.getAttribute("placeholder");
        Assert.assertEquals(intPricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"internet-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }

    @Test(description = "checking the link in installments")
    public void installmentTest() {
        gotoMenu();

        WebElement accNumber = driver.findElement(By.xpath("//*[@id=\"score-instalment\"]"));
        String accNumPlaceholderText = accNumber.getAttribute("placeholder");
        Assert.assertEquals(accNumPlaceholderText, "Номер счета на 44");

        WebElement instPriceTextBox = driver.findElement(By.xpath("//*[@id=\"instalment-sum\"]"));
        String instPricePlaceholderText = instPriceTextBox.getAttribute("placeholder");
        Assert.assertEquals(instPricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"instalment-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }

    @Test(description = "checking the link operation debt")
    public void debtTest() {
        gotoMenu();

        WebElement accNumberTextBox = driver.findElement(By.xpath("//*[@id=\"score-arrears\"]"));
        String accNumberPlaceholderText = accNumberTextBox.getAttribute("placeholder");
        Assert.assertEquals(accNumberPlaceholderText, "Номер счета на 2073");

        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"arrears-sum\"]"));
        String pricePlaceholderText = priceTextBox.getAttribute("placeholder");
        Assert.assertEquals(pricePlaceholderText, "Сумма");

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"arrears-email\"]"));
        String emailPlaceholderText = emailTextBox.getAttribute("placeholder");
        Assert.assertEquals(emailPlaceholderText, "E-mail для отправки чека");
    }


    @Test(description = "checking the link \"Online replenishment without commission\"")
    public void checkServicesConnectionsTest() {
        gotoMenu();

        driver.findElement
                (By.xpath("//*[@id=\"connection-phone\"]")).sendKeys("297777777");
        driver.findElement
                (By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("2");
        driver.findElement
                        (By.xpath("//*[@id=\"pay-connection\"]/button"))
                .click();

        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1)); //нашел наугад
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='header__payment']")));

        WebElement headerPayment = driver.findElement
                (By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div"));
        Assert.assertTrue(headerPayment.getText().contains("2"));
        Assert.assertTrue(headerPayment.getText().contains("297777777"));

        WebElement buttonPrice = driver.findElement
                (By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button"));
        Assert.assertTrue(buttonPrice.getText().contains("2"));

        WebElement paymentWindow = driver.findElement
                (By.xpath("/html/body/app-root/div/div/app-payment-container/section/" +
                        "app-card-page/div/div[1]/app-card-input/form/div[1]"));
        String paymentData = paymentWindow.getText();
        Assert.assertTrue(paymentData.contains("Номер карты"));
        Assert.assertTrue(paymentData.contains("Срок действия"));
        Assert.assertTrue(paymentData.contains("CVC"));
        Assert.assertTrue(paymentData.contains("Имя держателя (как на карте)"));

        WebElement logos = driver.findElement
                (By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page" +
                        "/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div"));
        Assert.assertTrue(logos.isDisplayed());
    }
}
