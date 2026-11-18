import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MtsMainPage {

    private final String PLACEHOLDER = "placeholder";

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement title;

    @FindBy(xpath = "//div[@class='pay__partners']//li/img")
    private List<WebElement> logos;

    @FindBy(xpath = "//section[@class='pay']//a")
    private WebElement moreLink;

    @FindBy(xpath = "//form[@id='pay-connection']//button[contains(translate(., 'БАНКОВСКАЯ КАРТА', 'банковская карта'), 'банковская')]")
    private WebElement bankCardButton;

    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe') or contains(@src, 'bepaid')]")
    private WebElement paymentWindow;

    @FindBy(xpath = "//button[text()='Принять']")
    private WebElement cookieButtons;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement serviceSelectButton;

    @FindBy(xpath = "//ul[@class='select__list']//p[text()='Услуги связи']")
    private WebElement connectionOption;

    @FindBy(xpath = "//ul[@class='select__list']//p[text()='Домашний интернет']")
    private WebElement internetOption;

    @FindBy(xpath = "//ul[@class='select__list']//p[text()='Рассрочка']")
    private WebElement instalmentOption;

    @FindBy(xpath = "//ul[@class='select__list']//p[text()='Задолженность']")
    private WebElement arrearsOption;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement connectionPhoneInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement connectionSumInput;

    @FindBy(xpath = "//input[@id='connection-email']")
    private WebElement connectionEmailInput;

    @FindBy(xpath = "//input[@id='internet-phone']")
    private WebElement internetPhoneInput;

    @FindBy(xpath = "//input[@id='internet-sum']")
    private WebElement internetSumInput;

    @FindBy(xpath = "//input[@id='internet-email']")
    private WebElement internetEmailInput;

    @FindBy(xpath = "//input[@id='score-instalment']")
    private WebElement instalmentScoreInput;

    @FindBy(xpath = "//input[@id='instalment-sum']")
    private WebElement instalmentSumInput;

    @FindBy(xpath = "//input[@id='instalment-email']")
    private WebElement instalmentEmailInput;

    @FindBy(xpath = "//input[@id='score-arrears']")
    private WebElement arrearsScoreInput;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement arrearsSumInput;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement arrearsEmailInput;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__cost')]//*[contains(text(), 'BYN')]")
    private WebElement modalHeaderAmount;

    @FindBy(xpath = "//div[contains(@class, 'pay-description__text')]//span")
    private WebElement modalDescriptionText;

    @FindBy(xpath = "//button[contains(@class, 'colored') and contains(., 'Оплатить')]")
    private WebElement modalPayButton;

    @FindBy(xpath = "//label[contains(@class, 'ng-tns')]")
    private List<WebElement> modalCardLabels;

    @FindBy(xpath = "//div[contains(@class, 'cards-brands')]//img")
    private List<WebElement> modalCardIcons;

    public MtsMainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Открыть главную страницу mts.by и принять cookie")
    public MtsMainPage open() {
        driver.get("https://mts.by");
        wait.until(ExpectedConditions.visibilityOf(cookieButtons));
        cookieButtons.click();
        return this;
    }

    @Step("Проверить отображение заголовка блока оплаты")
    public boolean isTitleDisplayed() {
        return title.isDisplayed();
    }

    @Step("Получить текст заголовка блока оплаты")
    public String getTitleText() {
        return title.getText().replace("\n", " ").toUpperCase();
    }

    @Step("Получить список логотипов платёжных систем")
    public List<WebElement> getLogos() {
        return logos;
    }

    @Step("Нажать на ссылку «Подробнее о сервисе»")
    public void clickMoreLink() {
        moreLink.click();
    }

    @Step("Заполнить форму «Услуги связи»: телефон {phone}, сумма {sum}")
    public void fillForm(String phone, String sum) {
        connectionPhoneInput.sendKeys(phone);
        connectionSumInput.sendKeys(sum);
    }

    @Step("Нажать на кнопку «Банковская карта»")
    public void clickBankCardButton() {
        bankCardButton.click();
    }

    @Step("Проверить отображение модального окна оплаты")
    public boolean isPaymentWindowDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(paymentWindow));
        return paymentWindow.isDisplayed();
    }

    @Step("Выбрать вариант оплаты «Домашний интернет»")
    public void selectInternet() {
        serviceSelectButton.click();
        internetOption.click();
    }

    @Step("Выбрать вариант оплаты «Рассрочка»")
    public void selectInstalment() {
        serviceSelectButton.click();
        instalmentOption.click();
    }

    @Step("Выбрать вариант оплаты «Задолженность»")
    public void selectArrears() {
        serviceSelectButton.click();
        arrearsOption.click();
    }

    public List<String> getConnectionPlaceholders() {
        return List.of(
                Objects.requireNonNull(connectionPhoneInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(connectionSumInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(connectionEmailInput.getAttribute(PLACEHOLDER))
        );
    }

    public List<String> getInternetPlaceholders() {
        return List.of(
                Objects.requireNonNull(internetPhoneInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(internetSumInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(internetEmailInput.getAttribute(PLACEHOLDER))
        );
    }

    public List<String> getInstalmentPlaceholders() {
        return List.of(
                Objects.requireNonNull(instalmentScoreInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(instalmentSumInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(instalmentEmailInput.getAttribute(PLACEHOLDER))
        );
    }

    public List<String> getArrearsPlaceholders() {
        return List.of(
                Objects.requireNonNull(arrearsScoreInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(arrearsSumInput.getAttribute(PLACEHOLDER)),
                Objects.requireNonNull(arrearsEmailInput.getAttribute(PLACEHOLDER))
        );
    }

    @Step("Переключиться внутрь фрейма окна оплаты bePaid")
    public void switchToPaymentIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentWindow));
    }

    public String getModalHeaderAmount() {
        wait.until(ExpectedConditions.visibilityOf(modalHeaderAmount));
        return modalHeaderAmount.getText().trim();
    }

    public String getModalDescriptionText() {
        return modalDescriptionText.getText().trim();
    }

    public String getModalPayButtonText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(@class, 'colored') and contains(., 'Оплатить')]")
        ));
        return Objects.requireNonNull(modalPayButton.getAttribute("textContent")).trim();
    }

    public List<String> getModalCardLabels() {
        return modalCardLabels.stream()
                .map(el -> el.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public List<WebElement> getModalCardIcons() {
        return modalCardIcons;
    }
}
