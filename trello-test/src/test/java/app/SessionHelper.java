package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        click(By.linkText("Log In"));
        type(By.id("user"), userName);
        type(By.id("password"), password);
        click(By.id("login"));
    }

    public void openSite() {
        wd.get("https://trello.com/");
    }
}
