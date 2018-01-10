package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardClosingTest extends TestBase {

    @Test
    public void BoardClosingTest() {
        int before = app.getBoardCount();
        if(before == 0){
            app.boardCreation("New board Title");
        }
        //openBoard
        app.openBoard();
        //openMoreMenu
        app.openMoreMenu();
        //initBoardClosing
        app.initBoardClosing();
        //confirmBoardClosing
        app.confirmBoardClosing();
        app.goToBoardsPage();
        int after = app.getBoardCount();
        Assert.assertEquals(before, after + 1);
    }




}
