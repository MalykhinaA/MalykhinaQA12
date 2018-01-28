package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void groupCreationTest() {
        //openGroupPage
        app.goTo().groupsPage();
        List<GroupData> before = app.groups().getGroupList();
        //int before = app.groups().getGroupCount();
        //initGroupCreation
        app.groups().initGroupCreation();
        //fillGroupForm
        //app.groups().createGroup(new GroupData("edit", "header1", "footer1"));
        GroupData newGroup = new GroupData().withGroupName("GroupName1").withHeader("Header").withFooter("Footer");
        app.groups().fillGroupForm(newGroup);
        //submitGroupCreation
        app.groups().submitGroupCreation();
        //returnToGroupPage
        app.groups().returnToGroupPage();
        //int after = app.groups().getGroupCount();
        List<GroupData> after = app.groups().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        Collections.sort(after);
        before.add(after.get(after.size()-1));
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//        boolean flag = false;
//        for (int i = after.size() - 1; i >= 0; i--) {
//            if (after.get(i).equals(newGroup)) {
//                flag = true;
//            } else if (!before.contains(after.get(i))) {
//                flag = false;
//                return;
//            }
//            before.remove(after.get(i));
//            after.remove(i);
//
//        }
//        assertEquals(flag, true);

    }


}
