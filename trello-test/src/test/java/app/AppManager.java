package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {

    public BoardHelper boardHelper;
    public ListHelper listHelper;
    public CardHelper cardHelper;
    public NavigationHelper navigationHelper;
    public SessionHelper sessionHelper;

    WebDriver wd;
    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    //setUp
    public void start() {
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite();
        boardHelper = new BoardHelper(wd);
        listHelper = new ListHelper(wd);
        cardHelper = new CardHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("qa12Test", "qa12Test");

    }


    //tearDown
    public void stop() {
        wd.quit();
    }


    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public ListHelper getListHelper() {
        return listHelper;
    }

    public CardHelper getCardHelper() {
        return cardHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getHelperBase() {
        return sessionHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
