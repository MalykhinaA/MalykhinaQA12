package tests;

import model.CardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardAddingTest extends TestBase {
    @Test
    public void cardAddingTest() {
        app.getNavigationHelper().openBoard();
        int listCount = app.getListHelper().getListCount();
        if (listCount == 0) {
            app.getListHelper().initListAdding();
            app.getListHelper().typeListTitle(new ListData("List Title"));
            app.getListHelper().submitListCreation();
        }
        int before = app.getCardHelper().getCardCount();
        //initCardAdding
        app.getCardHelper().initCardAdding();
        //typeCardTitle
        app.getCardHelper().typeCardTitle(new CardData("new card"));
        //confirmCardAdding
        app.getCardHelper().confirmCardAdding();
        int after = app.getCardHelper().getCardCount();
        Assert.assertEquals(before, after - 1);
    }


}
