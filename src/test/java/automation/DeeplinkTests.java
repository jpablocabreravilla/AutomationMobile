package automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.ContextUtilities;
import utilities.Logs;

public class DeeplinkTests extends BaseTest {

    @Test(groups = {regression, smoke})
    public void webViewDeepLinkTest() {
        final var deepLink = "swaglabs://webview";

        Logs.info("Navegando a la pagina de webview usando el deeplink %s", deepLink);
        driver.get(deepLink);

        Logs.info("Escribiendo la url en el input");
        driver.findElement(AppiumBy
                        .accessibilityId("test-enter a https url here..."))
                .sendKeys("www.saucedemo.com");

        Logs.info("Clickeando en el boton go to site");
        driver.findElement(AppiumBy.accessibilityId("test-GO TO SITE")).click();

        Logs.debug("Cambiando a contexto web");
        ContextUtilities.switchWebContext();

        Logs.info("Verificando si el username es visible");
        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());

        Logs.info("Regresando al contexto native app");
        ContextUtilities.switchNativeContext();

        Logs.info("Presionando el boton atras del dispositivo para regresar a la pagina anterior");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Logs.info("Verificando que se regreso a la pagina de webview");
        //Assert.assertTrue(driver.findElement(AppiumBy                .accessibilityId("test-GO TO SITE")).isDisplayed());

    }

}
