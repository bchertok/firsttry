package first;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
    protected WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://sb-oad-test/app1/dictionaries/subdivisions";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        startPage();
    }

    private void startPage() {
        driver.get("http://sb-oad-test/app1/dictionaries/subdivisions");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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

    protected void acceptArchive() {
        driver.findElement(By.cssSelector("div.p-content")).click();
        driver.findElement(By.cssSelector("button.g-button.success")).click();
    }

    protected void fillArchive(String kod, String name, String adress) {
        driver.findElement(By.cssSelector("input.input")).click();
        driver.findElement(By.cssSelector("input.input")).clear();
        driver.findElement(By.cssSelector("input.input")).sendKeys(kod);
        driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
        driver.findElement(By.xpath("(//input[@value=''])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys(name);
        driver.findElement(By.xpath("//div[4]/div[2]/input")).click();
        driver.findElement(By.xpath("//div[4]/div[2]/input")).clear();
        driver.findElement(By.xpath("//div[4]/div[2]/input")).sendKeys(adress);
    }

    protected void newArchive() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/a[17]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Создать")).click();
    }
}
