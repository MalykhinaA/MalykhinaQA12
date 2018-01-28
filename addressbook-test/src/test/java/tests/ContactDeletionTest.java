package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withName("Name").withSurname("Surname").withBirthYear("1990"));
        }
        //int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        //selectContact
        //app.getContactHelper().selectContact();
        int index = before.size() - 1;
        app.contacts().selectContactByIndex(index);
        //submitContactDeletion
        app.contacts().submitContactDeletion();
        app.helperBase.alertAccept();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(before.size(), after.size() + 1);
        before.remove(index);
        Assert.assertEquals(before,after);


    }

}
