package ru.gb.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class DressesPage extends BaseView{
    public DressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    public DressesPage selectSizeInFilters(String size) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        sizesList.stream().filter(s -> s.getText().contains(size)).findAny().get().click();
        return this;
    }

    @FindBy(xpath = "//span[.='Color']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> colorsList;

    public DressesPage selectColorInFilters(String color) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enabled_filters")));
        colorsList.stream().filter(s -> s.getText().contains(color)).findAny().get().click();
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
