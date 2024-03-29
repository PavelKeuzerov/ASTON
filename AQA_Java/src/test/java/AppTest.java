import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AppTest {
    private static final double PAYMENT = 5.00;
    private static final long PHONE = 297777777;
    WebDriver driver;
    WebDriverWait webDriverWait;
    private Actions actions;

    @BeforeMethod
    void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(22));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        if (driver.findElement(By.id("cookie-agree")).isDisplayed()) {
            driver.findElement(By.id("cookie-agree")).click();
        }
    }

    @Test
    public void testDropDownList() {
        driver.findElement(By.xpath("//div[@class = 'select__wrapper']")).click();
        List<WebElement> dropDownList = driver.findElements(By.xpath("//div[@class = 'select']/div/ul/li/p"));
        Assert.assertEquals(dropDownList.get(0).getText(), "Услуги связи");
        Assert.assertEquals(dropDownList.get(1).getText(), "Домашний интернет");
        Assert.assertEquals(dropDownList.get(2).getText(), "Рассрочка");
        Assert.assertEquals(dropDownList.get(3).getText(), "Задолженность");
    }


    private Actions getActions() {
        if(actions == null) {
            actions = new Actions(driver);
        }
        return actions;
    }

    public void scrollPage() {
        WebElement dropdown = driver.findElement(By.cssSelector("#pay-section .select button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",dropdown);
        getActions().moveToElement(dropdown).click().perform();
    }

    @Test
    public void task1() {
        scrollPage();
//        WebElement homeInternet = driver.findElement(By.xpath("//p[@class='select__option'][contains(.,'Домашний интернет')]"));
//        getActions().moveToElement(homeInternet).click().build().perform();
        WebElement internetPhone = driver.findElement(By.xpath("//input[@id='internet-phone']"));
        WebElement internetSum = driver.findElement(By.xpath("//input[@id='internet-sum']"));
        WebElement internetEmail = driver.findElement(By.xpath("//input[@id='internet-email']"));
        Assert.assertEquals("Номер абонента", internetPhone.getAttribute("placeholder"));
        Assert.assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        Assert.assertEquals("E-mail для отправки чека", internetEmail.getAttribute("placeholder"));
    }

    @Test
    public void task2() {
        scrollPage();
//        WebElement installment = driver.findElement(By.xpath("//p[@class='select__option'][contains(.,'Рассрочка')]"));
//        getActions().moveToElement(installment).click().perform();
        WebElement scoreInstalment = driver.findElement(By.id("score-instalment"));
        WebElement internetSum = driver.findElement(By.id("internet-sum"));
        WebElement instalmentEmail = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals("Номер счета на 44", scoreInstalment.getAttribute("placeholder"));
        Assert.assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        Assert.assertEquals("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"));
    }

    @Test
    public void task3() {
        scrollPage();
//
//        WebElement debt = driver.findElement(By.xpath("//p[@class='select__option'][contains(.,'Задолженность')]"));
//        getActions().moveToElement(debt).click().perform();
        WebElement invoiceNumber2073 = driver.findElement(By.id("score-arrears"));
        WebElement internetSum = driver.findElement(By.id("internet-sum"));
        WebElement instalmentEmail = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals("Номер счета на 2073", invoiceNumber2073.getAttribute("placeholder"));
        Assert.assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        Assert.assertEquals("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"));
    }

    @Test
    public void task4() {

        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement internetSum = driver.findElement(By.id("internet-sum"));
        WebElement instalmentEmail = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals("Номер телефона", phoneNumber.getAttribute("placeholder"));
        Assert.assertEquals("Сумма", internetSum.getAttribute("placeholder"));
        Assert.assertEquals("E-mail для отправки чека", instalmentEmail.getAttribute("placeholder"));
    }

    @Test
    public void task5() {
        scrollPage();

        WebElement communicationServices = driver.findElement(By.xpath("//p[@class='select__option'][contains(.,'Услуги связи')]"));
        getActions().moveToElement(communicationServices).click().perform();
        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.clear();
        phone.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.sendKeys("10");
        WebElement email = driver.findElement(By.id("connection-email"));
        email.sendKeys("Abc@mail.ru");

        WebElement form = driver.findElement(By.id("pay-connection"));
        WebElement button = form.findElement(By.xpath(".//button[contains(@class, 'button button__default') and text()='Продолжить']"));
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/iframe")));
        Assert.assertTrue(driver.findElement(By.xpath("//div/iframe")).isDisplayed());
        driver.switchTo().frame
                (driver.findElement(By.cssSelector("body>.bepaid-app>.bepaid-app__container>iframe.bepaid-iframe")));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'payment-amount')]")));
        WebElement headerPayAmount = driver.findElement(By.xpath("//p[contains(@class,'payment-amount')]"));

        WebElement buttonSubmit = driver.findElement(By.xpath("//div[@class='card-page__card']/button"));

        WebElement phoneInfo = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        WebElement textNumberCard = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-1']/label"));
        WebElement duration = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-4']/label"));
        WebElement cvc = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-5']/label"));
        WebElement namePerson = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-3']/label"));
        List<WebElement> icons = driver.findElements(By.xpath("//div[@class='icons-container ng-tns-c47-1']//img"));


        Assert.assertEquals("10.00 BYN", headerPayAmount.getText());
        Assert.assertEquals("Оплатить 10.00 BYN", buttonSubmit.getText());
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", phoneInfo.getText());
        Assert.assertEquals("Номер карты", textNumberCard.getText());
        Assert.assertEquals("Срок действия", duration.getText());
        Assert.assertEquals("CVC", cvc.getText());
        Assert.assertEquals("Имя держателя (как на карте)", namePerson.getText());
        Assert.assertFalse(icons.isEmpty());
        driver.switchTo().defaultContent();
    }

    @Test
    public void test12() {
        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.click();
        String phoneValue = "297777777";
        phone.sendKeys(phoneValue);
        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.click();

        String sumValue = "29.76";
        sum.sendKeys(sumValue);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        button.click();

        driver.findElement(By.id("connection-sum")).sendKeys("2");

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));
        WebElement paidFrame = driver.findElement(By.cssSelector(".bepaid-iframe"));

        driver.switchTo().frame(paidFrame);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__payment-amount")));

        String headerSum = driver.findElement(By.className("header__payment-amount")).getText();
        Assert.assertTrue(headerSum.contains(sumValue));


        WebElement cardRoot = driver.findElement(By.className("card-page__card"));

        String btnSum = cardRoot.findElement(By.tagName("button")).getText();
        Assert.assertTrue(btnSum.contains(sumValue));

        String headerPhone = driver.findElement(By.className("header__payment-info")).getText();
        Assert.assertTrue(headerPhone.contains(phoneValue));

        List<WebElement> cardLabels = cardRoot.findElements(By.tagName("label"));

        for (WebElement element : cardLabels) {
            switch (element.getAttribute("class")) {
                case "ng-tns-c47-1 ng-star-inserted":
                    Assert.assertEquals("Номер карты", element.getText());
                    break;
                case "ng-tns-c47-4 ng-star-inserted":
                    Assert.assertEquals("Срок действия", element.getText());
                    break;
                case "ng-tns-c47-5 ng-star-inserted":
                    Assert.assertEquals("CVC", element.getText());
                    break;
                case "ng-tns-c47-3 ng-star-inserted":
                    Assert.assertEquals("Имя держателя (как на карте)", element.getText());
                    break;
            }
        }

//        List<WebElement> icons = cardRoot.findElements(By.tagName("img"));
//
//        for (WebElement icon : icons) {
//            if (icon.getAttribute("class").equals("ng-tns-c53-0 ng-star-inserted")) {
//                Assert.assertFalse(icon.getAttribute("src").isEmpty());
//            }
//        }

        List<WebElement> elementList = driver.findElements(By.xpath("//img[contains(@src, '/pay')]"));
        for (WebElement we :
                elementList) {
            if (we.getAttribute("class").equals("ng-tns-c53-0 ng-star-inserted")) {
                Assert.assertFalse(we.getAttribute("src").isEmpty());
            }
        }
    }



    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
