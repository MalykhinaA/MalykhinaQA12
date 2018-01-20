package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        //openGroupPage
        app.getNavigationHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        //initGroupCreation
        app.getGroupHelper().initGroupCreation();
        //fillGroupForm
        app.getGroupHelper().fillGroupForm(new GroupData("New group", null, "Footer"));
        //submitGroupCreation
        app.getGroupHelper().submitGroupCreation();
        //returnToGroupPage
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after - 1);

    }


}
    
