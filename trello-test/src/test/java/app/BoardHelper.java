package app;

import model.BoardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    NavigationHelper navigationHelper = new NavigationHelper(wd);

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    //BoardCreationMethods
    public int getBoardCount() {
        return wd.findElements(By.xpath("//*[@class='board-tile-details-name']")).size();
    }

    public void submitBoardCreation() {
        click(By.xpath("//*[@value='Create']"));
    }

    public void typeBoardTitle(BoardData boardData) {
        type(By.id("boardNewTitle"), "boardTitle");
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

    public void createBoard(BoardData board) {
        initBoardCreation();
        typeBoardTitle(board);
        submitBoardCreation();
    }
    public void openBoardsList() {
        click(By.className("header-btn-text"));
    }


    public void openClosedBoards() {
        click(By.xpath("//*[@class='quiet-button js-open-closed-boards']"));
    }

    public void submitBoardReopening() {
        //click(By.className("button-link js-reopen"));
        click(By.xpath("//*[@class='button-link js-reopen']"));

    }
    public void submitBoardReopeningByIndex(int index) {
        wd.findElements(By.xpath("//*[@class='button-link js-reopen']")).get(index).click();
    }
    public boolean isBoardPresent() {
        return isElementPresent(By.xpath("//*[@class='board-tile-details-name']"));
    }

    public int getClosedBoardCount() {
        return wd.findElements(By.xpath("//*[@class='button-link js-reopen']")).size();
    }


    public boolean isClosedBoardPresent() {
        return isElementPresent(By.xpath("//*[@class='button-link js-reopen']"));
    }

    public void closeBoard() {
        if (!isBoardPresent()) {
            createBoard(new BoardData("New board Title"));
        }
        navigationHelper.openBoard();
        openMoreMenu();
        initBoardClosing();
        confirmBoardClosing();
        navigationHelper.goToBoardsPage();
    }

    public void closeClosedBoardList() {
        click(By.xpath("//*[@class='icon-lg icon-close dialog-close-button js-close-window']"));
    }
}
