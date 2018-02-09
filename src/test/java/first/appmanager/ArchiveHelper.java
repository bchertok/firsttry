package first.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArchiveHelper {


    private final WebDriver driver;

    public ArchiveHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptArchive() {
        driver.findElement(By.cssSelector("div.p-content")).click();
        driver.findElement(By.cssSelector("button.g-button.success")).click();
    }

    public void fillArchive(String kod, String name, String adress) {
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

    public void newArchive() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div[2]/div/div/div/div/a[17]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Создать")).click();
    }
}
