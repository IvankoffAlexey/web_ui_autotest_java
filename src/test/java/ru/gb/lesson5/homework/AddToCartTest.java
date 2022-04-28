package ru.gb.lesson5.homework;

// Generated by Selenium IDE

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    ChromeOptions options;

    @BeforeAll
    static void regDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        options = new ChromeOptions();
        options.addArguments("--window-size=1050,1050");
        options.addArguments("--window-position=1050,10");
        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebDriverManager.chromedriver().setup();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    @DisplayName("1. Авторизация")
    void authTest() {
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("qatesta@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("1q2w3e4r5t");
        driver.findElement(By.id("SubmitLogin")).click();
    }
    @Test
    @DisplayName("2. Добавление товаров")
    void addToCart() {
        authTest();
        driver.findElement(By.xpath("//*[@alt='My Store']")).click();

        driver.findElement(By.xpath("//a[contains(@href,'1&id_product=1&token=97491ef9b4643f2aaae9024c41056129')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='layer_cart']//h2")));
        Assertions.assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("//div[@id='layer_cart']//h2")).getText());
        driver.findElement(By.xpath("//*[@title='Continue shopping']")).click();

        driver.findElement(By.xpath("//a[contains(@href,'1&id_product=2&token=97491ef9b4643f2aaae9024c41056129')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='layer_cart']//h2")));
        Assertions.assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("//div[@id='layer_cart']//h2")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@title='Continue shopping']")).click();

        driver.findElement(By.xpath("//a[contains(@href,'1&id_product=3&token=97491ef9b4643f2aaae9024c41056129')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='layer_cart']//h2")));
        Assertions.assertEquals("Product successfully added to your shopping cart", driver.findElement(By.xpath("//div[@id='layer_cart']//h2")).getText());
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    }

    @Test
    @DisplayName("3. Удаление товаров")
    void deleteFromCart() {
        addToCart();
        driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        driver.findElement(By.id("3_13_0_670399")).click();
        driver.findElement(By.id("2_7_0_670399")).click();
        driver.findElement(By.id("1_1_0_670399")).click();
        driver.findElement(By.xpath("//a[@title='Log me out']")).click();
    }

    @AfterEach
    void tearDown() {
       driver.quit();
    }
}