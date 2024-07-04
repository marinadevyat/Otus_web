package pages;

import annotations.PageValidation;
import org.openqa.selenium.WebDriver;
@PageValidation("template://div[text()='%s']")
public class CoursesPage extends AbsBasePage<CoursesPage> {


  public CoursesPage(WebDriver driver) {
    super(driver);

  }


}
