package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AbsPageObject;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbsBasePage<T> extends AbsPageObject {

  private final static String BASE_URL = System.getProperty("base.url");
  private String path = "";
  public AbsBasePage(WebDriver driver, String path) {
    super(driver);

    this.path = path;
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
