package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;

public class DeleteContact extends TestBase {
    @Test
    public void deleteContact() {
        //selectContactDelete
        selectContactDelete();
        //submitContactDelete
        submitContactDelete();
        alertAccept();




    }

}
