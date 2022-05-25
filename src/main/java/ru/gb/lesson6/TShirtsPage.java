package ru.gb.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TShirtsPage extends BaseView{
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    public TShirtsPage selectSizeInFilters(String size) {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sizesList.stream().filter(s -> s.getText().contains(size)).findAny().get().click();
        return this;
    }

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[contains(.,'Add to cart')]")
    private WebElement addToCartButton;
@Step("6")
    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        actions.moveToElement(productList.stream().filter(s -> s.getText().contains(productName))
                .findAny()
                .get())
                .build()
                .perform();
        addToCartButton.click();
        return new ConfirmBlock(driver);
    }

}
