package ru.gb.lesson6;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class ConfirmBlock extends BaseView {
    WebDriverWait webDriverWait;
    public ConfirmBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='ajax_block_products_total']")
    private WebElement sumElement;

    @FindBy(xpath = "//i[@class='icon-ok']")
    private WebElement iconOk;

    public void checkSumAndIconOK(String summ) {
        webDriverWait.until(ExpectedConditions.visibilityOf(iconOk));
        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")), isDisplayed()),
                () -> assertThat(driver.findElement(By.xpath("//span[@class='ajax_block_products_total']")), hasText(summ))
        );
    }

}
