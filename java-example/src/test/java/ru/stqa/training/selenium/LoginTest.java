package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginTest {

    public WebDriver driver = new ChromeDriver();

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }


}
