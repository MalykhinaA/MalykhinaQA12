package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardReopeningTest extends TestBase{

    @Test
    public void reopenBoardTest(){
        int before = app.getBoardHelper().getBoardCount();
        app.getBoardHelper().openBoardsList();
        app.getBoardHelper().openClosedBoards();
        app.getBoardHelper().submitBoardReopening();
        app.getNavigationHelper().reloadPage();
        int after = app.getBoardHelper().getBoardCount();
        Assert.assertEquals(before, after -1);

    }




}
