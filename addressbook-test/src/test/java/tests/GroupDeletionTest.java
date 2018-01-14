package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.getNavigationHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        //selectGroupTodelete
        app.getGroupHelper().selectGroupTodelete();
        //submitGroupDelete
        app.getGroupHelper().submitGroupDelete();
        //returnToGroupPage
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after + 1);
    }


}
