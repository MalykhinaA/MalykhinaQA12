package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToBoardsPage() {
        if(isElementPresent(By.tagName("h3")) &&
                wd.findElement(By.tagName("h3")).getText().equals("Personal Boards") &&
                    isElementPresent(By.xpath("//a[@class='board-tile mod-add']"))) {
            return;
        }
        click(By.className("header-logo-default"));
    }

    public void openBoard() {
        click(By.className("board-tile-fade"));
    }
    public void reloadPage() {
        wd.navigate().refresh();
    }

    public void openBoardByIndex(int index) {
        wd.findElements(By.className("board-tile-fade")).get(index).click();
    }
}
