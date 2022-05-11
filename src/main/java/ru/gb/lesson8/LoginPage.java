package ru.gb.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement emailField = $(By.id("email"));

    private SelenideElement passwdField = $(By.id("passwd"));

    private SelenideElement submitButton = $(By.id("SubmitLogin"));

    @Step("Ввод логина и авторизация")
    public SuggestBlock login(String email, String passwd){

        Allure.step("Ввод логина");
        emailField.sendKeys(email);
        Allure.step("Ввод пароля");
        passwdField.sendKeys(passwd);
        submitButton.click();
        return page(SuggestBlock.class);
    }
}
