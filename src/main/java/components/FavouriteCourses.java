package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;


// @Component("xpath://section[.//*[text()='%s']]")
// @Component("xpath://*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div/a")
@Component("//div[text()='%s']")
public class FavouriteCourses extends AbsComponent<FavouriteCourses> {
  // @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div/a")
  // private final List<WebElement> listItems = getComponentEntity().findElements(By.xpath(".//a[.div]"));

  private final DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
          .appendPattern("dd MMMM")
          .parseDefaulting(ChronoField.YEAR, 2024)
          .toFormatter(Locale.forLanguageTag("ru"));

  public FavouriteCourses(WebDriver driver) {
    super(driver);
  }


  @Override
  public WebElement $(By componentLocator) {
    return null;
  }

  public String getTitle() {
    return driver.findElement(By.tagName("h5")).getText();
  }

  public void clickItem(String title) {
    // getComponentEntity().findElement(By.xpath(String.format("xpath://section[.//*[text()='%s']]", name))).click();
    getComponentEntity(title).click();
    // return new CoursesPage(driver);
  }

  //  public String getItemName(int index) {
  //    return getComponentEntity().findElements(By.xpath(".//a[./div]")).get(--index).findElement(By.xpath(".//div[2]")).getText();
  //  }

  public LocalDate getStartDate(String title) {
    System.out.println("@#$ before");
    WebElement elem = getComponentEntity(title);
    System.out.println("@#$ after");
    System.out.println(elem);
    List<WebElement> spans = elem.findElements(By.tagName("span"));

    for (WebElement span : spans) {
      String spanText = span.getText();
      String[] parsedSpanText = spanText.split(" ");
      if (spanText.startsWith("С") && parsedSpanText.length == 5) {
        return LocalDate.parse(
                String.join(" ", parsedSpanText[1], parsedSpanText[2]),
                dateTimeFormatter
        );
      }
    }

    return LocalDate.EPOCH;
  }
}
