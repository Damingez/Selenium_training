package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class TestBase {

  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
  public WebDriver driver;
  public WebDriverWait wait;

  @Before
  public void start() {
    if (tlDriver.get() != null) {
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, 10);
      return;
    }
   // driver = new FirefoxDriver();
    driver = new ChromeDriver();
    tlDriver.set(driver);
    wait = new WebDriverWait(driver, 10);

   // Runtime.getRuntime().addShutdownHook(
   //         new Thread(() -> { driver.quit(); driver = null; }));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }


}
