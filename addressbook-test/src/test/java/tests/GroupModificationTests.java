package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void groupModifyTest() {
        app.goTo().openGroupPage();
        if (!app.groups().isGroupPresent()) {
            //app.groups().createGroup(new GroupData("name","header1",null));
            app.groups().createGroup(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        }
        int before = app.groups().getGroupCount();
        // app.getGroupHelper().selectGroup();
        app.groups().selectGroupByIndex(before - 1);
        app.groups().initGroupModification();
        //app.groups().fillGroupForm(new GroupData("edit", null, ""));
        app.groups().fillGroupForm(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        app.groups().confirmGroupModification();
        app.groups().returnToGroupPage();
        int after = app.groups().getGroupCount();
        Assert.assertEquals(before, after);

    }
}
