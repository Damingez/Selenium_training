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

    int choosenProductAmount = 3;
    app.loginCustomer(customer.getEmail(),customer.getPassword());
    app.addRandomProductsToCart(choosenProductAmount);
    int itemAmount = app.getNumberOfCurrentlyOrderedProducts();
    Assert.assertEquals(choosenProductAmount, itemAmount);
    app.removeProducts(itemAmount);

  }

}


