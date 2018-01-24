package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    //(enabled = false)
    @Test
    public void contactCreationTest() {
        int before = app.getContactHelper().getContactCount();
        //initContactCreation
        app.getContactHelper().initContactCreation();
        //fillContactForm
        app.getContactHelper().fillContactForm(new ContactData("Name", "Surname", "1970"));
        //submitCreationContact
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before + 1, after);
    }


}
