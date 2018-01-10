package first;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
@Test
        public void TestArea() {
    Danniye n = new Danniye();
    double m = n.rasschet(25);
    Assert.assertEquals(m,3125.0);
}
}
