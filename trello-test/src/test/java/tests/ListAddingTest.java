package tests;

import model.BoardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListAddingTest extends TestBase {

    @Test
    public void listAddingTest() {
        if (!appManager.boards().isBoardPresent()) {
            appManager.boards().createBoard(new BoardData().withBoardTitle("New board Title"));
        }
        appManager.goTo().pause(2000);
        int boardCount = appManager.boards().getBoardCount();
        appManager.goTo().openBoardByIndex(boardCount - 1);

        int before = appManager.lists().getListCount();
        appManager.lists().initListAdding();
        appManager.lists().typeListTitle(new ListData().withListTitle("List Title"));
        appManager.lists().submitListCreation();
        int after = appManager.lists().getListCount();
        Assert.assertEquals(before, after - 1);
        appManager.goTo().boardsPage();

    }
}
