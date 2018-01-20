package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void groupModifyTest(){
        app.getNavigationHelper().openGroupPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup(new GroupData("name","header1",null));
        }
        int before = app.getGroupHelper().getGroupCount();
       // app.getGroupHelper().selectGroup();
        app.getGroupHelper().selectGroupByIndex(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("edit", null, ""));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);

    }
}
