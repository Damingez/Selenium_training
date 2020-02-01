package ru.stqa.training.selenium;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;

public class CheckLogs extends TestBase {

  @Test
  public void checkLogsOccurence()
  {
      proxy.newHar();
      driver.navigate().to("http://www.krakow.pl/english/");
      Har har = proxy.endHar();
      har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));

    }
  }


