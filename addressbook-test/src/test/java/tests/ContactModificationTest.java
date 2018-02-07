package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

    @Test
    public void contactModifyTest() {
        app.goTo().homePage();
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withName("New name").withSurname("Surname").withBirthYear(null));
        }
        //int before = app.contacts().getContactCount();

        List<ContactData> before = app.contacts().getContactList();
        int index = before.size() - 1;
        app.contacts().initContactModification(index);


        ContactData editedContact = new ContactData().withId(before.get(index).getId()).withName(app.getHelperBase().generateRandomString(10))
                .withSurname(app.getHelperBase().generateRandomString(10))
                .withBirthYear("1988");
        app.contacts().fillContactForm(editedContact);
        app.contacts().confirmContactModification();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        before.remove(index);
        before.add(editedContact);
        assertEquals(before.size(), after.size());
        assertEquals(new HashSet<Object>(before), new HashSet<Object>( after));


//        boolean flag = false;
//        for (int i = after.size() - 1; i >= 0; i--) {
//            //Assert.assertEquals(before.get(i), after.get(i));
//           if (after.get(i).equals(editedContact)) {
//                flag = true;
//            } else if (!before.contains(after.get(i))) {
//                flag = false;
//                return;
//            }
//            before.remove(after.get(i));
//            after.remove(i);
//        }
//        assertEquals(flag, true);


    }
}
