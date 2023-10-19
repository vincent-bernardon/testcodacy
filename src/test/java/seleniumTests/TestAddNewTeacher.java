package seleniumTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class TestAddNewTeacher extends BaseForTests {

    @Test
    void addNewTeacherNotAuthorized() {
        login("Lovelace", "lovelace");

        click(driver.findElement(By.id("listTeachers")));
        String StateOfPageBeforeInteraction = read(driver.findElement(By.cssSelector("table")));
        WebElement addTeacher = driver.findElement(By.id("addTeacher"));

        click(addTeacher);

        assertTrue(driver.getTitle().contains("Error"));
        click(driver.findElement(By.tagName("a")));
        click(driver.findElement(By.id("listTeachers")));
        assertEquals(StateOfPageBeforeInteraction, read(driver.findElement(By.cssSelector("table"))));
    }

    @Test
    void addNewTeacher() {
        login("Chef", "mdp");

        click(driver.findElement(By.id("listTeachers")));

        click(driver.findElement(By.id("addTeacher")));

        write(driver.findElement(By.id("firstName")), "toma");
        write(driver.findElement(By.id("lastName")), "dopo");
        click(driver.findElement(By.cssSelector("[type=submit]")));
        String page = read(driver.findElement(By.cssSelector("table")));
        assertTrue(page.contains("dopo"));
        try {
            screenshot("teacherList");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
