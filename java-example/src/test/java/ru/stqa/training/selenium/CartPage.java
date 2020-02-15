package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CartPage extends Page{
  public CartPage(WebDriver driver) {
    super(driver);
  }

  public CartPage open() {
    driver.get("http://localhost/litecart/en/checkout");
    return this;
  }


  public void removeProductsFromTheCart(int itemAmount) {
    for (int i=0; i<itemAmount; i++)
    {
      // checking the value of the table in cart page
      wait.until(numberOfElementsToBe(By.cssSelector(lacatorRowFromTable()), itemAmount--));
      wait.until(visibilityOfElementLocated(By.cssSelector(locatorToRemoveButton()))).click();
    }
  }

 // public WebElement rowFromTable() {return driver.findElement(By.cssSelector("td.item"));}
   public String lacatorRowFromTable() {return "td.item";}
   public String locatorToRemoveButton() {return "button[name=remove_cart_item]";}
}
