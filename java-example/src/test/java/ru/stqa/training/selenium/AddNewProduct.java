package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class AddNewProduct extends TestBase{

  @Test
  public void addProduct()
  {
    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    driver.navigate().to("http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product");

    // General section
    // status
    driver.findElement(By.cssSelector("div#tab-general input[name=status]")).click();
    // name
    driver.findElement(By.cssSelector("div#tab-general input[name=\"name[en]\"]")).sendKeys("productx");
    // code
    driver.findElement(By.cssSelector("div#tab-general input[name=code]")).sendKeys("te123");

    // categories checkboxes
    List<WebElement> categories = driver.findElements(By.cssSelector("div#tab-general input[name=\"categories[]\"]"));
    categories.get(1).click();

    // Default Category select list
    driver.findElement(By.cssSelector("div#tab-general select[name=default_category_id]")).click();
    driver.findElement(By.cssSelector("div#tab-general select[name=default_category_id] :nth-child(2)")).click();

    // Product groups
    List<WebElement> genders = driver.findElements(By.cssSelector("div#tab-general input[name=\"product_groups[]\"]"));
    genders.get(2).click();

    // quantity
  WebElement quantity =  driver.findElement(By.cssSelector("div#tab-general input[name=quantity]"));
  quantity.clear();
  String qty = "1";
  quantity.sendKeys(qty);

  // upload of the file
    File directory = new File("./src/test/resources/automatyzacja.txt");

  WebElement fileUpload = driver.findElement(By.cssSelector("div#tab-general input[name=\"new_images[]\"]"));
  fileUpload.sendKeys(directory.getAbsolutePath());

  // dates
 WebElement date1 = driver.findElement(By.cssSelector("div#tab-general input[name=date_valid_from]"));
  date1.sendKeys("0020190912");

 WebElement date2 =  driver.findElement(By.cssSelector("div#tab-general input[name=date_valid_to]"));
    date2.sendKeys("00202001231");

    // Information section

  WebElement informationToolbar =  driver.findElement(By.cssSelector("a[href=\"#tab-information\"]"));
    informationToolbar.click();

    // Manfacturer selects
    driver.findElement(By.cssSelector("select[name=manufacturer_id]")).click();
    driver.findElement(By.cssSelector("select[name=manufacturer_id] :nth-child(2)")).click();

    // Keywords
    driver.findElement(By.cssSelector("input[name=keywords]")).sendKeys("clothes");

    driver.findElement(By.cssSelector("input[name=\"short_description[en]\"]")).sendKeys("for usage");
    // Lomger description
    String description = "Can be worn during spring and autumn";
    driver.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys(description);
    // Head title
    driver.findElement(By.cssSelector("input[name=\"head_title[en]\"]")).sendKeys("clothes");
    // Meta description
    driver.findElement(By.cssSelector("input[name=\"meta_description[en]\"]")).sendKeys("xyz");

    // Prices page
    driver.findElement(By.cssSelector("a[href=\"#tab-prices\"]")).click();

    //Purchase price
    WebElement purchasePrice = driver.findElement(By.cssSelector("input[name=purchase_price]"));
    purchasePrice.clear();
    purchasePrice.sendKeys("5");

    driver.findElement(By.cssSelector("select[name=purchase_price_currency_code]")).click();
    WebElement thirdOption = driver.findElement(By.cssSelector("select[name=purchase_price_currency_code] :nth-child(3)"));
    thirdOption.click();

    // Price including tax
    WebElement priceUSD = driver.findElement(By.cssSelector("input[name=\"gross_prices[USD]\"]"));
    priceUSD.clear();
    priceUSD.sendKeys("6,5");

    WebElement priceEUR = driver.findElement(By.cssSelector("input[name=\"gross_prices[EUR]\"]"));
    priceEUR.clear();
    priceEUR.sendKeys("4,5");

    //Saving the product
    WebElement buttonSave = driver.findElement(By.cssSelector("button[name=save]"));
     buttonSave.click();



  }


}
