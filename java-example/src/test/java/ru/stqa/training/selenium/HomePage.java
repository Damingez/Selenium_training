package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends Page {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public HomePage open() {
    driver.get("http://localhost/litecart/");
    return this;
  }

  public int getAndConcwertNumberOfProductsFromHomePageToInt() {
    String itemAmountAsString = getQuantityValue();
    return Integer.parseInt(itemAmountAsString);
  }

  public void goToProductFromHomePage(int i) {
    wait.until(elementToBeClickable(productsList().get(i))).click();
  }

 public WebElement email() {
    return driver.findElement(By.name("email"));
 }
 public WebElement password() {
    return driver.findElement(By.name("password"));
  }
  public WebElement login() {
    return driver.findElement(By.name("login"));
  }
  public List<WebElement> productsList() { return driver.findElements(By.cssSelector("div.content div.image-wrapper"));}
  public String getQuantityValue() {return driver.findElement(By.cssSelector("span.quantity")).getAttribute("textContent");}

}
