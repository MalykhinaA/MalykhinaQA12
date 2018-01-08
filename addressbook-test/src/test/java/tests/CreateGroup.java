package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGroup extends TestBase {

    @Test
    public void createGroup() {
        //openGroupPage
        app.openGroupPage();
        int before = app.wd.findElements(By.name("selected[]")).size();
        //initGroupCreation
        app.initGroupCreation();
        //fillGroupForm
        app.fillGroupForm(new GroupData("New group", "Header", "Footer"));
        //submitGroupCreate
        app.submitGroupCreate();
        //returnToGroupPage
        app.returnToGroupPage();
        int after = app.wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(before,after-1);

    }


}
    
