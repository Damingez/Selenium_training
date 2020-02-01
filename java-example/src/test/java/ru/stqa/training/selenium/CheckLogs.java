package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CheckLogs extends TestBase {

  @Test
  public void checkLogsOccurence()
  {

    driver.navigate().to("https://www.wp.pl/");

    for (LogEntry l : driver.manage().logs().get("driver").getAll()) {
      System.out.println(l);
    }
  }

}
