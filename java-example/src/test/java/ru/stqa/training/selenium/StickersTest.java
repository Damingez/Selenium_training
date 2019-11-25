package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickersTest {

  @Test

  public void stickersNumberTest ()
  {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("unexpectedAlertBehaviour", "dismiss");
    WebDriver driver = new ChromeDriver();
    System.out.println(((HasCapabilities) driver).getCapabilities());

    driver.navigate().to("http://localhost/litecart/");

    List <WebElement> stickers = driver.findElements(By.cssSelector("div.sticker"));
    List <WebElement> stickersNew = driver.findElements(By.cssSelector("div[title=New]"));
    List <WebElement> stickersSale = driver.findElements(By.cssSelector("div[title=\"On Sale\"]"));

      int numberOfStickers= stickers.size();
    assert numberOfStickers == stickersNew.size() + stickersSale.size();
    driver.quit();

    // System.out.println(stickersNew.size());
    // System.out.println(stickersSale.size());
    // System.out.println(stickers.size());
  }

}
