package first.tests;

import first.appmanager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class TestBase {

    protected final ApplicationManager application = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        application.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        application.stop();
    }

}
