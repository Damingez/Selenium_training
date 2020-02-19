package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRemote {

  @Test
  public void testIE() throws MalformedURLException {
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.106:4444/wd/hub"),
            DesiredCapabilities.internetExplorer());
    driver.navigate().to("https://www.google.pl/");
 //   driver.quit();

  }

}
/*
 hub
 node on virtual machine http://192.168.68.10:4444/wd/hub
java -jar selenium-server-standalone-3.141.59.jar -role hub
java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.106:4444/wd/hub -capabilities browserName=firefox,maxInstances=4 -capabilities browserName=chrome,maxInstances=4
(on virtual machine) java -jar selenium-server-standalone-3.141.59.jar -role node -host 192.168.68.10 -hub http://192.168.1.106:4444/wd/hub

*/