import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MtsMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement title;

    @FindBy(xpath = "//div[@class='pay__partners']//li/img")
    private List<WebElement> logos;

    @FindBy(xpath = "//section[@class='pay']//a")
    private WebElement moreLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='button']")
    private WebElement bankCardButton;

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe') or contains(@src, 'bepaid')]")
    private WebElement paymentWindow;

    @FindBy(xpath = "//button[text()='Принять']")
    private WebElement cookieButtons;

    public MtsMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public MtsMainPage open() {
        driver.get("https://mts.by");
        wait.until(ExpectedConditions.visibilityOf(cookieButtons));
        cookieButtons.click();
        return this;
    }

    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    public String getTitleText() {
        return title.getText().replace("\n", " ").toUpperCase();
    }

    public List<WebElement> getLogos() {
        return logos;
    }

    public void clickMoreLink() {
        moreLink.click();
    }

    public void fillForm(String phone, String sum) {
        phoneInput.sendKeys(phone);
        sumInput.sendKeys(sum);
    }

    public void clickBankCardButton() {
        bankCardButton.click();
    }

    public boolean isPaymentWindowDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(paymentWindow));
        return paymentWindow.isDisplayed();
    }
}
