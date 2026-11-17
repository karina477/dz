import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest extends BaseTest {

    @Test
    public void checkTitle() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();

        assertTrue(mtsMainPage.isTitleDisplayed(), "Заголовок блока оплаты не отображается");
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", mtsMainPage.getTitleText());
    }

    @Test
    public void checkLogos() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();
        List<WebElement> logos = mtsMainPage.getLogos();

        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Логотип " + logo.getAttribute("alt") + " не отображается");
        }
    }

    @Test
    public void checkMoreLink() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();
        mtsMainPage.clickMoreLink();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl())
                .contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void checkPaymentForm() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();
        mtsMainPage.fillForm("297777777", "10");
        mtsMainPage.clickBankCardButton();

        assertTrue(mtsMainPage.isPaymentWindowDisplayed(), "Окно оплаты не открылось");
    }

    @Test
    public void checkEmptyFieldsPlaceholders() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();

        assertEquals(
                List.of("Номер телефона", "Сумма", "E-mail для отправки чека"),
                mtsMainPage.getConnectionPlaceholders(),
                "Неверные надписи в полях 'Услуги связи'"
        );

        mtsMainPage.selectInternet();
        assertEquals(
                List.of("Номер абонента", "Сумма", "E-mail для отправки чека"),
                mtsMainPage.getInternetPlaceholders(),
                "Неверные надписи в полях 'Домашний интернет'"
        );

        mtsMainPage.selectInstalment();
        assertEquals(
                List.of("Номер счета на 44", "Сумма", "E-mail для отправки чека"),
                mtsMainPage.getInstalmentPlaceholders(),
                "Неверные надписи в полях 'Рассрочка'"
        );

        mtsMainPage.selectArrears();
        assertEquals(
                List.of("Номер счета на 2073", "Сумма", "E-mail для отправки чека"),
                mtsMainPage.getArrearsPlaceholders(),
                "Неверные надписи в полях 'Задолженность'"
        );
    }

    @Test
    public void checkPaymentModalDetails() {
        MtsMainPage mtsMainPage = new MtsMainPage(driver, wait).open();

        mtsMainPage.fillForm("297777777", "10");
        mtsMainPage.clickBankCardButton();

        mtsMainPage.switchToPaymentIframe();

        assertEquals("10.00 BYN", mtsMainPage.getModalHeaderAmount(), "Неверная сумма в шапке окна");
        assertEquals(
                "Оплатить  10.00 BYN",
                mtsMainPage.getModalPayButtonText(),
                "Неверная сумма на кнопке оплаты"
        );

        assertTrue(
                mtsMainPage.getModalDescriptionText().contains("375297777777"),
                "Номер телефона не совпадает"
        );

        List<String> expectedLabels = List.of("Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте");
        assertTrue(mtsMainPage.getModalCardLabels().containsAll(expectedLabels),
                "Не найдены все ожидаемые надписи полей карты: " + mtsMainPage.getModalCardLabels());

        List<WebElement> cardIcons = mtsMainPage.getModalCardIcons();
        assertFalse(cardIcons.isEmpty(), "Иконки платёжных систем в окне оплаты не найдены");
    }
}
