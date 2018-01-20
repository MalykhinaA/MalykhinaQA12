package tests;

import model.BoardData;
import model.CardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardAddingTest extends TestBase {
    @Test
    public void cardAddingTest() {
        if (!app.getBoardHelper().isBoardPresent()) {
            app.getBoardHelper().createBoard(new BoardData("New board Title"));
        }
        int boardCount = app.getBoardHelper().getBoardCount();
        app.getNavigationHelper().openBoardByIndex(boardCount - 1);
        if (!app.getListHelper().isListPresent()) {
            app.getListHelper().addList(new ListData("title of list"));
        }
        int listCount = app.getListHelper().getListCount();
        int before = app.getCardHelper().getCardCount();
        app.getListHelper().openListActionsByIndex(listCount-1);
        app.getCardHelper().initCardAdding();
        app.getCardHelper().typeCardTitle(new CardData("new card"));
        app.getCardHelper().confirmCardAdding();
        int after = app.getCardHelper().getCardCount();
        Assert.assertEquals(before, after - 1);
    }




}
