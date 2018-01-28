package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.goTo().groupsPage();
        if (!app.groups().isGroupPresent()) {
            //app.groups().createGroup(new GroupData("edit", "header1", "footer1"));
            app.groups().createGroup(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        }

        //int before = app.groups().getGroupCount();
        List<GroupData> before = app.groups().getGroupList();
        int index = before.size() - 1;
        // app.getGroupHelper().selectGroup();//selectGroup
        app.groups().selectGroupByIndex(index);
        app.groups().submitGroupDeletion();//submitGroupDeletion
        //returnToGroupPage
        app.groups().returnToGroupPage();
        //int after = app.groups().getGroupCount();
        List<GroupData> after = app.groups().getGroupList();

        Assert.assertEquals(after.size(),index);
        before.remove(index);
        Assert.assertEquals(before,after);
    }


}
