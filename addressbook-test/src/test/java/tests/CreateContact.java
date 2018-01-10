package tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContact extends TestBase {

    @Test
    public void createContactTest() {
        int before = app.getContactCount();
        //initCreationContact
        app.initCreationContact();
        //fillContactForm
        app.fillContactForm(new ContactData("Name", "Surname", "1970"));
        //submitCreationContact
        app.submitCreateContact();
        int after = app.getContactCount();
        Assert.assertEquals(before+1, after);
    }



}
