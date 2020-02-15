package ru.stqa.training.selenium;

import com.tngtech.java.junit.dataprovider.DataProvider;


public class DataProviders {

  @DataProvider
  public static Object[][] validCustomers() {
    return new Object[][]{
            {Customer.newEntity()
                    .withEmail("user1576266011131@domain.com").withPassword("testy1234").build()
            }
            /* ... */
    };
  }

}