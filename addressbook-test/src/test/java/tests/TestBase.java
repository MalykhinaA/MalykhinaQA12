package tests;

import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void setUp() throws Exception {
        app.start();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] o) {
        logger.info("Start test "+ m.getName() +" with parameter" + o);
    }
    @AfterMethod(alwaysRun = true)
    public void logTestFinish() {
        logger.info("Finish test");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }



}
