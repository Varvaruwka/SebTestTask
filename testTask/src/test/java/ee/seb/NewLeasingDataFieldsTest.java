package ee.seb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class NewLeasingDataFieldsTest {

    public static NewLeasingDataFieldsPage newLeasingDataFieldsPage;
    public static DataOfApplicantPage dataOfApplicantPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().version(ConfProperties.getProperty("chromedriver")).setup();
        driver = new ChromeDriver();
        newLeasingDataFieldsPage = new NewLeasingDataFieldsPage(driver);
        dataOfApplicantPage = new DataOfApplicantPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("testpage"));
    }

    @Test
    public void newLeasingDataFieldsTest() {
        newLeasingDataFieldsPage.initNewLeasingDataFields();
        String user = dataOfApplicantPage.getFirstName();
        Assert.assertEquals(ConfProperties.getProperty("firstname").toUpperCase(Locale.ROOT), user);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
