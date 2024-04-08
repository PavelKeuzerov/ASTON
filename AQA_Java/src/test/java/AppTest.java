//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {
    @Test (description = "Checking products on the main page and in the cart")
    void productsTest() {
        wildberriesPage.fillBasket();
        basketPage = wildberriesPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        Assert.assertFalse(wildberriesPage.inputProduct.isEmpty());

    }
// Тут у меня возникли проблемы незнаю куда лезть уже........
    @Test (description = "Testing the total amount in the cart")
    void basketTest(){
        wildberriesPage.fillBasket();
        basketPage = wildberriesPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        basketPage.initInBasketProduct();
        Assert.assertEquals(Integer
                        .valueOf(basketPage.productInBasketCoast.getText().replaceAll("\\D", "")),
                basketPage.productPriceWithDiscountInBasket.stream().mapToInt(o -> o).sum());
    }
}
