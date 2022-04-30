package ru.gb.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmBlock {
    private SelenideElement sumElement = $(By.xpath("//span[@class='ajax_block_products_total']"));

    private SelenideElement iconOk = $(By.xpath("//i[@class='icon-ok']"));

    @Step("Проверка наименования и суммы товара на соответствие добавляемому товару перед оформлением ")
    public void checkSumAndIconOK(String summ) {
       Assertions.assertAll(
                () -> iconOk.shouldBe(Condition.visible),
                () -> sumElement.shouldHave(Condition.text("16"))
        );
    }
}
