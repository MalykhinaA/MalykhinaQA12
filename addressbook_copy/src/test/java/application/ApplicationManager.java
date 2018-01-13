package application;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver wd;

    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //goToSite
        openSite();
        //login
        login("admin", "secret");
    }
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void stop() {
        wd.quit();
    }
    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@title='vCard']")).size();
    }


    //Methods
    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void openGroupPage() {
        click(By.linkText("groups"));
    }

    public void openSite() {
        wd.get("http://localhost:8080/addressbook/");
    }

    public void submitGroupCreate() {
        click(By.name("submit"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupDelete() {
        click(By.xpath("//input[@name='delete']"));
    }

    public void selectGroupTodelete() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void submitContactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContactDelete() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
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
