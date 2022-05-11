package ru.gb.lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class WomenPage extends BaseView {

    @FindBy(xpath = "//span[.='Categories']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> categoriesList;

    @FindBy(xpath = "//span[.='Color']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> colorsList;

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]/li")
    private List<WebElement> productList;

    @FindBy(xpath = "//span[contains(.,'Add to cart')]")
    private WebElement addToCartButton;

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WomenPage selectCategoriesInFilters(String categories) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        categoriesList.stream().filter(s -> s.getText().contains(categories)).findAny().get().click();
        return this;
    }

    public WomenPage selectColorInFilters(String color) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enabled_filters")));
        colorsList.stream().filter(s -> s.getText().contains(color)).findFirst().get().click();
        return this;
    }

    public WomenPage selectSizeInFilters(String size) {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='enabled_filters']//li[contains(.,'Color')]")));
        sizesList.stream().filter(s -> s.getText().contains(size)).findAny().get().click();
        return this;
    }
@Step("Переход на вкладку 'Women'")
    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='enabled_filters']//li[contains(.,'Size')]")));
        actions.moveToElement(productList.stream().filter(s -> s.getText().contains(productName))
                .findFirst()
                .get())
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Add to cart')]")));
        addToCartButton.click();
        return new ConfirmBlock(driver);
    }

}

