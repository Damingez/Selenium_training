package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase{

  @Test
  public void registerUser()
  {
    long now = System.currentTimeMillis();

    driver.navigate().to("http://localhost/litecart/en/create_account");
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    WebElement nameElement = driver.findElement(By.cssSelector("input[name=firstname]"));
    String name = String.format("user%s",now);
    nameElement.sendKeys(name);

    WebElement lastNameField = driver.findElement(By.cssSelector("input[name=lastname]"));
    lastNameField.sendKeys("surname");

    WebElement addressField = driver.findElement(By.cssSelector("input[name=address1]"));
    addressField.sendKeys("Cintra 43");

    WebElement postCodeField = driver.findElement(By.cssSelector("input[name=postcode]"));
    postCodeField.sendKeys("43-706");

    WebElement cityField = driver.findElement(By.cssSelector("input[name=city]"));
    cityField.sendKeys("Melbeurne");

    WebElement emailField = driver.findElement(By.cssSelector("input[name=email]"));
    String email = String.format("user%s@domain.com",now);
    emailField.sendKeys(email);

    WebElement phoneField = driver.findElement(By.cssSelector("input[name=phone]"));
    phoneField.sendKeys("68767890");

    WebElement passwordField = driver.findElement(By.cssSelector("input[name=password]"));
    String password = "testy1234";
    passwordField.sendKeys(password);

    WebElement password_confField = driver.findElement(By.cssSelector("input[name=confirmed_password]"));
    password_confField.sendKeys("testy1234");

    WebElement crateButton = driver.findElement(By.cssSelector("button[name=create_account]"));
    crateButton.click();

    WebElement logoutButton = driver.findElement(By.cssSelector("ul.list-vertical :nth-child(4) a"));
    logoutButton.click();

  //  driver.navigate().to("http://localhost/litecart/en/");

    WebElement loginMail = driver.findElement(By.cssSelector("input[name=email]"));
    loginMail.sendKeys(email);

    WebElement loginPassword = driver.findElement(By.cssSelector("input[name=password]"));
    loginPassword.sendKeys(password);

    WebElement loginButton = driver.findElement(By.cssSelector("button[name=login]"));
    loginButton.click();
    logoutButton.click();
  }

}
