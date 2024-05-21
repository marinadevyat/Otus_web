package factory.impl;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSettings implements IBrowserSettings{
  @Override
  public MutableCapabilities getSettings() {
    FirefoxOptions firefoxOptions = new FirefoxOptions();

    return new FirefoxOptions();
  }
}
