package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void contactModifyTest() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withName("New name").withSurname("Surname").withBirthYear(null));
        }
        int before = app.contacts().getContactCount();
        app.contacts().initContactModification(before - 1);
        app.contacts().fillContactForm(new ContactData().withName("Name").withSurname(null).withBirthYear("1988"));
        app.contacts().confirmContactModification();
        int after = app.contacts().getContactCount();
        Assert.assertEquals(before, after);

    }
}
