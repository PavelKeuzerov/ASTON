package lesson_15.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildberriesPage extends BaseView{
    WildberriesProducts mainProducts = new WildberriesProducts(driver);

    public WildberriesPage(WebDriver driver) {
        super(driver);
    }

    public List<List<String>> inputProduct = new ArrayList<>();

    @FindBy(xpath = "//div[@class=\"header__navbar-pc navbar-pc hide-mobile j-b-header-menu\"]/div")
    public List<WebElement> sideMenu;

    @FindBy(xpath = "//a[@class = 'product-card__add-basket j-add-to-basket btn-main']")
    public List<WebElement> addToBasketButtonList;

    List<WebElement> mainPageProductObject = mainProducts.mainPageProductObjects;

    public BasketPage binClick() {
        sideMenu.get(2).click();
        return new BasketPage(driver);
    }

    public void addToBasketObj(int number) {
        mainPageProductObject.get(number)
                .findElement(By.xpath("div/p/a[contains(@class ,'product-card__add-basket')]"))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        if (!driver.findElements(By.xpath("//div[@class = 'popup popup-list-of-sizes shown slideUp']"))
                .isEmpty()) {
            driver.findElement(By.xpath("(//li[@class = 'sizes-list__item'])[1]")).click();
        }
    }

    public void fillBasket() {
        for (int i = 1; i < 3; i++) {
            this.addToBasketObj(i + 1);
            inputProduct.add(Arrays.asList((this.mainPageProductObject.get(i + 1)
                            .findElement(By.xpath("div[2]/h2/span[2]"))
                            .getText().substring(2)),
                    this.mainPageProductObject.get(i + 1).findElement(By.xpath("div/p/span/del")).getText()));
        }
    }
}