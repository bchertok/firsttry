package first;


import org.testng.annotations.*;


public class Archive extends TestBase{

    @Test
    public void testUntitledTestCase() throws Exception {

        newArchive();
        fillArchive("код", "наменование", "адрес");
        acceptArchive();
    }

}
