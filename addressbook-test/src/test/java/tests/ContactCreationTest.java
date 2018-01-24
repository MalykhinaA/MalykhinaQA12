package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    //(enabled = false)
    @Test
    public void contactCreationTest() {
        int before = app.contacts().getContactCount();
        //initContactCreation
        app.contacts().initContactCreation();
        //fillContactForm
        app.contacts().fillContactForm(new ContactData().withName("Nmae").withSurname("Surname").withBirthYear("1978"));
        //submitCreationContact
        app.contacts().submitContactCreation();
        int after = app.contacts().getContactCount();
        Assert.assertEquals(before + 1, after);
    }


}
