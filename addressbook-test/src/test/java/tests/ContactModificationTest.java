package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void contactModifyTest(){
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("editedName", null, "1977"));
        app.getContactHelper().confirmContactModification();

    }
}
