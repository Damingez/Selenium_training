package ru.stqa.training.selenium;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.runner.RunWith;


public class DataProviders {

  @DataProvider
  public static Object[][] validCustomers() {
    return new Object[][]{
            {Customer.newEntity()
                    .withName("user1576266011131@domain.com").withPassword("testy1234").build()
            }
            /* ... */
    };
  }

}