
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.HasCapabilities;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Test1 {


    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

        //пачка команд, для настроек перед загрузкой браущера
      //  DesiredCapabilities caps = new DesiredCapabilities();
   //     caps.setCapability("unexpectedAlertBehaviour", "dismiss");
       // driver = new ChromeDriver(caps);
    //    System.out.println(((HasCapabilities) driver).getCapabilities());



        // опицц командной строки
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);



        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void SecondTest() {
        driver.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/dossiersDocuments");
        driver.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/dossiersDocuments/new");

        driver.findElement(By.cssSelector("input.input")).click();
        driver.findElement(By.cssSelector("input.input")).clear();
        driver.findElement(By.cssSelector("input.input")).sendKeys("ntcn");
        driver.findElement(By.cssSelector("label.f-label")).click();
        if (!driver.findElement(By.id("multicontract")).isSelected()) {
            driver.findElement(By.id("multicontract")).click();
        }
        driver.findElement(By.cssSelector("div.Select-placeholder")).click();


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
