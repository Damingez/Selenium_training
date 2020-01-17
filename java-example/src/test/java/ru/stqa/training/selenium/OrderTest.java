package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/* Część z problemów wynikała z tego że dwa razy dodaje się ten sam produkt
 z racji tego że kolejność produktów na stronie głównej generowana jest losowo  */

public class OrderTest extends TestBase {

  // Task 13
  @Test
  public void checkOrder()
  {
    driver.navigate().to("http://localhost/litecart/");

    // login action
    driver.findElement(By.name("email")).sendKeys("user1576266011131@domain.com");
    driver.findElement(By.name("password")).sendKeys("testy1234");
    driver.findElement(By.name("login")).click();

    int choosenProductAmount = 3;



    for (int i=0; i<choosenProductAmount; i++)
    {
        // getting the first three product available on the list
         // assertTrue(isElementPresent(driver, By.name("div.content div.image-wrapper")));
      List <WebElement> products = driver.findElements(By.cssSelector("div.content div.image-wrapper"));

      //products.get(i).click();
       wait.until(elementToBeClickable(products.get(i))).click();


        // setting value for select list if such exists in the product view
        String selectListLocator = "select[name=\"options[Size]\"]";
        if (isElementPresent(driver,By.cssSelector(selectListLocator)))
        {
          driver.findElement(By.cssSelector(selectListLocator)).click();
          driver.findElement(By.cssSelector("select[name=\"options[Size]\"] option[value=Small]")).click();
        }

        // adding product to the cart
      String addToCardButtonLocator = "add_cart_product";

        assertTrue(isElementPresent(driver, By.name(addToCardButtonLocator)));
        driver.findElement(By.name(addToCardButtonLocator)).click();


        // checking if basket is updated
         WebElement cartItem = driver.findElement(By.cssSelector("span.quantity"));
         int itemsExpectedNumber = i + 1;
         String itemsExpectedNumberAsString = Integer.toString(itemsExpectedNumber);

          wait.until(attributeContains(cartItem,"textContent" , itemsExpectedNumberAsString));

         // going back to home page
          driver.findElement(By.cssSelector("a[href=\"/litecart/\"]")).click();
    }
      // getting the amount of products
     String itemAmountAsString = driver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");

    // navigting to cart view
     driver.findElement(By.cssSelector("div#cart")).click();
    int itemAmount = Integer.parseInt(itemAmountAsString) ;

    for (int i=0; i<itemAmount; i++)
    {

      // checking the value of the table
        wait.until(numberOfElementsToBe(By.cssSelector("td.item"), itemAmount--));

        wait.until(visibilityOfElementLocated(By.cssSelector("button[name=remove_cart_item]"))).click();
    }
  }

  public static boolean isElementPresent(WebDriver driver, By locator)
  {
    try {
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     int elementsNumber = driver.findElements(locator).size();
      System.out.println(elementsNumber);
       return  elementsNumber > 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

  }

}


