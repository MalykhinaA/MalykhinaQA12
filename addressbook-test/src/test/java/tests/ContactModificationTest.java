package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void contactModifyTest() {
        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact(new ContactData("Name", "Surname", "1990"));
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactModification(before - 1);
        app.getContactHelper().fillContactForm(new ContactData("editedName", null, "1977"));
        app.getContactHelper().confirmContactModification();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after);

    }
}
