package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.getNavigationHelper().openGroupPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup(new GroupData("edit", "header1", "footer1"));
        }
        int before = app.getGroupHelper().getGroupCount();

       // app.getGroupHelper().selectGroup();//selectGroupTodelete
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().submitGroupDeletion();//submitGroupDeletion
        //returnToGroupPage
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after + 1);
    }


}
