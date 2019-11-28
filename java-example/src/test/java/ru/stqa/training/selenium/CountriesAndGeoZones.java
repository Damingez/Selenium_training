package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountriesAndGeoZones extends TestBase {

  @Test
  public void testCountries ()
  {

    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    List<WebElement> names = driver.findElements(By.cssSelector("tr.row :nth-child(5) a"));
    ArrayList <String> countriesNames = new ArrayList<>();


    for (int i=0; i<names.size(); i++)
    {
      String name = names.get(i).getAttribute("textContent");
      countriesNames.add(name) ;
    }
    // copy of the countriesNames list that will be sorted
    ArrayList<String> sortedList = new ArrayList<>();

    for(String s:countriesNames) {
      sortedList.add(s);
    }

    Collections.sort(sortedList);
    Assert.assertEquals(sortedList, countriesNames);

  }


  @Test
  public void checkZones()
  {


    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    List<WebElement> countriesNames = driver.findElements(By.cssSelector("tr.row :nth-child(5) a"));

    // getting the list of zones numbers
    List<WebElement> zonesNumbers = driver.findElements(By.cssSelector("tr.row :nth-child(6) "));


    ArrayList<String> links = new ArrayList<>(); // lins to the pages
    ArrayList<String> names = new ArrayList<>();

    // populating the list ith the links of the countries which have zones > 0
    for (int i=0; i< zonesNumbers.size(); i++)
    {
      int zones = Integer.parseInt( zonesNumbers.get(i).getAttribute("textContent"));
      if ( zones > 0)
      {
         links.add( countriesNames.get(i).getAttribute("href"));
      }
    }

    // navigating to the countries which have zones > 0
    for (int i=0; i< links.size(); i++)
    {

      driver.navigate().to(links.get(i));
      // getting the zones from Country page
       List<WebElement> zonesNames =  driver.findElements(By.cssSelector("table.dataTable tr :nth-child(3) input[type=hidden]"));



      for (int j=0; j< zonesNames.size(); j++)
      {
        String zoneName = zonesNames.get(j).getAttribute("value");
        names.add(zoneName);

      }
      checkIfZonesSorted(names);

        if (names.size() > 0)
        {
            names.clear();
        }
    }

  }

public static void checkIfZonesSorted(ArrayList <String> lista)
  {
    ArrayList<String> sortedList = new ArrayList<>();

    for(String s:lista) {
      sortedList.add(s);
    }
    Collections.sort(sortedList);

    Assert.assertEquals(sortedList, lista);

  }

}






