package ru.stqa.training.selenium;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/* Część z problemów wynikała z tego że dwa razy dodaje się ten sam produkt
 z racji tego że kolejność produktów na stronie głównej generowana jest losowo  */

@RunWith(DataProviderRunner.class)
public class OrderTest extends TestBase {

  // Task 13
  @Test
  @UseDataProvider(value = "validCustomers", location = DataProviders.class)
  public void checkOrder(Customer customer) {

   app.LoginUser(customer.getName(),customer.getPassword());

    int choosenProductAmount = 3;
    for (int i = 0; i < choosenProductAmount; i++) {
      app.goToProductView(i);
      app.chooseProductSizeWhenPossible();
      app.addProductToTheCart();
      app.checkIfNumOfProductsIsUpdated(i);
      app.goToHomePage();
    }
    int itemAmount = app.getNumOfProductsFromHomePage();
    Assert.assertEquals(3, itemAmount);
    app.goToCartView();
    app.removeProductsFromTheCart(itemAmount);

  }

}


