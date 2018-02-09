package first.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager extends BuisnessUnitHelper{
    public WebDriver driver;
    private ArchiveHelper archiveHelper;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
       driver = new FirefoxDriver();
        baseUrl = "http://sb-oad-test/app1/dictionaries/subdivisions";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        archiveHelper = new ArchiveHelper(driver);
        startPage();
    }

    public void startPage() {
        driver.get("http://sb-oad-test/app1/dictionaries/subdivisions");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
           driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void newBuisnessUnit() throws InterruptedException {
        driver.get("http://sb-oad-test.reksoft.ru/app1/dictionaries/subdivisions");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/a[4]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.add-link > span.label")).click();
    }

    public void acceptBuisnessUnit() {
        driver.findElement(By.cssSelector("button.g-button.success")).click();
    }

    public void fillBuisnessUnit(String name, String comment) {
        driver.findElement(By.cssSelector("input.input")).click();
        driver.findElement(By.cssSelector("input.input")).clear();
        driver.findElement(By.cssSelector("input.input")).sendKeys(name);
        driver.findElement(By.cssSelector("label.f-label")).click();
        driver.findElement(By.xpath("//input[@value='']")).click();
        driver.findElement(By.xpath("//input[@value='']")).clear();
        driver.findElement(By.xpath("//input[@value='']")).sendKeys(comment);
    }

    public ArchiveHelper getArchiveHelper() {
        return archiveHelper;
    }
}
