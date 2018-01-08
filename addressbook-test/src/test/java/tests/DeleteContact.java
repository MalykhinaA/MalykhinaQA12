package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;

public class DeleteContact extends TestBase {
    @Test
    public void deleteContact() {
        int before = wd.findElements(By.xpath("//*[@title='vCard']")).size();
        //selectContactDelete
        selectContactDelete();
        //submitContactDelete
        submitContactDelete();
        alertAccept();
        int after = wd.findElements(By.xpath("//*[@title='vCard']")).size();
        Assert.assertEquals(before, after+1);




    }

}
