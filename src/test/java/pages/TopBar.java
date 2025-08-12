package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBar extends BasePage {
    private final By burgerButton = AppiumBy.accessibilityId("test-Menu");

    @Override
    public void waitPageToLoad() {
    }

    @Override
    @Step("Verificando la barra superior")
    public void verifyPage() {
        Logs.info("Verificando la barra superior");
        softAssert.assertTrue(find(burgerButton).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Abriendo el burger menu")
    public void openBurgerMenu() {
        Logs.info("Abriendo el burger menu");
        find(burgerButton).click();
    }
}