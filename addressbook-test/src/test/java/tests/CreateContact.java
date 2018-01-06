package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class CreateContact extends TestBase {

    @Test
    public void createContact() {
        int before = wd.findElements(By.xpath("//*[@title='vCard']")).size();
        //initCreationContact
        initCreationContact();
        //fillContactForm
        fillContactForm("Name", "Surname", "1970");
        //submitCreationContact
        submitCreateContact();
        int after = wd.findElements(By.xpath("//*[@title='vCard']")).size();
        Assert.assertEquals(before+1, after);
    }

}
