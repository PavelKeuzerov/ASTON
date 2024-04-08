package lesson_15.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WildberriesProducts extends BaseView {

    public WildberriesProducts(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-card__wrapper']")
    public List<WebElement> mainPageProductObjects;
}