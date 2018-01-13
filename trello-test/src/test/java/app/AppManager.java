package app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AppManager {

    public HelperBase helperBase;
    public BoardHelper boardHelper;
    public ListHelper listHelper;
    public CardHelper cardHelper;
    public NavigationHelper navigationHelper;

    FirefoxDriver wd;

    //setUp
    public void start() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite();
        boardHelper = new BoardHelper(wd);
        listHelper = new ListHelper(wd);
        cardHelper = new CardHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        helperBase = new HelperBase(wd);
        login("qa12Test", "qa12Test");

    }

    public void login(String userName, String password) {
        helperBase.click(By.linkText("Log In"));
        helperBase.type(By.id("user"), userName);
        helperBase.type(By.id("password"), password);
        helperBase.click(By.id("login"));
    }


    public void openSite() {
        helperBase.wd.get("https://trello.com/");
    }

    //tearDown
    public void stop() {
        helperBase.wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
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

    public HelperBase getHelperBase() {
        return helperBase;
    }
}
