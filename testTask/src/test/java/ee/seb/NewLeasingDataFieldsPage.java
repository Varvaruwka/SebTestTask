package ee.seb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLeasingDataFieldsPage {

    public WebDriver driver;
    public NewLeasingDataFieldsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@name, 'firstname')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[contains(@name, 'lastname')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[contains(@name, 'id_code')]")
    private WebElement idCodeField;

    @FindBy(xpath = "//*[contains(@id, '-994_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement productionYearField;

    @FindBy(xpath = "//*[contains(@id, '-991_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement maxOutputField;

    @FindBy(xpath = "//*[contains(@id, '-982_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement assetPriceField;

    @FindBy(xpath = "//*[contains(@id, '-981_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement downPaymentField;

    @FindBy(xpath = "//*[contains(@id, '-977_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement leasePeriodInMonthsField;

    @FindBy(xpath = "//*[contains(@id, '-969_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement offerEmailField;

    @FindBy(xpath = "//*[contains(@id, '-958_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement sellerContactPersonField;

    @FindBy(xpath = "//*[contains(@id, '-957_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")
    private WebElement sellerContactPhoneField;

    @FindBy(xpath = "//*[contains(text(), 'Next')]")
    private WebElement nextBtn;

    public void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void inputIdCode(String idCode) {
        idCodeField.sendKeys(idCode);
    }

    public void inputProductionYear(String productionYear) {
        productionYearField.sendKeys(productionYear);
    }

    public void inputMaxOutput(String maxOutput) {
        maxOutputField.sendKeys(maxOutput);
    }

    public void inputAssetPrice(String assetPrice) {
        assetPriceField.sendKeys(assetPrice);
    }

    public void inputDownPayment(String downPayment) {
        downPaymentField.sendKeys(downPayment);
    }

    public void inputLeasePeriodInMonths(String leasePeriodInMonths) {
        leasePeriodInMonthsField.sendKeys(leasePeriodInMonths);
    }

    public void inputOfferEmail(String offerEmail) {
        offerEmailField.sendKeys(offerEmail);
    }

    public void inputSellerContactPerson(String sellerContactPerson) {
        sellerContactPersonField.sendKeys(sellerContactPerson);
    }

    public void inputSellerContactPhone(String sellerContactPhone) {
        sellerContactPhoneField.sendKeys(sellerContactPhone);
    }

    public void selectAssetType() {
        Select drpAssetType = new Select(driver.findElement(By.id("-998_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm-teema-t-lseauto-objtyyp-")));
        drpAssetType.selectByVisibleText("Passanger car");
    }

    public void selectBrand() {
        Select drpAssetType = new Select(driver.findElement(By.id("-997_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm_pm_soiduk_mark")));
        drpAssetType.selectByVisibleText("AUDI");
    }

    public void selectModel() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, '-996_DELIMITER_crmContactTopic_T_LSEAUTO_000')]")));
        Select drpAssetType = new Select(driver.findElement(By.id("-996_DELIMITER_crmContactTopic_T_LSEAUTO_000")));
        drpAssetType.selectByVisibleText("A5");
    }

    public void selectTypeOfFinancing() {
        Select drpAssetType = new Select(driver.findElement(By.id("-983_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm-teema-t-lseauto-fin-tyyp-")));
        drpAssetType.selectByVisibleText("Operational lease");
    }

    public void selectLesseesPermanentAddress() {
        Select drpAssetType = new Select(driver.findElement(By.id("-970_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm_pm_soiduk_arvel")));
        drpAssetType.selectByVisibleText("Tallinn");
    }

    public void selectInsuranceOffer() {
        Select drpAssetType = new Select(driver.findElement(By.id("-968_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm_pm_car_insur")));
        drpAssetType.selectByVisibleText("Yes");
    }

    public void selectSellerName() {
        Select drpAssetType = new Select(driver.findElement(By.id("-1003_DELIMITER_crmContactTopic_T_LSEAUTO_000_autocrm_pm_myyja_nimi")));
        drpAssetType.selectByVisibleText("ABC MOTORS AS, TALLINN, PALDISKI MNT 105");
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void initNewLeasingDataFields() {
        inputFirstName("TestFirstName");
        inputLastName("TestLastName");
        inputIdCode("12345678");
        selectAssetType();
        selectBrand();
        selectModel();
        inputProductionYear("2015");
        inputMaxOutput("100");
        selectTypeOfFinancing();
        inputAssetPrice("15000");
        inputDownPayment("20");
        inputLeasePeriodInMonths("48");
        selectLesseesPermanentAddress();
        inputOfferEmail("example@example.com");
        selectInsuranceOffer();
        selectSellerName();
        inputSellerContactPerson("Taavi Muts");
        inputSellerContactPhone("+37258445566");
        clickNextBtn();
    }

}
