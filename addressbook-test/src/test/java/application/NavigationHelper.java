package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupsPage() {

        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups") && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }


    public void homePage() {
        if (isElementPresent(By.tagName("strong")) && wd.findElement(By.tagName("strong")).getText().equals("Number of results: ")) {
            return;
        }
        click(By.linkText("home"));
    }
}
