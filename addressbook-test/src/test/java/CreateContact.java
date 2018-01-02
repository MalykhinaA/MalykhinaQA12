import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class CreateContact extends TestBase{

    @Test
    public void createContact() {
        //initCreationContact
        initCreationContact();
        //fillContactForm
        fillContactForm("Name", "Surname", "1970");
        //submitCreationContact
        submitCreateContact();
    }

    public void submitCreateContact() {
        wd.findElement(By.xpath("//input[@name='submit']")).click();
    }

    public void fillContactForm(String name, String surname, String year) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(name);
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(surname);
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(year);
    }

    public void initCreationContact() {
        wd.findElement(By.linkText("add new")).click();
    }

}
