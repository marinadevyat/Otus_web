package actions;

import factory.FactoryWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.Objects;


public class CommonActions<T> {

  protected final WebDriver driver;
  private final Actions actions;

  public CommonActions(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    actions = new Actions(driver);
  }

  public WebElement $(By locator) {
    return driver.findElement(locator);

  }
  public void click(WebElement element) {
    if (Objects.equals(FactoryWebDriver.BROWSER_NAME, "chrome")) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
      actions.pause(Duration.ofSeconds(1));
    }
    actions
            .moveToElement(element)
            .pause(Duration.ofSeconds(1))
            .click()
            .pause(Duration.ofSeconds(1))
            .perform();
  }


}
