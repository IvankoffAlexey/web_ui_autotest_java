package ru.gb.lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.quit();

        WebDriverManager.operadriver().setup();
        WebDriver oDriver = new OperaDriver();
        oDriver.get("https://ya.ru");
        Thread.sleep(3000);

        oDriver.quit();

        WebDriverManager.edgedriver().setup();
        WebDriver eDriver = new EdgeDriver();
        eDriver.get("https://ya.ru");
        Thread.sleep(3000);

        eDriver.quit();

    }

}
