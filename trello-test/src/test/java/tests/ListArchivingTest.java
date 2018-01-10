package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListArchivingTest extends TestBase {
    @Test
    public void listArchivingTest() {
        app.openBoard();
        int before = app.getListCount();
        if (before == 0) {
            app.addList("List Title");
            before = app.getListCount();
        }
        //initListArchiving
        app.initListArchiving();
        //submitListArchiving
        app.submitListArchiving();
        int after = app.getListCount();
        Assert.assertEquals(before, after + 1);

    }


}
