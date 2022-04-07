package ru.gb.lesson3.homework.seleniumIde;
// Generated by Selenium IDE

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AddToCartTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1048, 1650));
        driver.findElement(By.xpath("//a[@title=\"Log in to your customer account\"]")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("qatesta@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("1q2w3e4r5t");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.xpath("//*[@alt=\"My Store\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@title=\"Continue shopping\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
        driver.findElement(By.id("3_13_0_670399")).click();
        driver.findElement(By.id("2_7_0_670399")).click();
        driver.findElement(By.id("1_1_0_670399")).click();
        driver.findElement(By.xpath("//a[@title=\"Log me out\"]")).click();
        driver.navigate().refresh();
        driver.close();
    }
}
