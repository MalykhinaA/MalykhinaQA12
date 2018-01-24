package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withName("Name").withSurname("Surname").withBirthYear("1990"));
        }
        int before = app.contacts().getContactCount();
        //selectContact
        //app.getContactHelper().selectContact();
        app.contacts().selectContactByIndex(before - 1);
        //submitContactDeletion
        app.contacts().submitContactDeletion();
        app.helperBase.alertAccept();
        int after = app.contacts().getContactCount();
        Assert.assertEquals(before, after + 1);


    }

}
