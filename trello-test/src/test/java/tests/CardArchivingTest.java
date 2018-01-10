package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardArchivingTest extends TestBase {
    @Test
    public void cardArchivingTest() {
        app.openBoard();
        int listCount = app.getListCount();
        int before = app.getCardCount();
        if (listCount == 0) {
            app.addList("List Title");
        }
        if (before == 0) {
            app.addCard("new card");
            before = app.getCardCount();
        }
        //openCard
        app.openCard();
        //submitCardArchiving
        app.submitCardArchiving();
        //closeCard
        app.closeCard();
        int after = app.getCardCount();
        Assert.assertEquals(before, after + 1);

    }


}
