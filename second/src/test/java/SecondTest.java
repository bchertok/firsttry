import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SecondTest {

private WebDriver driver;
private WebDriverWait wait;

    @Before
    public void start () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

@Test
    public void SecondTest () {
        driver.navigate().to("https://www.yandex.ru/");
        driver.findElement(By.id("text")).sendKeys("KirillPidor");
        driver.findElement(By.className("search2__button")).click();
        wait.equals(5);


}

@After
    public void stop() {
        driver.quit();
        driver = null;
}
}
