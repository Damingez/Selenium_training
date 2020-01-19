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


    String originalWindow = driver.getWindowHandle();

    //  action of opening new window and closing it
    for (int i=0; i<links.size(); i++)
    {
      Set<String> oldWindows = driver.getWindowHandles();
       links.get(i).click();
          wait.until(numberOfWindowsToBe( 2));
        Set<String> currentWindows = driver.getWindowHandles();

        String newWindow = thereIsWindowOtherThan(oldWindows, currentWindows);

        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(originalWindow);
    }
        driver.close();

  }

  private String thereIsWindowOtherThan(Set<String> oldWindows,Set<String> currentWindows) {

  currentWindows.removeAll(oldWindows);
    String malformed_newPageId = String.valueOf(currentWindows);
  String newPageId =  malformed_newPageId.replace("[","").replace("]","");
  return newPageId;
  }

}
