package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {
    @Test
    public void deleteGroup() {
        openGroupPage();
        int before = wd.findElements(By.name("selected[]")).size();
        //selectGroupTodelete
        selectGroupTodelete();
        //submitGroupDelete
        submitGroupDelete();
        //returnToGroupPage
        returnToGroupPage();
        int after = wd.findElements(By.name("selected[]")).size();
        Assert.assertEquals(before, after+1);
    }

}
