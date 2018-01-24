package tests;

import model.BoardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListArchivingTest extends TestBase {
    @Test
    public void listArchivingTest() {

        if (!appManager.boards().isBoardPresent()) {
            appManager.boards().createBoard(new BoardData().withBoardTitle("New board Title"));
        }
        appManager.goTo().pause(2000);
        int boardCount = appManager.boards().getBoardCount();
        appManager.goTo().openBoardByIndex(boardCount - 1);

        if (!appManager.lists().isListPresent()) {
            appManager.lists().addList(new ListData().withListTitle("List Title"));
        }
        int before = appManager.lists().getListCount();

       // app.getListHelper().openListActions();
        appManager.lists().openListActionsByIndex(before - 1);
        //submitListArchiving
        appManager.lists().submitListArchiving();
        int after = appManager.lists().getListCount();
        Assert.assertEquals(before, after + 1);
        appManager.goTo().boardsPage();

    }


}
