package ee.seb;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataOfApplicantPage {
    private final static long TIMEOUT_10_SECONDS = 10;

    public WebDriver driver;
    public DataOfApplicantPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@title, 't_lseauto') and contains(@class, 'active')]")
    private WebElement carLeasingApplicationBtn;

    @FindBy(xpath = "//*[contains(@title, 'appl_data2') and contains(@class, 'active')]")
    private WebElement dataOfApplicantBtn;

    @FindBy(xpath = "//*[contains(text(), 'Previous')]")
    private WebElement previousBtn;

    @FindBy(xpath = "//*[contains(@name, '-999_DELIMITER_crmContactTopic_APPL_DATA2_000')]")
    private WebElement firstName;

    public String getFirstName() {
        String userFirstName = firstName.getAttribute("value");
        return userFirstName; }

    public void clickPreviousBtn() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_10_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Previous')]")));
        Assert.assertNotNull(previousBtn);
        previousBtn.click();
    }

    public void initLeasingDataDields(NewLeasingDataFieldsPage newLeasingDataFieldsPage) {
        newLeasingDataFieldsPage.inputFirstName("FirstName");
        newLeasingDataFieldsPage.inputLastName("LastName");
        newLeasingDataFieldsPage.inputIdCode("123");
        newLeasingDataFieldsPage.selectAssetType();
        newLeasingDataFieldsPage.selectBrand();
        newLeasingDataFieldsPage.selectModel();
        newLeasingDataFieldsPage.inputProductionYear("2010");
        newLeasingDataFieldsPage.inputMaxOutput("150");
        newLeasingDataFieldsPage.selectTypeOfFinancing();
        newLeasingDataFieldsPage.inputAssetPrice("8000");
        newLeasingDataFieldsPage.inputDownPayment("15");
        newLeasingDataFieldsPage.inputLeasePeriodInMonths("60");
        newLeasingDataFieldsPage.selectLesseesPermanentAddress();
        newLeasingDataFieldsPage.inputOfferEmail("example2@example.com");
        newLeasingDataFieldsPage.selectInsuranceOffer();
        newLeasingDataFieldsPage.selectSellerName();
        newLeasingDataFieldsPage.inputSellerContactPerson("Andres Pall");
        newLeasingDataFieldsPage.inputSellerContactPhone("+37258445566");
        newLeasingDataFieldsPage.clickNextBtn();
    }
}
