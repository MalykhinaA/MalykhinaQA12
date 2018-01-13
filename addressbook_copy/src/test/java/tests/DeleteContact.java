package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {
    @Test
    public void deleteContactTest() {
        int before = app.getContactCount();
        //selectContactDelete
        app.selectContactDelete();
        //submitContactDelete
        app.submitContactDelete();
        app.alertAccept();
        int after = app.getContactCount();
        Assert.assertEquals(before, after+1);




    }

}
