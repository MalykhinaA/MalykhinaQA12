package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = br.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withName(split[0]).withSurname(split[1]).withBirthYear(split[2])});
            line = br.readLine();
        }
        br.close();
        return list.iterator();
    }

    //(enabled = false)
    @Test(dataProvider = "validContacts")
    public void contactCreationTest(ContactData contact) {
        app.goTo().homePage();
        //int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        //initContactCreation
        app.contacts().initContactCreation();
        //fillContactForm
        app.contacts().fillContactForm(contact);
        //submitCreationContact
        app.contacts().submitContactCreation();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());
        Collections.sort(after);
        before.add(after.get(after.size() - 1));

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//        boolean flag = false;
//        for (int i = after.size() - 1; i >= 0; i--) {
//            if (after.get(i).equals(newContact)) {
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

    @Test
    public void contactCreationWithPhotoTest(){
        app.goTo().homePage();
        //int before = app.contacts().getContactCount();
        List<ContactData> before = app.contacts().getContactList();
        //initContactCreation
        app.contacts().initContactCreation();
        //fillContactForm
        File photo = new File("src/test/resources/photo.jpg");
        app.contacts().fillContactForm(new ContactData().withName("").withSurname("").withPhoto(photo));
        //submitCreationContact
        app.contacts().submitContactCreation();
        //int after = app.contacts().getContactCount();
        List<ContactData> after = app.contacts().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());
        Collections.sort(after);
        before.add(after.get(after.size() - 1));

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }
}
