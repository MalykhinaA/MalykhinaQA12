package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void groupModifyTest(){
        app.getNavigationHelper().openGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("edit", null, ""));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupPage();

    }
}
