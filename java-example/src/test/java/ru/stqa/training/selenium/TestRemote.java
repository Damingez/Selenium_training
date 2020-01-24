package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRemote {

  @Test
  public void testIE() throws MalformedURLException {
    WebDriver driver = new RemoteWebDriver(new URL("http://10.0.2.15:4444/wd/hub"),
            DesiredCapabilities.internetExplorer());
    driver.navigate().to("https://www.google.pl/");
  }

}