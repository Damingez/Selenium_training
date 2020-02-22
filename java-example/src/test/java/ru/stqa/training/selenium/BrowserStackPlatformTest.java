package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackPlatformTest {

    public static final String USERNAME = "damiankowalik1";
    public static final String AUTOMATE_KEY = "rRVpQq8n9i4kgXGAy1xg";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("browser", "Chrome");
      caps.setCapability("browser_version", "79.0");
      caps.setCapability("os", "Windows");
      caps.setCapability("os_version", "7");
      caps.setCapability("resolution", "1920x1200");
      caps.setCapability("name", "Bstack-[Java] Sample Test");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com/ncr");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();
  }
}
