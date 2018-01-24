package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.goTo().groupsPage();
        if (!app.groups().isGroupPresent()) {
            //app.groups().createGroup(new GroupData("edit", "header1", "footer1"));
            app.groups().createGroup(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        }
        int before = app.groups().getGroupCount();

        // app.getGroupHelper().selectGroup();//selectGroup
        app.groups().selectGroupByIndex(before - 1);
        app.groups().submitGroupDeletion();//submitGroupDeletion
        //returnToGroupPage
        app.groups().returnToGroupPage();
        int after = app.groups().getGroupCount();
        Assert.assertEquals(before, after + 1);
    }


}
