package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardClosingTest extends TestBase {

    @Test
    public void BoardClosingTest() {
        int before = app.getBoardHelper().getBoardCount();
        if(before == 0){
            app.getBoardHelper().boardCreation("New board Title");
        }
        //openBoard
        app.getNavigationHelper().openBoard();
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
