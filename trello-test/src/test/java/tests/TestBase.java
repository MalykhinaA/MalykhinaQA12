package tests;

import app.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final AppManager appManager = new AppManager(BrowserType.FIREFOX);


    @BeforeSuite
    public void setUp() throws Exception {
        appManager.start();
    }


    @AfterSuite
    public void tearDown() {
        appManager.stop();
    }


}
