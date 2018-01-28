package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void groupModifyTest() {
        app.goTo().groupsPage();
        if (!app.groups().isGroupPresent()) {
            //app.groups().createGroup(new GroupData("name","header1",null));
            app.groups().createGroup(new GroupData().withGroupName("GroupName").withHeader("Header").withFooter("Footer"));
        }
       // int before = app.groups().getGroupCount();
        List<GroupData> before = app.groups().getGroupList();
        // app.getGroupHelper().selectGroup();
        int index = before.size() - 1;
        app.groups().selectGroupByIndex(index);
        app.groups().initGroupModification();

        GroupData editedGroup = new GroupData().withId(before.get(index).getId())
                .withGroupName(app.getHelperBase().generateRandomString(10))
                .withHeader("HeaderEdit")
                .withFooter("FooterEdit");
        app.groups().fillGroupForm(editedGroup);
        app.groups().confirmGroupModification();
        app.groups().returnToGroupPage();
        //int after = app.groups().getGroupCount();
        List<GroupData> after = app.groups().getGroupList();
        Assert.assertEquals(before.size(), after.size());
        before.remove(index);
        before.add(editedGroup);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//        boolean flag = false;
//        for(int i = after.size()-1; i >=0 ; i--){
//            if (after.get(i).equals(editedGroup)) {
//                flag = true;
//            } else if (!before.contains(after.get(i))) {
//                flag = false;
//                return;
//            }
//            before.remove(after.get(i));
//            after.remove(i);
//        }
//        assertEquals(flag, true);
    }
}
