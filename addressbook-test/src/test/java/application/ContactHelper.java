package application;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        //click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
       // click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        type(By.name("byear"), contactData.getYear());
        attach(By.name("photo"),contactData.getPhoto());

    }


    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void initContactModification(int index) {
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


public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows){
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("id"));
            String lastName = row.findElement(By.xpath(".//td[2]")).getText();
            String name = row.findElement(By.xpath(".//td[3]")).getText();
            ContactData contact = new ContactData().withId(id).withSurname(lastName).withName(name);
            contacts.add(contact);
        }
        return contacts;
    }
//    public List<ContactData> getContactList() {
//        List<ContactData> contacts = new ArrayList<>();
//        List<WebElement> elementSurname = wd.findElements(By.xpath("//table/tbody/tr/td[2]"));
//        List<WebElement> elementName = wd.findElements(By.xpath("//table/tbody/tr/td[3]"));
//        List<WebElement> iD = wd.findElements(By.xpath("//table/tbody/tr/td[1]/input"));
//        for(int i = 0; i < elementName.size();i++){
//            int id = Integer.parseInt(iD.get(i).getAttribute("id"));
//            String name = elementName.get(i).getText();
//            String surName = elementSurname.get(i).getText();
//            ContactData contact = new ContactData().withId(id).withSurname(surName).withName(name);
//            contacts.add(contact);
//
//        }
//        return contacts;
//    }

}
