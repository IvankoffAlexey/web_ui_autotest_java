package ru.gb.lesson7;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseView {
    WebDriverWait webDriverWait;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    @Step("Ввод логина и авторизация")
    public SuggestBlock login(String email, String passwd){
        //webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Allure.step("Ввод логина");
        emailField.sendKeys(email);
        Allure.step("Ввод пароля");
        passwdField.sendKeys(passwd);
        submitButton.click();
        return new SuggestBlock(driver);
    }
}
