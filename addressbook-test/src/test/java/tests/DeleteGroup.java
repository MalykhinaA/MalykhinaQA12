package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {
    @Test
    public void deleteGroupTest() {
        app.openGroupPage();
        int before = app.getGroupCount();
        //selectGroupTodelete
        app.selectGroupTodelete();
        //submitGroupDelete
        app.submitGroupDelete();
        //returnToGroupPage
        app.returnToGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(before, after+1);
    }



}
