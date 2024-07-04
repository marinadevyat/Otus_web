package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import components.FavouriteCourses;
import factory.FactoryWebDriver;
import org.openqa.selenium.WebDriver;
import pages.CoursesPage;
import pages.MainPage;


public class GuiceModule extends AbstractModule {

  private final WebDriver driver = new FactoryWebDriver().create();


  @Provides
  @Singleton
  public WebDriver getDriver() {
    return driver;
  }

  @Provides
  @Singleton
  public MainPage getMainPage() {
    return new MainPage(driver);
  }

  @Provides
  @Singleton
  public CoursesPage getCoursesPage() {
    return new CoursesPage(driver);
  }

  @Provides
  @Singleton
  public FavouriteCourses getFavouriteCourses() {
    return new FavouriteCourses(driver);
  }
}
