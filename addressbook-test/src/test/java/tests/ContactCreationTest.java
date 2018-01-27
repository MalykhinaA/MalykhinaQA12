package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {
    //(enabled = false)
    @Test
    public void contactCreationTest() {
        //int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        //initContactCreation
        app.contacts().initContactCreation();
        //fillContactForm
        ContactData newContact = new ContactData().withName("Nmae").withSurname("Surname").withBirthYear("1978");
        app.contacts().fillContactForm(newContact);
        //submitCreationContact
        app.contacts().submitContactCreation();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());
        before.add(after.get(before.size()));
//        for(int i = 0; i < before.size(); i++){
//            Assert.assertEquals(before.get(i),after.get(i));
//        }

        boolean flag = false;
        for (int i = after.size() - 1; i >= 0; i--) {
            if (after.get(i).equals(newContact)) {
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
