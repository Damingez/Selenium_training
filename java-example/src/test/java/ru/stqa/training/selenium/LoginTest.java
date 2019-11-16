package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class LoginTest {


    /*
    @Test
    public void chromeTest() {
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }           */


    @Test
    public void firefoxTest() {
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }


        /*
    @Test
    public void ieTest() {
        WebDriver driver = new InternetExplorerDriver();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }       */




}
