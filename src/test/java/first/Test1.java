package first;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Test1 {
        FirefoxDriver wd;

@BeforeMethod
public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wd.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/businessesUnits");

        }

@Test
public void testMetod() {
        //wd.findElement(By.linkText("Создать")).click();
        wd.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/businessesUnits/new");
        wd.findElement(By.cssSelector("input.input")).click();
        wd.findElement(By.cssSelector("input.input")).clear();
        wd.findElement(By.cssSelector("input.input")).sendKeys("новый");
        wd.findElement(By.cssSelector("label.f-label")).click();
        if (!wd.findElement(By.id("active")).isSelected()) {
        wd.findElement(By.id("active")).click();
        }
        wd.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).click();
        wd.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).clear();
        wd.findElement(By.xpath("//div[@class='f-form']/div[5]/div[2]/input")).sendKeys("кек");
        wd.findElement(By.cssSelector("button.g-button.success")).click();
        }

@AfterMethod
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
