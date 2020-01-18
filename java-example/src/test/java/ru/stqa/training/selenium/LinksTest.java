package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class LinksTest extends TestBase{


  @Test
  public void linksTest()
  {
    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");


    driver.findElement(By.cssSelector("tr.row td:nth-child(5) a")).click();
// extracting the arrow links to the list
   List<WebElement> links = driver.findElements(By.cssSelector("i.fa.fa-external-link"));

    Set<String> oldWindows = driver.getWindowHandles();
    String originalWindow = driver.getWindowHandle();
   links.get(0).click();
      wait.until(numberOfWindowsToBe( 2));
    Set<String> currentWindows = driver.getWindowHandles();

    String newWindow = thereIsWindowOtherThan(oldWindows, currentWindows);
    originalWindow = driver.getWindowHandle();
    driver.switchTo().window(newWindow);

    System.out.println(driver.getWindowHandle());
   links.get(1).click();
    wait.until(numberOfWindowsToBe( 3));

     oldWindows = driver.getWindowHandles();
    System.out.println(oldWindows);

  }

  private String thereIsWindowOtherThan(Set<String> oldWindows,Set<String> currentWindows) {

  currentWindows.removeAll(oldWindows);
    String newPageId = String.valueOf(currentWindows);
    return newPageId;
  }

}
