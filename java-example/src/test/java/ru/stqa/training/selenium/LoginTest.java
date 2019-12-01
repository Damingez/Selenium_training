package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


public class LoginTest extends TestBase {


    @Test
    public void chromeTest() {

        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
        /*
    @Test
    public void firefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(false);
        WebDriver driver = new FirefoxDriver(options);

        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
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

         driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }       */

    /*
    @Test
    public void firefoxOldSchemeTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLegacy(true);
        options.setBinary("c:/Program Files (x86)/Mozilla Firefox ESR/firefox.exe");
        WebDriver driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }           */
  // C:\Program Files\Firefox Developer Edition

    /*
    @Test
    public void firefoxNightlyTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("c:/Program Files/Firefox Developer Edition/firefox.exe");
        WebDriver driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }           */

  // $$("a span.name ")
}
