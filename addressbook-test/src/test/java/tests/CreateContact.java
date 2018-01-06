package tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class CreateContact extends TestBase {

    @Test
    public void createContact() {
        //initCreationContact
        initCreationContact();
        //fillContactForm
        fillContactForm("Name", "Surname", "1970");
        //submitCreationContact
        submitCreateContact();
    }

}
