package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickersTest extends TestBase{

  @Test
    // need to be fixed
  public void stickersNumberTest ()
  {
    driver.navigate().to("http://localhost/litecart/");

    List <WebElement> stickers = driver.findElements(By.cssSelector("div.sticker"));
    List <WebElement> stickersNew = driver.findElements(By.cssSelector("div[title=New]"));
    List <WebElement> stickersSale = driver.findElements(By.cssSelector("div[title=\"On Sale\"]"));

      int numberOfStickers= stickers.size();
    assert numberOfStickers == stickersNew.size() + stickersSale.size();


  }

}
