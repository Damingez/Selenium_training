package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductTest extends TestBase {

  @Test
  public void checkProduct()
  {
    driver.navigate().to("http://localhost/litecart/");
    WebElement grayPriceElement = driver.findElement(By.cssSelector("#box-campaigns div.price-wrapper s.regular-price"));
    WebElement  redPriceElement = driver.findElement(By.cssSelector("#box-campaigns div.price-wrapper strong.campaign-price"));
    // getting the text of the price element
    String redPriceText1 = redPriceElement.getAttribute("textContent");
    // getting the color of the price
   String grayPriceColor = grayPriceElement.getCssValue("color");
   String redPriceColor = redPriceElement.getCssValue("color");
    // getting the color of the price
   String grayPriceFont = grayPriceElement.getCssValue("font");
   String redPrice1Font =  redPriceElement.getCssValue("font");

    driver.findElement(By.cssSelector("#box-campaigns img")).click();
    String title = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");

    WebElement grayPriceElement2 = driver.findElement(By.cssSelector("s.regular-price"));
    WebElement redPriceElement2 = driver.findElement(By.cssSelector("strong[itemprop=price]"));
    // gray price
    String grayPriceText2 = grayPriceElement2.getAttribute("textContent");
    String grayPriceColor2 = grayPriceElement2.getCssValue("color");
    String grayPriceFont2 =  grayPriceElement2.getCssValue("font");

    // red price
    String redPriceText2 = redPriceElement2.getAttribute("textContent");
    String redPriceColor2 = redPriceElement2.getCssValue("color");
    String redPriceFont2 =  redPriceElement2.getCssValue("font");

    Assert.assertEquals(title,"Yellow Duck");
    Assert.assertEquals(redPriceText1, redPriceText2);
    Assert.assertEquals(redPriceColor,redPriceColor2);

    Assert.assertEquals(redPrice1Font,redPriceFont2);
    Assert.assertEquals(grayPriceColor,grayPriceColor2);
    Assert.assertEquals(grayPriceFont,grayPriceFont2);

  }

}
