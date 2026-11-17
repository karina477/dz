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
}
