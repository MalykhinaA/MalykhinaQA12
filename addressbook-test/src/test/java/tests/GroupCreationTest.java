package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader bReader = new BufferedReader(new FileReader( new File("src/test/resources/groups.csv")));
        String line = bReader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withHeader(split[0]).withGroupName(split[1]).withFooter(split[2])});
            line = bReader.readLine();
        }
        bReader.close();
        return list.iterator();
    }
    @Test(dataProvider = "validGroups")
    public void groupCreationTest(GroupData group) {
        //logger.info("Start test groupCreationTest");
        //openGroupPage
        app.goTo().groupsPage();
        List<GroupData> before = app.groups().getGroupList();
        //int before = app.groups().getGroupCount();
        //initGroupCreation
        app.groups().initGroupCreation();
        //fillGroupForm
        //app.groups().createGroup(new GroupData("edit", "header1", "footer1"));

        app.groups().fillGroupForm(group);
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
      //  logger.info("Finish test groupCreationTest");
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
