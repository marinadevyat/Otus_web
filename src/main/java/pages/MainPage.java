package pages;
import static java.lang.Thread.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage<MainPage> {

  public MainPage(WebDriver driver) {
    super(driver, "/");
  }

  public CoursesPage navigateToCourses(String nameCourse) throws InterruptedException {

    //driver.registerListener(new ListenerThatHiglilightsElementsBeforeAnyAction(3, 500, TimeUnit.MILLISECONDS));
    driver.findElement(By.xpath("//div[text() = 'Тестирование']")).click();
    //sleep(10000);
    //String criteria = String.format("//div[text() = 'Тестироване']", nameCourse);
    //WebElement button = waitForElement(By.xpath("//div[text() = 'Тестирование']"));button.click();
    return new CoursesPage(driver);

  }
}