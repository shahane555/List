package listAmTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.list.Am.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class DriverSetup {
    protected WebDriver driver;
    protected Actions action;
    protected HomePage homePage;
    protected WebDriverWait wait;

    @BeforeClass
    public void openListAmSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        action = new Actions(driver);
        homePage = new HomePage(driver, action, wait);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        homePage.open();
    }

    @AfterClass
    public void closeListAmSite() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
