package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class CreateGroup extends TestBase {

    @Test
    public void createGroup() {
        //openGroupPage
        openGroupPage();
        int before = wd.findElements(By.name("selected[]")).size();
        //initGroupCreation
        initGroupCreation();
        //fillGroupForm
        fillGroupForm(new GroupData("New group", "Header", "Footer"));
        //submitGroupCreate
        submitGroupCreate();
        //returnToGroupPage
        returnToGroupPage();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(before,after-1);

    }


}
    
