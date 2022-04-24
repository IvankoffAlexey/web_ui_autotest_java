package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver = new ChromeDriver();
    }

    @Test
    void addProductToCartTest() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://automationpractice.com/");
        new MainPage(driver)
                .clickSignInButton()
                .login("qatesta@mail.ru", "1q2w3e4r5t")
                .hoverTShirtsButton()
                .tShirtsButtonClick()
                .selectSizeInFilters("S")
                .hoverAndClickAddToCartProductByName("Faded")
                .checkSumAndIconOK("$16.51");
    }

    @Test
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
