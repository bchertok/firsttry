package first.tests;


import org.testng.annotations.*;


public class Archive extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {
        application.startPage();
        application.getArchiveHelper().newArchive();
        application.getArchiveHelper().fillArchive("код", "наменование", "адрес");
        application.getArchiveHelper().acceptArchive();
    }

}
