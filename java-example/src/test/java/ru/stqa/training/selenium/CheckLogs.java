package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CheckLogs extends TestBase {

  @Test
  public void checkLogsOccurence()
  {

    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

    for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
      System.out.println(l);
    }
  }

}
