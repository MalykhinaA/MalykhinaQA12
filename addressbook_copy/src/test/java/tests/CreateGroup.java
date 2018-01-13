package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGroup extends TestBase {

    @Test
    public void createGroupTest() {
        //openGroupPage
        app.openGroupPage();
        int before = app.getGroupCount();
        //initGroupCreation
        app.initGroupCreation();
        //fillGroupForm
        app.fillGroupForm(new GroupData("New group", "Header", "Footer"));
        //submitGroupCreate
        app.submitGroupCreate();
        //returnToGroupPage
        app.returnToGroupPage();
        int after = app.getGroupCount();
        Assert.assertEquals(before,after-1);

    }


}
    
