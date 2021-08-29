package ee.seb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainTestPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public MainTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), '\n" +
            "\t\t\t\t\tCar leasing calculator')]")
    private WebElement carLeasingCalculatorBtn;

    @FindBy(xpath = "//*[contains(@class, 't -value-compare calc08-action-compare')]")
    private WebElement addToComparisonBtn;

    @FindBy(xpath = "//*[contains(@id, 'calc08-sum')]")
    private WebElement priceOfTheVehicleField;

    @FindBy(xpath = "//*[contains(@id, 'calc08-deposit')]")
    private WebElement downpaymentField;

    @FindAll(@FindBy(css = "div.calc-result-compare table.calc-data tbody tr"))
    private List<WebElement> comparisonTableRows;

    @FindBy(xpath = "//*[contains(@class, 'main accept-selected')]")
    private WebElement iAgreeBtn;

    public void inputPriceOfTheVehicleField(String priceOfTheVehicle) {
        priceOfTheVehicleField.clear();
        priceOfTheVehicleField.sendKeys(priceOfTheVehicle);
    }

    protected void waitMs(int ms) {
        try {
            Thread.sleep(ms)
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputDownPayment(String downPayment) {
        downpaymentField.clear();
        downpaymentField.sendKeys(downPayment);
    }

    public List<WebElement> getComparisonTableRows() {
        WebElement iFrame = driver.findElement(By.id("calculator-frame-08a"));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrame);
        return comparisonTableRows;
    }

    public void clickCarLeasingCalculatorBtn() {
        carLeasingCalculatorBtn.click();
    }

    public void clickAddToComparisonBtn() {
        addToComparisonBtn.click();
    }

    public void clickIAgreeBtn() {
        iAgreeBtn.click();
    }

    public void initTableData() {
        WebElement iFrame = driver.findElement(By.id("calculator-frame-08a"));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrame);
        inputPriceOfTheVehicleField("1500");
        inputDownPayment("10");
        clickAddToComparisonBtn();
        inputPriceOfTheVehicleField("2500");
        inputDownPayment("15");
        clickAddToComparisonBtn();
        inputPriceOfTheVehicleField("3500");
        inputDownPayment("20");
        clickAddToComparisonBtn();
        driver.switchTo().defaultContent();
    }
}
