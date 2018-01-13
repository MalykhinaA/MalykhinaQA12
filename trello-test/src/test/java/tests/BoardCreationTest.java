package tests;

import model.BoardData;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    @Test
    public void boardCreationTest() {
        int before = app.getBoardHelper().getBoardCount();
        //initBoardCreation
        app.getBoardHelper().initBoardCreation();
        //typeBoardTitle
        app.getBoardHelper().typeBoardTitle(new BoardData("New board Title"));
        //submitBoardCreation
        app.getBoardHelper().submitBoardCreation();
        //goToBoardsPage
        app.getNavigationHelper().goToBoardsPage();
        int after = app.getBoardHelper().getBoardCount();
        Assert.assertEquals(before, after - 1);

    }


}
