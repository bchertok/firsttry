package first.tests;


import org.testng.annotations.*;


public class BuisnessUnit extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {
        application.startPage();
        application.newBuisnessUnit();
        application.fillBuisnessUnit("name", "comment");
        application.acceptBuisnessUnit();
    }


}