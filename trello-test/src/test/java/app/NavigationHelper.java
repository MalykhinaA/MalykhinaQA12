package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void boardsPage() {
        if(isElementPresent(By.tagName("h3")) &&
                wd.findElement(By.tagName("h3")).getText().equals("Personal Boards") &&
                    isElementPresent(By.xpath("//a[@class='board-tile mod-add']"))) {
            return;
        }
        click(By.xpath("//*[@class='header-logo-default']"));
    }

    public void openBoard() {
        click(By.className("board-tile-details is-badged"));
    }
    public void reloadPage() {
        wd.navigate().refresh();
    }
    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openBoardByIndex(int index) {
        wd.findElements(By.xpath("//*[@class='board-tile-details is-badged']")).get(index).click();
    }

}
