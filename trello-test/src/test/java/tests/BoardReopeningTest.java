package tests;

import model.BoardData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardReopeningTest extends TestBase{

    @Test
    public void reopenBoardTest(){
        app.getBoardHelper().openBoardsList();
        app.getBoardHelper().openClosedBoards();
        if(!app.getBoardHelper().isClosedBoardPresent()){
            app.getBoardHelper().closeClosedBoardList();
            app.getBoardHelper().closeBoard();
            app.getBoardHelper().openBoardsList();
            app.getBoardHelper().openClosedBoards();
        }
        int before = app.getBoardHelper().getBoardCount();
       // app.getBoardHelper().submitBoardReopening();
        int closedBoardCount = app.getBoardHelper().getClosedBoardCount();
        app.getBoardHelper().submitBoardReopeningByIndex(closedBoardCount - 1);
        app.getNavigationHelper().reloadPage();
        int after = app.getBoardHelper().getBoardCount();
        Assert.assertEquals(before, after -1);

    }




}
