package ru.gb.lesson8;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverListener {

    public Logger logger = LoggerFactory.getLogger(CustomLogger.class);

       //Прикрепление к отчету скриншота страницы перед определенным событием
    public void beforeFindElement(WebDriver driver, By locator) {
                Allure.addAttachment("Скриншот страницы перед поиском элемента",
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(BYTES)));
    }

    // Логирование при обращении к поиску по локатору
    public void afterFindElement(WebDriver driver, By locator) {
        logger.info("Поиск элемента по локатору" + locator.toString());
        Allure.step("Поиск элемента по локатору" + locator);
    }


    public void beforeQuit(WebDriver driver) {
        Allure.addAttachment("Скриншот страницы перед поиском элемента",
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(BYTES)));
    }

}
