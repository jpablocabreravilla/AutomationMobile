package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class BurgerMenu extends BasePage {
    private final By logoutButton = AppiumBy.accessibilityId("test-LOGOUT");
    private final By closeButton = AppiumBy.accessibilityId("test-Close");

    @Override
    @Step("Esperando que el burger menu cargue")
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando el burger menu")
    public void verifyPage() {
        Logs.info("Verificando el burger menu");
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Haciendo click en logout")
    public void clickLogout() {
        Logs.info("Haciendo click en logout");
        find(logoutButton).click();
    }

    @Step("Haciendo click en la X")
    public void clickCloseX() {
        Logs.info("Haciendo click en la X");
        find(closeButton).click();
    }
}
