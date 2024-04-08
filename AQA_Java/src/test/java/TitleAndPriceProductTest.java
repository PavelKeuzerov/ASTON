//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleAndPriceProductTest extends BaseTest {
    @Test (description = "Checking products on the main page and in the cart")
    void priceAndProductsTest() {
        mainPage.fillBasket();
        basketPage = mainPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        Assert.assertFalse(mainPage.inputProduct.isEmpty());
    }

    @Test
//    @DisplayName("Total sum in Basket Test")
    void clickBasketButtonTest(){
        mainPage.fillBasket();
        basketPage = mainPage.binClick();
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[contains(@class, 'total line')]/span[2]")));
        basketPage.initInBasketProduct();
        Assert.assertEquals(Integer
                        .valueOf(basketPage.productInBasketCoast.getText().replaceAll("\\D", "")),
                basketPage.productPriceWithDiscountInBasket.stream().mapToInt(o -> o).sum());
    }




}
