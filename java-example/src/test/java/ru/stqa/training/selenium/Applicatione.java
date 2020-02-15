package ru.stqa.training.selenium;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Applicatione {

  private WebDriver driver;
  private WebDriverWait wait;
  private HomePage homePage;
  private ProductPage productPage;
  private CartPage cartPage;

  public Applicatione() {
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver,10);
    homePage = new HomePage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

  public void addRandomProductsToCart(int ProductNumber) {
    for (int i = 0; i < ProductNumber; i++) {
      homePage.goToProductFromHomePage(i);
      productPage.chooseProductSizeWhenPossible();
      productPage.addProductToTheCart();
      productPage.checkIfNumOfProductsIsUpdated(i);
      homePage.open();
    }
  }


 public void removeProducts(int amount)
 {
   cartPage.open();
   cartPage.removeProductsFromTheCart(amount);
 }

  public void loginCustomer(String email, String password) {
    homePage.open();
    homePage.email().sendKeys(email);
    homePage.password().sendKeys(password);
    homePage.login().click();
  }

  public int getNumberOfCurrentlyOrderedProducts(){
    return homePage.getAndConcwertNumberOfProductsFromHomePageToInt();
  }

}
