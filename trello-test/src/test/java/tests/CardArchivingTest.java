package tests;

import model.BoardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardArchivingTest extends TestBase {
    @Test
    public void cardArchivingTest() {
        if (!app.getBoardHelper().isBoardPresent()) {
            app.getBoardHelper().createBoard(new BoardData("New board Title"));
        }
        int boardCount = app.getBoardHelper().getBoardCount();
       // app.getNavigationHelper().openBoard();
        app.getNavigationHelper().openBoardByIndex(boardCount - 1);
        if (!app.getListHelper().isListPresent()) {
            app.getListHelper().addList(new ListData("List Title"));
        }
        if (!app.getCardHelper().isCardPresent()) {
            app.getCardHelper().addCard("new card");
        }
        int before = app.getCardHelper().getCardCount();
        //app.getCardHelper().openCard();
        app.getCardHelper().openCardByIndex(before - 1);
        //submitCardArchiving
        app.getCardHelper().submitCardArchiving();
        //closeCard
        app.getCardHelper().closeCard();
        int after = app.getCardHelper().getCardCount();
        Assert.assertEquals(before, after + 1);

    }


}
