package app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AppManager {
    FirefoxDriver wd;


    //setUp
    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite();
        login("qa12Test", "qa12Test");

    }

    public void login(String userName, String password) {
        click(By.linkText("Log In"));
        type(By.id("user"), userName);
        type(By.id("password"), password);
        click(By.id("login"));
    }


    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void openSite() {
        wd.get("https://trello.com/");
    }

    //tearDown
    public void stop() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    //BoardCreationMethods
    public int getBoardCount() {
        return wd.findElements(By.xpath("//*[@class='board-tile-details-name']")).size();
    }

    public void goToBoardsPage() {
        click(By.className("header-logo-default"));
    }

    public void submitBoardCreation() {
        click(By.xpath("//*[@value='Create']"));
    }

    public void typeBoardTitle(String boardTitle) {
        type(By.id("boardNewTitle"), boardTitle);
    }

    public void initBoardCreation() {
        click(By.xpath("//*[@class ='header-btn-icon icon-lg icon-add light']"));
        click(By.className("js-new-board"));
    }

    //BoardClosingTest
    public void confirmBoardClosing() {
        click(By.xpath("//*[@class='js-confirm full negate']"));
    }

    public void initBoardClosing() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void openMoreMenu() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void openBoard() {
        click(By.className("board-tile-fade"));
    }

    //ListCreationMethods
    public void submitListCreation() {
        click(By.xpath("//*[@class='primary mod-list-add-button js-save-edit']"));
    }

    public int getListCount() {
        return wd.findElements(By.xpath("//*[@class='list js-list-content']")).size();
    }

    public void typeListTitle(String listTitle) {
        type(By.xpath("//*[@class='list-name-input']"), listTitle);
    }

    public void initListAdding() {
        click(By.xpath("//*[@class='placeholder js-open-add-list']"));
    }

    //ListArchivingMethods
    public void submitListArchiving() {
        click(By.xpath("//*[@class='js-close-list']"));
    }

    public void initListArchiving() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal']"));
    }

    //CardAddingMethod
    public void confirmCardAdding() {
        click(By.xpath("//*[@class='primary confirm mod-compact js-add-card']"));
    }

    public int getCardCount() {
        return wd.findElements(By.xpath("//*[@class='list-card-title js-card-name']")).size();
    }

    public void typeCardTitle(String cardTitle) {
        type(By.xpath("//*[@class='list-card-composer-textarea js-card-title']"), cardTitle);
    }

    public void initCardAdding() {
        click(By.xpath("//*[@class='open-card-composer js-open-card-composer']"));
    }

    //CardArchivingMethods
    public void closeCard() {
        click(By.xpath("//*[@class='icon-lg icon-close dialog-close-button js-close-window']"));
    }

    public void submitCardArchiving() {
        click(By.xpath("//*[@class='button-link js-archive-card']"));
    }

    public void openCard() {
        click(By.xpath("//*[@class='list-card-details']"));
    }

    //adds
    public void addCard(String cardTitle) {
        initCardAdding();
        typeCardTitle(cardTitle);
        confirmCardAdding();
    }

    public void addList(String listTitle) {
        initListAdding();
        typeListTitle(listTitle);
        submitListCreation();
    }
    public void boardCreation(String boardTitle) {
        initBoardCreation();
        typeBoardTitle(boardTitle);
        submitBoardCreation();
        goToBoardsPage();
    }
}
