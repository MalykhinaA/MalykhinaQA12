package tests;

import model.BoardData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardClosingTest extends TestBase {

    @Test
    public void BoardClosingTest() {
        if (!app.getBoardHelper().isBoardPresent()) {
            app.getBoardHelper().createBoard(new BoardData("New board Title"));
        }
        int before = app.getBoardHelper().getBoardCount();
        //openBoard
        //app.getNavigationHelper().openBoard();
        app.getNavigationHelper().openBoardByIndex(before - 1);
        //openMoreMenu
        app.getBoardHelper().openMoreMenu();
        //initBoardClosing
        app.getBoardHelper().initBoardClosing();
        //confirmBoardClosing
        app.getBoardHelper().confirmBoardClosing();
        app.getNavigationHelper().goToBoardsPage();
        int after = app.getBoardHelper().getBoardCount();
        Assert.assertEquals(before, after + 1);
    }


}
