package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact(new ContactData("Name", "Surname", "1990"));
        }
        int before = app.getContactHelper().getContactCount();
        //selectContact
        //app.getContactHelper().selectContact();
        app.getContactHelper().selectContactByIndex(before - 1);
        //submitContactDeletion
        app.getContactHelper().submitContactDeletion();
        app.helperBase.alertAccept();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after + 1);


    }

}
