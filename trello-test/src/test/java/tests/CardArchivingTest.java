package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardArchivingTest extends TestBase {
    @Test
    public void cardArchivingTest() {
        int boardCount = app.getBoardHelper().getBoardCount();
        if (boardCount == 0) {
            app.getBoardHelper().boardCreation("New board Title");
        }
        app.getNavigationHelper().openBoard();
        int listCount = app.getListHelper().getListCount();
        int before = app.getCardHelper().getCardCount();
        if (listCount == 0) {
            app.getListHelper().addList("List Title");
        }
        if (before == 0) {
            app.getCardHelper().addCard("new card");
            before = app.getCardHelper().getCardCount();
        }
        //openCard
        app.getCardHelper().openCard();
        //submitCardArchiving
        app.getCardHelper().submitCardArchiving();
        //closeCard
        app.getCardHelper().closeCard();
        int after = app.getCardHelper().getCardCount();
        Assert.assertEquals(before, after + 1);

    }


}
