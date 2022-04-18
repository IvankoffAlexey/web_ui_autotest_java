package ru.gb.lesson5.homework;
//package ru.gb.lesson3.homework.seleniumJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HorzaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String HORZA_BASE_URL = "http://horza.ru/";

    @BeforeAll
    static void regDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(HORZA_BASE_URL);
        Thread.sleep(5000);
    }

    @Test
    void checkCurrentUrl(){
        Assertions.assertEquals("http://horza.ru/", driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
