package pages;

import org.openqa.selenium.WebDriver;
import pageobject.AbsPageObject;

public abstract class AbsBasePage<T> extends AbsPageObject {

  private final static String BASE_URL = System.getProperty("browser",  "https://otus.ru");
  private String path = "";
  public AbsBasePage(WebDriver driver, String path) {
    super(driver);

    this.path = path;
  }

  public AbsBasePage(WebDriver driver) {
    super(driver);
  }

  public T open() {
    String url = BASE_URL;

    if (!BASE_URL.endsWith("/")) {
      url += "/";
    }

    driver.get(url + path);

    return (T) this;
  }


}
