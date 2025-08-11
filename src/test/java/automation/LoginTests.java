package automation;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class LoginTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    void setUp() {
        Logs.info("Esperando que el app cargue");
        sleep(1500);
    }

    @Test(groups = {regression, smoke})
    public void verificaPaginaTest() {
        Logs.info("Verificando la pagina de login");
        final var usernameInput = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        final var passwordInput = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        final var botonLogin = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        softAssert.assertTrue(usernameInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(botonLogin.isDisplayed());
        softAssert.assertTrue(botonLogin.isEnabled());
        softAssert.assertAll();
    }

    @Test(groups = {regression, smoke})
    public void login() {
        Logs.info("Escribiendo el username");
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("standard_user");

        Logs.info("Escribiendo el password");
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        Logs.info("Haciendo click en el boton de login");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

    }

    @Test(groups = {regression, smoke})
    public void credencialesBloqueadasTest() {
        Logs.info("Escribiendo el username");
        driver.findElement(AppiumBy.accessibilityId("test-Username"))
                .sendKeys("locked_out_user");

        Logs.info("Escribiendo el password");
        driver.findElement(AppiumBy.accessibilityId("test-Password"))
                .sendKeys("secret_sauce");

        Logs.info("Haciendo click en el boton de login");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        Logs.info("Verificando el mensaje de error");
        final var mensajeError = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "description(\"test-Error message\")" +
                                ".childSelector(className(\"android.widget.TextView\"))"
                )
        );

        softAssert.assertTrue(mensajeError.isDisplayed());
        softAssert.assertEquals(mensajeError.getText(),
                "Sorry, this user has been locked out.");
        softAssert.assertAll();
    }
}
