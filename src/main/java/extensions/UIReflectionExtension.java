package extensions;

import annotations.Driver;
import factory.FactoryWebDriver;
import listeners.ActionsListener;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Field;

public class UIReflectionExtension implements BeforeEachCallback, AfterEachCallback {

  private WebDriver driver = null;
  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    if(driver !=null) {
      driver.close();
      driver.quit();
    }

  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    driver = new FactoryWebDriver().getDriver();
    driver.get(new ActionsListener().toString());

    Class clazz = extensionContext.getTestInstance().getClass();
    Field[] fields = clazz.getDeclaredFields();
    for(Field field: fields) {
      if (field.isAnnotationPresent(Driver.class) && field.getType().equals(WebDriver.class)) {
        field.setAccessible(true);
        field.set(extensionContext.getTestInstance(), driver);
      }
    }

  }
}
