package ru.gb.lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

@Story("Добавление товаров в корзину авторизованным пользователем")
public class AutomationPracticeTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void regDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Feature("Добавление в корзину рубашки")
    void addProductToCartTest() {
        driver.get("http://automationpractice.com/");
        new MainPage(driver)
                .clickSignInButton()
                .login("qatesta@mail.ru", "1q2w3e4r5t")
                .hoverTShirtsButton()
                .tShirtsButtonClick()
                .selectSizeInFilters("S")
                .hoverAndClickAddToCartProductByName("a")
                .checkSumAndIconOK("$16.51");
    }

    @Test
    @Feature("Добавление в корзину Платья")
    void addProduct1ToCartTest() {
        driver.get("http://automationpractice.com/");
        new MainPage(driver)
                .clickSignInButton()
                .login("qatesta@mail.ru", "1q2w3e4r5t")
                .hoverDressesButton()
                .dressesButtonClick()
                .selectSizeInFilters("S")
                .selectColorInFilters("Orange")
                .hoverAndClickAddToCartProductByName("Printed")
                .checkSumAndIconOK("$26.00");
    }

    @Test
    @Feature("Добавление в корзину товаров из раздела Женщинам")
    void addProduct2ToCartTest() {
        driver.get("http://automationpractice.com/");
        new MainPage(driver)
                .clickSignInButton()
                .login("qatesta@mail.ru", "1q2w3e4r5t")
                .hoverWomenButton()
                .womenButtonClick()
                .selectCategoriesInFilters("Tops")
                .selectColorInFilters("Black")
                .selectSizeInFilters("S")
                .hoverAndClickAddToCartProductByName("Blouse")
                .checkSumAndIconOK("$27.00");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
