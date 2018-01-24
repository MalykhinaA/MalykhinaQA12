package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    public SessionHelper sessionHelper;
    public HelperBase helperBase;
    public ContactHelper contactHelper;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;

    WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //goToSite
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        helperBase = new HelperBase(wd);
        //login
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }


    public GroupHelper groups(
    ) {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
