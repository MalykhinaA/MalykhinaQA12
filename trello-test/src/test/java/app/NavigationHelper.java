package app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToBoardsPage() {
        click(By.className("header-logo-default"));
    }

    public void openBoard() {
        click(By.className("board-tile-fade"));
    }
}
