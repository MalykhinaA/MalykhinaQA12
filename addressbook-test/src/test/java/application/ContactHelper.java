package application;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@title='vCard']")).size();
    }

    public void submitContactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContactDelete() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void submitCreateContact() {
        click(By.xpath("//input[@name='submit']"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getSurname());
        click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        type(By.name("byear"), contactData.getYear());
    }

    public void initCreationContact() {
        click(By.linkText("add new"));
    }
}
