package tests;

import model.BoardData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardReopeningTest extends TestBase{

    @Test
    public void reopenBoardTest(){
        appManager.boards().openBoardsList();
        appManager.boards().openClosedBoards();
        if(!appManager.boards().isClosedBoardPresent()){
            appManager.boards().closeClosedBoardList();
            if(!appManager.boards().isBoardPresent()){
                appManager.boards().createBoard(new BoardData().withBoardTitle("Board Title"));
            }
            appManager.boards().closeBoard();
            appManager.boards().openBoardsList();
            appManager.boards().openClosedBoards();
        }
        int before = appManager.boards().getBoardCount();
       // app.getBoardHelper().submitBoardReopening();
        int closedBoardCount = appManager.boards().getClosedBoardCount();
        appManager.boards().submitBoardReopeningByIndex(closedBoardCount - 1);
        appManager.goTo().reloadPage();
        int after = appManager.boards().getBoardCount();
        Assert.assertEquals(before, after -1);


    }




}
