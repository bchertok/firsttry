package first.tests;


import org.testng.annotations.*;


public class Archive extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {
        application.startPage();
        application.newArchive();
        application.fillArchive("код", "наменование", "адрес");
        application.acceptArchive();
    }

}
