package factory;

import exceptions.BrowserNotSupportedExceptions;
import factory.impl.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ActionsListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import java.util.Locale;


public class FactoryWebDriver {

  public static final String BROWSER_NAME = System.getProperty("browser.name", "chrome");
  private final String browserVersion = System.getProperty("browser.version", "125.0");



  public WebDriver create() throws BrowserNotSupportedExceptions {
    switch (BROWSER_NAME.toLowerCase(Locale.ROOT)) {
      case "chrome": {
        WebDriverManager.chromiumdriver().browserVersion(browserVersion).setup();
        ChromeSettings browserSettings = new ChromeSettings();
        return new EventFiringDecorator<>(new ActionsListener())
                .decorate(new ChromeDriver(browserSettings.getSettings()));


      }

      default:
        throw new WebDriverException(BROWSER_NAME);
    }

  }
}
