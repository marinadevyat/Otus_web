package ui.courses;

import components.FavouriteCourses;
import extensions.GuiceExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;


@ExtendWith(GuiceExtension.class)
public class CoursesPageTest {

  @Inject
  private MainPage mainPage;

  @Inject
  private FavouriteCourses favouriteCourses;
  @Test
  public void click_favourite_course() throws InterruptedException {
    mainPage.open();
    favouriteCourses
        .clickItem("Тестирование");
  }
  @Test
  public void testProgramByEarliestStartDate() throws InterruptedException {
    mainPage
            .open()
            .selectProgramByEarliestStartDate();
  }

  @Test
  public void testProgramByLatestStartDate() throws InterruptedException {
    mainPage
            .open()
            .selectProgramByLatestStartDate();
  }

}
