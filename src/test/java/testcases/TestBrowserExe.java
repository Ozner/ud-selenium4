package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestBrowserExe {

    private WebDriver driver;
    public static String browser = "chrome";


    @BeforeClass
    public void setUp() {

        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBrowserVersion("0.30.0");
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new EdgeDriver();
		}
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
