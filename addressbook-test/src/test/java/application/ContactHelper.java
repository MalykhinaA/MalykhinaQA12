package application;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@title='vCard']")).size();
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void selectContactByIndex(int index) {
        wd.findElements(By.xpath("//input[@type='checkbox']")).get(index).click();
    }
    public void submitContactCreation() {
        click(By.xpath("//input[@name='submit']"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getSurname());
        click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        type(By.name("byear"), contactData.getYear());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void initContactModification(int index ) {
        wd.findElements(By.xpath("//*[@title='Edit']")).get(index).click();
    }

    public void confirmContactModification() {
        click(By.name("update"));
    }

    public boolean isContactPresent() {
        return isElementPresent(By.xpath("//*[@title='vCard']"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
    }

}
