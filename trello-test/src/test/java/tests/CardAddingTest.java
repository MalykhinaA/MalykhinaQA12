package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CardAddingTest extends TestBase {
    @Test
    public void cardAddingTest() {
        app.openBoard();
        int listCount = app.getListCount();
        if (listCount == 0) {
            app.initListAdding();
            app.typeListTitle("List Title");
            app.submitListCreation();
        }
        int before = app.getCardCount();
        //initCardAdding
        app.initCardAdding();
        //typeCardTitle
        app.typeCardTitle("new card");
        //confirmCardAdding
        app.confirmCardAdding();
        int after = app.getCardCount();
        Assert.assertEquals(before, after - 1);
    }


}
