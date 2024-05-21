package factory.impl;


import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChromeSettings implements IBrowserSettings{
  @Override
  public ChromeOptions getSettings() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-fullscreen");
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.addArguments("--remote-allow-origins=*");

    return chromeOptions;

  }
}
