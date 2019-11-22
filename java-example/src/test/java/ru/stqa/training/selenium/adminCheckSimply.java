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




 WebElement appearance =  driver.findElement(By.xpath("//*/text()[normalize-space(.)='Appearence']/parent::*"));
  appearance.click();
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//li[@id='doc-logotype']/a/span")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Catalog']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Product Groups']/parent::*")).click();

    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Option Groups']/parent::*")).click();

    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Manufacturers']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Suppliers']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Delivery Statuses']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Sold Out Statuses']/parent::*")).click();

    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Quantity Units']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='CSV Import/Export']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Countries']/parent::*")).click();
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='Currencies']/parent::*")).click();
     driver.quit();

  }


}
