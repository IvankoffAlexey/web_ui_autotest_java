package ru.gb.lesson8;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TShirtsPage {

    private ElementsCollection sizesList = $$(By.xpath("//span[.='Size']/ancestor::div[@class='layered_filter']//a"));
    @Step("Выбор размера в фильтре")
    public TShirtsPage selectSizeInFilters(String size) {
        sizesList.findBy(Condition.text(size)).click();
        return this;
    }

    private ElementsCollection productList = $$(By.xpath("//ul[contains(@class, 'product_list')]/li"));

    private SelenideElement addToCartButton = $(By.xpath("//span[contains(.,'Add to cart')]"));
    @Step("Наведение курсора мыши и клик на кнопку 'Добавить в корзину'")
    public ConfirmBlock hoverAndClickAddToCartProductByName(String productName) {
        productList.findBy(Condition.text(productName)).hover();
        addToCartButton.click();
        return page(ConfirmBlock.class);
    }

}
