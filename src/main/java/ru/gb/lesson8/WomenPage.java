package ru.gb.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class WomenPage {

    private ElementsCollection categoriesList = $$(By.xpath("//span[.='Categories']/ancestor::div[@class='layered_filter']//a"));

    private ElementsCollection colorsList = $$(By.xpath("//span[.='Color']/ancestor::div[@class='layered_filter']//a"));

    private ElementsCollection sizesList = $$(By.xpath("//span[.='Size']/ancestor::div[@class='layered_filter']//a"));

    private ElementsCollection productList = $$(By.xpath("//ul[contains(@class, 'product_list')]/li"));

    private SelenideElement addToCartButton = $(By.xpath("//span[contains(.,'Add to cart')]"));

    public WomenPage selectCategoriesInFilters(String categories) {
        categoriesList.findBy(Condition.text(categories)).click();
        return this;
    }

    public WomenPage selectColorInFilters(String color) {
        categoriesList.findBy(Condition.text(color)).click();
        return this;
    }

    public WomenPage selectSizeInFilters(String size) {
      sizesList.findBy(Condition.text(size)).click();
      return this;
    }
    @Step("Переход на вкладку 'Women'")
    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        productList.findBy(Condition.text(productName)).click();
        addToCartButton.click();
        return page(ConfirmBlock.class);
    }

}

