package ru.stqa.training.selenium;

import org.junit.Before;

public class TestBase {

  public static ThreadLocal<Applicatione> tlApp = new ThreadLocal<>();
  public Applicatione app;

  @Before
  public void start() {
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = new Applicatione();
    tlApp.set(app);
 //   System.out.println(((HasCapabilities) driver).getCapabilities());

  }

}
