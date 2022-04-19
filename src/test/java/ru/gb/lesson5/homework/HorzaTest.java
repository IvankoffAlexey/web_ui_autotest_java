package ru.gb.lesson5.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HorzaTest {
    // Объявление полей класса
    WebDriver driver;
    WebDriverWait wait;
    private static final String HORZA_URL = "http://horza.ru";

    @BeforeAll
    static void regDriver(){
        // Перед запуском всех тестов
        // регистрируем экземпляр драйвера для нашего браузера
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        //Прописываем параметры в качестве предусловий
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(HORZA_URL);
    }

    @Test
    @DisplayName("1. Проверка соответствия адреса страницы")
    void isValidUrl(){
        Assertions.assertEquals("http://horza.ru/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("2. Проверка кнопки 'Вход' и появление формы авторизации")
    void loginButtonTest() {
        driver.findElement(By.xpath("//a[@title='Войти']")).click();
            Assertions.assertEquals("Авторизация", driver.findElement(By.xpath("//*[@class='auth_header' and contains(.,'Авторизация')]")).getText());
    }

    @Test
    @DisplayName("3. Заполнение полей формы авторизации тестовыми данными и авторизация")
    void enterAuthDataTest() {
        loginButtonTest();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.findElement(By.id("ctl00_txtLogin")).sendKeys("qatesta");
        driver.findElement(By.id("ctl00_txtPassword")).sendKeys("1q2w3e4r5t");
        driver.findElement(By.id("ctl00_btnLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a_tabMenu3")));
            Assertions.assertEquals("Мой кабинет", driver.findElement(By.id("a_tabMenu3")).getText());
    }

    @Test
    @DisplayName("4. Добавление товаров в корзину")
    void addToBasket() {

        enterAuthDataTest();
        // Добавляем товар в корзину и
        // проверяем, что товар появившийся в корзине
        // соответствует добавляемому.
        String firstProduct = driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl00_lblProductName")).getText();
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl00_btnAdd")).click();
        Assertions.assertEquals(firstProduct, driver.findElement(By.xpath("//a[@href='/Stulya/Stul_Pekin_khrom?key=showp1']")).getText());
        driver.findElement(By.id("ctl00_cphMain_aBackToCatalog")).click();

        String secondProduct = driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl01_lblProductName")).getText();
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl01_btnAdd")).click();
        Assertions.assertEquals(secondProduct, driver.findElement(By.xpath("//a[@href='/Stulya/Stul_Sonata_Komfort?key=showp1']")).getText());
        driver.findElement(By.id("ctl00_cphMain_aBackToCatalog")).click();

        String thirdProduct = driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl02_lblProductName")).getText();
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl02_btnAdd")).click();
        Assertions.assertEquals(thirdProduct, driver.findElement(By.xpath("//a[@href='/Ofis_stulya/Stul_ofisnyi_Samba_khrom?key=showp1']")).getText());
    }

    @Test
    @DisplayName("5. Удаление всех товаров из корзины")
    void clearBasket() {
        enterAuthDataTest();
        // Удаление всех товаров из корзины.
        // После нажатия кнопки удалить появляется 'Alert',
        // в котором необходимо подтвердить удаление.
        // Проверяем, что корзина пуста. Выходим из ЛК.
        driver.findElement(By.xpath("//a[@href='/ShoppingCart.aspx' and contains(.,'Корзина')]")).click();
        driver.findElement(By.id("ctl00_cphMain_lblClearBasket")).click();
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ctl00_cphMain_lblEmpty")));
        Assertions.assertEquals("Ваш заказ не содержит товаров.", driver.findElement(By.id("ctl00_cphMain_lblEmpty")).getText());
        driver.findElement(By.xpath("//a[@title='Выход']")).click();
    }


    @AfterEach
    //Постусловие после каждого теста
    void tearDown(){
       driver.quit();
    }
}
