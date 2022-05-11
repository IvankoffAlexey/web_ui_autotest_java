package ru.gb.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DressesPage {
    private ElementsCollection sizesList = $$(By.xpath("//span[.='Size']/ancestor::div[@class='layered_filter']//a"));

    public DressesPage selectSizeInFilters(String size) {
        sizesList.findBy(Condition.text(size)).click();
        return this;
    }

    private ElementsCollection colorsList = $$(By.xpath("//span[.='Color']/ancestor::div[@class='layered_filter']//a"));

    public DressesPage selectColorInFilters(String color) {
        colorsList.findBy(Condition.text(color)).click();
        return this;
    }

    private ElementsCollection productList = $$(By.xpath("//ul[contains(@class, 'product_list')]/li"));

    private SelenideElement addToCartButton = $(By.xpath("//span[contains(.,'Add to cart')]"));

    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        productList.findBy(Condition.text(productName)).click();
        addToCartButton.click();
        return page(ConfirmBlock.class);
    }

}
