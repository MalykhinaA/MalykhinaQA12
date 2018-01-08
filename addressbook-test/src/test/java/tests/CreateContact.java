package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContact extends TestBase {

    @Test
    public void createContact() {
        int before = app.wd.findElements(By.xpath("//*[@title='vCard']")).size();
        //initCreationContact
        app.initCreationContact();
        //fillContactForm
        app.fillContactForm(new ContactData("Name", "Surname", "1970"));
        //submitCreationContact
        app.submitCreateContact();
        int after = app.wd.findElements(By.xpath("//*[@title='vCard']")).size();
        Assert.assertEquals(before+1, after);
    }

}
