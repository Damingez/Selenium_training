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
  public void countriesTest ()
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
  public void zonesTest()
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


    ArrayList<String> links = new ArrayList<>(); // links to the pages
    ArrayList<String> names = new ArrayList<>();

    // populating the list if the links of the countries which have zones > 0
    for (int i=0; i< zonesNumbers.size(); i++)
    {
      int zones = Integer.parseInt( zonesNumbers.get(i).getAttribute("textContent"));
      if ( zones > 0)
      {
         links.add( countriesNames.get(i).getAttribute("href"));
      }
    }

    // navigating to the countries which have zones
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

  @Test
  public void geoZonesTest()
  {
    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    List<WebElement> countriesElements = driver.findElements(By.cssSelector("table.dataTable tr :nth-child(3) a"));
     ArrayList<String> links = new ArrayList<>();
    ArrayList<String> zonesNames = new ArrayList<>();

     for (int i = 0; i < countriesElements.size(); i++)
     {
       String link = countriesElements.get(i).getAttribute("href");
       links.add(link);
     }

     for (int i=0; i<links.size(); i++)
     {
       driver.navigate().to(links.get(i));
       List <WebElement> zonesElements = driver.findElements(By.cssSelector("table#table-zones tr :nth-child(3) select option[selected]"));

       if (zonesElements.size() == 0)
       {
         System.out.println("There are no timezones on the page");
         continue;
       }


       for (int j=0; j< zonesElements.size(); j++)
       {

         String zoneName = zonesElements.get(j).getAttribute("textContent");
         zonesNames.add(zoneName);
       }
       checkIfZonesSorted(zonesNames);

        if (zonesElements.size()!=0 || zonesNames.size()!=0)
        {
          zonesElements.clear();
          zonesNames.clear();
        }
     }

  }

public static void checkIfZonesSorted(ArrayList <String> lista)
  {
    ArrayList<String> sortedList = new ArrayList<>();

    sortedList.addAll(lista);
    Collections.sort(sortedList);
 //  sortedList.add("falafel");
    Assert.assertEquals(sortedList, lista);

  }

}






