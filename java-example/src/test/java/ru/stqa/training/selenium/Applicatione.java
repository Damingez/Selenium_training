package ru.stqa.training.selenium;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Applicatione {

  private WebDriver driver;
  private WebDriverWait wait;


  public Applicatione() {
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver,10);
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public void removeProductsFromTheCart(int itemAmount) {
    for (int i=0; i<itemAmount; i++)
    {
      // checking the value of the table
      wait.until(numberOfElementsToBe(By.cssSelector("td.item"), itemAmount--));
      wait.until(visibilityOfElementLocated(By.cssSelector("button[name=remove_cart_item]"))).click();
    }
    //wait.until(visibilityOfElementLocated(By.cssSelector("button[name=remove_cart_item]"))).click();
  }

  public void goToCartView() {
    driver.navigate().to("http://localhost/litecart/en/checkout");
  }

  public int getNumOfProductsFromHomePage() {
    String itemAmountAsString =  driver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");
    int itemAmount = Integer.parseInt(itemAmountAsString);
    return itemAmount;
  }

  public void goToHomePage() {
    driver.findElement(By.cssSelector("a[href=\"/litecart/\"]")).click();
  }

  public void checkIfNumOfProductsIsUpdated(int i) {
    WebElement cartItem = driver.findElement(By.cssSelector("span.quantity"));
    int itemsExpectedNumber = i + 1;
    String itemsExpectedNumberAsString = Integer.toString(itemsExpectedNumber);

    wait.until(attributeContains(cartItem,"textContent" , itemsExpectedNumberAsString));
  }

  public void addProductToTheCart() {
    String addToCardButtonLocator = "add_cart_product";
    assertTrue(isElementPresent(driver, By.name(addToCardButtonLocator)));
    driver.findElement(By.name(addToCardButtonLocator)).click();
  }

  public void chooseProductSizeWhenPossible() {
    String selectListLocator = "select[name=\"options[Size]\"]";
    if (isElementPresent(driver, By.cssSelector(selectListLocator)))
    {
      driver.findElement(By.cssSelector(selectListLocator)).click();
      driver.findElement(By.cssSelector("select[name=\"options[Size]\"] option[value=Small]")).click();
    }
  }

  public void goToProductView(int i) {
    List<WebElement> products = driver.findElements(By.cssSelector("div.content div.image-wrapper"));
    wait.until(elementToBeClickable(products.get(i))).click();
  }

  public void LoginUser(String email, String password) {
    driver.navigate().to("http://localhost/litecart/");
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).click();
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
