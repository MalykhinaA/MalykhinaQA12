package tests;

import model.BoardData;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    @Test
    public void boardCreationTest() throws InterruptedException {
        int before = appManager.boards().getBoardCount();
        //initBoardCreation
        appManager.boards().initBoardCreation();
        //typeBoardTitle
        appManager.boards().typeBoardTitle(new BoardData().withBoardTitle("New board Title"));
        //submitBoardCreation
        appManager.boards().submitBoardCreation();
        appManager.goTo().pause(2000);
        //goToBoardsPage
        appManager.goTo().boardsPage();
        int after = appManager.boards().getBoardCount();
        Assert.assertEquals(before, after - 1);

    }




}
