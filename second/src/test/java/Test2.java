
import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;

public class Test2 {


    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void SecondTest() {
        driver.navigate().to("http://sb-oad-test.reksoft.ru/app1/dictionaries");
        driver.navigate().to("http://sb-oad-test.reksoft.ru/app1/dictionaries/subdivisions/new");
        driver.findElement(By.cssSelector("input.input")).click();
        driver.findElement(By.cssSelector("input.input")).clear();
        driver.findElement(By.cssSelector("input.input")).sendKeys("123");





        driver.findElement(By.xpath("//div[@class='f-form']/div[4]/div[2]/input")).click();
        driver.findElement(By.xpath("//div[@class='f-form']/div[4]/div[2]/input")).clear();
        driver.findElement(By.xpath("//div[@class='f-form']/div[4]/div[2]/input")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).click();
        driver.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).clear();
        driver.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='f-form']/div[9]/div[2]/input")).click();
        driver.findElement(By.xpath("//div[@class='f-form']/div[9]/div[2]/input")).clear();
        driver.findElement(By.xpath("//div[@class='f-form']/div[9]/div[2]/input")).sendKeys("1");
        driver.findElement(By.cssSelector("button.g-button.success")).click();



    }
/*
   @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

*/}
