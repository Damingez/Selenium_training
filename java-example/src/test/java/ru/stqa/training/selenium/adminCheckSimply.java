package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class adminCheckSimply  {

  @Test
  public void testAdminMenu()
  {
    WebDriver driver = new ChromeDriver();

    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

// li#app-
//*[@id="app-"]/a/span[2]


    List <WebElement> menuElements =  driver.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
   for (int i=0; i < menuElements.size(); i++)
   {
     menuElements =  driver.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
      menuElements.get(i).click();

     List <WebElement> submenuElements = driver.findElements(By.xpath("//*[@id=\"app-\"]/ul/li"));
     if (submenuElements.size() > 0)
     {

       for (int j=0; j < submenuElements.size(); j++)
       {
         submenuElements.get(j).click();
       }
     }

   }
     driver.quit();
  }


}
