package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class ConfirmBlock extends BaseView {
    public ConfirmBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='ajax_block_products_total']")
    private WebElement sumElement;

    private static final String iconOkXpathLocator = "//i[@class='icon-ok']";
    // Вынос xpath локатора из @FindBy в константу для последующей подстановки
    // в webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconOkXpathLocator)));
    // Позволяет легко и удобно заменять xpath локаторы без их поиска во всем документе
    @FindBy(xpath = iconOkXpathLocator)
    private WebElement iconOk;

    public void checkSumAndIconOK(String summ) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconOkXpathLocator)));
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//span[@class='ajax_block_products_total']")), hasText(summ))
        );
    }
}
