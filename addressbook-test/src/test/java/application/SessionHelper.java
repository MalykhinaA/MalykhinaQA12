package application;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    //Methods
    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void openSite() {
        wd.get("http://localhost/addressbook/");
    }
}
