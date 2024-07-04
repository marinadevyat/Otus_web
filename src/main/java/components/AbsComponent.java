package components;

import actions.CommonActions;
import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.StandartWaiter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbsComponent<T> extends CommonActions<T> {
  private StandartWaiter waiter;

  protected String baseLocator;

  protected Actions actions;

  protected String title = "";

  public void setTitle(String title) {
    this.title = title;
  }

  public AbsComponent(WebDriver driver) {
    super(driver);
    actions = new Actions(driver);

  }

  public void click() {
    waiter.waitForCondition(ExpectedConditions.stalenessOf((WebElement) driver));
    actions.click((WebElement) driver);
  }
  public WebElement getComponentEntity(String title) {
    // System.out.println("@#$%");
    // System.out.println(getComponentLocator());
    setTitle(title);
    return driver.findElement(getComponentLocator());
    // return $(getComponentLocator());
    // return null;

  }

  private By getComponentLocator() {
    Component component = getClass().getAnnotation(Component.class);

    if (component != null) {
      String value = component.value();

      if(!this.title.isEmpty()) {
        value = String.format(value, this.title);
      }

      String searchStrategy = "";
      Pattern pattern = Pattern.compile("^(\\w+):.+?");
      Matcher matcher = pattern.matcher(value);
      if (matcher.find()) {
        searchStrategy = matcher.group(1).toLowerCase(Locale.ROOT);
      }

      switch (searchStrategy) {
        case "xpath":
          return By.xpath(value.replace(String.format(searchStrategy), ""));
        default:
          return By.xpath(value);
      }
    }

    return null;
  }
}