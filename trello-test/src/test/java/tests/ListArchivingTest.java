package tests;

import model.BoardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListArchivingTest extends TestBase {
    @Test
    public void listArchivingTest() {

        if (!app.getBoardHelper().isBoardPresent()) {
            app.getBoardHelper().createBoard(new BoardData("New board Title"));
        }
        int boardCount = app.getBoardHelper().getBoardCount();
        app.getNavigationHelper().openBoardByIndex(boardCount - 1);

        if (!app.getListHelper().isListPresent()) {
            app.getListHelper().addList(new ListData("List Title"));
        }
        int before = app.getListHelper().getListCount();

       // app.getListHelper().openListActions();
        app.getListHelper().openListActionsByIndex(before - 1);
        //submitListArchiving
        app.getListHelper().submitListArchiving();
        int after = app.getListHelper().getListCount();
        Assert.assertEquals(before, after + 1);

    }


}
