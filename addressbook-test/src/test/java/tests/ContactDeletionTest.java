package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
    public void contactDeletionTest() {
        int before = app.getContactHelper().getContactCount();
        //selectContactDelete
        app.getContactHelper().selectContactDelete();
        //submitContactDelete
        app.getContactHelper().submitContactDelete();
        app.alertAccept();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after+1);




    }

}
