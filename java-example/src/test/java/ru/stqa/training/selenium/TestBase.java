package ru.stqa.training.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

  public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
  public EventFiringWebDriver driver;
  public WebDriverWait wait;
  public BrowserMobProxy proxy;

  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + "found");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + "found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);

      /*File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      try {
        Files.copy(tempFile, new File("screen.png")); compliler cannot resolve this method
      } catch (IOException e) {
        e.printStackTrace();
      }*/

    }
  }

  @Before
  public void start() {
    if (tlDriver.get() != null) {
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, 10);
      return;
    }
   // driver = new EventFiringWebDriver ( new FirefoxDriver());

    // start the proxy
    proxy = new BrowserMobProxyServer();
    proxy.start(0);

    // get the Selenium proxy object
    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
    
    // configure it as a desired capability
    DesiredCapabilities capabilities = new DesiredCapabilities();
    Proxy proxy = new Proxy();
    proxy.setHttpProxy("localhost:8888");
    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

    driver = new EventFiringWebDriver(new ChromeDriver());
    driver.register(new MyListener());
    tlDriver.set(driver);
    wait = new WebDriverWait(driver, 10);

 //   Runtime.getRuntime().addShutdownHook(
 //           new Thread(() -> { driver.quit(); driver = null; }));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }


}
