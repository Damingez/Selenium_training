package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminCheckSimply {

  @Test
  public void testAdminMenu()
  {
    WebDriver driver = new ChromeDriver();

    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    List <WebElement> menuElements =  driver.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
   for (int i=0; i < menuElements.size(); i++)
   {
     menuElements =  driver.findElements(By.xpath("//*[@id=\"app-\"]/a/span[2]"));
      menuElements.get(i).click();

     List <WebElement> submenuElements = driver.findElements(By.xpath("//*[@id=\"app-\"]/ul/li"));
     if (submenuElements.size() > 0)
     {
          WebElement header = driver.findElement(By.cssSelector("#content > h1"));
       assertTrue( header.isDisplayed());
       for (int j=0; j < submenuElements.size(); j++)
       {
         submenuElements = driver.findElements(By.xpath("//*[@id=\"app-\"]/ul/li"));
         submenuElements.get(j).click();
         header = driver.findElement(By.cssSelector("#content > h1"));
         assertTrue( header.isDisplayed());
       }
     }

     //*[@id="content"]/h1/text()


   }
     driver.quit();
  }


}
