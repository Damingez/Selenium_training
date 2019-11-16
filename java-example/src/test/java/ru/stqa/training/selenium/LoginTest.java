package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class LoginTest {


/*
    @Test
    public void chromeTest() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        WebDriver driver = new ChromeDriver();
        System.out.println(((HasCapabilities) driver).getCapabilities());


        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }                       */
        /*
    @Test
    public void firefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(false);
        WebDriver driver = new FirefoxDriver(options);

        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }               */


                /*
    @Test
    public void ieTest() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        WebDriver driver = new InternetExplorerDriver(caps);

        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }       */


    @Test
    public void firefoxOldSchemeTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(true);
        options.setBinary("c:/Program Files (x86)/Mozilla Firefox ESR/firefox.exe");
        WebDriver driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys("damian.kowalik94@gmail.com");
        driver.findElement(By.name("password")).sendKeys("damian");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }



}