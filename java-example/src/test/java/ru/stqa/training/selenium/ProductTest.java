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
    WebElement oldPriceElement = driver.findElement(By.cssSelector("#box-campaigns div.price-wrapper s.regular-price"));
    WebElement  priceElement = driver.findElement(By.cssSelector("#box-campaigns div.price-wrapper strong.campaign-price"));
    // getting the text of the price element
    String priceText1 = priceElement.getAttribute("textContent");
    // getting the color of the price
   String oldPriceColor = oldPriceElement.getCssValue("color");
   String priceColor = priceElement.getCssValue("color");
    // getting the color of the price
   String oldPriceFont = oldPriceElement.getCssValue("font");
   String price1Font =  priceElement.getCssValue("font");

    driver.findElement(By.cssSelector("#box-campaigns img")).click();
    String title = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");

    WebElement oldPriceElement2 = driver.findElement(By.cssSelector("s.regular-price"));
    WebElement priceElement2 = driver.findElement(By.cssSelector("strong[itemprop=price]"));
    // old price
    String oldPriceText2 = oldPriceElement2.getAttribute("textContent");
    String oldPriceColor2 = oldPriceElement2.getCssValue("color");
    String oldPriceFont2 =  oldPriceElement2.getCssValue("font");

    // new price
    String priceText2 = priceElement2.getAttribute("textContent");
    String priceColor2 = priceElement2.getCssValue("color");
    String priceFont2 =  priceElement2.getCssValue("font");


    Assert.assertEquals(title,"Yellow Duck");
    Assert.assertEquals(priceText1, priceText2);
    Assert.assertEquals(priceColor,priceColor2);
    Assert.assertEquals(price1Font,priceFont2);
    Assert.assertEquals(oldPriceColor,oldPriceColor2);
    Assert.assertEquals(oldPriceFont,oldPriceFont2);


  }

}
