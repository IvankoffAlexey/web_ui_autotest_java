package ru.gb.lesson3.homework.seleniumJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class CrmForHorza {
    public static void main(String[] args) {
        System.out.println("* * * Кратко о сценарии: * * * \n" +                                // Ожидаемый результат
                "1. Открываем страницу по адресу http://horza.ru\n" +                           // Открыта страница http://horza.ru
                "2. Авторизация метод №1 \n" +
                    "2.1. Нажимаем 'Войти'\n" +                                                 // Появилась форма авторизации с полями Логина и Пароля
                    "2.2. Вводим Логин и Пароль\n" +                                            // В поле Логин - отображаются символы, а пароль с маской '*'
                    "2.3. Нажимаем 'Вход' \n" +                                                 //Открыта главная страница и в шапке появилась вкладка 'Мой кабинет'
                "3. Авторизуемся методом №2\n" +                                                //Открыта главная страница и в шапке появилась вкладка 'Мой кабинет'
                "4. Выбираем любой товар и нажимаем 'Купить' \n" +                              //Попадаем в корзину с купленным товаром
                "5. Находясь в корзине нажимаем 'Продолжить покупки'\n" +                       //Переход на главную страницу
                "6. Выбираем любой товар и нажимаем 'Купить' \n" +                              //Попадаем в корзину с купленным товаром
                "7. Находясь в корзине нажимаем 'Продолжить покупки'\n" +                       //Переход на главную страницу"
                "8. Выбираем любой товар и нажимаем 'Купить' \n" +                              //Попадаем в корзину с купленным товаром
                "9. Находясь в корзине \n" +
                     "9.1. Для удаления 3-й позиции нажимаем красный крестик справа от неё \n" +//Данный товар удалился и в корзине остались 2 других товара
                     "9.2. Для удаления 2-й позиции нажимаем красный крестик справа от неё \n" +//Данный товар удалился и в корзине остался только 1 товар
                     "9.3. Для удаления 1-й позиции нажимаем красный крестик справа от неё \n" +//Данный товар удалился и появилось сообщение 'Ваш заказ не содержит товаров.'
                "10. Нажимаем 'Выход'");                                                        //Выход из личного кабинета и переход на главную страницу,
                                                                                                // а вкладка 'Мой кабинет' теперь отсутствует в шапке.
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        // Указываем размеры и место расположения окна
        chromeOptions.addArguments("--window-size=1050,840");
        chromeOptions.addArguments("--window-position=1050,10");

        WebDriver driver = new ChromeDriver(chromeOptions);

        //Открываем в браузере страницу по заданному адресу
        driver.get("http://horza.ru");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Авторизация 2 способа:
        /*
        //1. Переход к авторизации на сайте с заполнением логина и пароля
        WebElement loginButton = driver.findElement(By.xpath("//a[@title='Войти']"));
        loginButton.click();
        //driver.findElement(By.xpath("//a[@title='Войти']")).click();

        //Поиск и заполнение полей тестовыми данными для авторизации на сайте
        driver.findElement(By.id("ctl00_txtLogin")).sendKeys("qatesta");
        driver.findElement(By.id("ctl00_txtPassword")).sendKeys("1q2w3e4r5t");

        //Кликаем вход и авторизуемся
        driver.findElement(By.id("ctl00_btnLogin")).click();
        */

        //2. Авторизация с помощью подстановки куки уже авторизованного пользователя
        Cookie authCookie = new Cookie("ADV26_saskud", "cUserName=qatesta&cUserPWD=l9sYRlcIN/zm/2KkCPHCag==");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        //Нажимаем купить 1-й товар и попадаем в корзину
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl00_btnAdd")).click();

        // возвращаемся к покупкам
        driver.findElement(By.id("ctl00_cphMain_aBackToCatalog")).click();

        //Нажимаем купить 2-й товар и попадаем в корзину
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl01_btnAdd")).click();

        // возвращаемся к покупкам
        driver.findElement(By.id("ctl00_cphMain_aBackToCatalog")).click();

        //Нажимаем купить 3-й товар и попадаем в корзину
        driver.findElement(By.id("ctl00_cphMain_vProducts_dlTilesView_ctl05_btnAdd")).click();

        //Находясь в корзине последовательно удаляем 3-й, 2-й и 1-й товар
        //т.к. если начать удалять с первого то "id" будет тот же
        driver.findElement(By.id("ctl00_cphMain_DataListBasket_ctl03_ImageButton_DeleteItem")).click();
        driver.findElement(By.id("ctl00_cphMain_DataListBasket_ctl02_ImageButton_DeleteItem")).click();
        driver.findElement(By.id("ctl00_cphMain_DataListBasket_ctl01_ImageButton_DeleteItem")).click();

        driver.findElement(By.xpath("//a[@title='Выход']")).click();

//      Thread.sleep(5000);
        driver.quit();
    }
}
