package factory;

import exceptions.BrowserNotSupportedExceptions;
import factory.impl.ChromeSettings;
import factory.impl.IBrowserSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ActionsListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class FactoryWebDriver {

  private final String browserName = System.getProperty("browser", "Chrome");
  private final String browserVersion = System.getProperty("brower.vertion", "120.0");



  public WebDriver getDriver() throws BrowserNotSupportedExceptions {
    switch (browserName) {
      case "Chrome": {
        WebDriverManager.chromedriver().setup();
        ChromeSettings browserSettings = new ChromeSettings();
        return new EventFiringDecorator<>(new ActionsListener())
                .decorate(new ChromeDriver(browserSettings.getSettings()));


      }

        default:
          throw new WebDriverException(browserName);
    }
    
  }
}
