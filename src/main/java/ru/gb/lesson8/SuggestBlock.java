package ru.gb.lesson8;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SuggestBlock {

    private SelenideElement womenButton = $(By.xpath("//div/ul/li/a[@title='Women']"));

    @Step("Наведение курсора мыши на кнопку 'Женщинам' ")
    public SuggestBlock hoverWomenButton() {
        womenButton.hover();
        return this;
    }
    @Step("Клик на кнопку 'Женщинам' ")
    public WomenPage womenButtonClick() {
        womenButton.click();
        return page(WomenPage.class);
    }

    private SelenideElement dressesButton = $(By.xpath("//div/ul/li/a[@title='Dresses']"));

    @Step("Наведение курсора мыши на кнопку 'Платья' ")
    public SuggestBlock hoverDressesButton() {
        dressesButton.hover();
        return this;
    }
    @Step("Клик на кнопку 'Платья' ")
    public DressesPage dressesButtonClick() {
        dressesButton.click();
        return page(DressesPage.class);
    }

    private SelenideElement tShirtsButton = $(By.xpath("//div/ul/li/a[@title='T-shirts']"));

    @Step("Наведение курсора мыши на кнопку 'Рубашки' ")
    public SuggestBlock hoverTShirtsButton() {
        tShirtsButton.hover();
        return this;
    }
    @Step("Клик на кнопку 'Рубашки' ")
    public TShirtsPage tShirtsButtonClick() {
        tShirtsButton.click();
        return page(TShirtsPage.class);
    }
}
