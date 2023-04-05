package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestBrowserExe {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void searchAbstracta() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Abstracta");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        Assert.assertTrue(driver.getTitle().contains("Abstracta"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
