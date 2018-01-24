package tests;

import model.BoardData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardClosingTest extends TestBase {

    @Test
    public void BoardClosingTest() {
        if (!appManager.boards().isBoardPresent()) {
            appManager.boards().createBoard(new BoardData().withBoardTitle("New board Title"));
        }
        int before = appManager.boards().getBoardCount();
        //openBoard
        //app.getNavigationHelper().openBoard();
        appManager.goTo().openBoardByIndex(before - 1);
        //openMoreMenu
        appManager.boards().openMoreMenu();
        //initBoardClosing
        appManager.boards().initBoardClosing();
        //confirmBoardClosing
        appManager.boards().confirmBoardClosing();
        appManager.goTo().boardsPage();
        int after = appManager.boards().getBoardCount();
        Assert.assertEquals(before, after + 1);
    }


}
