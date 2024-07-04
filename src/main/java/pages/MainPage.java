package pages;

import exceptions.ProgramCardNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage extends AbsBasePage<MainPage> {
  public MainPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getSpecCard(int index) {
    List<WebElement> specCards = driver.findElements(
        By.xpath("//section[./h2[text()='Специализации']]/div/div")
    );
    if (specCards.size() <= index) {
      throw new IllegalArgumentException("index must be greater than count of specialization cards");
    }
    return specCards.get((specCards.size() + index) % specCards.size());
  }

  public void selectProgramByEarliestStartDate() {
    try {
      getSpecCard(0).click();
    } catch (IllegalArgumentException exc) {
      throw new ProgramCardNotFoundException(exc);
    }
  }

  public void selectProgramByLatestStartDate() {
    try {
      getSpecCard(- 1).click();
    } catch (IllegalArgumentException exc) {
      throw new ProgramCardNotFoundException(exc);
    }
  }
}
