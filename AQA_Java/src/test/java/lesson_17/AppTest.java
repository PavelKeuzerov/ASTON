package lesson_17;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    @Test(description = "addition test")
    public void additionTest() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"сложить\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "12");
    }

    @Test(description = "subtraction test")
    public void subtractionTest() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"вычесть\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "6");
    }

    @Test(description = "multiplication test")
    public void multiplicationTest() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"умножение\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "27");
    }

    @Test(description = "division test")
    public void divisionTest() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"разделить\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"равно\"]")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "3");
    }
}
