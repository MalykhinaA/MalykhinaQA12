package tests;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //goToSite
        openSite();
        //login
        login("admin", "secret");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
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
        wd.get("http://localhost/addressbook/");
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

    public void fillContactForm(String name, String surname, String year) {
        type(By.name("firstname"),name);
        type(By.name("lastname"),surname);
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
        }
        type(By.name("byear"),year);
    }

    public void initCreationContact() {
        click(By.linkText("add new"));
    }
}
