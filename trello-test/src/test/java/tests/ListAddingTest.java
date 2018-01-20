package tests;

import model.BoardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListAddingTest extends TestBase {

    @Test
    public void listAddingTest() {
        if (!app.getBoardHelper().isBoardPresent()) {
            app.getBoardHelper().createBoard(new BoardData("New board Title"));
        }
        int boardCount = app.getBoardHelper().getBoardCount();
        app.getNavigationHelper().openBoardByIndex(boardCount - 1);

        int before = app.getListHelper().getListCount();
        app.getListHelper().initListAdding();
        app.getListHelper().typeListTitle(new ListData("List Title"));
        app.getListHelper().submitListCreation();
        int after = app.getListHelper().getListCount();
        Assert.assertEquals(before, after - 1);

    }
}
