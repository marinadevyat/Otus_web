package factory.impl;


import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSettings implements IBrowserSettings{
  @Override
  public ChromeOptions getSettings() {
    ChromeOptions chromeOptions = new ChromeOptions();
    //chromeOptions.addArguments("--kiosk");
    //chromeOptions.addArguments("--start-full screen");
    //chromeOptions.addArguments("disable-info bars");
    //chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.addArguments("--no-first-run");
    chromeOptions.addArguments("--homepage=about:blank");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("start-maximized");

    return chromeOptions;

  }
}
