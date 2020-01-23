package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class StickersTest extends TestBase{

  @Test
  public void stickersNumberTest ()
  {
    driver.navigate().to("http://localhost/litecart/");


      List<WebElement> products = driver.findElements(By.cssSelector("li.product"));
      int[] numberOfStickersPerProduct = new int[products.size()];

    for (int i=0; i<products.size(); i++)
    {
      List <WebElement> stickers = products.get(i).findElements(By.cssSelector("div.sticker"));
      numberOfStickersPerProduct[i] = stickers.size();
    }

    for (int i=0; i<numberOfStickersPerProduct.length; i++)
    {
      Assert.assertEquals(1,numberOfStickersPerProduct[i]);
    }


  }

}
