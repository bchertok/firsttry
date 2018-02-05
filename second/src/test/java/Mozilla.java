import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.OutputType.*;

public class Mozilla {
    FirefoxDriver wd;

    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void Test3() {
        wd.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/dossiersDocuments");
        wd.findElement(By.xpath("//div[@class='items']/span/span")).click();
        wd.findElement(By.linkText("Создать")).click();
        wd.findElement(By.cssSelector("input.input")).click();
        wd.findElement(By.cssSelector("input.input")).clear();
        wd.findElement(By.cssSelector("input.input")).sendKeys("ntcn");
        wd.findElement(By.cssSelector("label.f-label")).click();
        if (!wd.findElement(By.id("multicontract")).isSelected()) {
            wd.findElement(By.id("multicontract")).click();
        }
        wd.findElement(By.cssSelector("div.Select-placeholder")).click();
        wd.findElement(By.cssSelector("button.g-button.success")).click();
    }

    @After
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
