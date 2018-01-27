package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @Test
    public void contactModifyTest() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withName("New name").withSurname("Surname").withBirthYear(null));
        }
        //int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        int index = before.size() - 1;
        app.contacts().initContactModification(index);


        ContactData editedContact = new ContactData().withName(app.getHelperBase().generateRandomString(10))
                .withSurname(app.getHelperBase().generateRandomString(10))
                .withBirthYear("1988");
        app.contacts().fillContactForm(editedContact);
        app.contacts().confirmContactModification();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        assertEquals(before.size(), after.size());

        boolean flag = false;
        for (int i = after.size() - 1; i >= 0; i--) {
            //Assert.assertEquals(before.get(i), after.get(i));
           if (after.get(i).equals(editedContact)) {
                flag = true;
            } else if (!before.contains(after.get(i))) {
                flag = false;
                return;
            }
            before.remove(after.get(i));
            after.remove(i);
        }


        assertEquals(flag, true);


    }
}
