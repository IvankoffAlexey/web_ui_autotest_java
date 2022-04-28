package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class TShirtsPage extends BaseView{
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    public TShirtsPage selectSizeInFilters(String size) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[contains(.,'Add to cart')]")
    private WebElement addToCartButton;

    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(productList.stream().filter(s -> s.getText().contains(productName))
                .findFirst()
                .get())
                .build()
                .perform();
        addToCartButton.click();
        return new ConfirmBlock(driver);
    }

}
