package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToBoardsPage() {
        click(By.className("header-logo-default"));
    }

    public void openBoard() {
        click(By.className("board-tile-fade"));
    }
    public void reloadPage() {
        wd.navigate().refresh();
    }
}
