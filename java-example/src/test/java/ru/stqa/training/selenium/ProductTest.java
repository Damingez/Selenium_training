package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

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
 //  String grayPriceFont = grayPriceElement.getCssValue("font");
 //  String redPrice1Font =  redPriceElement.getCssValue("font");

    driver.findElement(By.cssSelector("#box-campaigns img")).click();
    String title = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");

    WebElement grayPriceElement2 = driver.findElement(By.cssSelector("s.regular-price"));
    WebElement redPriceElement2 = driver.findElement(By.cssSelector("strong[itemprop=price]"));
    // gray price
    String grayPriceText2 = grayPriceElement2.getAttribute("textContent");
    String grayPriceColor2 = grayPriceElement2.getCssValue("color");
   // String grayPriceFont2 =  grayPriceElement2.getCssValue("font");

    // red price
    String redPriceText2 = redPriceElement2.getAttribute("textContent");
    String redPriceColor2 = redPriceElement2.getCssValue("color");
   // String redPriceFont2 =  redPriceElement2.getCssValue("font");
  int[] greyPrice_RGB_MainPage = convertRGBAtoArray(grayPriceColor);
  int[] redPrice_RGB_MainPAge = convertRGBAtoArray(redPriceColor);
  int[] greyPrice_RGB_ProductPage = convertRGBAtoArray(grayPriceColor2);
  int[] redPrice_RGB_ProductPage = convertRGBAtoArray(redPriceColor2);


    Assert.assertEquals(title,"Yellow Duck");
    Assert.assertEquals(redPriceText1, redPriceText2);
    // checking if color of price is grey on main page
    Assert.assertEquals(greyPrice_RGB_MainPage[0],greyPrice_RGB_MainPage[1]);
    Assert.assertEquals(greyPrice_RGB_MainPage[0],greyPrice_RGB_MainPage[2]);

    // checking if color of price is red on the main page
    Assert.assertEquals(0,redPrice_RGB_MainPAge[1]);
    Assert.assertEquals(0,redPrice_RGB_MainPAge[2]);

    // checking if the color is grey for product page
    Assert.assertEquals(greyPrice_RGB_ProductPage[0],greyPrice_RGB_ProductPage[1]);
    Assert.assertEquals(greyPrice_RGB_ProductPage[0],greyPrice_RGB_ProductPage[2]);

    // checking if the color is red for product page
    Assert.assertEquals(0, redPrice_RGB_ProductPage[1]);
    Assert.assertEquals(0, redPrice_RGB_ProductPage[2]);

  }

  public static int[] convertRGBAtoArray (String rgba)
  {
    String text =  rgba.substring(5,rgba.lastIndexOf(")"));
    String[] arrayOfString = text.split(",",4);
    int size = arrayOfString.length;
    int[] rgbNumbers = new int[size];
    for (int i=0; i< arrayOfString.length; i++)
    {
      rgbNumbers[i] = Integer.parseInt (arrayOfString[i].trim());
    }

    return rgbNumbers;

  }

}
