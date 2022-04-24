package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestBlock extends BaseView {

    public SuggestBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/ul/li/a[@title='Women']")
    public WebElement womenButton;

    public SuggestBlock hoverWomenButton() {
        actions.moveToElement(womenButton).build().perform();
        return this;
    }
    public WomenPage womenButtonClick() {
        womenButton.click();
        return new WomenPage(driver);
    }


    @FindBy(xpath = "//div/ul/li/a[@title='Dresses']")
    public WebElement dressesButton;

    public SuggestBlock hoverDressesButton() {
        actions.moveToElement(dressesButton).build().perform();
        return this;
    }
    public DressesPage dressesButtonClick() {
        dressesButton.click();
        return new DressesPage(driver);
    }

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
    public WebElement tShirtsButton;

    public SuggestBlock hoverTShirtsButton() {
        actions.moveToElement(tShirtsButton).build().perform();
        return this;
    }
    public TShirtsPage tShirtsButtonClick() {
        tShirtsButton.click();
        return new TShirtsPage(driver);
    }
}
