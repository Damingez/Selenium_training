package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

public class ProductPage extends Page {

  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public WebElement sizeList() {
    return driver.findElement(By.cssSelector("select[name=\"options[Size]\"]"));
  }
  public WebElement sizeListOption() {
    return driver.findElement(By.cssSelector("select[name=\"options[Size]\"] option[value=Small]"));
  }
  public WebElement addToCartButton() {return driver.findElement(By.name("add_cart_product"));}
  public WebElement quantityInCart() {return driver.findElement(By.cssSelector("span.quantity"));}

  public String sizeListSelector() {
    return "select[name=\"options[Size]\"]";
  }
  public String addToCartSelector() {return "add_cart_product";}


  public void addProductToTheCart() {
    assertTrue(isElementPresent(driver, By.name(addToCartSelector())));
    addToCartButton().click();
  }

  public void checkIfNumOfProductsIsUpdated(int i) {
    int itemsExpectedNumber = i + 1;
    String itemsExpectedNumberAsString = Integer.toString(itemsExpectedNumber);
    wait.until(attributeContains(quantityInCart(),"textContent" , itemsExpectedNumberAsString));
  }

  public void chooseProductSizeWhenPossible() {
    if (isElementPresent(driver, By.cssSelector(sizeListSelector()) ))
    {
      sizeList().click();
      sizeListOption().click();
    }
  }

  public static boolean isElementPresent(WebDriver driver, By locator)
  {
    try {
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      int elementsNumber = driver.findElements(locator).size();

      return  elementsNumber > 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
  }

}
