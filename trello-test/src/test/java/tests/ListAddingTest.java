package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListAddingTest extends TestBase {

    @Test
    public void listAddingTest() {
        app.openBoard();
        int before = app.getListCount();
        app.initListAdding();
        app.typeListTitle("List Title");
        app.submitListCreation();
        int after = app.getListCount();
        Assert.assertEquals(before, after - 1);

    }
}
