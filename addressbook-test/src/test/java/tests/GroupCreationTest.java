package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        //openGroupPage
        app.goTo().groupsPage();
        int before = app.groups().getGroupCount();
        //initGroupCreation
        app.groups().initGroupCreation();
        //fillGroupForm
        //app.groups().createGroup(new GroupData("edit", "header1", "footer1"));
        app.groups().fillGroupForm(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        //submitGroupCreation
        app.groups().submitGroupCreation();
        //returnToGroupPage
        app.groups().returnToGroupPage();
        int after = app.groups().getGroupCount();
        Assert.assertEquals(before, after - 1);

    }


}
