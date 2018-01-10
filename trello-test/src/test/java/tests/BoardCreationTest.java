package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    @Test
    public void boardCreationTest() {
        int before = app.getBoardCount();
        //initBoardCreation
        app.initBoardCreation();
        //typeBoardTitle
        app.typeBoardTitle("New board Title");
        //submitBoardCreation
        app.submitBoardCreation();
        //goToBoardsPage
        app.goToBoardsPage();
        int after = app.getBoardCount();
        Assert.assertEquals(before, after - 1);

    }


}
