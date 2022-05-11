package ru.gb;

import com.codeborne.selenide.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.lesson8.ConfirmBlock;
import ru.gb.lesson8.MainPage;
import ru.gb.lesson8.SuggestBlock;
import ru.gb.lesson8.TShirtsPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Авторизованный пользователь")
    public void userAuthorized() {
        //Configuration.headless = true;
        open("http://automationpractice.com/");
        new MainPage()
                .clickSignInButton()
                .login("qatesta@mail.ru", "1q2w3e4r5t");
    }

    @When("Навести мышь на раздел TShirts")
    public void hoverWomenButton() {
        new SuggestBlock().hoverTShirtsButton();
    }

    @And("Клик по кнопке рубашки")
    public void clickTShirtsButton() {
        new SuggestBlock().tShirtsButtonClick();
    }

    @And("Выбрать размер S в фильтре")
    public void selectSizeSInFilter() {
        new TShirtsPage().selectSizeInFilters("S");
    }

    @And("Добавляем в корзину товар Faded")
    public void addToCart() {
        new TShirtsPage().hoverAndClickAddToCartProductByName("Faded");
    }

    @Then("Проверка соответствия цены добавленного товара")
    public void checkSumm() {
        new ConfirmBlock().checkSumAndIconOK("$16.51");
    }
}


