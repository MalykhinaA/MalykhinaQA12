package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListArchivingTest extends TestBase {
    @Test
    public void listArchivingTest() {
        app.getNavigationHelper().openBoard();
        int before = app.getListHelper().getListCount();
        if (before == 0) {
            app.getListHelper().addList("List Title");
            before = app.getListHelper().getListCount();
        }
        //initListArchiving
        app.getListHelper().initListArchiving();
        //submitListArchiving
        app.getListHelper().submitListArchiving();
        int after = app.getListHelper().getListCount();
        Assert.assertEquals(before, after + 1);

    }


}
