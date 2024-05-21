package news;

import static java.lang.Thread.sleep;

import annotations.Driver;
import exceptions.BrowserNotSupportedExceptions;
import extensions.UIReflectionExtension;
import factory.FactoryWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


@ExtendWith(UIReflectionExtension.class)
public class CoursesPageTest {

  @Driver
  private WebDriver driver;

  @BeforeEach
  public void init() throws BrowserNotSupportedExceptions {
    FactoryWebDriver driverFactory = new FactoryWebDriver();
    //driver = driverFactory.create();
  }

  @Test

  public void newsPageOpened() throws InterruptedException {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    String nameCourse = "Тестирование";
    //mainPage.navigateToCourses(nameCourse);
    sleep(10000);
  }

  //@AfterEach
  //public void closeAll() {
  //if (driver != null) {
  //driver.close();
  //driver.quit();
  //}
  //}

}
