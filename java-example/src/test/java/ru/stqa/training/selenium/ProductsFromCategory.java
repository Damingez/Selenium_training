package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsFromCategory extends TestBase {

    @Test
    public void productsLogsTest()
    {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

//        System.out.println(driver.manage().logs().getAvailableLogTypes()); not working now

        for (LogEntry entry : driver.manage().logs().get(LogType.DRIVER)) {
            System.out.println(entry.toString());
        }

        List <WebElement> products = driver.findElements(By.cssSelector("tr.row img + a"));


        for (int i=0; i<products.size(); i++) {

                products = driver.findElements(By.cssSelector("tr.row img + a"));
                products.get(i).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           // driver.findElement(By.cssSelector("tr.row img + a")).click();
            for (LogEntry entry : driver.manage().logs().get(LogType.CLIENT)) {
                System.out.println(entry.toString());
            }

            driver.findElement(By.name("cancel")).click();
        }
    }

}
