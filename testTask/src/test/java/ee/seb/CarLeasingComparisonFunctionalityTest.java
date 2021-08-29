package ee.seb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarLeasingComparisonFunctionalityTest {

    public static WebDriver driver;
    public static MainTestPage mainTestPage;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().version(ConfProperties.getProperty("chromedriver")).setup();
        driver = new ChromeDriver();
        mainTestPage = new MainTestPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("maintestpage"));
    }

    @Test
    public void carLeasingComparisonFunctionalityTest() {
        mainTestPage.clickIAgreeBtn();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        mainTestPage.clickCarLeasingCalculatorBtn();
        mainTestPage = new MainTestPage(driver);
        mainTestPage.initTableData();
        mainTestPage = new MainTestPage(driver);
        List<WebElement> comparisonTableRows = mainTestPage.getComparisonTableRows();
        Assert.assertEquals(3, comparisonTableRows.size());

        driver.switchTo().defaultContent();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
