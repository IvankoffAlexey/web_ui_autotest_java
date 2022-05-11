package ru.gb.lesson7;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestBlock extends BaseView {

    public SuggestBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/ul/li/a[@title='Women']")
    public WebElement womenButton;

    @Step("Наведение курсора мыши на кнопку 'Женщинам' ")
    public SuggestBlock hoverWomenButton() {
        actions.moveToElement(womenButton).build().perform();
        return this;
    }
    @Step("Наведение курсора мыши на кнопку 'Женщинам' ")
    public WomenPage womenButtonClick() {
        womenButton.click();
        return new WomenPage(driver);
    }


    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    public WebElement dressesButton;

    @Step("Наведение курсора мыши на кнопку 'Платья' ")
    public SuggestBlock hoverDressesButton() {
        actions.moveToElement(dressesButton).build().perform();
        return this;
    }
    @Step("Клик на кнопку 'Платья' ")
    public DressesPage dressesButtonClick() {
        dressesButton.click();
        return new DressesPage(driver);
    }

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
    public WebElement tShirtsButton;

    @Step("Наведение курсора мыши на кнопку 'Рубашки' ")
    public SuggestBlock hoverTShirtsButton() {
        actions.moveToElement(tShirtsButton).build().perform();
        return this;
    }
    @Step("Клик на кнопку 'Рубашки' ")
    public TShirtsPage tShirtsButtonClick() {
        tShirtsButton.click();
        return new TShirtsPage(driver);
    }
}
