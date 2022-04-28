package ru.gb.lesson6;

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

    public SuggestBlock login(String email, String passwd){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        emailField.sendKeys(email);
        passwdField.sendKeys(passwd);
        submitButton.click();
        return new SuggestBlock(driver);
    }
}
